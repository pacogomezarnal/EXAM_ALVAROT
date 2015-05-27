package views;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PanelPerfil extends JPanel {
	private JTextField textNombre;
	private JTextField textId;
	private JTextField textApellidos;
	private JTextField textEdad;
	private JTextField textNacionalidad;
	private JLabel foto;
	
	private LabyApp ventana;

	/**
	 * Create the panel.
	 */
	public PanelPerfil(LabyApp ven) {
		ventana = ven;
		
		setBounds(10, 11, 534, 321);
		setLayout(null);
		
		
		
		foto = new JLabel("");
		foto.setBounds(28, 21, 118, 146);
		//CREAMOS UNA NUEVA IMAGEN PARA PONERLA EN EL LABEL FOTO
		Image imgHistoria = new ImageIcon(this.getClass().getResource("/FrontCover.jpg")).getImage();
		foto.setIcon(new ImageIcon(imgHistoria));
		add(foto);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(195, 21, 118, 14);
		add(lblNombre);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(364, 21, 46, 14);
		add(lblId);
		/*
		 * RELLENAMOS LOS DATOS CON LOS QUE NOS PROPORCIONA LA CLASE CADETE 
		 */
		textNombre = new JTextField(ventana.getCadete().getNombre());
		textNombre.setEditable(false);
		textNombre.setBounds(195, 46, 152, 20);
		add(textNombre);
		textNombre.setColumns(10);
		
		textId = new JTextField(String.valueOf(ventana.getCadete().getId()));
		textId.setEditable(false);
		textId.setBounds(364, 46, 86, 20);
		add(textId);
		textId.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(195, 93, 118, 14);
		add(lblApellidos);
		
		textApellidos = new JTextField(ventana.getCadete().getApellidos());
		textApellidos.setEditable(false);
		textApellidos.setBounds(195, 118, 152, 20);
		add(textApellidos);
		textApellidos.setColumns(10);
		
		JLabel lblEdad = new JLabel("Edad");
		lblEdad.setBounds(195, 163, 118, 14);
		add(lblEdad);
		
		textEdad = new JTextField(String.valueOf(ventana.getCadete().getEdad()));
		textEdad.setEditable(false);
		textEdad.setBounds(195, 188, 152, 20);
		add(textEdad);
		textEdad.setColumns(10);
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad");
		lblNacionalidad.setBounds(195, 235, 118, 14);
		add(lblNacionalidad);
		
		textNacionalidad = new JTextField(ventana.getCadete().getNacionalidad());
		textNacionalidad.setEditable(false);
		textNacionalidad.setBounds(195, 260, 152, 20);
		add(textNacionalidad);
		textNacionalidad.setColumns(10);

	}
}
