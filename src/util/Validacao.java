package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validacao {
	// validações dos atributos
	// public static boolean isCpf();
	// isEmail();
	// isEndereco();
	// isCodTurma();
	// isCodDisc();
	// isMatricula();
	
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

}