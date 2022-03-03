package com.finworks.utilities;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author ybilgin
 * @project FinworksErp
 */


public class ConfigurationReader_MT {

    private static Properties properties;

    static {

        try {
            String path = "configuration_MT.properties";
            FileInputStream input = new FileInputStream(path);
            properties = new Properties();
            properties.load(input);

            input.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static String get(String keyName) {
        return properties.getProperty(keyName);
    }

}
