package vista;

import modelo.PrManager;
import modelo.Proyecto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JComboBox;
import modelo.Actividad;
import modelo.Usuario;
public class FrameNewAct extends JFrame {

	private JPanel contentPane;
	private JTextField txtDescripcion;
	private JTextField txtNombre;
	private JLabel lblMessage = new JLabel("");
	private JTextField txtActividad;
	private JTextField txtCorreoEncargado;
	private String seleccionTipoAct;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameNewAct frame = new FrameNewAct();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public FrameNewAct(int idProy,PrManager manager, Usuario usuarioActual) {
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
		lblTitle.setBounds(174, 10, 134, 20);
		pnlArriba.add(lblTitle);
		
		JLabel lblExit = new JLabel("X");
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, "�Estas seguro que quieres salir?", "Confirmaci�n", JOptionPane.YES_NO_OPTION)==0) {
					FrameNewAct.this.dispose();
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
		
		JPanel pnlAzul = new JPanel();
		pnlAzul.setBorder(new MatteBorder(3, 3, 3, 3, (Color) new Color(100, 149, 237)));
		pnlAzul.setBackground(new Color(224, 255, 255));
		pnlAzul.setForeground(Color.WHITE);
		pnlAzul.setBounds(0, 334, 600, 66);
		contentPane.add(pnlAzul);
		pnlAzul.setLayout(null);
		
		JPanel pnlBtnRegresar = new JPanel();
		pnlBtnRegresar.setBounds(10, 11, 132, 44);
		pnlAzul.add(pnlBtnRegresar);
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
		
		JLabel lbRegresar = new JLabel("Regresar");
		lbRegresar.setHorizontalAlignment(SwingConstants.CENTER);
		lbRegresar.setForeground(new Color(30, 144, 255));
		lbRegresar.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lbRegresar.setBackground(Color.WHITE);
		lbRegresar.setBounds(0, 0, 132, 44);
		pnlBtnRegresar.add(lbRegresar);

		JPanel pnlBtnAdd = new JPanel();

		pnlBtnAdd.setLayout(null);
		pnlBtnAdd.setBorder(new LineBorder(new Color(100, 149, 237), 2));
		pnlBtnAdd.setBackground(new Color(135, 206, 250));
		pnlBtnAdd.setBounds(458, 11, 132, 44);
		pnlAzul.add(pnlBtnAdd);
		
		JLabel lbAdd = new JLabel("Agregar");
		
		lbAdd.setHorizontalAlignment(SwingConstants.CENTER);
		lbAdd.setForeground(new Color(30, 144, 255));
		lbAdd.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lbAdd.setBackground(Color.WHITE);
		lbAdd.setBounds(0, 0, 132, 44);
		pnlBtnAdd.add(lbAdd);
		
		txtDescripcion = new JTextField();
		txtDescripcion.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtDescripcion.getText().equals("Descripcion Actividad")) {
					txtDescripcion.setText("");
				}
				else {
					txtDescripcion.selectAll();
					// TODO
				}
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				if(txtDescripcion.getText().equals("")) {
					txtDescripcion.setText("Descripcion Actividad");
				}
				
			}
		});
		txtDescripcion.setBorder(new LineBorder(new Color(135, 206, 250), 2));
		txtDescripcion.setForeground(new Color(100, 149, 237));
		txtDescripcion.setBackground(new Color(240, 255, 255));
		txtDescripcion.setText("Descripcion Actividad");
		txtDescripcion.setHorizontalAlignment(SwingConstants.LEFT);
		txtDescripcion.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(24, 150, 337, 37);
		contentPane.add(txtDescripcion);
		
		txtNombre = new JTextField();
		txtNombre.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtNombre.getText().equals("Nombre Encargado")) {
					txtNombre.setText("");
				}
				else {
					txtNombre.selectAll();
					// TODO
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtNombre.getText().equals("")) {
					txtNombre.setText("Nombre Encargado");
					
				}
				
			}
		});
		txtNombre.setText("Nombre Encargado");
		txtNombre.setHorizontalAlignment(SwingConstants.LEFT);
		txtNombre.setForeground(new Color(100, 149, 237));
		txtNombre.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		txtNombre.setColumns(10);
		txtNombre.setBorder(new LineBorder(new Color(135, 206, 250), 2));
		txtNombre.setBackground(new Color(240, 255, 255));
		txtNombre.setBounds(24, 198, 337, 37);
		contentPane.add(txtNombre);
		
		lblMessage.setForeground(new Color(139, 0, 0));
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		lblMessage.setBounds(371, 51, 219, 37);
		contentPane.add(lblMessage);
		
		txtActividad = new JTextField();
		txtActividad.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtActividad.getText().equals("Nombre Actividad")) {
					txtActividad.setText("");
				}
				else {
					txtActividad.selectAll();
					// TODO
				}
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				if(txtActividad.getText().equals("")) {
					txtActividad.setText("Nombre Actividad");
				}
				
			}
		});
		txtActividad.setText("Nombre Actividad");
		txtActividad.setHorizontalAlignment(SwingConstants.LEFT);
		txtActividad.setForeground(new Color(100, 149, 237));
		txtActividad.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		txtActividad.setColumns(10);
		txtActividad.setBorder(new LineBorder(new Color(135, 206, 250), 2));
		txtActividad.setBackground(new Color(240, 255, 255));
		txtActividad.setBounds(24, 102, 337, 37);
		contentPane.add(txtActividad);
		
		JLabel lblTitulo = new JLabel("Agregar una actividad");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblTitulo.setForeground(new Color(51, 102, 204));
		lblTitulo.setBounds(24, 51, 337, 40);
		contentPane.add(lblTitulo);
		
		txtCorreoEncargado = new JTextField();
		txtCorreoEncargado.setText("Correo Encargado");
		txtCorreoEncargado.setHorizontalAlignment(SwingConstants.LEFT);
		txtCorreoEncargado.setForeground(new Color(100, 149, 237));
		txtCorreoEncargado.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
		txtCorreoEncargado.setColumns(10);
		txtCorreoEncargado.setBorder(new LineBorder(new Color(135, 206, 250), 2));
		txtCorreoEncargado.setBackground(new Color(240, 255, 255));
		txtCorreoEncargado.setBounds(24, 246, 337, 37);
		contentPane.add(txtCorreoEncargado);
		txtCorreoEncargado.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(txtCorreoEncargado.getText().equals("Correo Encargado")) {
					txtCorreoEncargado.setText("");
				}
				else {
					txtCorreoEncargado.selectAll();
					// TODO
				}
			}
			
			@Override
			public void focusLost(FocusEvent e) {
				if(txtCorreoEncargado.getText().equals("")) {
					txtCorreoEncargado.setText("Correo Encargado");
				}
				
			}
		});
		
		JComboBox  <String> cmbBoxTipos = new JComboBox <String> ();
		
		cmbBoxTipos.setBackground(new Color(240,255,255));
		cmbBoxTipos.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		cmbBoxTipos.setBounds(24, 294, 337, 37);
		contentPane.add(cmbBoxTipos);
		
		for(String tipo: manager.getProyecto(idProy).getTiposArray()) {
			cmbBoxTipos.addItem(tipo);
			
		}
		cmbBoxTipos.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				seleccionTipoAct = cmbBoxTipos.getSelectedItem().toString();
				
			}
			
		});
		setLocationRelativeTo(null);
		
		//Logica para añadir actividad 
		pnlBtnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtNombre.getText().equals("") || txtActividad.getText().equals("") || txtDescripcion.getText().equals("")){
					lblMessage.setText("¡ Ingresa todos los datos !");
				}
				else {
					lblMessage.setText("");
					int idProyecto = manager.getId();	
					Usuario user = manager.getProyecto(idProy).getParticipante(txtCorreoEncargado.getText());
					if (user != null){
						Proyecto prActual = manager.getProyecto(idProy);
						user.setPrActual(prActual);
						user.iniciarActividadExt(txtCorreoEncargado.getText(),txtActividad.getText(),cmbBoxTipos.getName(),txtDescripcion.getText());
						
						JOptionPane.showMessageDialog(null, "ï¿½ Agrego con exito !");
						
				    	JComponent comp = (JComponent) e.getSource();
				        Window win = SwingUtilities.getWindowAncestor(comp);
				        win.dispose();
				        FrameNewAct irAReporte = new FrameNewAct(idProy,manager,usuarioActual);
				        irAReporte.setVisible(true);
					}
					else{
						Proyecto prActual = manager.getProyecto(idProy);
						Usuario newUser = new Usuario(txtNombre.getText(),txtCorreoEncargado.getText(), prActual);
						manager.getProyecto(idProy).addParticipante(newUser);
						newUser.iniciarActividadExt(txtCorreoEncargado.getText(),txtActividad.getText(),cmbBoxTipos.getName(),txtDescripcion.getText());
						JOptionPane.showMessageDialog(null, "Se agrego el nuevo usuario y se creo la actividad!");	
						
				    	JComponent comp = (JComponent) e.getSource();
				        Window win = SwingUtilities.getWindowAncestor(comp);
				        win.dispose();
				        FrameNewAct irAReporte = new FrameNewAct(idProy,manager,usuarioActual);
				        irAReporte.setVisible(true);				
					}
					
					

				}
				
				
			}		
		});
	}
}
