package vista;

import modelo.PrManager;
import modelo.Proyecto;
import modelo.Usuario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

public class FrameAddUser extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtCorreo;
	private JLabel lblLoginMessage = new JLabel("");

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameAddUser frame = new FrameAddUser();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the frame.
	 */
	public FrameAddUser(int idProy,PrManager manager, Usuario usuarioActual) {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(100, 149, 237)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlArriba = new JPanel();
		pnlArriba.setLayout(null);
		pnlArriba.setForeground(Color.BLACK);
		pnlArriba.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(100, 149, 237)));
		pnlArriba.setBackground(new Color(102, 204, 204));
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
					FrameAddUser.this.dispose();
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
		
		JPanel pnlBtnAdd = new JPanel();
		pnlBtnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtNombre.getText().equals("") || txtCorreo.getText().equals("") ||
					txtNombre.getText().equals("Nombre") || txtCorreo.getText().equals("Correo")) {
					lblLoginMessage.setText("� Ingresa todos los datos !");
				}
				else if(usuarioActual.equals(manager.getProyecto(idProy).getDuenio())){
					Proyecto prActual = manager.getProyecto(idProy);
					Usuario newUser = new Usuario(txtNombre.getText(),txtCorreo.getText(),prActual);
					manager.getProyecto(idProy).addParticipante(newUser);
					lblLoginMessage.setText("");
					JOptionPane.showMessageDialog(null, "� Agrego con exito !");
					
			    	JComponent comp = (JComponent) e.getSource();
			        Window win = SwingUtilities.getWindowAncestor(comp);
			        win.dispose();
			        FrameAddUser irAReporte = new FrameAddUser(idProy,manager, usuarioActual);
			        irAReporte.setVisible(true);					
				}
				
				else {
					JOptionPane.showMessageDialog(null, "No puedes añadir participantes, no eres el dueño");				
				}
				
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlBtnAdd.setBackground(new Color(153, 204, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnlBtnAdd.setBackground(new Color(135, 206, 250));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				pnlBtnAdd.setBackground(new Color(153, 204, 255));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				pnlBtnAdd.setBackground(new Color(135, 206, 250));
			}
		
		});
		pnlBtnAdd.setBorder(new LineBorder(new Color(100, 149, 237), 2));
		pnlBtnAdd.setBackground(new Color(135, 206, 250));
		pnlBtnAdd.setBounds(458, 338, 132, 51);
		contentPane.add(pnlBtnAdd);
		pnlBtnAdd.setLayout(null);
		
		JLabel lbAdd = new JLabel("Agregar");
		lbAdd.setForeground(new Color(30, 144, 255));
		lbAdd.setBackground(Color.WHITE);
		lbAdd.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lbAdd.setBounds(38, 11, 71, 28);
		pnlBtnAdd.add(lbAdd);
		
		JPanel pnlAzul = new JPanel();
		pnlAzul.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(100, 149, 237)));
		pnlAzul.setBackground(new Color(224, 255, 255));
		pnlAzul.setForeground(Color.WHITE);
		pnlAzul.setBounds(0, 0, 202, 400);
		contentPane.add(pnlAzul);
		pnlAzul.setLayout(null);
		
		JLabel lblNewUser = new JLabel("nuevo participante");
		lblNewUser.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblNewUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewUser.setBounds(10, 207, 182, 39);
		pnlAzul.add(lblNewUser);
		
		JLabel lblPorFavor = new JLabel("Por favor ingresa ");
		lblPorFavor.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblPorFavor.setHorizontalAlignment(SwingConstants.CENTER);
		lblPorFavor.setBounds(10, 149, 182, 47);
		pnlAzul.add(lblPorFavor);
		
		JLabel lblDatos = new JLabel("los datos del");
		lblDatos.setHorizontalAlignment(SwingConstants.CENTER);
		lblDatos.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblDatos.setBounds(10, 179, 182, 39);
		pnlAzul.add(lblDatos);
		
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
		txtNombre.setBackground(new Color(240, 255, 255));
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
		txtCorreo.setBackground(new Color(240, 255, 255));
		txtCorreo.setBounds(263, 213, 280, 37);
		contentPane.add(txtCorreo);
		
		lblLoginMessage.setForeground(new Color(139, 0, 0));
		lblLoginMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginMessage.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblLoginMessage.setBounds(263, 91, 279, 37);
		contentPane.add(lblLoginMessage);
		
		JPanel pnlBtnRegresar = new JPanel();
		pnlBtnRegresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pnlBtnRegresar.setBackground(new Color(135, 149, 250));
		    	JComponent comp = (JComponent) e.getSource();
		        Window win = SwingUtilities.getWindowAncestor(comp);
		        win.dispose();
		        FrameListadoActividades irAReporte = new FrameListadoActividades(idProy,manager, usuarioActual);//FrameReporteUser
		        irAReporte.setVisible(true);
				}
		});
		

		pnlBtnRegresar.setLayout(null);
		pnlBtnRegresar.setBorder(new LineBorder(new Color(100, 149, 237), 2));
		pnlBtnRegresar.setBackground(new Color(135, 206, 250));
		pnlBtnRegresar.setBounds(212, 338, 132, 51);
		contentPane.add(pnlBtnRegresar);
		
		JLabel lbRegresar = new JLabel("Regresar");
		lbRegresar.setForeground(new Color(30, 144, 255));
		lbRegresar.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lbRegresar.setBackground(Color.WHITE);
		lbRegresar.setBounds(38, 11, 71, 28);
		pnlBtnRegresar.add(lbRegresar);
		
		
		setLocationRelativeTo(null);
	}
}


