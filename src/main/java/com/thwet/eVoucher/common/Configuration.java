/**
 * 
 */
package com.thwet.eVoucher.common;

import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Thwet Thwet Mar
 *
 *         Sep 23, 2021
 */
public class Configuration {
	private static final Logger LOGGER = LoggerFactory.getLogger(Configuration.class);

	private static Properties config;

	static {
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties");
		config = new Properties();
		try {
			config.load(is);
		} catch (Exception e) {
			LOGGER.error("Error! Configuration");
		}
	}

	public static Properties getConfigs() {
		return config;
	}
}
