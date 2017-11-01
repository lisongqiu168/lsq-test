package com.lsq.service.tika;

import org.apache.tika.language.LanguageIdentifier;

public class TikaService {

	public static void main(String[] args) {
		language("にほんご、にっぽんご");
		language("this");
	}
	
	public static void language(String s){
		LanguageIdentifier identifier = new LanguageIdentifier(
				s);
		String language = identifier.getLanguage();
		System.out.println("Language of the given content is : " + language);
	}
}
