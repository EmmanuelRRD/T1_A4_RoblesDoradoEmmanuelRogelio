import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

class VentanaInicio extends JFrame implements ActionListener{
	
	
	
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	//==========================================================================
	JTextField resultado = new JTextField();
	
	JButton CE, C, delet, suma, resta, multiplicacion, divicion, igual, porcentaje, raiz, cuadrado, unoEntreN;
	
    JButton uno, dos, tres, cuatro, cinco, seis, siete, ocho, Nueve;
	
	
	public VentanaInicio() {
		
		getContentPane().setLayout(gbl);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,600);
		setLocationRelativeTo(null);
		setTitle("Calculadora");
		setVisible(true);
		
		CE = new JButton("CE");
		CE.addActionListener(this);
		settComponents(CE, 0, 0, 2, 2);
		
		C = new JButton("C");
		C.addActionListener(this);
		gbc.fill = GridBagConstraints.VERTICAL;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		settComponents(C, 2, 0, 2, 2);
		
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
