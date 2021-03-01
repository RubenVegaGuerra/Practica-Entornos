package practicaJUnit;

import java.util.Date;
// TODO: Auto-generated Javadoc

/**
 * The Class Movimiento.
 */
public class Movimiento{
	
	/** The concepto. Motivo por el cual se hace un moviento. */
	public String concepto;
	
	/** The fecha. Fecha del movimiento realizado.*/
	public Date fecha;
	
	/** The importe. Parametro que indica el numero modificado por un movimiento. */
	public double importe;
	
	/**
	 * Inicializa un nuevo movimiento.
	 */
	public Movimiento()
	{
		fecha=new Date();
	}
	
	/**
	 * Gets the importe. Indica el importe.
	 *
	 * @return the importe
	 */
	public double getImporte()
	{
		return importe;
	}
	
	/**
	 * Gets the concepto. Indica el concepto.
	 *
	 * @return the concepto
	 */
	public String getConcepto()
	{
		return concepto;
	}
	
	/**
	 * Sets the concepto. Añade un nuevo concepto.
	 *
	 * @param _concepto Parametro que indica el motivo del movimeinto.
	 */
	public void setConcepto(String _concepto)
	{
		concepto = _concepto;
	}
	
	/**
	 * Gets the fecha. Indica la fecha del movimiento.
	 *
	 * @return the fecha
	 */
	public Date getFecha()
	{
		return fecha;
	}
	
	/**
	 * Sets the fecha. Añade una fecha al movimiento.
	 *
	 * @param _fecha Valor que indica la fecha del movimiento.
	 */
	public void setFecha(Date _fecha)
	{
		fecha = _fecha;
	}
	
	/**
	 * Sets the importe. Añade un importe al movimiento.
	 *
	 * @param _importe Parametro en double que indica el valor numerico con el que realizar el movimiento.
	 */
	public void setImporte(double _importe)
	{
		importe = _importe;
	}
}
