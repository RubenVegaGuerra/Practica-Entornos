package practicaJUnit;

import java.util.Date;
// TODO: Auto-generated Javadoc

/**
 * The Class Tarjeta.
 */
public abstract class Tarjeta
{
	
	/** The titular Nombre del titular de la tarjeta.
	 *  The numero Numero de la tarjeta.  */
	public String numero, titular;
	
	/** The fecha de caducidad Indica la fecha de caducidad de la tarjeta. */
	public Date fechaDeCaducidad;
	
	/** The cuenta asociada Indica la cuenta a la que esta vinculada. */
	public Cuenta cuentaAsociada;
	
	/**
	 * Inicializa una nueva tarjeta.
	 *
	 * @param _numero Numero de la tarjeta.
	 * @param _titular Nombre del titular de la tarjeta.
	 * @param _fechaCaducidad Indica la fecha de caducidad de la tarjeta.
	 */
	public Tarjeta(String _numero, String _titular, Date _fechaCaducidad)
	{
		numero=_numero;
		titular=_titular;
		fechaDeCaducidad=_fechaCaducidad;
	}
	
	/**
	 * Sets the cuenta Asocia la tarjeta a una cuenta.
	 *
	 * @param c Cuenta sobre la que se va a asociar la tarjeta.
	 */
	public void setCuenta(Cuenta c)
	{
		cuentaAsociada=c;
	}
	
	/**
	 * Retirar. Este método retira dinero de una tarjeta.
	 *
	 * @param x Parametro en double que marca la cifra de dinero a retirar.
	 * @throws Exception the exception
	 */
	public abstract void retirar(double x) throws Exception;
	
	/**
	 * Ingresar. Este método ingresa dinero a una tarjeta.
	 *
	 * @param x Parametro en double que marca la cifra de dinero a ingresar.
	 * @throws Exception the exception
	 */
	public abstract void ingresar(double x) throws Exception;
	
	/**
	 * Pago en establecimiento. Retira dinera de una tarjeta indicando datos de la retirada.
	 *
	 * @param datos Parametro que indica el motivo de la retirada.
	 * @param x Parametro en double que marca la cifra de dinero a retirar.
	 * @throws Exception the exception
	 */
	public abstract void pagoEnEstablecimiento(String datos, double x) throws Exception;
	
	/**
	 * Gets the saldo. Indica el saldo de la tarjeta.
	 *
	 * @return the saldo
	 */
	public abstract double getSaldo();
}