package com.ric.bill.excp;

/**
 * Exception возникающий если задана пустая услуга 
 * @author lev
 *
 */
public class EmptyServ  extends Exception {

	public EmptyServ(String message) {
        super(message);
    }
}
