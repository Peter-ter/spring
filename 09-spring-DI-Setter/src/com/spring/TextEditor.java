package com.spring;

public class TextEditor {

	private SpellChecker spellChecker;
	
	

	public TextEditor() {
		System.out.println("Inside TextEditor constructor.");
	}

	public SpellChecker getSpellChecker() {
		return spellChecker;
	}

	public void setSpellChecker(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}

	public void spellCheck() {
		spellChecker.checkSpelling();
	}

}
