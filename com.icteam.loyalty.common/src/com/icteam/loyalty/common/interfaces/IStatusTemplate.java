package com.icteam.loyalty.common.interfaces;

/**
 * IStatusTemplate
 */
public interface IStatusTemplate {
	/**
	 * Setta los tato
	 *
	 * @param status EStatus
	 */
	void setStatus(IStatus status);

	/**
	 * Ritorna lo stato
	 *
	 * @return EStatus
	 */
	IStatus getStatus();

}
