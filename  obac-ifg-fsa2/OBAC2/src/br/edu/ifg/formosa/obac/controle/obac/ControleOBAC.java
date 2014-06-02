package br.edu.ifg.formosa.obac.controle.obac;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;

import br.edu.ifg.formosa.obac.controle.paineis.ControlePainelConfiguracaoEntradaDeDados;
import br.edu.ifg.formosa.obac.controle.paineis.ControlePainelConfiguracaoAtualizacoes;
import br.edu.ifg.formosa.obac.controle.paineis.ControlePainelConfiguracaoExecucao;
import br.edu.ifg.formosa.obac.modelo.ModeloPainelConfiguracao;
import br.edu.ifg.formosa.obac.principal.OBAC;
import br.edu.ifg.formosa.obac.visao.VisaoPainelConfiguracao;
import br.edu.ifg.formosa.obac.visao.VisaoPainelFormulas;
import br.edu.ifg.formosa.obac.visao.VisaoPainelInformacao;

public class ControleOBAC {
	
	//Painel Principal
		private JPanel painelPrincipal = null;
	//Painel de Abas
		private JTabbedPane painelAbas = null;
	//Modelo Painel de Configuração - Contém os arrays de string utilizados e as strings que são modificadas durante o código
		private ModeloPainelConfiguracao mpc = null;
	//Painel de Configuração
		private VisaoPainelConfiguracao vpc = null;
	//Painel de Informações
		private VisaoPainelInformacao vpi = null;
	//Painel de Fórmulas
		private VisaoPainelFormulas vpf = null;
		
	//Painel da Superfície
	//Painel do Objeto
	//Painel da Escala
	//Painel de Simulação
	
	public ControleOBAC(OBAC obac) {
		
		//Painel Principal
		painelPrincipal = new JPanel(null);
			painelPrincipal.setBackground(Color.BLACK);
			painelPrincipal.setSize(1000, 600);
		obac.add(painelPrincipal);
		
		//Paienl de Abas
		painelAbas = new JTabbedPane();
			painelAbas.setBounds(0, 0, 250, 600);
			painelAbas.setFont(new Font("Arial", Font.BOLD, 15));
		painelPrincipal.add(painelAbas);
		
		//Modelo Painel de Configuração
		mpc = new ModeloPainelConfiguracao();
		
		//Painel de Configuração
		vpc = new VisaoPainelConfiguracao(mpc);
		painelAbas.add(vpc);
		painelAbas.setTitleAt(0, "Configuração");
		
		//Painel de Fórmulas
		vpf = new VisaoPainelFormulas();
		
		painelAbas.add(vpf);
		painelAbas.setTitleAt(1, "Fórmulas");
		
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
