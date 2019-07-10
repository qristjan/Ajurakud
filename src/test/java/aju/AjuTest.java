package aju;

import ajurakud.Ajurakud;
import ajurakud.AjurakudImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class AjuTest {

	@Test
	public void testSaaVõiSeaAjurakke_SaabAjurakud_KuiAjurakudNull(){
		List<Ajurakud> ajurakud = new ArrayList<>();

		ajurakud.add(new AjurakudImpl("Markus"));

		Aju aju = new Aju(ajurakud);

		List<Ajurakud> tulemus = aju.SaaVõiSeaAjurakke(null);

		Assert.assertArrayEquals(tulemus.toArray(), ajurakud.toArray());
	}

	@Test
	public void testSaaVõiSeaAjurakke_SeabAjuRakud(){
		List<Ajurakud> ajurakud = new ArrayList<>();

		ajurakud.add(new AjurakudImpl("Markus"));

		Aju aju = new Aju();

		aju.SaaVõiSeaAjurakke(ajurakud);

		Assert.assertArrayEquals(aju.SaaVõiSeaAjurakke(null).toArray(), ajurakud.toArray());
	}

	@Test
	public void testLisaVõiEemaldaAjurakke_LisabAjurakke_KuiAjurakudJubaPole(){
		List<Ajurakud> ajurakud = new ArrayList<>();

		ajurakud.add(new AjurakudImpl("Markus"));

		Aju aju = new Aju(ajurakud);

		String siim = "Siim";

		aju.LisaVõiEemaldaAjurakke(new AjurakudImpl(siim));
		ajurakud.add(new AjurakudImpl(siim));

		Assert.assertArrayEquals(aju.SaaVõiSeaAjurakke(null).toArray(), ajurakud.toArray());
	}

	@Test
	public void testLisaVõiEemaldaAjurakke_EemaldabAjurakke_KuiAjurakkOnOlemas(){
		List<Ajurakud> ajurakud = new ArrayList<>();

		String siim = "Siim";

		AjurakudImpl ajurakk = new AjurakudImpl(siim);

		ajurakud.add(ajurakk);

		Aju aju = new Aju(ajurakud);

		aju.LisaVõiEemaldaAjurakke(ajurakk);

		Assert.assertEquals(0,aju.SaaVõiSeaAjurakke(null).size());
	}
}
