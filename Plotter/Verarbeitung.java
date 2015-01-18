package plotter;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Verarbeitung {
	int Alaenge=0;
	int indexA=0;
	String stringA="";
	private int Xmin,Xmax,Skalierung;
	private int Ymax;
	private int Ymin;
	private String Eingabe;
	
	public void setXmin(int X)
	{
		Xmin=X;
		System.out.println("xmin" +Xmin);
	}
	
	public void setXmax(int X)
	{
		Xmax=X;
		System.out.println("xmax"+Xmax);
	}
	
	public void setYmax(int yMa)
	{
		Ymax = yMa;
		System.out.println("ymax"+Ymax);
	}
		
	public void setYmin(int yMi)
	{
		Ymin = yMi;
		System.out.println("ymin"+Ymin);
	}
	
	public void setSkalierung(int X)
	{
		Skalierung=X;
		System.out.println("skal"+Skalierung);
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
		
	public int getYmax()
	{
		return Ymax;
	}

	public int getYmin()
	{
		return Ymin;
	}
	

	public void verarbeitung(String hilfsEingabe)
	{
		Eingabe=hilfsEingabe;
		
		int indexX= Eingabe.indexOf('x');
		if(! Character.isDigit( Eingabe.charAt( indexX-1 ) ))
		{
			for(int i=indexX-2;i>0;i=i-1)
			{
				//if(Character.isDigit( Eingabe.charAt( i ) ))
				//{
				indexA=i;
				Alaenge=Alaenge+1;
				//}
			}
		for(int i=indexA;i<Alaenge;i++)
		{
		stringA=stringA + Eingabe.charAt(i);
		}
		}
		else
		{
			
		}
	System.out.println("hallo Welt");
	}
}
