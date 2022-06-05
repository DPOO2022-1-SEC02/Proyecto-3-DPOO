package vista;

import modelo.PrManager;
import modelo.Proyecto;
import modelo.Usuario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JList;
import java.awt.ScrollPane;
import java.awt.Window;
import javax.swing.JTextField;

public class FrameProyectInfo extends JFrame {

	private JPanel contentPane;
	private JTextField txtDescripcion;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameProyectInfo frame = new FrameProyectInfo();
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
	public FrameProyectInfo(PrManager manager, int idProy, Usuario usuarioActual) {
		//Algo de logica
		Proyecto prActual = manager.getProyecto(idProy);
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
					FrameProyectInfo.this.dispose();
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
		pnlAzul.setBorder(new MatteBorder(2, 2, 2, 1, (Color) new Color(100, 149, 237)));
		pnlAzul.setBackground(new Color(209, 240, 238,40));
		pnlAzul.setForeground(Color.WHITE);
		pnlAzul.setBounds(0, 0, 186, 400);
		contentPane.add(pnlAzul);
		pnlAzul.setLayout(null);
	
		JPanel BtnEditar = new JPanel();
		BtnEditar.setBounds(21, 122, 148, 50);
		pnlAzul.add(BtnEditar);
		BtnEditar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BtnEditar.setBackground(new Color(135, 149, 250));
		    	JComponent comp = (JComponent) e.getSource();
		        Window win = SwingUtilities.getWindowAncestor(comp);
		        win.dispose();
		        FrameListadoActividades irAReporte = new FrameListadoActividades(idProy,manager, usuarioActual);
		        irAReporte.setVisible(true);
				}

		
		});
		BtnEditar.setBorder(new LineBorder(new Color(100, 149, 237), 2));
		BtnEditar.setBackground(new Color(135, 206, 250));
		BtnEditar.setLayout(null);
		
		JLabel lbLogin = new JLabel("Editar proyecto");
		lbLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lbLogin.setForeground(new Color(30, 144, 255));
		lbLogin.setBackground(Color.WHITE);
		lbLogin.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lbLogin.setBounds(10, 11, 107, 28);
		BtnEditar.add(lbLogin);
		
		
		JPanel btnReporte = new JPanel();
		btnReporte.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			btnReporte.setBackground(new Color(135, 149, 250));
	    	JComponent comp = (JComponent        ) e.getSource();
	        Window win = SwingUtilities.getWindowAncestor(comp);
	        win.dispose();
	        FrameReporteUser irAReporte = new FrameReporteUser(usuarioActual, manager, idProy);//FrameReporteUser
	        irAReporte.setVisible(true);   
			}
		});

		btnReporte.setLayout(null);
		btnReporte.setBorder(new LineBorder(new Color(100, 149, 237), 2));
		btnReporte.setBackground(new Color(135, 206, 250));
		btnReporte.setBounds(21, 202, 148, 50);
		pnlAzul.add(btnReporte);
		
		JLabel lblGenerarReporte = new JLabel("Generar reporte");
		lblGenerarReporte.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenerarReporte.setForeground(new Color(30, 144, 255));
		lblGenerarReporte.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblGenerarReporte.setBackground(Color.WHITE);
		lblGenerarReporte.setBounds(10, 11, 128, 28);
		btnReporte.add(lblGenerarReporte);
		
		JPanel btnRegresar = new JPanel();
		btnRegresar.setLayout(null);
		btnRegresar.setBorder(new LineBorder(new Color(100, 149, 237), 2));
		btnRegresar.setBackground(new Color(135, 206, 250));
		btnRegresar.setBounds(21, 277, 148, 50);
		pnlAzul.add(btnRegresar);
		
		JLabel lblRegresar = new JLabel("Regresar");
		lblRegresar.setHorizontalAlignment(SwingConstants.CENTER);
		btnRegresar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				btnRegresar.setBackground(new Color(135, 149, 250));
				JComponent comp = (JComponent) e.getSource();
				Window win = SwingUtilities.getWindowAncestor(comp);
				win.dispose();
				FrameListadoProyectos vistaAnterior = new FrameListadoProyectos(manager, usuarioActual);//FrameReporteUser
				vistaAnterior.setVisible(true);
			}
		});
		lblRegresar.setForeground(new Color(30, 144, 255));
		lblRegresar.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblRegresar.setBackground(Color.WHITE);
		lblRegresar.setBounds(10, 10, 128, 28);
		btnRegresar.add(lblRegresar);
		

		
		JLabel lblNombreProyecto = new JLabel("Nombre: " + prActual.getName());
		lblNombreProyecto.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombreProyecto.setForeground(new Color(30, 144, 255));
		lblNombreProyecto.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblNombreProyecto.setBounds(196, 51, 343, 26);
		contentPane.add(lblNombreProyecto);
		JLabel lblIdProyecto_1 = new JLabel("ID: " + String.valueOf(prActual.getId()));
		lblIdProyecto_1.setBackground(Color.WHITE);
		lblIdProyecto_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblIdProyecto_1.setForeground(new Color(30, 144, 255));
		lblIdProyecto_1.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblIdProyecto_1.setBounds(196, 88, 343, 26);
		contentPane.add(lblIdProyecto_1);
		
		
		JPanel pnlParticipantes = new JPanel(new GridLayout (prActual.getParticipantes().size(),0));
		pnlParticipantes.setBackground(new Color(204, 226, 243,80));
		pnlParticipantes.setBorder(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBounds(196, 249, 343, 130);
		
		
		for (String correo : prActual.getParticipantes().keySet()) {
			Usuario participante = prActual.getParticipantes().get(correo);
			String nombre = participante.getName();
			String textoMostrar = nombre+" - "+correo;
			JLabel texto = new JLabel(textoMostrar);
			texto.setFont(new Font("Roboto",Font.PLAIN,18));
            texto.setForeground(new Color(100, 100, 100));
			if (correo.equals(prActual.getDuenio().getEmail())) {
				texto.setFont(new Font("Roboto",Font.BOLD,18));
	            texto.setForeground(new Color(0, 110, 197));
			}
			
			
			pnlParticipantes.add(texto);
		}
		
		scrollPane.setViewportView(pnlParticipantes);
		contentPane.add(scrollPane);
		
		JLabel lblParticipantes_1 = new JLabel("Participantes");
		lblParticipantes_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblParticipantes_1.setForeground(new Color(30, 144, 255));
		lblParticipantes_1.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblParticipantes_1.setBounds(196, 208, 182, 47);
		contentPane.add(lblParticipantes_1);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setFont(new Font("Comic Sans MS", Font.PLAIN, 12));
			
		txtDescripcion.setText(prActual.getDescripcion());
		txtDescripcion.setEditable(false);
		txtDescripcion.setBackground(new Color(204, 226, 243,80));
		txtDescripcion.setBounds(196, 125, 343, 92);
		contentPane.add(txtDescripcion);
		txtDescripcion.setColumns(10);

		setLocationRelativeTo(null);
	}
}
