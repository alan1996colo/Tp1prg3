package Negocio;

import org.junit.Test;

public class NegocioTest {

	@Test (expected=IllegalArgumentException.class)
	public void validarInputNonsepuedeNegativoTest() {
		Negocio a=new Negocio();
		a.validarInput(-1, 1, 1);
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void ValidarInputNoFilaNegTest() {
		Negocio a=new Negocio();
		a.validarInput(1, -1, 1);
		
	}
	@Test (expected=IllegalArgumentException.class)
	public void ValidarInputNoColNegTest() {
		Negocio a=new Negocio();
		a.validarInput(1, 1, -1);
		
	}
	


}
