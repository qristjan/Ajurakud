package ajurakudroot.aju;

import ajurakudroot.ajurakud.Ajurakud;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Aju implements Ajurakud{
	private List<Ajurakud> ajurakud;

	public Aju(List<Ajurakud> ajurakud)
	{
		this.ajurakud = ajurakud;
	}

	public Aju(){
		this.ajurakud = new ArrayList<>();
	}

	private static void accept(Ajurakud ajurakud_)
	{
		try {
			ajurakud_.mõtle();
		} catch (InterruptedException e) {
			System.out.println("ei suutnud mõelda.");
			e.printStackTrace();
		}
	}

	public List<Ajurakud> SaaVõiSeaAjurakke(List<Ajurakud> ajurakud){
		if(ajurakud == null){
			return this.ajurakud;
		}

		this.ajurakud = ajurakud;
		return Collections.emptyList();
	}

	public void LisaVõiEemaldaAjurakke(Ajurakud ajurakud){
		if(ajurakud == null){
			return;
		}

		if(this.ajurakud.contains(ajurakud)){
			this.ajurakud.remove(ajurakud);
		}
		else{
			this.ajurakud.add(ajurakud);
		}
	}

	@Override
	public void mõtle()
	{
		ajurakud.forEach(Aju::accept);
	}

}
