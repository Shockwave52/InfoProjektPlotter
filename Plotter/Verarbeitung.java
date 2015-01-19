package plotter;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Verarbeitung {
	int Alänge=0,Klänge=0;
	int indexA=0,indexK;
	int xLänge=0;
	String stringA="",stringK="";
	private int Xmin,Xmax,Skalierung;
	private String Eingabe;
	private JLabel ausgabeFeld;
	int test=0;
	
	
	

	public ArrayList<Integer> calculate(String formel,int xMinHilf,int xMaxHilf)// erechnet die benötigten Werte
	{	
		ArrayList<Integer> yWerte= new ArrayList<Integer>();
		int xMax=xMaxHilf;
		int xMin=xMinHilf;
		Eingabe=formel;
		int faktor=0;
		int konstante=0;
		//int x=xMin;
		int indexX= Eingabe.indexOf('x');
		if(indexX<Eingabe.length() && !Character.isDigit(Eingabe.charAt(indexX+1)))// Errechnung der Konstante mit x+k
		{
			indexK=indexX+2;
			for(int i=indexX+2;i<Eingabe.length();i++)
			{
				Klänge++;
			}
			for(int i=0;i<Klänge;i++)
			{
				stringK=stringK+Eingabe.charAt(indexK+i);
			}
			konstante=Integer.parseInt(stringK);
			
		}
		if(! Character.isDigit( Eingabe.charAt( indexX-1 ) ))		// Errechnung des Faktors mit a*x
		{
			for(int i=indexX-2;i>=0 && Character.isDigit(Eingabe.charAt(i)) ;i=i-1)
			{
			indexA=i;
			Alänge++;
			}
			for(int i=0;i<Alänge;i++)
			{
				stringA=stringA+Eingabe.charAt(indexA+i);
			}
		faktor=Integer.parseInt(stringA);
		}
		else														//Errechnung des Faktors mit ax
		{
			for(int i=indexX-1;i>=0 && Character.isDigit(Eingabe.charAt(i)) ;i=i-1)
			{
			indexA=i;
			Alänge++;
			}
			for(int i=0;i<Alänge;i++)
			{
				stringA=stringA+Eingabe.charAt(indexA+i);
			}
		faktor=Integer.parseInt(stringA);
		}
		int i=0;
		for(int x=xMin;x<=(xMax-xMin);x++)
		{
			yWerte.add(i, faktor*x+konstante);
			i++;
		}
		return yWerte;
	
	}
	public void test(JLabel debug) //Test methode
	{
		debug.setText("Sucess");
	}
	
	

}
