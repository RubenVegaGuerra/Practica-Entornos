package practicaJUnit;

import java.util.Date;
// TODO: Auto-generated Javadoc

/**
 * The Class Debito.
 */
public class Debito extends Tarjeta
{
	
	/**
	 * Inicializa un nuevo debito.
	 *
	 * @param _numero Parametro que indica el numero de debito.
	 * @param _titular Indica el nombre del titular del debito.
	 * @param _fechaCaducidad Indica la fecha de caducidad del debito.
	 */
	public Debito(String _numero, String _titular, Date _fechaCaducidad)
	{
		super(_numero, _titular, _fechaCaducidad);
	}
	
	/**
	 * Retirar. Este método retira dinero del debito.
	 *
	 * @param x Parametro en double que marca la cifra de dinero a retirar.
	 * @throws Exception the exception
	 */
	public void retirar(double x) throws Exception
	{
		this.cuentaAsociada.retirar("Retirada en cajero autom·tico", x);
	}
	
	/**
	 * Ingresar. Este método ingresa dinero al debito.
	 *
	 * @param x Parametro en double que marca la cifra de dinero a ingresar.
	 * @throws Exception the exception
	 */
	public void ingresar(double x) throws Exception
	{
		this.cuentaAsociada.retirar("Ingreso en cajero autom·tico", x);
	}
	
	/**
	 * Pago en establecimiento. Retira dinera del debito indicando datos de la retirada.
	 *
	 * @param datos Parametro que indica el motivo de la retirada.
	 * @param x Parametro en double que marca la cifra de dinero a retirar.
	 * @throws Exception the exception
	 */
	public void pagoEnEstablecimiento(String datos, double x) throws Exception
	{
		this.cuentaAsociada.retirar("Compra en :" + datos, x);
	}
	
	/**
	 * Gets the saldo. Indica el saldo del debito.
	 *
	 * @return the saldo
	 */
	public double getSaldo()
	{
		return cuentaAsociada.getSaldo();
	}
}
