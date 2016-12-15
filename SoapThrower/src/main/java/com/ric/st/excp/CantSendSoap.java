package com.ric.st.excp;

/**
 * Exception возникающий при невозможности отправить SOAP запрос
 * @author lev
 *
 */
@SuppressWarnings("serial")
public class CantSendSoap  extends Exception {

	public CantSendSoap(String message) {
        super(message);
    }
}
