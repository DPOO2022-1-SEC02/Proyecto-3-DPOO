package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.border.MatteBorder;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JComboBox;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import modelo.PrManager;
import modelo.Usuario;
import modelo.Proyecto;
import javax.swing.JTextArea;

public class FrameReporteUser extends JFrame {

	private JPanel contentPane;
	private JTextField txtInfoUsuariocambia;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameReporteUser frame = new FrameReporteUser();
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
	public FrameReporteUser(Usuario usuarioActual, PrManager manager, int idProy) {
		Proyecto prActual = manager.getProyecto(idProy);
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
					FrameReporteUser.this.dispose();
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
		pnlAzul.setBounds(0, 0, 202, 400);
		contentPane.add(pnlAzul);
		pnlAzul.setLayout(null);
		
		JLabel txtTitulo = new JLabel("Reporte de");
		txtTitulo.setVerticalAlignment(SwingConstants.BOTTOM);
		txtTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		txtTitulo.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		txtTitulo.setBounds(0, 38, 202, 40);
		pnlAzul.add(txtTitulo);
		
		JLabel lblActividades = new JLabel("Participantes");
		lblActividades.setVerticalAlignment(SwingConstants.TOP);
		lblActividades.setHorizontalAlignment(SwingConstants.CENTER);
		lblActividades.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblActividades.setBounds(0, 82, 202, 40);
		pnlAzul.add(lblActividades);
		
		JComboBox <String> cmboxListaUsers = new JComboBox<String>();
		cmboxListaUsers.setBackground(new Color(173, 216, 230));
		cmboxListaUsers.setFont(new Font("Comic Sans MS", Font.PLAIN, 11));
		cmboxListaUsers.setBounds(10, 135, 182, 22);
		pnlAzul.add(cmboxListaUsers);
		
		JPanel btnRegresar = new JPanel();
		btnRegresar.setLayout(null);
		btnRegresar.setBorder(new LineBorder(new Color(100, 149, 237), 2));
		btnRegresar.setBackground(new Color(135, 206, 250));
		btnRegresar.setBounds(24, 339, 148, 50);
		pnlAzul.add(btnRegresar);
		btnRegresar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				btnRegresar.setBackground(new Color(135, 149, 250));
				JComponent comp = (JComponent) e.getSource();
				Window win = SwingUtilities.getWindowAncestor(comp);
				win.dispose();
				FrameProyectInfo vistaAnterior = new FrameProyectInfo(manager,idProy, usuarioActual);//FrameReporteUser
				vistaAnterior.setVisible(true);
			}
		});
		
		JLabel lblRegresar = new JLabel("Regresar");
		lblRegresar.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegresar.setForeground(new Color(30, 144, 255));
		lblRegresar.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblRegresar.setBackground(Color.WHITE);
		lblRegresar.setBounds(10, 10, 128, 28);
		btnRegresar.add(lblRegresar);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(208, 116, 382, 273);
		contentPane.add(textArea);
		
		
				
		
		
		JLabel lblNombre = new JLabel();
		lblNombre.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		lblNombre.setBounds(212, 54, 378, 40);
		contentPane.add(lblNombre);
		
		for (String correo : prActual.getParticipantes().keySet()) {
			cmboxListaUsers.addItem(correo);
			
			cmboxListaUsers.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String seleccion = cmboxListaUsers.getSelectedItem().toString();
					Usuario reportado = prActual.getParticipante(seleccion);
					String reporte = reportado.generarReporte();
					textArea.setText(reporte);
					lblNombre.setText("Nombre: " + reportado.getName());
				}
			});
		
		setLocationRelativeTo(null);
		}
	}
}

