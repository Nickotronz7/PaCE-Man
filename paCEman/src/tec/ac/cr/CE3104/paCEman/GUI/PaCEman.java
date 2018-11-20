package tec.ac.cr.CE3104.paCEman.GUI;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import tec.ac.cr.CE3104.paCEman.GUI.PaCEmanFrame;
import tec.ac.cr.CE3104.paCEman.network.SimpleSocketClient;
import tec.ac.cr.CE3104.paCEman.programConstraints.Constraints;
import com.google.gson.JsonObject;

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
	
	private Integer direction;
	private Integer pValue;
	private Integer increment;
	
	private KeyListener pacManMovements = new KeyListener() {
		
		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
			//System.out.println(e);
			
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
		}
	
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			switch(e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				if(INITIAL_MATRIX[(_pacMan.getY()-10)/24][((_pacMan.getX()-20)/24)-1]!=0) {
					direction = KeyEvent.VK_LEFT;
				}
				//_pacMan.setBounds(_pacMan.getX()-24, _pacMan.getY(), _pacMan.getWidth(), _pacMan.getHeight());
				break;
			case KeyEvent.VK_UP:
				if(INITIAL_MATRIX[(_pacMan.getY()-10)/24-1][(_pacMan.getX()-10)/24]!=0) {
					direction = KeyEvent.VK_UP;
				}
				//_pacMan.setBounds(_pacMan.getX(), _pacMan.getY() - 24, _pacMan.getWidth(), _pacMan.getHeight());
				break;
			case KeyEvent.VK_RIGHT:
				if(INITIAL_MATRIX[(_pacMan.getY()-10)/24][(_pacMan.getX()-20)/24 +1]!=0) {
					direction = KeyEvent.VK_RIGHT;
				}
				//_pacMan.setBounds(_pacMan.getX()+24, _pacMan.getY(), _pacMan.getWidth(), _pacMan.getHeight());
				break;
			case KeyEvent.VK_DOWN:
				if(INITIAL_MATRIX[(_pacMan.getY()-10)/24 +1][(_pacMan.getX()-20)/24]!=0) {
					direction = KeyEvent.VK_DOWN;
				}
				//_pacMan.setBounds(_pacMan.getX(), _pacMan.getY() + 24, _pacMan.getWidth(), _pacMan.getHeight());
				break;
			default:
				break;
		}
			try {
				e.wait(200);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			
		}
	}
	};
	
	
	private JsonObject json;
	private SimpleSocketClient socket;
	
	public PaCEman() throws Exception{
		PaCEmanFrame.buildFrame(this, Constraints.GAME_DIMENSION);
		_elementMat = new JLabel[19][21];
		_pacMan = new JLabel();
		drawGame(this, _elementMat);
		setResizable(false);
		direction = KeyEvent.VK_LEFT;
		_pacMan.setBounds(10*24+20,15*24+10, 22,22);
		_pacMan.setVisible(true);
		getContentPane().add(_pacMan);
		setVisible(true);
		json = new JsonObject();
		socket = new SimpleSocketClient(8080, "172.18.66.214");
		json.addProperty("message_type", "begin_game");
		System.out.println(socket.writeToAndReadFromSocket(json.toString()));
		pValue = 1;
		increment = 1;
		this.addKeyListener(pacManMovements);
		
	}
	
	private static void drawGame(PaCEman frame, JLabel[][] pElementMat) {
		frame.getContentPane().setBackground(Color.BLACK);
		//JLabel _block = new JLabel(new ImageIcon(new File("").getAbsolutePath() + Properties.getProperties("IMAGEPATH") + "PACMURO.png"));
		//JLabel _dot = new JLabel(new ImageIcon(new File("").getAbsolutePath() + Properties.getProperties("IMAGEPATH") + "PACPUNTO.png"));
		
		for(Integer i = 0; i<19; i++) {
			for(Integer j = 0; j < 21; j++) {
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
	
	private ImageIcon rotateImageIcon(ImageIcon picture, double angle) {
        // FOR YOU ...
        Integer w = picture.getIconWidth();
        Integer h = picture.getIconHeight();
        Integer type = BufferedImage.TYPE_INT_RGB;  // other options, see api
        BufferedImage image = new BufferedImage(h, w, type);
        Graphics2D g2 = image.createGraphics();
        double x = (h - w)/2.0;
        double y = (w - h)/2.0;
        AffineTransform at = AffineTransform.getTranslateInstance(x, y);
        at.rotate(Math.toRadians(angle), w/2.0-1.5, h/2.0-0.5);
        g2.drawImage(picture.getImage(), at, null);
        g2.dispose();
        picture = new ImageIcon(image);
 
        return picture;
    }
	
	void move() throws InterruptedException {
		switch (direction) {
			case KeyEvent.VK_LEFT:
				if(INITIAL_MATRIX[(_pacMan.getY()-10)/24][((_pacMan.getX()-20)/24)-1]!=0) {
					for(Integer i = 0; i<4 ; i++) {
						_pacMan.setBounds(_pacMan.getX()-6, _pacMan.getY(), _pacMan.getWidth(), _pacMan.getHeight());
						
						if (pValue%4 == 3 || pValue%4 == 0) {
							increment = -1*increment;
						}
						
						_pacMan.setIcon(rotateImageIcon(_pacman[pValue], 180));
						pValue = pValue + increment;
						System.out.println("here");
						Thread.sleep(40);
					}
					_elementMat[((_pacMan.getX()-20)/24)][(_pacMan.getY()-10)/24].setIcon(null);
				}
				break;
				
			case KeyEvent.VK_UP:
				if(INITIAL_MATRIX[(_pacMan.getY()-10)/24-1][(_pacMan.getX()-10)/24]!=0) {
					for(Integer i = 0; i<4 ; i++) {
						_pacMan.setBounds(_pacMan.getX(), _pacMan.getY() - 6, _pacMan.getWidth(), _pacMan.getHeight());
						
						if (pValue%4 == 3 || pValue%4 == 0) {
							increment = -1*increment;
						}
						_pacMan.setIcon(rotateImageIcon(_pacman[pValue], -90));
						pValue = pValue + increment;
						Thread.sleep(40);
					}
					_elementMat[((_pacMan.getX()-20)/24)][(_pacMan.getY()-10)/24].setIcon(null);
				}
				break;
			case KeyEvent.VK_RIGHT:
				if(INITIAL_MATRIX[(_pacMan.getY()-10)/24][(_pacMan.getX()-20)/24 +1]!=0) {
					for(Integer i = 0; i<4 ; i++) {
						_pacMan.setBounds(_pacMan.getX()+6, _pacMan.getY(), _pacMan.getWidth(), _pacMan.getHeight());
						if (pValue%4 == 3 || pValue%4 == 0) {
							increment = -1*increment;
						}
						_pacMan.setIcon(_pacman[pValue]);
						pValue = pValue + increment;
						Thread.sleep(40);
					}
					_elementMat[((_pacMan.getX()-20)/24)][(_pacMan.getY()-10)/24].setIcon(null);
				}
				break;
			case KeyEvent.VK_DOWN:
				if(INITIAL_MATRIX[(_pacMan.getY()-10)/24 +1][(_pacMan.getX()-20)/24]!=0) {
					for(Integer i = 0; i<4 ; i++) {
						_pacMan.setBounds(_pacMan.getX(), _pacMan.getY() + 6, _pacMan.getWidth(), _pacMan.getHeight());
						
						if (pValue%4 == 3 || pValue%4 == 0) {
							increment = -1*increment;
						}
						_pacMan.setIcon(rotateImageIcon(_pacman[pValue], 90));
						pValue = pValue + increment;
						Thread.sleep(40);
					}
					_elementMat[((_pacMan.getX()-20)/24)][(_pacMan.getY()-10)/24].setIcon(null);
					
				}
				break;
			

		default:
			break;
		}
	}
	
	
	@Override
	public void run(){
		while(true) {
			try {
				move();
				
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				//e1.printStackTrace();
			}
			
			
		
		}
		// TODO Auto-generated method stub
		
	}
}
