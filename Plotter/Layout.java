

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Layout implements ActionListener{
	
	
	private JTextField eingabeFeld,xMaxFeld,xMinFeld,yMaxFeld,yMinFeld,skalierungFeld;
	private JLabel eingabeLabel,xMaxLabel, xMinLabel,yMaxLabel,yMinLabel,skalierungLabel,ausgabeFeld,debugFeld;
	Graphzeichner sup;
	
	
	
	public Layout () {
		sup = new Graphzeichner();
		
		//Window definieren
		JFrame window = new JFrame();
		window.setTitle("Funktions-Plotter");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(800,800);
		window.setBackground(Color.lightGray);
		
		//Panel definieren
		JPanel debug=new JPanel();
		debug.setBackground(Color.GREEN);
		debug.setPreferredSize(new Dimension(100,30));
		JPanel ausgabe=new JPanel();
		ausgabe.setBackground(Color.RED);
		ausgabe.setPreferredSize(new Dimension(100,50));
		ausgabe.add(new Graphzeichner());
		JPanel eingabe=new JPanel();
		eingabe.setBackground(Color.BLUE);
		//eingabe.setPreferredSize(new Dimension(100,90)); quetscht sonst die buttons etc.
		
		//Button,Label, etc definieren
		
		//Buttons
		JButton draw= new JButton("Zeichnen");
		draw.addActionListener(this);
		JButton reset= new JButton("Löschen");
		
		//eingabeTexfelder
		
		eingabeFeld=new JTextField("0",10);
		xMaxFeld=new JTextField("0",10);
		xMinFeld=new JTextField("0",10);
		yMaxFeld=new JTextField("0",10);
		yMinFeld=new JTextField("0",10);
		skalierungFeld=new JTextField("0",10);
		
		//JLabel zu eingabeFelder
		debugFeld=new JLabel();
		ausgabeFeld=new JLabel();
		eingabeLabel = new JLabel();
		eingabeLabel.setText("Funktion");
		xMaxLabel = new JLabel();
		xMaxLabel.setText("Maximaler X-Wert");
		xMinLabel = new JLabel();
		xMinLabel.setText("Minimaler X-Wert");
		yMaxLabel = new JLabel();
		yMaxLabel.setText("Maximaler Y-Wert");
		yMinLabel = new JLabel();
		yMinLabel.setText("Minimaler Y-Wert");
		skalierungLabel = new JLabel();
		skalierungLabel.setText ("Skalierung");
				
		//Panel zusammenbauen
		eingabe.setLayout(new GridLayout(7,2)); 
		//button.setBounds(100, 100, 100, 100);
		debug.add(debugFeld);
		ausgabe.add(ausgabeFeld);
		eingabe.add(eingabeLabel);
		eingabe.add(eingabeFeld);
		eingabe.add(xMaxLabel);
		eingabe.add(xMaxFeld);
		eingabe.add(xMinLabel);
		eingabe.add(xMinFeld);
		eingabe.add(yMaxLabel);
		eingabe.add(yMaxFeld);
		eingabe.add(yMinLabel);
		eingabe.add(yMinFeld);
		eingabe.add(skalierungLabel);
		eingabe.add(skalierungFeld);
		eingabe.add(draw);
		eingabe.add(reset);		
		
		window.setLayout(new BorderLayout());
		window.add(debug,BorderLayout.SOUTH);
		window.add(eingabe,BorderLayout.WEST);
		window.add(ausgabe,BorderLayout.CENTER);
		
		window.pack();
		window.setVisible(true);
	}
	
		
	public void actionPerformed(ActionEvent e)
	{

		String ein = eingabeFeld.getText();
		String xma = xMaxFeld.getText();
		String xmi = xMinFeld.getText();
		String ska = skalierungFeld.getText();
		String ymi = yMinFeld.getText();
		String yma = yMaxFeld.getText();
		
		int xmin =Integer.parseInt(xmi);
		int xmax =Integer.parseInt(xma);
		int skal =Integer.parseInt(ska);
		int ymin =Integer.parseInt(ymi);
		int ymax =Integer.parseInt(yma);
			
		sup.setWindow(xmin,xmax,ymin,ymax,skal,ein);
		sup.plot(ein,xmin,xmax,debugFeld);
		sup.repaint();
	}

	public static void main(String[] args) {
		
		Layout Plotter = new Layout();
	}

}
