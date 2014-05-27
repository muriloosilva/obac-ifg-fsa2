package br.edu.ifg.formosa.obac.controle.obac;

import java.awt.Color;

import javax.swing.JPanel;

import br.edu.ifg.formosa.obac.controle.paineis.ControlePainelConfiguracaoAtualizacoes;
import br.edu.ifg.formosa.obac.principal.OBAC;
import br.edu.ifg.formosa.obac.visao.VisaoPainelConfiguracao;
import br.edu.ifg.formosa.obac.visao.VisaoPainelInformacao;

public class ControleOBAC {
	
	//Painel Principal
		private JPanel painelPrincipal = null;
	//Painel de configuração
		private VisaoPainelConfiguracao vpc = null;
	//Painel de informações
		private VisaoPainelInformacao vpi = null;
	
	public ControleOBAC(OBAC obac) {
		
		//Painel Principal
		painelPrincipal = new JPanel(null);
			painelPrincipal.setBackground(Color.BLUE);
			painelPrincipal.setSize(1000, 600);
		obac.add(painelPrincipal);
		
		//Painel de Configuração
		vpc = new VisaoPainelConfiguracao();
		painelPrincipal.add(vpc);
		
		//Controles do Painel de Configuração
		new ControlePainelConfiguracaoAtualizacoes(vpc);
		
		
		//Painel de Configurações
		vpi = new VisaoPainelInformacao();
		painelPrincipal.add(vpi);
		
		//Repintar Applet
		obac.repaint();
	}
	
}
