
public class EccezioneMatricola extends Exception 
{
	private String messaggio;
	
	public EccezioneMatricola(String messaggio)
	{
		this.messaggio=messaggio;
	}
	
	public String toString ()
	{
		return messaggio;
	}
}
