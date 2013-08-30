package com.gs.test.random;

import java.util.Random;

public class Password {

	/**
	 * Alphabet consisting of all the printable ASCII characters.
	 */
	public static final char[] PRINTABLE_ALPHABET = {
		'!','\"','#','$','%','&','\'','(',
		')','*','+',',','-','.','/','0',
		'1','2','3','4','5','6','7','8',
		'9',':',';','<','?','@','A','B',
		'C','D','E','F','G','H','I','J',
		'K','L','M','N','O','P','Q','R',
		'S','T','U','V','W','X','Y','Z',
		'[','\\',']','^','_','`','a','b',
		'c','d','e','f','g','h','i','j',
		'k','l','m','n','o','p','q','r',
		's','t','u','v','w','x','y','z',
		'{','|','}','~',
	};

	/**
	 * Generate a password follow the char array and length
	 * 
	 * @param p_charArray	the char array
	 * @param p_length		the length of password
	 */
	public String generater(char[] p_charArray, int p_length){
		
		char[] result = new char[p_length];
		int charArrLen = p_charArray.length;
		Random generator = new Random();
		
		for(int i=0,randomNum;i<result.length;i++){
			randomNum = generator.nextInt(charArrLen);
			result[i] = p_charArray[randomNum];
		}
		
		return String.valueOf(result);
	}
	
	public static void main(String[] args) {
		Password test = new Password();
		//System.out.println(PRINTABLE_ALPHABET.length);
		System.out.println(String.valueOf(PRINTABLE_ALPHABET));
		for(int i=0;i<10;i++){
			System.out.println(test.generater(PRINTABLE_ALPHABET, 8));
		}
		
		/*char charArr[] = {'a', 'b', 'c'};
		for(int i=0;i<10;i++){
			System.out.println(test.generater(charArr, 2));
		}*/
	}

}
