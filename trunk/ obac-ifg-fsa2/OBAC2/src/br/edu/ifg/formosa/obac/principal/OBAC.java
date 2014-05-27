package br.edu.ifg.formosa.obac.principal;

import java.applet.Applet;

import br.edu.ifg.formosa.obac.controle.obac.ControleOBAC;
import br.edu.ifg.formosa.obac.visao.VisaoOBAC;

public class OBAC extends Applet{
	
	private static final long serialVersionUID = 1L;

	@Override
	public void init() {
		new VisaoOBAC(this);
		new ControleOBAC(this);
	}
	
}
