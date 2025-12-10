package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;
    static {
        String configFilePath = System.getProperty("user.dir") + "/src/main/resources/config.properties";
        FileInputStream fileInputStream = null;
        try{
            properties = new Properties();
            fileInputStream = new FileInputStream(configFilePath);
            properties.load(fileInputStream);
        }catch(IOException e){
            e.printStackTrace();  
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}
