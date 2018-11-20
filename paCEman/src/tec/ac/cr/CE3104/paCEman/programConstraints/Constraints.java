package tec.ac.cr.CE3104.paCEman.programConstraints;

import java.io.File;

import tec.ac.cr.CE3104.paCEman.propertyLoader.Properties;

public abstract class Constraints {
	//paCEmanFrame.java constraints
		//int
	public final static Integer DIMENSION= new Integer(Integer.parseInt(Properties.getProperties("DIMENSION")));
	public final static Integer GAME_DIMENSION= new Integer(Integer.parseInt(Properties.getProperties("GAME_DIMENSION")));
	public final static Integer BTN_CREATE_X = new Integer(Integer.parseInt(Properties.getProperties("BTN_CREATE_X")));
	public final static Integer BTN_CREATE_Y = new Integer(Integer.parseInt(Properties.getProperties("BTN_CREATE_Y")));
	
	public final static Integer BTN_CONNECT_X = new Integer(Integer.parseInt(Properties.getProperties("BTN_CONNECT_X")));
	public final static Integer BTN_CONNECT_Y = new Integer(Integer.parseInt(Properties.getProperties("BTN_CONNECT_Y")));
	
	public final static Integer BTN_WIDTH = new Integer(Integer.parseInt(Properties.getProperties("BTN_WIDTH")));
	public final static Integer BTN_HEIGHT =new Integer(Integer.parseInt(Properties.getProperties("BTN_HEIGHT")));
	
	public final static Integer BACKGROUND_X = new Integer(Integer.parseInt(Properties.getProperties("BACKGROUND_POS")));
	public final static Integer BACKGROUND_Y = BACKGROUND_X;
	public final static Integer BACKGROUND_WIDTH = DIMENSION;
	public final static Integer BACKGROUND_HEIGHT = DIMENSION;
	
		//String
	public final static String BTN_CREATE1 = Properties.getProperties("BTN_CREATE1");
	public final static String BTN_CREATE2 = Properties.getProperties("BTN_CREATE2");
	public final static String BTN_CREATE3 = Properties.getProperties("BTN_CREATE3");
	
	public final static String BTN_CONNECT1 = Properties.getProperties("BTN_CONNECT1");
	public final static String BTN_CONNECT2 = Properties.getProperties("BTN_CONNECT2");
	public final static String BTN_CONNECT3 = Properties.getProperties("BTN_CONNECT3");
	
	public final static String STARTUP_NAME = Properties.getProperties("STARTUP_NAME");
	
	public final static String PATH = new File("").getAbsolutePath();
	public final static String PACMANLOGO = Properties.getProperties("PACMANLOGO");
	
	public final static String PACMAN_BACKGROUND = Properties.getProperties("PACMAN_BACKGROUND");
	public final static String IMAGEPATH = PATH + Properties.getProperties("IMAGEPATH");
	
	
}
