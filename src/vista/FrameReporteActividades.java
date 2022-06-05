package vista;

import modelo.PrManager;
import modelo.Usuario;

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
import javax.swing.JComponent;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class FrameReporteActividades extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameReporteActividades frame = new FrameReporteActividades();
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



	public FrameReporteActividades(int idProy, PrManager manager, Usuario usuarioActual) {

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
					FrameReporteActividades.this.dispose();
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
		txtTitulo.setBounds(0, 38, 202, 175);
		pnlAzul.add(txtTitulo);
		
		JLabel lblActividades = new JLabel("Actividades");
		lblActividades.setVerticalAlignment(SwingConstants.TOP);
		lblActividades.setHorizontalAlignment(SwingConstants.CENTER);
		lblActividades.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblActividades.setBounds(0, 225, 202, 175);
		pnlAzul.add(lblActividades);

		JPanel pnlReporte = new JPanel();
		pnlReporte.setBackground(Color.WHITE);
		pnlReporte.setBorder(new LineBorder(new Color(51, 51, 204)));
		pnlReporte.setBounds(212, 51, 375, 283);
		contentPane.add(pnlReporte);

	
		JPanel pnlBtnRegresar = new JPanel();
		pnlBtnRegresar.setLayout(null);
		pnlBtnRegresar.setBorder(new LineBorder(new Color(100, 149, 237), 2));
		pnlBtnRegresar.setBackground(new Color(135, 206, 250));
		pnlBtnRegresar.setBounds(455, 345, 132, 44);
		contentPane.add(pnlBtnRegresar);
		pnlBtnRegresar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pnlBtnRegresar.setBackground(new Color(135, 149, 250));
		    	JComponent comp = (JComponent) e.getSource();
		        Window win = SwingUtilities.getWindowAncestor(comp);
		        win.dispose();
		        FrameListadoActividades irAReporte = new FrameListadoActividades (idProy, manager,usuarioActual);
		        irAReporte.setVisible(true);
				
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlBtnRegresar.setBackground(new Color(153, 204, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnlBtnRegresar.setBackground(new Color(135, 206, 250));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				pnlBtnRegresar.setBackground(new Color(153, 204, 255));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				pnlBtnRegresar.setBackground(new Color(135, 206, 250));
			}
		});
		
		JLabel lbRegresar = new JLabel("Regresar");
		lbRegresar.setHorizontalAlignment(SwingConstants.CENTER);
		lbRegresar.setForeground(new Color(30, 144, 255));
		lbRegresar.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lbRegresar.setBackground(Color.WHITE);
		lbRegresar.setBounds(0, 0, 132, 44);
		pnlBtnRegresar.add(lbRegresar);
		
		
		setLocationRelativeTo(null);
	}
}
