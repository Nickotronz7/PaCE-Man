package tec.ac.cr.CE3104.paCEman.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import tec.ac.cr.CE3104.paCEman.programConstraints.Constraints;
//import tec.ac.cr.CE3104.paCEman.network.SimpleSocketClient;

public class PaCEmanFrame extends JFrame implements Runnable{
	
	private JButton _crearPartida;
	private JButton _conectarPartida;
	private JLabel img;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

//	private SimpleSocketClient client;
	
	public PaCEmanFrame() {
		buildFrame(this, Constraints.DIMENSION);
		_crearPartida = new JButton();
		_conectarPartida = new JButton();
		
		formatButton(_crearPartida, Constraints.BTN_CREATE1,
									Constraints.BTN_CREATE2,
									Constraints.BTN_CREATE3,
									Constraints.BTN_CREATE_X,
									Constraints.BTN_CREATE_Y);
		
		formatButton(_crearPartida, Constraints.BTN_CONNECT1,
									Constraints.BTN_CONNECT2,
									Constraints.BTN_CONNECT3,
									Constraints.BTN_CONNECT_X,
									Constraints.BTN_CONNECT_Y);
		
		img = getImage(Constraints.PACMAN_BACKGROUND);
		img.setBounds(	Constraints.BACKGROUND_X,
						Constraints.BACKGROUND_Y, 
						Constraints.BACKGROUND_WIDTH,
						Constraints.BACKGROUND_HEIGHT);
		
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
	public static void buildFrame(JFrame frame, Integer DIMENSION) {
		frame.setTitle(Constraints.STARTUP_NAME);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setSize(DIMENSION, DIMENSION);
		frame.setIconImage(new ImageIcon(Constraints.IMAGEPATH + Constraints.PACMANLOGO).getImage());
		frame.getContentPane().setLayout(null);
		
		//frame.getContentPane().setBackground(new Color(0, 0, 0));
	}
	
	private static void formatButton(	JButton pButton, 
										String pImage,
										String pSelected, 
										String pPressed, 
										Integer X, 
										Integer Y) {
		pButton.setBorder(BorderFactory.createEmptyBorder());
		pButton.setContentAreaFilled(false);
		pButton.setBounds(X, Y, Constraints.BTN_WIDTH, Constraints.BTN_HEIGHT);
		pButton.setIcon(getImage(pImage).getIcon());
		//pButton.setSelectedIcon(new ImageIcon(new File("").getAbsolutePath() + "\\Resources\\Images\\" + pSelected));
		pButton.setPressedIcon(getImage( pPressed).getIcon());
	}

	public static JLabel getImage(String imageName) {
		return new JLabel(new ImageIcon(Constraints.IMAGEPATH + imageName));
	}
	
	private ActionListener _crearPartidaListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			
			
		}
	};
	
	private ActionListener _conectarPartidaListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			//new Thread(new PaCEman()).start();
			setVisible(false);
		}
		
	};
	
	@Override
	public void run() {
		
		_crearPartida.addActionListener(_crearPartidaListener);
		
		_conectarPartida.addActionListener(_conectarPartidaListener);
	}
}
