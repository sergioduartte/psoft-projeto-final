package com.ufcg.psoft.projeto_final.util;

import org.apache.commons.lang3.RandomStringUtils;

public class LoginUtil {
	
	private LoginUtil() {}

	public static String geraSenha() {
        
		int length = 10;
        boolean useLetters = true;
        boolean useNumbers = false;
       
        return RandomStringUtils.random(length, useLetters, useNumbers);
    }
}
