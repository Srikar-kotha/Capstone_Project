package config;

import lombok.Getter;
import lombok.Setter;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Setter
@Getter
public class ConfigReader {

    private Properties properties;

    public ConfigReader() {
        properties = new Properties();
        try(InputStream input = new FileInputStream("C:\\Users\\srikar.kotha\\IdeaProjects\\Capstone_Project\\src\\main\\resources\\paraBank.properties"))
        {
            properties.load(input);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public String getUrl(){
        return properties.getProperty("url");
    }
}