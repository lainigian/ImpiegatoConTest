import static org.junit.Assert.*;

import java.time.DateTimeException;
import java.time.LocalDate;

import org.junit.Test;

public class ImpiegatoTest 
{

	@Test //Usare il metodo compare di LocalDate per confrontare due date
	public void testCostrttoreGetters() throws EccezioneMatricola 
	{
		Impiegato i1=new Impiegato(10, "Paolo Rossi", 1, 1, 2000);
		LocalDate data= LocalDate.of(2000,1,1);
		assertTrue(i1.getMatricola()==10 && i1.getNominativo()=="Paolo Rossi" && i1.getDataAssunzione().compareTo(data)==0);
	
	}

	//Non gestire l'eccezione con try-catch altrimeenti il test fallisce
	@Test (expected=EccezioneMatricola.class)
	public void testEccezioneMatricola() throws EccezioneMatricola
	{
		Impiegato i1=new Impiegato(0, "Paolo Rossi", 1, 1, 2000);
		
	}

	@Test (expected=DateTimeException.class)
	public void testEccezioneDataInesistente() throws EccezioneMatricola 
	{
		Impiegato i1=new Impiegato(10, "Paolo Rossi", 30, 2, 2000);
	
	}
	
	@Test 
	public void testStipendioAssuntoDaMenoDiUnAnno() throws EccezioneMatricola 
	{
		//data di oggi
		LocalDate annoMenoUnGiornoFa=LocalDate.now();
		//sottraggo un anno
		annoMenoUnGiornoFa=annoMenoUnGiornoFa.minusYears(1);
		//sommo un giorno
		annoMenoUnGiornoFa=annoMenoUnGiornoFa.plusDays(1);
		//estraggo giorno, mese, anno di un annno meno un giorno fa
		int giorno=annoMenoUnGiornoFa.getDayOfMonth();
		int mese=annoMenoUnGiornoFa.getMonthValue();
		int anno=annoMenoUnGiornoFa.getYear();
		Impiegato i1=new Impiegato(10, "Paolo Rossi",giorno, mese, anno);
		assertTrue(i1.calcolaStipendio()==1000);
	
	}
	
	@Test 
	public void testStipendioAssuntoDaUnAnno() throws EccezioneMatricola 
	{
		//data di oggi
		LocalDate annoMenoUnGiornoFa=LocalDate.now();
		//sottraggo un anno
		annoMenoUnGiornoFa=annoMenoUnGiornoFa.minusYears(1);
		//estraggo giorno, mese, anno di un annno meno un giorno fa
		int giorno=annoMenoUnGiornoFa.getDayOfMonth();
		int mese=annoMenoUnGiornoFa.getMonthValue();
		int anno=annoMenoUnGiornoFa.getYear();
		Impiegato i1=new Impiegato(10, "Paolo Rossi",giorno, mese, anno);
		assertTrue(i1.calcolaStipendio()==1100);
	
	}
	
	
	@Test 
	public void testEqualsTrue() throws EccezioneMatricola 
	{
		
		Impiegato i1=new Impiegato(10, "Paolo Rossi",1, 1, 2000);
		Impiegato i2=new Impiegato(10, "Paolo Rossi",1, 1, 2000);
		assertTrue(i1.equals(i2));
	}
	
	@Test 
	public void testEqualsFalse() throws EccezioneMatricola 
	{
		
		Impiegato i1=new Impiegato(10, "Paolo Rossi",1, 1, 2000);
		Impiegato i2=new Impiegato(11, "Paolo Rossi",1, 1, 2001);
		assertFalse(i1.equals(i2));
	}
	
	@Test 
	public void testToString() throws EccezioneMatricola 
	{	
		Impiegato i1=new Impiegato(10, "Paolo Rossi",1, 1, 2000);
		String s="Impiegato [matricola=10, nominativo=Paolo Rossi, dataAssunzione=2000-01-01]";
		assertTrue(i1.toString().compareTo(s)==0);
	}
	
	@Test 
	public void testClone() throws EccezioneMatricola, CloneNotSupportedException 
	{	
		Impiegato i1=new Impiegato(10, "Paolo Rossi",1, 1, 2000);
		Impiegato i2=i1.clone();
		assertTrue(i1.equals(i2));
	}
	
	
	
	
	
	
	
	
}
