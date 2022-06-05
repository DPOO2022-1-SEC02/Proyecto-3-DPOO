package vista;

import modelo.PrManager;
import modelo.Usuario;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.border.MatteBorder;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;


public class FrameLogin extends JFrame {
	
	private Usuario usuarioActual;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtCorreo;
	private JLabel lblLoginMessage = new JLabel("");
	/**
	 * Launch the application.
	 */

	private PrManager manager = new PrManager();
	public static void main(String[] args) {


		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameLogin frame = new FrameLogin();
					frame.loadData();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void loadData(){
		try {

			FileInputStream file = new FileInputStream("data/guardado.ser");
			ObjectInputStream in = new ObjectInputStream(file);
			manager = (PrManager) in.readObject();
			System.out.println("Info cargada");
		} catch (Exception ex) {
			System.out.println("No se han podido cargar datos anteriores. ");
		}
	}

	/**
	 * Create the frame.
	 */
	public FrameLogin() {

		ImageIcon iconTaskbar = new ImageIcon("./resources/drawable/appIcons/taskbar.png");
		this.setIconImage(iconTaskbar.getImage());


		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();

		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(100, 149, 237)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pnlArriba = new JPanel();
		pnlArriba.setLayout(null);
		pnlArriba.setForeground(Color.BLACK);
		pnlArriba.setBorder(new MatteBorder(2, 2, 1, 2, (Color) new Color(100, 149, 237)));
		pnlArriba.setBackground(new Color(227, 245, 244));
		pnlArriba.setBounds(0, 0, 600, 40);
		contentPane.add(pnlArriba);

		JLabel lblTitle = new JLabel("Project manager");
		lblTitle.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(227, 11, 134, 20);
		pnlArriba.add(lblTitle);

		JLabel lblExit = new JLabel("X");
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "�Estas seguro que quieres salir?", "Confirmaci�n", JOptionPane.YES_NO_OPTION)==0) {
					FrameLogin.this.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblExit.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblExit.setForeground(Color.WHITE);
			}
		});
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblExit.setBounds(558, 11, 32, 19);
		pnlArriba.add(lblExit);

		JPanel pnlBtnLogin = new JPanel();
		pnlBtnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtNombre.getText().equals("") || txtCorreo.getText().equals("") ||
					txtNombre.getText().equals("Nombre") || txtCorreo.getText().equals("Correo")) {
					lblLoginMessage.setText("� Ingresa todos los datos !");
				}
				else {
					//TODO Guardar nombres y esas vainas feas
					String nombre = txtNombre.getText();
					String correo = txtCorreo.getText();
					
					usuarioActual = new Usuario(nombre, correo,null);
					
					
					//Siguiente Frame
					JComponent comp = (JComponent) e.getSource();
                    Window win = SwingUtilities.getWindowAncestor(comp);
                    win.dispose();
                    FrameListadoProyectos listadoProyectos = new FrameListadoProyectos(manager, usuarioActual);
                    listadoProyectos.setVisible(true);
				}

			}
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlBtnLogin.setBackground(new Color(153, 204, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnlBtnLogin.setBackground(new Color(135, 206, 250));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				pnlBtnLogin.setBackground(new Color(153, 204, 255));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				pnlBtnLogin.setBackground(new Color(135, 206, 250));
			}

		});
		pnlBtnLogin.setBorder(new LineBorder(new Color(100, 149, 237), 2));
		pnlBtnLogin.setBackground(new Color(135, 206, 250));
		pnlBtnLogin.setBounds(410, 301, 132, 51);
		contentPane.add(pnlBtnLogin);
		pnlBtnLogin.setLayout(null);

		JLabel lbLogin = new JLabel("LOG IN");
		lbLogin.setForeground(new Color(30, 144, 255));
		lbLogin.setBackground(Color.WHITE);
		lbLogin.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lbLogin.setBounds(38, 11, 71, 28);
		pnlBtnLogin.add(lbLogin);

		JPanel pnlAzul = new JPanel();
		pnlAzul.setBorder(new MatteBorder(2, 2, 2, 1, (Color) new Color(100, 149, 237)));
		pnlAzul.setBackground(new Color(209, 240, 238,40));
		pnlAzul.setForeground(Color.WHITE);
		pnlAzul.setBounds(0, 0, 202, 400);
		contentPane.add(pnlAzul);
		pnlAzul.setLayout(null);

		JLabel lblBienvenido = new JLabel("Bienvenid@!");
		lblBienvenido.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenido.setBounds(10, 168, 182, 39);
		pnlAzul.add(lblBienvenido);

		JLabel lblPorFavor = new JLabel("Por favor ingresa ");
		lblPorFavor.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblPorFavor.setHorizontalAlignment(SwingConstants.CENTER);
		lblPorFavor.setBounds(10, 206, 182, 47);
		pnlAzul.add(lblPorFavor);

		JLabel lblTusDatos = new JLabel("tus datos");
		lblTusDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblTusDatos.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblTusDatos.setBounds(10, 241, 182, 39);
		pnlAzul.add(lblTusDatos);
		
		
		ImageIcon uniandes = new ImageIcon("./resources/drawable/andes.jpg");
		JLabel lblNewLabel = new JLabel(uniandes);
		lblNewLabel.setBounds(10, 62, 171, 65);
		pnlAzul.add(lblNewLabel);
		
		

		txtNombre = new JTextField();
		txtNombre.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtNombre.getText().equals("Nombre")) {
					txtNombre.setText("");
				}
				else {
					txtNombre.selectAll();
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if(txtNombre.getText().equals("")) {
					txtNombre.setText("Nombre");
				}

			}
		});
		txtNombre.setBorder(new LineBorder(new Color(135, 206, 250), 2));
		txtNombre.setForeground(new Color(100, 149, 237));
		txtNombre.setBackground(Color.WHITE);
		txtNombre.setText("Nombre");
		txtNombre.setHorizontalAlignment(SwingConstants.LEFT);
		txtNombre.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		txtNombre.setColumns(10);
		txtNombre.setBounds(263, 148, 280, 37);
		contentPane.add(txtNombre);

		txtCorreo = new JTextField();
		txtCorreo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtCorreo.getText().equals("Correo")) {
					txtCorreo.setText("");
				}
				else {
					txtCorreo.selectAll();
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtCorreo.getText().equals("")) {
					txtCorreo.setText("Correo");
				}

			}
		});
		txtCorreo.setText("Correo");
		txtCorreo.setHorizontalAlignment(SwingConstants.LEFT);
		txtCorreo.setForeground(new Color(100, 149, 237));
		txtCorreo.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		txtCorreo.setColumns(10);
		txtCorreo.setBorder(new LineBorder(new Color(135, 206, 250), 2));
		txtCorreo.setBackground(Color.WHITE);
		txtCorreo.setBounds(263, 213, 280, 37);
		contentPane.add(txtCorreo);

		lblLoginMessage.setForeground(new Color(139, 0, 0));
		lblLoginMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginMessage.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblLoginMessage.setBounds(263, 91, 279, 37);
		contentPane.add(lblLoginMessage);


		setLocationRelativeTo(null);
	}
}
