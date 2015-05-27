package views;

import java.util.Iterator;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelEquipos extends JPanel {
	private JTextField textNombre;
	private JTextField textId;
	private JTextField textApellido1;
	private JTextField textApellido2;
	private JTextField textNacionalidad;
	private JComboBox comboBox;
	
	private LabyApp ventana;

	/**
	 * Create the panel.
	 */
	public PanelEquipos(LabyApp ven) {
		ventana = ven;
		
		setBounds(10, 11, 534, 321);
		setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(195, 21, 118, 14);
		add(lblNombre);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(364, 21, 46, 14);
		add(lblId);
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		textNombre.setBounds(195, 46, 135, 20);
		add(textNombre);
		textNombre.setColumns(10);
		
		textId = new JTextField();
		textId.setEditable(false);
		textId.setBounds(364, 46, 86, 20);
		add(textId);
		textId.setColumns(10);
		
		JLabel lblApellidos = new JLabel("1er Apellido");
		lblApellidos.setBounds(195, 93, 118, 14);
		add(lblApellidos);
		
		textApellido1 = new JTextField();
		textApellido1.setEditable(false);
		textApellido1.setBounds(195, 118, 135, 20);
		add(textApellido1);
		textApellido1.setColumns(10);
		
		JLabel lblApellido2 = new JLabel("2\u00BA Apellido");
		lblApellido2.setBounds(195, 163, 118, 14);
		add(lblApellido2);
		
		textApellido2 = new JTextField();
		textApellido2.setEditable(false);
		textApellido2.setBounds(195, 188, 135, 20);
		add(textApellido2);
		textApellido2.setColumns(10);
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad");
		lblNacionalidad.setBounds(195, 235, 118, 14);
		add(lblNacionalidad);
		
		textNacionalidad = new JTextField();
		textNacionalidad.setEditable(false);
		textNacionalidad.setBounds(195, 260, 135, 20);
		add(textNacionalidad);
		textNacionalidad.setColumns(10);
		
		//RECORREMOS EL ARRAYLIST DEBUELTO POR EL METODO QUE FILTRA EQUIPOS Y AÑADIMOS TODOS LOS CAMPOS NOMBRE EN NUESTRO COMBOBOX
		Iterator<String[]> it = ventana.getModelo().consulta2("2").iterator();
		
		comboBox = new JComboBox();
		while(it.hasNext()){
			comboBox.addItem(it.next()[1]);
		}
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//RELLENAMOS LOS DATOS SEGUN EL NOMBRE DEL COMBOBOX ELEGIDO Y PASAMOS UN APELLIDO A LA SIGUIENTE PANTALLA
				int apll = ventana.getModelo().consulta2("2").get(comboBox.getSelectedIndex())[2].indexOf(" ");
				String apellidos = ventana.getModelo().consulta2("2").get(comboBox.getSelectedIndex())[2];
				textNombre.setText(ventana.getModelo().consulta2("2").get(comboBox.getSelectedIndex())[1]);
				textId.setText(ventana.getModelo().consulta2("2").get(comboBox.getSelectedIndex())[0]);
				textApellido1.setText(ventana.getModelo().consulta2("2").get(comboBox.getSelectedIndex())[2].substring(0, apll));
				textApellido2.setText(ventana.getModelo().consulta2("2").get(comboBox.getSelectedIndex())[2].substring(apll+1));
				textNacionalidad.setText(ventana.getModelo().consulta2("2").get(comboBox.getSelectedIndex())[4]);
				
				ventana.getpFinal().getTextApellido().setText(apellidos.substring(0, apll));
			}
		});
		comboBox.setBounds(30, 46, 118, 20);
		add(comboBox);
		
		JLabel lblEquipos = new JLabel("Equipos");
		lblEquipos.setBounds(30, 21, 118, 14);
		add(lblEquipos);

	}
}
