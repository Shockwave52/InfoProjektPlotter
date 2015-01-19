package plotter;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Graphzeichner extends JPanel {

	private int yMax,yMin,xMin,xMax,skal;
	private String eingabe;
	private int yRange;
	private int xRange;
	private int preSkal;
	
	
	
	protected void repaint(Graphics g)
	{
		g.setColor(Color.black);
		//g.drawRect(0, 0, 10, 10); debug
		
		yRange=yMax-yMin;
		xRange=xMax-xMin;
		/*
		g.drawLine(0,0,0,yRange); //Rahmen ver. Links
		g.drawLine(0,yRange,xRange,yRange); //Rahmen hor. Unten
		g.drawLine(xRange,yRange,xRange,0); //Rahmen ver. rechts
		g.drawLine(xRange,yRange,0,0); //Rahmen hor. oben
		
		//g.drawLine(0,0,0,0); //X-Achse
		//g.drawLine(0,0,0,0); //Y-Achse)
		*/
		
		System.out.println("Xmin" + xMin);
		System.out.println("Xmax" + xMax);
		System.out.println("Ymin" + yMin);
		System.out.println("ymax" + yMax);
		System.out.println("Xrange" + xRange);
		System.out.println("yRange" + yRange);
		
	}
	public void setWindow(int xMinHilf ,int xMaxHilf, int yMinHilf, int yMaxHilf, int skalHilf, String eingabeHilf)
	{
		xMin=xMinHilf;
		xMax=xMaxHilf;
		yMin=yMinHilf;
		yMax=yMaxHilf;
		skal=skalHilf;
		eingabe=eingabeHilf;
		System.out.println("derp");
	}

	public void plot(String eingabe,int xMin,int xMax)
	{
		
		Verarbeitung ver = new Verarbeitung(eingabe,xMin,xMax);
		
	}
	
}
