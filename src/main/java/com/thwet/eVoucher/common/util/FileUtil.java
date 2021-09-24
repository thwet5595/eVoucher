/**
 * 
 */
package com.thwet.eVoucher.common.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Thwet Thwet Mar
 *
 *         Sep 23, 2021
 */
public class FileUtil {
	public static void saveFile(String uploadDir, String fileName, MultipartFile file) throws Exception {

		Path uploadPath = Paths.get(uploadDir);

		if (!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}
		try (InputStream inputStream = file.getInputStream()) {
			Path filePath = uploadPath.resolve(fileName);
			Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException ex) {
			throw new Exception("Error occurs when save file " + fileName, ex);
		}
	}
}
