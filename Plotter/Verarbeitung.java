import java.awt.event.ActionEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class Verarbeitung {
	int Alänge=0;
	int indexA=0;
	String stringA="";
	private int Xmin,Xmax,Skalierung;
	private String Eingabe;
	private JLabel ausgabeFeld;
	int test=0;
	
	public Verarbeitung(String formel)
	{
		int i =0;
	}
		

	public void calculate()
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
	
	}
	
	

}
