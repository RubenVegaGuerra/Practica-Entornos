package practicaJUnit;
import java.util.Vector;

// TODO: Auto-generated Javadoc
/**
 * @author vega7
 * The Class Cuenta.
 */
public class Cuenta
{
	
	/** The numero se refiere a numero de cuneta. */
	protected String numero;
	
	/** The titular  se refiere al titular de la cuenta. */
	protected String titular;
	
	/** The movimientos se refiere a los cambios hechos con las cuentas. */
	protected Vector movimientos;
	
	
	/**
	 * Inicializa una nueva cuenta.
	 *@see Inicia una nueva cuenta.
	 * @param _numero the numero
	 * @param _titular the titular
	 */
	public Cuenta(String _numero, String _titular)
	{
		numero=_numero;
		titular=_titular;
		movimientos=new Vector();
	}
	
	/**
	 * Ingresar. Este método añade dinero a una cuenta. 
	 *
	 * @param x Parametro en double que marca la cifra de dinero a ingresar.
	 * @throws Exception the exception
	 */
	public void ingresar(double x) throws Exception
	{
		if (x<=0)
			throw new Exception("No se puede ingresar una cantidad negativa");
		Movimiento m=new Movimiento();
		m.setConcepto("Ingreso en efectivo");
		m.setImporte(x);
		this.movimientos.addElement(m);
	}
	
	/**
	 * Retirar. Este método retira dinero de una cuenta.
	 *
	 * @param x Parametro en double que marca la cifra de dinero a retirar.
	 * @throws Exception the exception
	 */
	public void retirar(double x) throws Exception
	{
		if (x<=0)
			throw new Exception("No se puede retirar una cantidad negativa");
		if (getSaldo()<x)
			throw new Exception("Saldo insuficiente");
		Movimiento m=new Movimiento();
		m.setConcepto("Retirada de efectivo");
		m.setImporte(-x);
		this.movimientos.addElement(m);
	}
	
	/**
	 * Ingresar. Este método añade dinero a una cuenta con un concepto.
	 *
	 * @param concepto Indica la causa del ingreso.
	 * @param x Parametro en double que marca la cifra de dinero a ingresar.
	 * @throws Exception the exception
	 */
	public void ingresar(String concepto, double x) throws Exception
	{
		if (x<=0)
			throw new Exception("No se puede ingresar una cantidad negativa");
		Movimiento m=new Movimiento();
		m.setConcepto(concepto);
		m.setImporte(x);
		this.movimientos.addElement(m);
	}
	
	/**
	 * Retirar. Este método retira dinero de una cuenta  con un concepto.
	 *
	 * @param concepto Indica la causa de la retirada.
	 * @param x Parametro en double que marca la cifra de dinero a retirar.
	 * @throws Exception the exception
	 */
	public void retirar(String concepto, double x) throws Exception
	{
		if (x<=0)
			throw new Exception("No se puede retirar una cantidad negativa");
		if (getSaldo()<x)
			throw new Exception("Saldo insuficiente");
		Movimiento m=new Movimiento();
		m.setConcepto(concepto);
		m.setImporte(-x);
		this.movimientos.addElement(m);
	}
	
	/**
	 * Gets the saldo. Muestra el saldo disponible de una cuenta.
	 *
	 * @return the saldo
	 */
	public double getSaldo()
	{
		double r=0.0;
		for (int i=0; i<this.movimientos.size(); i++)
		{
			Movimiento m=(Movimiento) movimientos.elementAt(i);
			r+=m.getImporte();
		}
		return r;
	}
	
	/**
	 * Adds the movimiento. Añade un movimiento a realizar en la cuenta.
	 *
	 * @param m Indica el objeto a añadir el movimiento.
	 */
	public void addMovimiento(Movimiento m)
	{
		movimientos.addElement(m);
	}
}