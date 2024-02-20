import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.*;

class VentanaInicio extends JFrame implements ActionListener{
	
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	//==========================================================================
	JTextField resultado = new JTextField();
	
    JButton[] arrayBotones;
	
	
	public VentanaInicio() {
		
		getContentPane().setLayout(gbl);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600,600);
		setLocationRelativeTo(null);
		setTitle("Calculadora");
		setVisible(true);
		
		String[] botones = {"%","√","x²","1/x","CE","C","«","/","7","8","9","X","4","5","6","-","1","2","3","+","±","0",".","="};
		arrayBotones = new JButton [botones.length];
		
		
		
		int y=2,x=1;
		for(int i = 0; i < botones.length ; i++) {
			
			arrayBotones[i] = new JButton(botones[i]);
			arrayBotones[i].addActionListener(this);
			if(i%4==0) {
				y = y*2;
				x=1;
			}
			settBotones(arrayBotones[i], 2*x, y, 2, 2);
			x++;
			
		}

		
		
		
	}//VentanaInicio
	
	@Override
	public void actionPerformed(ActionEvent e) {//Este es el metodo que sobreescrivimos para al precionar btnSumar realice una accion
	// TODO Auto-generated method stub
		System.out.println(e);
		
	
	}
	 
	public void settBotones(JComponent c, int x, int y,int w, int h) {
		gbc.gridx = x;//donde inicia en x
		gbc.gridy = y;//donde inicia en y
		gbc.gridwidth = w;//De cuanto es la medida de largo
		gbc.gridheight = h;//La medida de alto
		gbc.fill = GridBagConstraints.HORIZONTAL;
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
