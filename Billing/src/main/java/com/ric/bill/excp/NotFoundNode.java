package com.ric.bill.excp;

/**
 * Exception возникающий если счетчик не найден 
 * @author lev
 *
 */
public class NotFoundNode  extends Exception {

	public NotFoundNode(String message) {
        super(message);
    }
}
