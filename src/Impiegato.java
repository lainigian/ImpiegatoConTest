import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
public class Impiegato implements Cloneable
{
	private int matricola;
	private String nominativo;
	private LocalDate dataAssunzione;
	public static double stipendioBase=1000;
	
//--------------Costruttore---------------------------------------	
	public Impiegato(int matricola, String nominativo, int assunzioneGiorno, int assunzioneMese, int assunzioneAnno) throws EccezioneMatricola
	{
		if (matricola<=0)
			throw new EccezioneMatricola("Matricola non valida");
		else
			this.matricola=matricola;
		this.nominativo=nominativo;
		this.dataAssunzione=LocalDate.of(assunzioneAnno, assunzioneMese, assunzioneGiorno);
	}

//	--------------Getters---------------------------------------
	public int getMatricola() 
	{
		return matricola;
	}

	public String getNominativo() 
	{
		return nominativo;
	}

	public LocalDate getDataAssunzione() 
	{
		return dataAssunzione;
	}

//-----------Altri metodi------------------------------------

/**
 * Lo stipendio mensile viene calcolato aggiungendo ai 1000 euro dello stipendio di base,  100 Euro per ogni anno trascorso dalla data di assunzione
 * @return Lo stipendio mensile dell'impiegato.
 */
	public double calcolaStipendio()
	{
		double stipendio;
		long anniAssunzione;
		//Calcolo degli anni trascorsi, alla data odierna, dalla data di assunzione
		anniAssunzione=dataAssunzione.until(LocalDate.now(), ChronoUnit.YEARS);
		
		stipendio=stipendioBase+anniAssunzione*100;
		return stipendio;
	}
	
	public boolean equals(Impiegato i)
	{
		return (getMatricola()==i.getMatricola() && getNominativo()==i.getNominativo() && getDataAssunzione().compareTo(i.getDataAssunzione())==0);
	}
	
	public Impiegato clone() throws CloneNotSupportedException
	{
		return (Impiegato) super.clone();
	}
	
	@Override
	public String toString() 
	{
		return "Impiegato [matricola=" + matricola + ", nominativo=" + nominativo + ", dataAssunzione=" + dataAssunzione
				+ "]";
	}


}

