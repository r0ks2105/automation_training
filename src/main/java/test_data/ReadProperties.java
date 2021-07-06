package test_data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
    private final static String PATHTOPROPERTIES = "src/main/resources/project.properties";
    private static ReadProperties instance;
    Properties properties = new Properties();

    private ReadProperties()  throws IOException {
        FileInputStream inputStream = new FileInputStream(PATHTOPROPERTIES);
        properties.load(inputStream);
    }
    public static ReadProperties getInstance() throws Exception{
        if (instance == null){
            instance = new ReadProperties();
        }
        return instance;
    }

    public String getProperty(String propertyKey) throws Exception{
        return this.properties.getProperty(propertyKey);
        }

        public void setProperties(String key, String value) throws IOException {
            FileOutputStream fileInputStream = new FileOutputStream(PATHTOPROPERTIES);
            properties.put(key, value);
            properties.store(fileInputStream, "New email created");

        }
}
