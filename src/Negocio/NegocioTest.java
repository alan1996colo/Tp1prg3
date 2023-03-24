package Negocio;

import org.junit.Before;
import org.junit.Test;

public class NegocioTest {
	 Negocio neg;
	
	@Before
	public void setUp() throws Exception {//ejecuta una vez lo que este aca adentro por cada test
	 neg=new Negocio(4,1);
	//n.mostrar();
	//n.mostrarValoresDesuma();
	
	
	
	
	}
	
	//n.calcularResultadoMatrizCreadaFilaColumna();
	//n.mostrarValoresDesuma();
	@Test (expected=IllegalArgumentException.class)
	public void agregarValoresMatrizNoValNeg() {
		neg.agregarValoresMatriz(-1,2,3);
		
	}
	@Test (expected=IllegalArgumentException.class)
	public void agregarValoresMatrizNoPosYNeg() {	
		neg.agregarValoresMatriz(1,2,-3);
	
}
	@Test (expected=IllegalArgumentException.class)
	public void agregarValoresMatrizNoPosXNeg() {	
		neg.agregarValoresMatriz(1,-2,3);
		
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void validarInputNonsepuedeNegativoTest() {
	
		neg.validarInput(-1, 1, 1);
	}

	@Test (expected=IllegalArgumentException.class)
	public void ValidarInputNoFilaNegTest() {
		neg.validarInput(1, -1, 1);
		
	}

	@Test (expected=IllegalArgumentException.class)
	public void ValidarInputNoColNegTest() {
		neg.validarInput(1, 1, -1);
		}

	
	
	}
