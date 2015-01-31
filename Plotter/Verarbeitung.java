
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Verarbeitung {
	int Al�nge=0,Kl�nge=0;
	int indexA=0,indexK;
	int xL�nge=0;
	String stringA="",stringK="";
	private int Xmin,Xmax,Skalierung;
	private JLabel ausgabeFeld;
	int test=0;
	
	
	

	public ArrayList<Integer> calculate(String formel,int xMinHilf,int xMaxHilf)// erechnet die ben�tigten Werte
	//public String calculate(String formel,int xMinHilf,int xMaxHilf) //test Methode
	{	
		ArrayList<Integer> yWerte= new ArrayList<Integer>();
		ArrayList<Integer> faktorList= new ArrayList<Integer>();
		int faktorZ�hler=0;
		ArrayList<Integer> konstanteList= new ArrayList<Integer>();
		int konstanteZ�hler=0;
		ArrayList<Integer> potenzList=new ArrayList<Integer>();
		ArrayList<Integer> grenzList=new ArrayList<Integer>();
		ArrayList<Integer> variableList=new ArrayList<Integer>();
		int variableZ�hler=0;
		int summandZ�hler=1;
		int potenzZ�hler=0;
		int zahl=0;
		String zahlTyp="Unknown";
		int xMax=xMaxHilf;
		int xMin=xMinHilf;
		String Eingabe=formel;
		String zahlString ="";
		int faktor=0;
		int konstante=0;
		
		for(int i=0;i<Eingabe.length();i++) //Scan der Eingabe
		{
			
			if(testChar(i,Eingabe)=="+" || testChar(i,Eingabe)=="-") // Speichert die Indexe von '+'
			{
				grenzList.add(summandZ�hler-1,i);
				summandZ�hler++;
				
			}
			if(testChar(i,Eingabe)=="Variable") // Speichert die Variablen und deren Potenzen
			{
				variableList.add(variableZ�hler,i);
				variableZ�hler++;
				
				if(i<Eingabe.length()-1)
				{
					if(testChar(i+1,Eingabe)=="Potenz")
					{
						String s=""+Eingabe.charAt(i+2);
						potenzList.add(potenzZ�hler,Integer.parseInt(s));
						potenzZ�hler++;
					}
					else
					{
						potenzList.add(potenzZ�hler,1);
						potenzZ�hler++;
					}
				}
				else
				{
					potenzList.add(potenzZ�hler,1);
					potenzZ�hler++;
				}
			}
			if(testChar(i,Eingabe)=="Zahl") // �berpr�ft eine Zahl d.H. klassifizierung nach Konstante und Faktor
			{
				boolean exit=false;
				int zahlL�nge=1;
				
				
				for(int n=1;exit==false;n++)
				{
					if(i+n>Eingabe.length()-1)
					{
						zahlTyp="Konstante";
						exit=true;
					}
					else
					{
						if(testChar(i+n,Eingabe)=="Zahl")
						{
							zahlL�nge++;
						}
						if(testChar(i+n,Eingabe)=="*")
						{
							zahlTyp="Faktor";
							exit=true;
						}
						if(testChar(i+n,Eingabe)=="+")
						{
							zahlTyp="Konstante";
							exit=true;
						}
					}
				}
				zahlString="";
				for(int a=i;a<i+zahlL�nge;a++) // Speichert eine Zahl vollst�ndig
				{
					
					zahlString=zahlString+Eingabe.charAt(a);
				}
				zahl=Integer.parseInt(zahlString);
				i=i+zahlL�nge-1;
				if(zahlTyp=="Faktor")
				{
					faktorList.add(faktorZ�hler,zahl);
					faktorZ�hler++;
				}
				if(zahlTyp=="Konstante")
				{
					konstanteList.add(konstanteZ�hler,zahl);
					konstanteZ�hler++;
				}
			}
		}
		for(int x=xMin; x<=xMax; x++)
		{
			double Ergebnis=0;
			for(int s=0;s<summandZ�hler;s++)	//Test des Scans
			{
				if(faktorList.size()==variableList.size())
				{
					
					Ergebnis = Ergebnis+(faktorList.get(s)*Math.pow(x,potenzList.get(s)));
					//Ergebnis= Ergebnis+konstanteList.get(0);
					
				}
			}
			int ErgebnisHilf = (int) Ergebnis;
			yWerte.add(x-xMin,ErgebnisHilf);
		}
		
		return yWerte;
		/*int indexX= Eingabe.indexOf('x');
		if(indexX<Eingabe.length() && !Character.isDigit(Eingabe.charAt(indexX+1)))// Errechnung der Konstante mit x+k
		{
			indexK=indexX+2;
			for(int i=indexX+2;i<Eingabe.length();i++)
			{
				Kl�nge++;
			}
			for(int i=0;i<Kl�nge;i++)
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
			Al�nge++;
			}
			for(int i=0;i<Al�nge;i++)
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
			Al�nge++;
			}
			for(int i=0;i<Al�nge;i++)
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
		return yWerte;*/
	
		
	}

	public String testChar(int charIndex, String Eingabe)
	{
		String CharTyp="";
		if(Eingabe.charAt(charIndex)=='x')
		{
			CharTyp="Variable";
		}
		if(Character.isDigit(Eingabe.charAt(charIndex)))
		{
			CharTyp="Zahl";
		}
		if(Eingabe.charAt(charIndex)=='^')
		{
			CharTyp="Potenz";
		}
		if(Eingabe.charAt(charIndex)=='+')
		{
			CharTyp="+";
		}
		if(Eingabe.charAt(charIndex)=='*')
		{
			CharTyp="*";
		}
		if(Eingabe.charAt(charIndex)=='-')
		{
			CharTyp="-";
		}
		return CharTyp;
	}
	public String test(JLabel debug,String Eingabe) //Test Methode
	{
		String s="";
		s=testChar(0,Eingabe);
		return s;
	}
	
	

}
