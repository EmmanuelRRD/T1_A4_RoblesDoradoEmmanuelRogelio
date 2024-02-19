import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class VentanaInicio extends JFrame implements ActionListener{
	
	
	
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	JButton btnSumar = new JButton();
	JTextField boxA1 = new JTextField();
	JTextField boxA2 = new JTextField();
	JTextField resultado = new JTextField();
	
	
	public VentanaInicio() {
		
		getContentPane().setLayout(gbl);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,600);
		setLocationRelativeTo(null);
		setTitle("Calculadora");
		setVisible(true);
		
		btnSumar = new JButton("Sumar");
		btnSumar.addActionListener(this);
		add(btnSumar);
		
		
	}//VentanaInicio
	
	@Override
	public void actionPerformed(ActionEvent e) {//Este es el metodo que sobreescrivimos para al precionar btnSumar realice una accion
	// TODO Auto-generated method stub
		System.out.println(e);
		
	
	}
	 
	public void settComponents(JComponent c, int x, int y,int w, int h) {
		gbc.gridx = x;//donde inicia en x
		gbc.gridy = y;//donde inicia en y
		gbc.gridwidth = w;//De cuanto es la medida de largo
		gbc.gridheight = h;//La medida de alto
		gbl.setConstraints(c, gbc);
		add(c);
	}
	
	
}//Clase ventana

public class GUI_Eventos_Calculadora {
	public static void main(String[] args) {
		
SwingUtilities.invokeLater(new Runnable() {
				
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new VentanaInicio();
			}
		});
		
	}
}
