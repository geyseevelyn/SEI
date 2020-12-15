package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//validações dos atributos
public class Validacao {	
	
	public static boolean isCpf(String cpf){
		//verifica se é null ou vazio
		if(cpf == null || cpf.equals("")) {
			return false;
		}
		//verifica a qtd de caracteres
		if(cpf.length() != 14) {
			return false;
		}
		
		String padrao = "[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2}";
		Pattern pattern = Pattern.compile(padrao);
		Matcher matcher = pattern.matcher(cpf);
		
		// retorna se o cpf atende ao padrão ou não
		return matcher.matches();
	}
	
	public static boolean isEmail(String email) {
		if(email == null || email.equals("")) {
			return false;
		}
		
		String padrao = "^[a-zA-Z][\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
		Pattern pattern = Pattern.compile(padrao, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(email);
		
		// retorna se o email atende ao padrão ou não
		return matcher.matches();
	}
	
	public static boolean isMatricula(String matricula) {
		//verifica se é null ou vazio
		if(matricula == null || matricula.equals("")) {
			return false;
		}
		//verifica a qtd de caracteres
		if(matricula.length() != 10) {
			return false;
		}
		// retorna se a matricula atende ao padrão ou não
		return matricula.substring(0).matches("[0-9]*");
	}
	
	public static boolean isCodDisc(String codigo){
		//verifica se é null ou vazio
		if(codigo == null || codigo.equals("")) {
			return false;
		}
		//verifica a qtd de caracteres
		if(codigo.length() != 7){
			return false;
		}
		//verifica se os 3 primeiros caracteres são letras
		if(!codigo.substring(0, 3).matches("[A-Z]*")){
			return false;
		}
		// retorna se o código da disciplina atende ao padrão ou não
		return codigo.substring(3).matches("[0-9]*");
	}
	
	public static boolean isCodTurma(String codigo){
		//verifica se é null ou vazio
		if(codigo == null || codigo.equals("")) {
			return false;
		}
		//verifica a qtd de caracteres
		if(codigo.length() != 5){
			return false;
		}
		//verifica se o primeiro caractere é 'T'
		if(!codigo.substring(0, 1).matches("T")){
			return false;
		}
		// retorna se o código da turma atende ao padrão ou não
		return codigo.substring(1).matches("[0-9]*");
	}
	
	public static boolean isLogin(String login) {
		//verifica se é null ou vazio
		if(login == null || login.equals("")) {
			return false;
		}
		//verifica a qtd de caracteres
		if(login.length() < 6 || login.length() > 15) {
			return false;	
		}
		
		//começar com letra e mín. 6 / max. 10 caracteres alfanuméricos 
		String padrao = "^[a-zA-Z]\\w{5,14}$";
		Pattern pattern = Pattern.compile(padrao);
		Matcher matcher = pattern.matcher(login);
		
		// retorna se login atende ao padrão ou não
		return matcher.matches();
	}
	
	public static boolean isSenha(String senha) {
		//verifica se é null ou vazio
		if(senha == null || senha.equals("")) {
			return false;
		}
		//verifica a qtd de caracteres
		if(senha.length() < 6 || senha.length() > 15) {
			return false;	
		}
		
		//pelo menos 1 letra e 1 número / mín. 6 e max. 10 caracteres alfanuméricos 
		String padrao = "^(?!^[0-9]*$)(?!^[a-zA-Z]*$)^([a-zA-Z0-9]{6,15})$";
		Pattern pattern = Pattern.compile(padrao);
		Matcher matcher = pattern.matcher(senha);
		
		// retorna se senha atende ao padrão ou não
		return matcher.matches();
	}
}