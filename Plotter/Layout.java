package plotter;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Layout implements ActionListener{
	
	Verarbeitung test = new Verarbeitung();
	Graphzeichner sup = new Graphzeichner();
	private JTextField eingabeFeld,xMaxFeld,xMinFeld,yMaxFeld,yMinFeld,skalierungFeld;
	private JLabel eingabeLabel,xMaxLabel, xMinLabel,yMaxLabel,yMinLabel,skalierungLabel,platzhalter;
	
	public Layout () {
		//Window definieren
		JFrame window = new JFrame();
		window.setTitle("Funktions-Plotter");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(800,800);
		window.setBackground(Color.lightGray);
		
		//Panel definieren
		JPanel eingabe=new JPanel();
		eingabe.setBackground(Color.RED);
		
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
		
		//PlatzhalterLabel
		platzhalter = new JLabel("DerGraph",SwingConstants.LEFT);
		
		//Panel zusammenbauen
		eingabe.setLayout(new GridLayout(7,2,10,10)); 
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
		//window.add(new Graph(),BorderLayout.CENTER);
		window.add(new Graphzeichner(),BorderLayout.CENTER);
		window.add(eingabe,BorderLayout.WEST);
		
		window.pack();
		window.setVisible(true);
	}
		
	public void actionPerformed(ActionEvent e)
	{
		String ein = eingabeFeld.getText();
		
		String xmi = xMaxFeld.getText();
		String xma = xMinFeld.getText();
		String ska = skalierungFeld.getText();
		//String ymi = yMinLabel.getText();
		String yma = yMaxFeld.getText();
		
		int xmin =Integer.parseInt(xmi);
		int xmax =Integer.parseInt(xma);
		int skal =Integer.parseInt(ska);
		//int ymin =Integer.parseInt(ymi);
		int ymax =Integer.parseInt(yma);
		
		test.setXmin(xmin);
		test.setXmax(xmax);
		test.setSkalierung(skal);
		//test.setYmin(ymin);
		test.setYmax(ymax);
		
		test.verarbeitung(ein);
		sup.repaint();
		
		
	}

	public static void main(String[] args) {
		Layout Plotter = new Layout();
	
	}

}
