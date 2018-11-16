package tec.ac.cr.CE3104.paCEman.propertyLoader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import tec.ac.cr.CE3104.paCEman.main.Main;

/**
 *
 * @author Keylor Rojas 
 * @version 28/10/2015
 */

public class ReadProperties {
    
    private InputStream input;
    private Properties properties;
    
    public ReadProperties(String file) throws IOException{
        //input = getClass().getClassLoader().getResourceAsStream(file);
        input = new FileInputStream(new File("").getAbsolutePath() + "\\Resources\\" + file);
        
        if(input != null){
        	properties = new Properties();
            properties.load(input);
        }
        try {
        	input.close();
        } catch (Exception e) {
			// TODO: handle exception
		}
    }
    
    public String getProperties(String key){
        return properties.getProperty(key);
    }
}