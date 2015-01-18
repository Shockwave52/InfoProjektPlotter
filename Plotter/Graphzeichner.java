package plotter;

import java.awt.*;
import java.awt.Event.*;

import javax.swing.*;

public class Graphzeichner extends JPanel {

	private int Ymax;
	private int Ymin;
	private int yRange;
	private int Xmax;
	private int Xmin;
	private int xRange;
	private int preSkal;
	private int skal;
	
	Verarbeitung ver = new Verarbeitung();
	
	protected void repaint(Graphics g)//Graphics g)
	{
		//Graphics g;// =Graphics;
		g.drawRect(0,0,100,100);
		
		Xmax = ver.getXmax()*10;
		Xmin = ver.getXmin()*10;
		Ymax = ver.getYmax()*10;
		Ymin = ver.getYmin()*10;
		xRange = Xmax-Xmin;
		yRange = Ymax-Ymin;
		preSkal = ver.getSkalierung();
		skal = preSkal *10;
		
		g.setColor(Color.black);
		
		g.drawLine(0,0,0,yRange); //Rahmen ver. Links
		g.drawLine(0,yRange,xRange,yRange); //Rahemn hor. Unten
		g.drawLine(xRange,yRange,xRange,0); //Rahmen ver. rechts
		g.drawLine(xRange,yRange,0,0); //Rahmen hor. oben
		
		//g.drawLine(0,0,0,0); //X-Achse
		//g.drawLine(0,0,0,0); //Y-Achse)
		System.out.println("jop");
	}

}
