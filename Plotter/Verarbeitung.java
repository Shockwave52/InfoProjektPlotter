package plotter;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class Verarbeitung {
	int Al�nge=0;
	int indexA=0;
	String stringA="";
	private int Xmin,Xmax,Skalierung;
	private String Eingabe;
	private JLabel ausgabeFeld;
	int test=0;
	
	public Verarbeitung(String formel,int xMinHilf,int xMaxHilf)
	{
		int xMin=xMinHilf;
		int xMax=xMaxHilf;
		String eingabe=formel;
	}
	

	public int calculate(String formel,int xMinHilf,int xMaxHilf)// erechnet die ben�tigten Werte
	{
		Eingabe=formel;
		int faktor=0;
		int konstante=0;
		int indexX= Eingabe.indexOf('x');
		/*if(! Character.isDigit( Eingabe.charAt( indexX-1 ) ))
		{
			for(int i=indexX-2;i>0;i=i-1)
			{
				if(Character.isDigit( Eingabe.charAt( i ) ))
				{
				indexA=i;
				Al�nge=Al�nge+1;
				}
			}
		for(int i=indexA;i<Al�nge;i++)
		{
		stringA=stringA + Eingabe.charAt(i);
		}
		faktor=Integer.parseInt(stringA);
		}
		else
		{
			stringA=stringA + Eingabe.charAt(indexX-1);
			faktor=Integer.parseInt(stringA);
		}*/
		return indexX;
	
	}
	public void test(JLabel debug) //Test methode
	{
		debug.setText("Sucess");
	}
	
	

}
