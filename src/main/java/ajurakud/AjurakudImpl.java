package ajurakud;

public class AjurakudImpl implements Ajurakud {

	private String nimi;
	@Override
	public void mõtle() throws InterruptedException
	{
		Thread.sleep(1000);
		System.out.println("Mõtlesin välja");
	}

	public AjurakudImpl(String nimi)
	{
		this.nimi = nimi;
	}
}
