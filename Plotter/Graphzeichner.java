package plotter;
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Graphzeichner extends JPanel {

	private int yMax,yMin,xMin,xMax,skal,yAchseZero,xAchseZero;
	private String eingabe;
	private int yRange;
	private int xRange;
	private int preSkal;
	
	
	
	protected void repaint(Graphics g)
	{
		System.out.println("Xmin" + xMin);
		System.out.println("Xmax" + xMax);
		System.out.println("Ymin" + yMin);
		System.out.println("ymax" + yMax);
		System.out.println("Xrange" + xRange);
		System.out.println("yRange" + yRange);
		
		
		g.setColor(Color.black);
		//g.drawRect(0, 0, 10, 10); debug
		
		yRange=yMax-yMin;
		xRange=xMax-xMin;
		
		
		g.drawLine(0,0,0,yRange); //Rahmen ver. Links
		g.drawLine(0,yRange,xRange,yRange); //Rahmen hor. Unten
		g.drawLine(xRange,yRange,xRange,0); //Rahmen ver. rechts
		g.drawLine(xRange,yRange,0,0); //Rahmen hor. oben
		
		yAchseZero=yRange/2;
		xAchseZero=xRange/2;
	
		g.drawLine(0,yAchseZero,xRange,yAchseZero); //X-Achse
		g.drawLine(xAchseZero,0,xAchseZero,yRange); //Y-Achse)
		
		/*
		for (int i=0;i<arraycount;)
		{
			if (((array[i]+skalierung) < yRange && (array[i]+skalierung) > 0)&&((array[i+1]+skalierung) < yRange && (array[i+1]+skalierung) > 0)) 
			then
			{
			int x1= skalierung*i;
			int y1= array[i]+xAchseZero;
			int x2; skalierung*(i+1);
			int y2= array[i+1]+xAchseZero;
			g.drawLine(x1,y1,x2,y2);
			i++;
			}
			else
			{
			i++;
			}
		}
		*/
		
	}
	public void setWindow(int xMinHilf ,int xMaxHilf, int yMinHilf, int yMaxHilf, int skalHilf, String eingabeHilf)
	{
		xMin=xMinHilf;
		xMax=xMaxHilf;
		yMin=yMinHilf;
		yMax=yMaxHilf;
		skal=skalHilf;
		eingabe=eingabeHilf;
	}
	
	public void plot(String eingabe,int xMin,int xMax, JLabel debugFeld)
	{
		
		Verarbeitung ver = new Verarbeitung(eingabe,xMin,xMax);
		int test=ver.calculate(eingabe,xMin,xMax);
		String s=""+test;
		debugFeld.setText(s);
		
	}
	
	
}
