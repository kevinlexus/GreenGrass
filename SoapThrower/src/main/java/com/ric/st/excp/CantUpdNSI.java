package com.ric.st.excp;

/**
 * Exception возникающий при невозможности обновить справочники NSI
 * @author lev
 *
 */
@SuppressWarnings("serial")
public class CantUpdNSI  extends Exception {

	public CantUpdNSI(String message) {
        super(message);
    }
}
