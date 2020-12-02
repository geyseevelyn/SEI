package br.edu.ufersa.sei.exception;

public class AutenticationException extends Exception{
	private static final long serialVersionUID = 1L;

	public AutenticationException() {
		super("Login e/ou senha incorretos");
	}
}