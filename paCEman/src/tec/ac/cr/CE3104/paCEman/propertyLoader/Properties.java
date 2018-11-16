package tec.ac.cr.CE3104.paCEman.propertyLoader;

import java.io.IOException;
import javax.swing.JOptionPane;

public class Properties {

	private static ReadProperties PROPIEDADES = null;
		
	private Properties(){}
		
	public static String getProperties(String key){
		String value = "";
		try {
			value = getProps(key);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}
	
	private static String getProps(String key) throws IOException{
		if(PROPIEDADES == null){
			try {
				PROPIEDADES = new ReadProperties("Configuration.properties");
			} catch (IOException e) {
				System.out.println("Crear un archivo de constantes");
				JOptionPane.showMessageDialog(null, e.getStackTrace());
				return null;
				// TODO: handle exception
			}
		}			
		return PROPIEDADES.getProperties(key);
	}
}
