/**
 * 
 */
package com.thwet.eVoucher.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import com.thwet.eVoucher.common.Roles;
import com.thwet.eVoucher.model.User;
import com.thwet.eVoucher.service.UserService;

/**
 * @author Thwet Thwet Mar
 *
 *         Sep 23, 2021
 */
@Component
@EnableAsync
public class AppStartupRunner implements ApplicationRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(AppStartupRunner.class);

	@Value("${app.admin.username}")
	private String adminUserName;
	@Value("${app.admin.email}")
	private String adminEmail;
	@Value("${app.admin.password}")
	private String adminPassword;

	@Autowired
	UserService userService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		LOGGER.info("E-Voucher Application Started!");

		createAdminUser(adminUserName, adminPassword, adminEmail);
	}

	private void createAdminUser(String userName, String password, String email) {

		LOGGER.info("Inside createAdminUser()");

		// Check if already exist
		User user = userService.findByEmail(userName);

		if (user == null) {
			String encPwd = passwordEncoder.encode(password);

			User adminUser = new User();
			adminUser.setName(userName);
			adminUser.setEmail(email);
			adminUser.setPassword(encPwd);
			adminUser.setRole(Roles.ROLE_ADMIN.getRole());

			userService.save(adminUser);
		} else {
			LOGGER.info("Admin user already exit! => " + user.getEmail());
		}
	}
}
