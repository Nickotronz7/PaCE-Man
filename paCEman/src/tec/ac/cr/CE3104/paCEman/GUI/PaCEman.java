package tec.ac.cr.CE3104.paCEman.GUI;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

import tec.ac.cr.CE3104.paCEman.GUI.PaCEmanFrame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import tec.ac.cr.CE3104.paCEman.propertyLoader.Properties;

public class PaCEman extends JFrame implements Runnable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Explicación de los números en la matriz
	 */
	/*private final static byte INITIAL_MATRIX[][] = {
			{0,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,0},
			{0,8,1,1,1,1,1,1,1,1,8,1,1,1,1,1,1,1,1,8,0},
			{0,8,1,8,8,1,8,8,8,1,8,1,8,8,8,1,8,8,1,8,0},
			{0,8,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,8,0},
			{0,8,1,8,8,1,8,1,8,8,8,8,8,1,8,1,8,8,1,8,0},
			{0,8,1,1,1,1,8,1,1,1,8,1,1,1,8,1,1,1,1,8,0},
			{0,8,8,8,8,1,8,8,8,1,8,1,8,8,8,1,8,8,8,8,0},
			{0,0,0,0,8,1,8,0,0,0,0,0,0,0,8,1,8,0,0,0,0},
			{8,8,8,8,8,1,8,0,8,8,0,8,8,0,8,1,8,8,8,8,8},
			{0,0,0,0,0,1,1,0,8,0,0,0,8,0,1,1,0,0,0,0,0},
			{8,8,8,8,8,1,8,0,8,8,8,8,8,0,8,1,8,8,8,8,8},
			{0,0,0,0,8,1,8,0,0,0,0,0,0,0,8,1,8,0,0,0,0},
			{0,8,8,8,8,1,8,1,8,8,8,8,8,1,8,1,8,8,8,8,0},
			{0,8,1,1,1,1,1,1,1,1,8,1,1,1,1,1,1,1,1,8,0},
			{0,8,1,8,8,1,8,8,8,1,8,1,8,8,8,1,8,8,1,8,0},
			{0,8,1,1,8,1,1,1,1,1,5,1,1,1,1,1,8,1,1,8,0},
			{0,8,8,1,8,1,8,1,8,8,8,8,8,1,8,1,8,1,8,8,0},
			{0,8,1,1,1,1,8,1,1,1,8,1,1,1,8,1,1,1,1,8,0},
			{0,8,1,8,8,8,8,8,8,1,8,1,8,8,8,8,8,8,1,8,0},
			{0,8,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,8,0},
			{0,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,8,0}
	};*/
	private final static byte INITIAL_MATRIX[][] = {
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0},
			{0,1,0,0,1,0,0,0,1,0,1,0,0,0,1,0,0,1,0},
			{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
			{0,1,0,0,1,0,1,0,0,0,0,0,1,0,1,0,0,1,0},
			{0,1,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,1,0},
			{0,0,1,0,1,0,0,0,1,0,1,0,0,0,1,0,1,0,0},
			{0,1,1,0,1,0,1,1,1,1,1,1,1,0,1,0,1,1,0},
			{0,1,0,0,1,0,1,0,0,0,0,0,1,0,1,0,0,1,0},
			{0,1,0,0,1,1,1,0,2,3,4,0,1,1,1,0,0,1,0},
			{0,1,0,0,1,0,1,0,0,0,0,0,1,0,1,0,0,1,0},
			{0,1,1,1,1,0,1,1,1,1,1,1,1,0,1,1,1,1,0},
			{0,0,0,0,1,0,1,0,0,0,0,0,1,0,1,0,0,0,0},
			{0,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0},
			{0,1,0,0,1,0,0,0,1,0,1,0,0,0,1,0,0,1,0},
			{0,1,1,0,1,1,1,1,1,1,1,1,1,1,1,0,1,1,0},
			{0,0,1,0,1,0,1,0,0,0,0,0,1,0,1,0,1,0,0},
			{0,1,1,1,1,0,1,1,1,0,1,1,1,0,1,1,1,1,0},
			{0,1,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,1,0},
			{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
	};
	private static JLabel _elementMat[][];
	private JLabel _pacMan;
	private ImageIcon _pacman[] = {
			new ImageIcon(new File("").getAbsolutePath() + Properties.getProperties("IMAGEPATH") + "PACMAN-SPRITE-1.png"),
			new ImageIcon(new File("").getAbsolutePath() + Properties.getProperties("IMAGEPATH") + "PACMAN-SPRITE-2.png"),
			new ImageIcon(new File("").getAbsolutePath() + Properties.getProperties("IMAGEPATH") + "PACMAN-SPRITE-3.png"),
			new ImageIcon(new File("").getAbsolutePath() + Properties.getProperties("IMAGEPATH") + "PACMAN-SPRITE-4.png")
	};
	
	public PaCEman(){
		PaCEmanFrame.buildFrame(this, Integer.parseInt(Properties.getProperties("GAME_DIMENSION")));
		_elementMat = new JLabel[21][21];
		_pacMan = new JLabel();
		drawGame(this, _elementMat);
		setResizable(false);
	}
	
	private static void drawGame(PaCEman frame, JLabel[][] pElementMat) {
		frame.getContentPane().setBackground(Color.BLACK);
		//JLabel _block = new JLabel(new ImageIcon(new File("").getAbsolutePath() + Properties.getProperties("IMAGEPATH") + "PACMURO.png"));
		//JLabel _dot = new JLabel(new ImageIcon(new File("").getAbsolutePath() + Properties.getProperties("IMAGEPATH") + "PACPUNTO.png"));
		
		for(int i = 0; i<19; i++) {
			for(int j = 0; j < 21; j++) {
				switch (INITIAL_MATRIX[j][i]) {
				case 1:
					pElementMat[i][j] = getImage( "PACPUNTO.png");
					pElementMat[i][j].setBounds(i*24+20, j*24+10, 22, 22);
					frame.getContentPane().add(pElementMat[i][j]);
					pElementMat[i][j].setVisible(true);
					break;
					
				/*case 5:
					pElementMat[i][j] = getImage( "PACMAN.png");
					pElementMat[i][j].setBounds(i*24+20, j*24+10, 22, 22);
					frame.getContentPane().add(pElementMat[i][j]);
					pElementMat[i][j].setVisible(true);
					break;*/
					
				case 0:
					pElementMat[i][j] = getImage("PACMURO.png");
					pElementMat[i][j].setBounds(i*24+20, j*24+10, 22, 22);
					frame.getContentPane().add(pElementMat[i][j]);
					pElementMat[i][j].setVisible(true);
					break;
				default:
					break;
				}
			}
		}
	}
	
	
	private static JLabel getImage(String URL) {
		return PaCEmanFrame.getImage(URL);
	}
	
	
	@Override
	public void run() {
		_pacMan.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		int pValue = 1;
		int increment = 1;
		_pacMan.setIcon(_pacman[pValue]);
		_pacMan.setBounds(10*24+20,15*24+10, 22,22);
		_pacMan.setVisible(true);
		getContentPane().add(_pacMan);
		setVisible(true);
		while(true) {
			switch(pValue) {
			case 0:
				increment = -increment;
				break;
			case 3:
				increment = -increment;
				break;
			}
			pValue = pValue + increment;
			_pacMan.setIcon(_pacman[pValue]);

			
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		// TODO Auto-generated method stub
		
	}
}
