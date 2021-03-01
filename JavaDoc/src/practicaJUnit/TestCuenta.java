package practicaJUnit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.Test;


// TODO: Auto-generated Javadoc
/**
 * The Class TestCuenta.
 */
public class TestCuenta {
	
	/** The obj cuenta. LLama al objeto objCuenta. */
	Cuenta objCuenta;
	
	/**
	 * Before.
	 */
	@Before public void before() {
		System.out.println("before");
		objCuenta=new Cuenta("1234","Pepe");
	}
	
	/**
	 * Test ingreso. Comprueba si el ingreso se ejecuta correctamente.
	 *
	 * @throws Exception the exception
	 */
	@Test public void testIngreso() throws Exception {
		objCuenta.ingresar(500);
		assertEquals(500,objCuenta.getSaldo());
	}

}
