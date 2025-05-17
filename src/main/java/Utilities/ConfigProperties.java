package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {

    public static Properties property;
    private static String configPath="configuration/config.properties";
    public static void initializePropertyFile() throws IOException {
        property=new Properties();
        InputStream instm = new FileInputStream(configPath);
        property.load(instm);

    }

}
