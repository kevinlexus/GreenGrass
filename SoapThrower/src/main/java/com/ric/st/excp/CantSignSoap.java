package com.ric.st.excp;

/**
 * Exception возникающий при невозможности подписать SOAP запрос
 * @author lev
 *
 */
@SuppressWarnings("serial")
public class CantSignSoap  extends Exception {

	public CantSignSoap(String message) {
        super(message);
    }
}
