package derp;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class Verarbeitung {
	int Alänge=0;
	int indexA=0;
	String stringA="";
	private int Xmin,Xmax,Skalierung;
	private String Eingabe;
	public void setXmin(int X)
	{
		Xmin=X;
	}
	public void setXmax(int X)
	{
		Xmax=X;
	}
	public void setSkalierung(int X)
	{
		Skalierung=X;
	}
	public void setEingabe(String hilfsEingabe)
	{
		Eingabe=hilfsEingabe;
	}
	public void verarbeitung()
	{
		int indexX= Eingabe.indexOf('x');
		if(! Character.isDigit( Eingabe.charAt( indexX-1 ) ))
		{
			for(int i=indexX-2;i>0;i=i-1)
			{
				//if(Character.isDigit( Eingabe.charAt( i ) ))
				//{
				indexA=i;
				Alänge=Alänge+1;
				//}
			}
		for(int i=indexA;i<Alänge;i++)
		{
		stringA=stringA + Eingabe.charAt(i);
		}
		}
		else
		{
			
		}
	System.out.println("hallo Welt");
	}
	
	public int getSkalierung()
	{
		return Skalierung;
	}
	
	public int getXmin()
	{
		return Xmin;
	}

	public int getXmax()
	{
		return Xmax;
	}
	System.out.println("hello world");
}
