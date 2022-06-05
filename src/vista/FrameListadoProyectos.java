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
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.MatteBorder;

import modelo.PrManager;
import modelo.Proyecto;
import modelo.Usuario;

import java.awt.event.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JButton;
import java.awt.ScrollPane;
import javax.swing.JScrollBar;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class FrameListadoProyectos extends JFrame implements Serializable{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameListadoProyectos frame = new FrameListadoProyectos();
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
	public FrameListadoProyectos(PrManager manager, Usuario usuarioActual) {
		//Aqui viene la logica


		
		
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
					FrameListadoProyectos.this.dispose();
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
		
		JLabel lblNewLabel = new JLabel("Proyectos Disponibles");
		lblNewLabel.setForeground(new Color(51, 102, 204));
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblNewLabel.setBounds(57, 51, 247, 42);
		contentPane.add(lblNewLabel);

		//TODO cambiar el 1 por manager.sizeOfList() para que no se muera el editor
		GridLayout layoutProyectos = new GridLayout(manager.sizeOfList(),0);
		layoutProyectos.setVgap(20);
		JPanel listadoProyectos = new JPanel(layoutProyectos);
		listadoProyectos.setBorder(null);
		listadoProyectos.setBackground(new Color(204, 226, 243,80));

		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(57, 116, 485, 221);
		scrollPane.setBorder(null);
		
		
		
		ArrayList<Proyecto> proyectos = manager.getProyectos();

		for (Proyecto proyecto :proyectos) {
			//textoInteractivo proyDisplay = new textoInteractivo(texto,manager);
			JLabel texto = new JLabel(proyecto.getName());
			texto.setFont(new Font("Roboto",Font.PLAIN,18));
			texto.setForeground(new Color(0, 110, 197));
			listadoProyectos.add(texto);
			setActions(texto,manager,proyecto.getId(),usuarioActual);
		}

		scrollPane.setViewportView(listadoProyectos);
		contentPane.add(scrollPane);
		
		JPanel pnlBtnNewProyecto = new JPanel();
		pnlBtnNewProyecto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//TODO
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlBtnNewProyecto.setBackground(new Color(153, 204, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnlBtnNewProyecto.setBackground(new Color(135, 206, 250));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				pnlBtnNewProyecto.setBackground(new Color(153, 204, 255));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				pnlBtnNewProyecto.setBackground(new Color(135, 206, 250));
			}
		
		});
		pnlBtnNewProyecto.setLayout(null);
		pnlBtnNewProyecto.setBorder(new LineBorder(new Color(100, 149, 237), 2));
		pnlBtnNewProyecto.setBackground(new Color(135, 206, 250));
		pnlBtnNewProyecto.setBounds(400, 51, 141, 44);
		contentPane.add(pnlBtnNewProyecto);
		
		JLabel lblNuevoProyecto = new JLabel("+ Nuevo proyecto");
		lblNuevoProyecto.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoProyecto.setForeground(new Color(0, 110, 197));
		lblNuevoProyecto.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblNuevoProyecto.setBackground(Color.WHITE);
		lblNuevoProyecto.setBounds(0, 0, 141, 44);
		pnlBtnNewProyecto.add(lblNuevoProyecto);
		
		JPanel pnlBtnSaveInfo = new JPanel();
		pnlBtnSaveInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlBtnSaveInfo.setBackground(new Color(153, 204, 255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnlBtnSaveInfo.setBackground(new Color(135, 206, 250));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				pnlBtnSaveInfo.setBackground(new Color(153, 204, 255));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				pnlBtnSaveInfo.setBackground(new Color(135, 206, 250));
			}
		
		});
		
		pnlBtnNewProyecto.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				 JComponent comp = (JComponent) e.getSource();
                 Window win = SwingUtilities.getWindowAncestor(comp);
                 win.dispose();
				FrameCrearProyecto siguienteVista = null;
				try {
					siguienteVista = new FrameCrearProyecto(manager, usuarioActual);
				} catch (Exception ex) {
					throw new RuntimeException(ex);
				}
				siguienteVista.setVisible(true);
			}
		});
		pnlBtnSaveInfo.setLayout(null);
		pnlBtnSaveInfo.setBorder(new LineBorder(new Color(100, 149, 237), 2));
		pnlBtnSaveInfo.setBackground(new Color(135, 206, 250));
		pnlBtnSaveInfo.setBounds(385, 348, 157, 44);
		contentPane.add(pnlBtnSaveInfo);
		
		JLabel lblGuardarInformacin = new JLabel("Guardar Informaci\u00F3n");
		lblGuardarInformacin.setHorizontalAlignment(SwingConstants.CENTER);
		lblGuardarInformacin.setForeground(new Color(0, 110, 197));
		lblGuardarInformacin.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblGuardarInformacin.setBackground(Color.WHITE);
		lblGuardarInformacin.setBounds(0, 0, 157, 44);
		pnlBtnSaveInfo.add(lblGuardarInformacin);
		
		pnlBtnSaveInfo.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				try {
				FileOutputStream file = new FileOutputStream("data/guardado.ser");
				ObjectOutputStream out = new ObjectOutputStream(file);
				out.writeObject(manager);
				out.close();
				file.close();
				System.out.println("Info guardada.");}
				catch(Exception ex) {
					System.out.println("No se ha podido guardar la info.");
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}

			
		});

		
		setLocationRelativeTo(null);
	}

	public void setActions(JLabel textoDisplayed,PrManager manager,int idProy,Usuario usuarioActual){
		textoDisplayed.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textoDisplayed.setForeground(new Color(100,50,180));
				JComponent comp = (JComponent) e.getSource();
				Window win = SwingUtilities.getWindowAncestor(comp);
				win.dispose();
				FrameProyectInfo infoDelProyecto = new FrameProyectInfo(manager, idProy, usuarioActual);
				infoDelProyecto.setVisible(true);
			}

			@Override
			public void mousePressed(MouseEvent e) {}

			@Override
			public void mouseReleased(MouseEvent e) {}

			@Override
			public void mouseEntered(MouseEvent e) {}

			@Override
			public void mouseExited(MouseEvent e) {}
		});
	}

}
