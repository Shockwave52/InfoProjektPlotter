
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Graphzeichner extends JPanel {

	private int yMax,yMin,xMin,xMax,skal;
	private String eingabe;
	private int yRange;
	private int xRange;
	private int preSkal;
	
	
	
	protected void repaint(Graphics g)//Graphics g)
	{
		//Graphics g;// =Graphics;
	
		g.setColor(Color.black);
		
		g.drawLine(0,0,0,yRange); //Rahmen ver. Links
		g.drawLine(0,yRange,xRange,yRange); //Rahmen hor. Unten
		g.drawLine(xRange,yRange,xRange,0); //Rahmen ver. rechts
		g.drawLine(xRange,yRange,0,0); //Rahmen hor. oben
		
		//g.drawLine(0,0,0,0); //X-Achse
		//g.drawLine(0,0,0,0); //Y-Achse)
	
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
	/*public void setYmax(int yMa)
	{
		Ymax = yMa*10;
		
	}
		
	public void setYmin(int yMi)
	{
		Ymin = yMi*10;
	}*/
	
	public void plot(String eingabe,int xMin,int xMax)
	{
		
		Verarbeitung ver = new Verarbeitung(eingabe,xMin,xMax);
		
	}
	
}
