package tec.ac.cr.CE3104.paCEman.main;

import tec.ac.cr.CE3104.paCEman.GUI.PaCEman;
import tec.ac.cr.CE3104.paCEman.GUI.PaCEmanFrame;
import tec.ac.cr.CE3104.paCEman.propertyLoader.Properties;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Thread pacWindow = new Thread(new PaCEman());
		pacWindow.start();
		pacWindow.join();
	}

}
