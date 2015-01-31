
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
	private JLabel ausgabeFeld;
	int test=0;
	
	
	

	public ArrayList<Integer> calculate(String formel,int xMinHilf,int xMaxHilf)// erechnet die benötigten Werte
	//public String calculate(String formel,int xMinHilf,int xMaxHilf) //test Methode
	{	
		ArrayList<Integer> yWerte= new ArrayList<Integer>();
		ArrayList<Integer> faktorList= new ArrayList<Integer>();
		int faktorZähler=0;
		ArrayList<Integer> konstanteList= new ArrayList<Integer>();
		int konstanteZähler=0;
		ArrayList<Integer> potenzList=new ArrayList<Integer>();
		ArrayList<Integer> grenzList=new ArrayList<Integer>();
		ArrayList<Integer> variableList=new ArrayList<Integer>();
		int variableZähler=0;
		int summandZähler=1;
		int potenzZähler=0;
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
				grenzList.add(summandZähler-1,i);
				summandZähler++;
				
			}
			if(testChar(i,Eingabe)=="Variable") // Speichert die Variablen und deren Potenzen
			{
				variableList.add(variableZähler,i);
				variableZähler++;
				
				if(i<Eingabe.length()-1)
				{
					if(testChar(i+1,Eingabe)=="Potenz")
					{
						String s=""+Eingabe.charAt(i+2);
						potenzList.add(potenzZähler,Integer.parseInt(s));
						potenzZähler++;
					}
					else
					{
						potenzList.add(potenzZähler,1);
						potenzZähler++;
					}
				}
				else
				{
					potenzList.add(potenzZähler,1);
					potenzZähler++;
				}
			}
			if(testChar(i,Eingabe)=="Zahl") // Überprüft eine Zahl d.H. klassifizierung nach Konstante und Faktor
			{
				boolean exit=false;
				int zahlLänge=1;
				
				
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
							zahlLänge++;
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
				for(int a=i;a<i+zahlLänge;a++) // Speichert eine Zahl vollständig
				{
					
					zahlString=zahlString+Eingabe.charAt(a);
				}
				zahl=Integer.parseInt(zahlString);
				i=i+zahlLänge-1;
				if(zahlTyp=="Faktor")
				{
					faktorList.add(faktorZähler,zahl);
					faktorZähler++;
				}
				if(zahlTyp=="Konstante")
				{
					konstanteList.add(konstanteZähler,zahl);
					konstanteZähler++;
				}
			}
		}
		for(int x=xMin; x<=xMax; x++)
		{
			double Ergebnis=0;
			for(int s=0;s<summandZähler;s++)	//Test des Scans
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
