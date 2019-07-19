package com.spring;


public class TextEditor {

	private SpellChecker spellChecker;

	public TextEditor() {
		super();
	}

	public TextEditor(SpellChecker spellChecker) {
		System.out.println("Inside TextEditor constructor.");
		this.spellChecker = spellChecker;
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
