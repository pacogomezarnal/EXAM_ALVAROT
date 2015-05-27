package views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelFinal extends JPanel {
	private JTextField textId;
	private JTextField textApellido;
	private JTextField textMensage;
	private JButton btnComprobar;
	
	private LabyApp ventana;

	/**
	 * Create the panel.
	 */
	public PanelFinal(LabyApp ven) {
		ventana = ven;
		
		setBounds(10, 11, 534, 321);
		setLayout(null);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(22, 36, 64, 14);
		add(lblId);
		
		JLabel lblerApellido = new JLabel("1er Apellido");
		lblerApellido.setBounds(107, 36, 96, 14);
		add(lblerApellido);
		
		textId = new JTextField();
		textId.setBounds(22, 61, 64, 20);
		add(textId);
		textId.setColumns(10);
		
		textApellido = new JTextField();
		textApellido.setBounds(107, 61, 96, 20);
		add(textApellido);
		textApellido.setColumns(10);
		
		btnComprobar = new JButton("COMPROBAR");
		btnComprobar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//LLAMAMOS AL METODO DE COMPROVACION Y PONEMOS EL MENSAGE EN SU LUGAR CORRESPONDIENTE
				String s = ventana.getLaby().getCod(Integer.valueOf(textId.getText()), textApellido.getText());
				textMensage.setText(s);
			}
		});
		btnComprobar.setBounds(22, 131, 491, 23);
		add(btnComprobar);
		
		textMensage = new JTextField();
		textMensage.setEditable(false);
		textMensage.setBounds(22, 198, 491, 20);
		add(textMensage);
		textMensage.setColumns(10);

	}

	public JTextField getTextId() {
		return textId;
	}

	public JTextField getTextApellido() {
		return textApellido;
	}

	public JTextField getTextMensage() {
		return textMensage;
	}

	public JButton getBtnComprobar() {
		return btnComprobar;
	}

	public LabyApp getVentana() {
		return ventana;
	}
	
	

}
