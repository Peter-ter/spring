package com.spring;

import org.springframework.beans.factory.annotation.Autowired;

public class TextEditor {

	private SpellChecker spellChecker;

	public TextEditor() {
		System.out.println("Inside TextEditor constructor.");
	}

	public SpellChecker getSpellChecker() {
		return spellChecker;
	}
	@Autowired
	public void setSpellChecker(SpellChecker spellChecker) {
		this.spellChecker = spellChecker;
	}

	public void spellCheck() {
		spellChecker.checkSpelling();
	}

}
