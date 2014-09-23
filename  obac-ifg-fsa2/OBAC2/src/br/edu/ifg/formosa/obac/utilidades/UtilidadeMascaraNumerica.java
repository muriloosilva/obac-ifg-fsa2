package br.edu.ifg.formosa.obac.utilidades;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class UtilidadeMascaraNumerica extends PlainDocument{
	
	private static final long serialVersionUID = 1L;

	@Override
	public void insertString(int offset, String str, AttributeSet attr)
		throws BadLocationException {
		// TODO Auto-generated method stub
		super.insertString(offset, str.replaceAll("[^0-9|^,|^-]", ""), attr);
	}

	@Override
	public void replace(int arg0, int arg1, String str, AttributeSet attr)
		throws BadLocationException {
		// TODO Auto-generated method stub
		super.replace(arg0, arg1, str.replaceAll("[^0-9|^,|^-]", ""), attr);
	}
}
