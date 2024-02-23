import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class VentanaInicio extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
	GridBagLayout gbl = new GridBagLayout();
    GridBagConstraints gbc = new GridBagConstraints();
    JTextField resultado = new JTextField("");

    JButton[] arrayBotones;

    public VentanaInicio() {
        getContentPane().setLayout(gbl);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setTitle("Calculadora");
        setVisible(true);

        Font font = new Font("Arial", Font.PLAIN, 25);

        JTextArea Solucion = new JTextArea(" = ");
        settBotones(Solucion, 2, 0, 1, 2);

        JTextArea Estandar = new JTextArea("  ESTANDAR      ");
        settBotones(Estandar, 3, 0, 5, 2);

        JTextArea historial = new JTextArea("H");
        settBotones(historial, 8, 0, 2, 2);
        
        // Elimina esta redeclaración de resultado
        // JTextArea resultado = new JTextArea("");
        resultado.setFont(font);
        settBotones(resultado, 0, 2, 10, 2);

        String[] botones = {"%", "√", "x²", "1/x", "CE", "C", "«", "/", "7", "8", "9", "X", "4", "5", "6", "-", "1", "2", "3", "+", "±", "0", ".", "="};
        arrayBotones = new JButton[botones.length];

        int y = 4, x = 1;
        for (int i = 0; i < botones.length; i++) {
            arrayBotones[i] = new JButton(botones[i]);
            arrayBotones[i].addActionListener(this);
            arrayBotones[i].setBackground(Color.WHITE);
            arrayBotones[i].setFont(font);

            final int index = i;
            arrayBotones[i].addActionListener(this); 

            if (i % 4 == 0) {
                y = y + 2;
                x = 1;
            }
            settBotones(arrayBotones[i], 2 * x, y, 2, 2);
            x++;
        }
    }

    public void settBotones(JComponent c, int x, int y, int w, int h) {
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = w;
        gbc.gridheight = h;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbl.setConstraints(c, gbc);
        add(c);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton bottonElegido = (JButton) e.getSource();//Con el source
		String botonAtext = bottonElegido.getText();
		
		switch (botonAtext) {
		case "" :
			
			break;
		default:
			resultado.setText(botonAtext);
			break;
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
