import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class VentanaInicio extends JFrame implements ActionListener {
	
	String[] botones = {"%", "√", "x²", "1/x", "CE", "C", "«", "/", "7", "8", "9", "*", "4", "5", "6", "-", "1", "2", "3", "+", "±", "0", ".", "="};
	
	private static final long serialVersionUID = 1L;
	JButton[] arrayBotones;
	
	Logica_Calculadora lc = new Logica_Calculadora();
	GridBagConstraints gbc = new GridBagConstraints();
    JTextField resultado = new JTextField("");
	GridBagLayout gbl = new GridBagLayout();

    public VentanaInicio() {
        getContentPane().setLayout(gbl);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setTitle("Calculadora");
        setVisible(true);

        Font font = new Font("Arial", Font.PLAIN, 25);

        JButton options = new JButton("(");
        options.addActionListener(this);
        settBotones(options, 2, 0, 4, 2);
        JButton historial = new JButton(")");
        historial.addActionListener(this);
        settBotones(historial, 6, 0, 4, 2);
        
        resultado.setFont(font);
        settBotones(resultado, 0, 2, 10, 2);

        
        arrayBotones = new JButton[botones.length];

        int y = 4, x = 1;
        for (int i = 0; i < botones.length; i++) {
            arrayBotones[i] = new JButton(botones[i]);
            arrayBotones[i].addActionListener(this);
            arrayBotones[i].setFont(font);
            
            if (i % 4 == 0) {
                y = y + 2;
                x = 1;
            }
            settBotones(arrayBotones[i], 2 * x, y, 2, 2);
            x++;
        }
    }
//=====================================================================Mostrar cosas en el cajón de la calculadora===============================================================
    public void settBotones(JComponent c, int x, int y, int w, int h) {
    	c.setBackground(Color.WHITE);
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbl.setConstraints(c, gbc);
        add(c);
    }
 //================================================El código para lo botones============================
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton bottonElegido = (JButton) e.getSource();//Con el source
		String botonAtext = bottonElegido.getText();
		System.out.println(e);
		
		switch (botonAtext) {
		case "1/x":
			Double num = Double.parseDouble( resultado.getText()),resul = 1/num;
			resultado.setText(""+resul);
			
			break;
		case "CE": resultado.setText(""); break;
		
		case "C": resultado.setText(""); break;
			
		case "«": 
			String contenido = resultado.getText();
			
			if(contenido.length() > 0) {
			String datoBorrado = contenido.substring(0,contenido.length()-1);
			resultado.setText(datoBorrado);
			}
			break;
			
		//
		case "=":
			double res = lc.hacerOperaciones(resultado.getText());
			
			resultado.setText(res+"");
			break;
		
		case "±":
			double res2=0;
			if(resultado.getText().charAt(0) == 45) {
				res2 = lc.hacerOperaciones("0"+resultado.getText());
			}else {
				res2 = lc.hacerOperaciones(resultado.getText());
			}
			
			resultado.setText((res2*(-1))+"");
			
			break;
		case "x²":
			resultado.setText(resultado.getText() +"²");
			break;	
		case "√":
			resultado.setText("("+resultado.getText()+")√");
			break;	
		default:
			resultado.setText(resultado.getText() +botonAtext);
		}
		
	}

}

public class GUI_Eventos_Calculadora {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VentanaInicio();
            }
        });
    }
}
