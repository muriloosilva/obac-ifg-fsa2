package br.edu.ifg.formosa.obac.controle.paineis;

import javax.swing.JOptionPane;

import br.edu.ifg.formosa.obac.visao.VisaoPainelConfiguracao;

public class ControlePainelConfiguracaoEntradaDeDados {
	
	private static VisaoPainelConfiguracao vpc = null;
	
	public ControlePainelConfiguracaoEntradaDeDados(VisaoPainelConfiguracao vpc) {
		ControlePainelConfiguracaoEntradaDeDados.vpc = vpc;
	}
	
	public boolean verificaCampos(){
		//Todos os campos de dados
		if(vpc.getCtPropulsaoDado1().getText().equalsIgnoreCase("") == true
		|| vpc.getCtPropulsaoDado2().getText().equalsIgnoreCase("") == true
		|| vpc.getCtObjetoMassa().getText().equalsIgnoreCase("") == true
		){
			JOptionPane.showMessageDialog(null,
				"Por favor,\n preencha todos os campos de texto para que a simulação seja iniciada.",
				"Aviso", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		//Se todos os campos foram preenchidos - retorna verdadeiro
		else{
			return true;
		}
	}
	
	
}
