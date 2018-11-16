package tec.ac.cr.CE3104.paCEman.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import tec.ac.cr.CE3104.paCEman.propertyLoader.Properties;

public class PaCEmanFrame extends JFrame implements Runnable{
	
	private JButton _crearPartida;
	private JButton _conectarPartida;
	private JLabel img;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	protected final static Integer DIMENSION = Integer.parseInt(Properties.getProperties("DIMENSION"));

	public PaCEmanFrame() {
		buildFrame(this, DIMENSION);
		_crearPartida = new JButton();
		_conectarPartida = new JButton();
		formatButton(_crearPartida, "CREAR-01.png", "CREAR-02.png", "CREAR-03.png", 188,180);
		formatButton(_conectarPartida, "CONECTARSE-01.png", "CONECTARSE-02.png", "CONECTARSE-03.png", 188, 240);
		
		img = getImage("PACMAN.gif");
		img.setBounds(-10,-10, 500,500);
		img.setVisible(true);
		
		getContentPane().add(_crearPartida);
		getContentPane().add(_conectarPartida);
		getContentPane().add(img);
		
		_crearPartida.setVisible(true);
		_conectarPartida.setVisible(true);
		setResizable(false);
		setVisible(true);
		
	}
	
	/**
	 * 
	 * @param frame Objeto al que se desea modificar los elementos para que calcen con los elementos
	 * PaCEman
	 */
	public static void buildFrame(JFrame frame, int DIMENSION) {
		frame.setTitle(Properties.getProperties("STARTUP_NAME"));
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setSize(DIMENSION, DIMENSION);
		frame.setIconImage(new ImageIcon(new File("").getAbsolutePath() + Properties.getProperties("PACMANLOGO")).getImage());
		frame.getContentPane().setLayout(null);
		
		//frame.getContentPane().setBackground(new Color(0, 0, 0));
	}
	
	private static void formatButton(JButton pButton, String pImage,String pSelected, String pPressed, int X, int Y) {
		pButton.setBorder(BorderFactory.createEmptyBorder());
		pButton.setContentAreaFilled(false);
		pButton.setBounds(X, Y, 124,38);
		pButton.setIcon(getImage(pImage).getIcon());
		//pButton.setSelectedIcon(new ImageIcon(new File("").getAbsolutePath() + "\\Resources\\Images\\" + pSelected));
		pButton.setPressedIcon(getImage( pPressed).getIcon());
	}

	public static JLabel getImage(String imageName) {
		return new JLabel(new ImageIcon(new File("").getAbsolutePath() + Properties.getProperties("IMAGEPATH") + imageName));
	}
	
	@Override
	public void run() {
		_conectarPartida.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Thread(new PaCEman()).start();
				setVisible(false);
			}
		});
	}
}
