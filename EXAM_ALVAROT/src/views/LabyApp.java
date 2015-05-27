package views;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.Cadete;
import models.IngresoLaby;
import models.ModeloCadetes;

public class LabyApp extends JFrame {

	private JPanel contentPane;
	private JPanel panelCard;
	private JButton btnAtras;
	private JButton btnSiguiente;
	
	private PanelPerfil pPerfil;
	private PanelEquipos pEquipos;
	private PanelFinal pFinal;
	
	private IngresoLaby laby;
	
	private Connection conexion;
	
	private ModeloCadetes modelo;
	
	
	private Cadete cadete;
	
	private int pantalla=1;


	/**
	 * Create the frame.
	 */
	public LabyApp(Connection con) {
		
		conexion = con;
		
		modelo = new ModeloCadetes(conexion);
		
		String yo[] = modelo.consulta("32");
		//CREAMOS UN NUEVO CADETE CON LOS DATOS DE YO
		cadete = new Cadete(Integer.valueOf(yo[0]), yo[1], yo[2], Integer.valueOf(yo[3]), yo[4], Integer.valueOf(yo[5]));
		
		pPerfil = new PanelPerfil(this);
		pEquipos = new PanelEquipos(this);
		pFinal = new PanelFinal(this);
		
		laby = new IngresoLaby();
		
		
		setTitle("THE LABY");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelCard = new JPanel();
		panelCard.setBounds(10, 11, 534, 321);
		contentPane.add(panelCard);
		panelCard.setLayout(new CardLayout(0, 0));
		
		panelCard.add(pPerfil,"perfil");
		panelCard.add(pEquipos,"equipos");
		panelCard.add(pFinal,"final");
		
		
		btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarVista(btnAtras.getText());
			}
		});
		btnAtras.setBounds(10, 369, 163, 23);
		btnAtras.setVisible(false);
		contentPane.add(btnAtras);
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarVista(btnSiguiente.getText());
			}
		});
		btnSiguiente.setBounds(381, 369, 163, 23);
		contentPane.add(btnSiguiente);
		
		
	}
	//METODO EN EL QUE CAMBIAMOS LAS PANTALLAS DEPENDIENDO DE EN CUAL ESTEMOS Y A QUE BOTON LE DEMOS
	public void mostrarVista(String boton){
		CardLayout c= (CardLayout)panelCard.getLayout();
		if(boton.equals("Siguiente")){
			switch(pantalla){
			case 1:
				c.show(panelCard, "equipos");
				btnAtras.setVisible(true);
				pantalla++;
				break;
			case 2:
				c.show(panelCard, "final");
				btnSiguiente.setVisible(false);
				pantalla++;
				break;
			}
			
		}
		if(boton.equals("Atras")){
			switch(pantalla){
			case 3:
				c.show(panelCard, "equipos");
				btnSiguiente.setVisible(true);
				pantalla--;
				break;
			case 2:
				c.show(panelCard, "perfil");
				btnAtras.setVisible(false);
				pantalla--;
				break;
			}
		}
	}


	public JPanel getContentPane() {
		return contentPane;
	}


	public JPanel getPanelCard() {
		return panelCard;
	}


	public JButton getBtnAtras() {
		return btnAtras;
	}


	public JButton getBtnSiguiente() {
		return btnSiguiente;
	}


	public PanelPerfil getpPerfil() {
		return pPerfil;
	}


	public PanelEquipos getpEquipos() {
		return pEquipos;
	}


	public PanelFinal getpFinal() {
		return pFinal;
	}


	public Connection getConexion() {
		return conexion;
	}


	public ModeloCadetes getModelo() {
		return modelo;
	}


	public Cadete getCadete() {
		return cadete;
	}

	public IngresoLaby getLaby() {
		return laby;
	}
	
	
}
