package com.ubn.bvnv2.parameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Settings {


	public static String getPropertiesValue(String key) {
		Properties prop = new Properties();
		InputStream input = null;
		String retValue = "";
		String config_path = "C:\\bvn_update" + File.separator + "ubnwebpay.properties";

		try {
			input = new FileInputStream(config_path);
			prop.load(input);
			retValue = prop.getProperty(key);
		} catch (IOException ex) {
			ex.printStackTrace();
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (input != null) {
				try {
					input.close();
					prop.clear();
				} catch (IOException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return retValue;
	}
}
