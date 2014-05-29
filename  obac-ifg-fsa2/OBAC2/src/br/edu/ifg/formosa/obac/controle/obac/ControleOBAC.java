package br.edu.ifg.formosa.obac.controle.obac;

import java.awt.Color;

import javax.swing.JPanel;

import br.edu.ifg.formosa.obac.controle.paineis.ControlePainelConfiguracaoEntradaDeDados;
import br.edu.ifg.formosa.obac.controle.paineis.ControlePainelConfiguracaoAtualizacoes;
import br.edu.ifg.formosa.obac.controle.paineis.ControlePainelConfiguracaoExecucao;
import br.edu.ifg.formosa.obac.modelo.ModeloPainelConfiguracao;
import br.edu.ifg.formosa.obac.principal.OBAC;
import br.edu.ifg.formosa.obac.visao.VisaoPainelConfiguracao;
import br.edu.ifg.formosa.obac.visao.VisaoPainelInformacao;

public class ControleOBAC {
	
	//Painel Principal
		private JPanel painelPrincipal = null;
	//Modelo Painel de Configuração - Contém os arrays de string utilizados e as strings que são modificadas durante o código
		private ModeloPainelConfiguracao mpc = null;
	//Painel de Configuração
		private VisaoPainelConfiguracao vpc = null;
	//Painel de Informações
		private VisaoPainelInformacao vpi = null;
		
	//Painel da Superfície
	//Painel do Objeto
	//Painel da Escala
	//Painel de Simulação
	
	public ControleOBAC(OBAC obac) {
		
		//Painel Principal
		painelPrincipal = new JPanel(null);
			painelPrincipal.setBackground(Color.BLUE);
			painelPrincipal.setSize(1000, 600);
		obac.add(painelPrincipal);
		
		//Modelo Painel de Configuração
		mpc = new ModeloPainelConfiguracao();
		
		//Painel de Configuração
		vpc = new VisaoPainelConfiguracao(mpc);
		painelPrincipal.add(vpc);
		
		//Controles do Painel de Configuração
		new ControlePainelConfiguracaoAtualizacoes(vpc, mpc);
		new ControlePainelConfiguracaoEntradaDeDados(vpc);
		new ControlePainelConfiguracaoExecucao(vpc, mpc);
		
		
		//Painel de Informações
		vpi = new VisaoPainelInformacao();
		painelPrincipal.add(vpi);
		
		//Repintar Applet
		obac.repaint();
	}
	
}
