package practicaJUnit;

import java.util.Vector;
import java.util.Date;

// TODO: Auto-generated Javadoc
/**
 * The Class Credito.
 */
public class Credito extends Tarjeta
{
	
	/** The credito. Parametro que indica el dinero de la clase Credito */
	protected double credito;
	
	/** The movimientos. Parametro que indica los movimientos a realizar con la clase Credito*/
	protected Vector movimientos;
	
	/**
	 * Inicializa un nuevo credito.
	 *
	 * @param _numero Numero del Credito.
	 * @param _titular Nombre del titular del Credito.
	 * @param _fechaCaducidad Indica la fecha de caducidad del Credito.
	 * @param _credito Paramtro que indica el dinero de la clase Credito.
	 */
	public Credito(String _numero, String _titular, Date _fechaCaducidad, double _credito)
	{
		super(_numero, _titular, _fechaCaducidad);
		credito=_credito;
		movimientos=new Vector();
	}
	
	/**
	 * Retirar. Este método retira dinero del Credito.
	 *
	 * @param x Parametro en double que marca la cifra de dinero a retirar.
	 * @throws Exception the exception
	 */
	public void retirar(double x) throws Exception
	{
		Movimiento m=new Movimiento();
		m.setConcepto("Retirada en cajero autom·tico");
		x=(x*0.05<3.0 ? 3 : x*0.05); // AÒadimos una comisiÛn de un 5%, mÌnimo de 3 euros.
		m.setImporte(x);
		movimientos.addElement(m);
		if (x>getCreditoDisponible())
			throw new Exception("CrÈdito insuficiente");
	}
	
	/**
	 * Ingresar. Este método ingresa dinero al Credtio.
	 *
	 * @param x Parametro en double que marca la cifra de dinero a ingresar.
	 * @throws Exception the exception
	 */
	public void ingresar(double x) throws Exception
	{
		Movimiento m=new Movimiento();
		m.setConcepto("Ingreso en cuenta asociada (cajero autom·tico)");
		m.setImporte(x);
		movimientos.addElement(m);
		cuentaAsociada.ingresar(x);
	}
	
	/**
	 * Pago en establecimiento.  Retira dinera del Credito indicando datos de la retirada.
	 *
	 * @param datos Parametro que indica el motivo de la retirada.
	 * @param x Parametro en double que marca la cifra de dinero a retirar.
	 * @throws Exception the exception
	 */
	public void pagoEnEstablecimiento(String datos, double x) throws Exception
	{
		Movimiento m=new Movimiento();
		m.setConcepto("Compra a crÈdito en: " + datos);
		m.setImporte(x);
		movimientos.addElement(m);
	}
	
	/**
	 * Gets the saldo. Indica el saldo del Credito.
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
	 * Gets the credito disponible. Indica el credito disponible del Credito.
	 *
	 * @return the credito disponible
	 */
	public double getCreditoDisponible()
	{
		return credito-getSaldo();
	}

	/**
	 * Liquidar. Liquida el credito.
	 *
	 * @param mes Parametro que indica el mes a liquidar.
	 * @param aÒo Parametro que indica el año a liquidar.
	 */
	public void liquidar(int mes, int aÒo)
	{
		Movimiento liq=new Movimiento();
		liq.setConcepto("LiquidaciÛn de operaciones tarj. crÈdito, " + (mes+1) + " de " + (aÒo+1900));
		double r=0.0;
		for (int i=0; i<this.movimientos.size(); i++)
		{
			Movimiento m=(Movimiento) movimientos.elementAt(i);
			if (m.getFecha().getMonth()+1==mes && m.getFecha().getYear()+1900==aÒo)
				r+=m.getImporte();
		}
		liq.setImporte(r);
		if (r!=0)
			cuentaAsociada.addMovimiento(liq);
	}
}
