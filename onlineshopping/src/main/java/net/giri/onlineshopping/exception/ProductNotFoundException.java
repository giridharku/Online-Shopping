/**
 * 
 */
package net.giri.onlineshopping.exception;

/**
 * @author giridhar
 *
 */
public class ProductNotFoundException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String msg;

    public ProductNotFoundException(String msg) {
	super();
	this.msg = msg;
    }

    public String getMsg() {
	return msg;
    }

    public void setMsg(String msg) {
	this.msg = msg;
    }

}
