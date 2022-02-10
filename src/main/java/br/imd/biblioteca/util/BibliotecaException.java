package br.imd.biblioteca.util;

public class BibliotecaException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BibliotecaException() {
		super();
	}
	
	public BibliotecaException(String msg, Throwable thr) {
		super(msg,thr);
	}
	
	public BibliotecaException(String msg) {
		super(msg);
	}
	
	public BibliotecaException(Throwable thr) {
		super(thr);
	}

}
