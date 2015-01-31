
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Graphzeichner extends JPanel {

	//standard Koordinatensystem
	private int yMax = 5;
	private int yMin=-5;
	private int xMax = 5;
	private int xMin=-5;
	private int skal=1;
	private int zoom=10;
	private int yAchseZero,xAchseZero,yRange,xRange;
	private String eingabe;
		
	//protected void repaint(Graphics g)
	protected void paintComponent(Graphics g)
	{
		g.setColor(Color.black);
		
		yRange=(yMax-yMin);
		xRange=(xMax-xMin);
		
		//fenster von oben links z.B 0,0 nach unten rechts z.B.10,10
		//g.drawLine(x1, y1, x2, y2);
		g.drawLine(0,0,0,yRange); //Rahmen ver. Links
		g.drawLine(0,yRange,xRange,yRange); //Rahmen hor. Unten
		g.drawLine(xRange,yRange,xRange,0); //Rahmen ver. rechts
		g.drawLine(xRange,0,0,0); //Rahmen hor. oben
				
		yAchseZero=yMax;
		xAchseZero=xMin*-1;
	
		g.drawLine(0,yAchseZero,xRange,yAchseZero); //X-Achse
		g.drawLine(xAchseZero,0,xAchseZero,yRange); //Y-Achse
		
		for (int i=0; i<xRange;)//x-Achsen Striche
		{
			g.drawLine(i,yAchseZero,i,yAchseZero-1);
			i=i+skal;
		}
		
		for (int j=0;j<yRange;)//y-Achsen-Striche
		{
			g.drawLine(xAchseZero, j, xAchseZero+1, j);
			j=j+skal;
		}
		
		/*
		ArrayList<Int> ergebnisse = calculate_oder_plot_was_auch_immer();
		for (int i=0;i<ergebnisse.size;)
		{
			if (((ergebnisse.get(i)+skalierung) < yRange && (ergebnisse.get(i)+skalierung) > 0)&&((ergebnisse.get(i+1)+skalierung) < yRange && (ergebnisse.get(i+1)+skalierung) > 0)) 
			then
			{
			int x1= skalierung*i;
			int y1= ergebnisse.get(i);
			int x2; skalierung*(i+1);
			int y2= ergebnisse.get(i+1)+xAchseZero;
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
		
		//Zoom sozusagen weil sonst alles zu klein ist
		yMax=yMax*zoom;
		yMin=yMin*zoom;
		xMin=xMin*zoom;
		xMax=xMax*zoom;
		skal=skal*zoom;
	}
	
	public void plot(String eingabe,int xMin,int xMax, JLabel debugFeld)
	{
		
		Verarbeitung ver = new Verarbeitung();
		ArrayList<Integer> test=ver.calculate(eingabe,xMin,xMax);
		String s="";     //                         test für yWerte(ArrayList<Integer>)
		if(test.isEmpty())
		{
			s="Error";	
		}
		else
		{
			for(int i=0; i<test.size();i++)
			{
			
			
				s=s+test.get(i)+';';
			}
		}
		//String s=ver.test(debugFeld,eingabe);
		//String s=ver.calculate(eingabe, xMin, xMax);
		debugFeld.setText(s);
		
	}
	
	
}
