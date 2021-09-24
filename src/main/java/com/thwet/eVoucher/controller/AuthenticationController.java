/**
 * 
 */
package com.thwet.eVoucher.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thwet.eVoucher.common.JwtTokenUtil;
import com.thwet.eVoucher.common.ResponseCode;
import com.thwet.eVoucher.common.Roles;
import com.thwet.eVoucher.dto.ChangePasswordDto;
import com.thwet.eVoucher.dto.UserDto;
import com.thwet.eVoucher.model.User;
import com.thwet.eVoucher.request.TokenRequest;
import com.thwet.eVoucher.response.ApiResponse;
import com.thwet.eVoucher.response.TokenResponse;
import com.thwet.eVoucher.service.UserService;

/**
 * @author Thwet Thwet Mar
 *
 *         Sep 23, 2021
 */
@RestController
@RequestMapping("api")
@CrossOrigin
public class AuthenticationController {
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	@Qualifier("customUserDetailsService")
	private UserDetailsService userDetailsService;

	@Autowired
	private UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/requesttoken")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody TokenRequest authenticationRequest)
			throws Exception {

		TokenResponse response = new TokenResponse();
		response.setCode(ResponseCode.SUCCESS.getResponseCode());
		response.setDesc("Token Generated Successfully.");

		authenticate(authenticationRequest.getEmail(), authenticationRequest.getPassword());

		User user = userService.findByEmail(authenticationRequest.getEmail());

		if (user.isFirstLogin()) {
			response.setCode(ResponseCode.CHANGE_PASSWORD.getResponseCode());
			response.setDesc("Please Change Password");
			return ResponseEntity.ok(response);
		}

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getEmail());

		final String token = jwtTokenUtil.generateToken(userDetails);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String expireDate = dateFormat.format(jwtTokenUtil.getExpirationDateFromToken(token));

		response.setExpiry_date_time(expireDate);
		response.setToken(token);

		return ResponseEntity.ok(response);
	}

	@PostMapping("/register")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<ApiResponse> registerUser(@RequestBody UserDto userDto) throws Exception {
		LOGGER.info(" Inside registerUser().");
		ApiResponse apiResponse = new ApiResponse();
		User userByID = this.userService.findByEmail(userDto.getEmail());
		if (userByID != null) {
			apiResponse.setCode(ResponseCode.ERROR.getResponseCode());
			apiResponse.setDesc("UserID already exist.");
		} else {
			User user = new User();
			user.setEmail(userDto.getEmail());
			user.setPassword(this.passwordEncoder.encode(userDto.getPassword()));
			user.setFirstLogin(true);
			user.setRole(Roles.ROLE_USER.getRole());
			this.userService.save(user);

			apiResponse.setCode(ResponseCode.SUCCESS.getResponseCode());
			apiResponse.setDesc("Successfully Registered.");
		}

		return ResponseEntity.ok(apiResponse);
	}

	@PostMapping("/changepassword")
	public ResponseEntity<?> changepassword(@RequestBody ChangePasswordDto changePasswordDto) throws Exception {
		ApiResponse apiResponse = new ApiResponse();
		User userData = this.userService.findByEmail(changePasswordDto.getEmail());

		if ((userData != null)
				&& passwordEncoder.matches(changePasswordDto.getCurrentPassword(), userData.getPassword())) {
			String newPwd = passwordEncoder.encode(changePasswordDto.getCurrentPassword());
			String oldPwd = passwordEncoder.encode(changePasswordDto.getCurrentPassword());

			userData.setFirstLogin(false);
			userData.setPassword(newPwd);
			userData.setOldPassword(oldPwd);

			this.userService.save(userData);
			apiResponse.setCode(ResponseCode.SUCCESS.getResponseCode());
			apiResponse.setDesc("Password change successfully.");
		} else {
			apiResponse.setCode(ResponseCode.ERROR.getResponseCode());
			apiResponse.setDesc("User not found.");
		}

		return ResponseEntity.ok(apiResponse);
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED");
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS");
		}
	}
}
