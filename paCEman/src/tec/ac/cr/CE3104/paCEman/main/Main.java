package tec.ac.cr.CE3104.paCEman.main;

import tec.ac.cr.CE3104.paCEman.GUI.PaCEmanFrame;
import tec.ac.cr.CE3104.paCEman.propertyLoader.Properties;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread pacWindow = new Thread(new PaCEmanFrame());
		pacWindow.start();
		pacWindow.join();
	}

}
