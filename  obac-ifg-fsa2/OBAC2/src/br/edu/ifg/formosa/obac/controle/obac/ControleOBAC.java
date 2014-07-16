package br.edu.ifg.formosa.obac.controle.obac;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import br.edu.ifg.formosa.obac.controle.escala.ControleEscala;
import br.edu.ifg.formosa.obac.controle.paineis.ControlePainelConfiguracaoAtualizacoes;
import br.edu.ifg.formosa.obac.controle.paineis.ControlePainelConfiguracaoEntradaDeDados;
import br.edu.ifg.formosa.obac.controle.paineis.ControlePainelConfiguracaoExecucao;
import br.edu.ifg.formosa.obac.controle.paineis.ControlePainelInformacao;
import br.edu.ifg.formosa.obac.modelo.ModeloAmbiente;
import br.edu.ifg.formosa.obac.modelo.ModeloEscala;
import br.edu.ifg.formosa.obac.modelo.ModeloPainelConfiguracao;
import br.edu.ifg.formosa.obac.principal.OBAC;
import br.edu.ifg.formosa.obac.visao.VisaoPainelConfiguracao;
import br.edu.ifg.formosa.obac.visao.VisaoPainelFormulas;
import br.edu.ifg.formosa.obac.visao.VisaoPainelInformacao;
import br.edu.ifg.formosa.obac.visao.VisaoPainelSimulacao;

public class ControleOBAC {
	
	//Painel Principal
		private JPanel painelPrincipal = null;
	//Painel de Abas
		private JTabbedPane painelAbas = null;
	//Modelo Painel de Configuração - Contém os arrays de string utilizados e as strings que são modificadas durante o código
		private ModeloPainelConfiguracao mpc = null;
	//Modelo do Ambiente
		private ModeloAmbiente mA = null;
	//Painel de Configuração
		private VisaoPainelConfiguracao vpc = null;
	//Painel de Informações
		private VisaoPainelInformacao vpi = null;
	//Painel de Fórmulas
		private VisaoPainelFormulas vpf = null;
	//Painel de Simulação
		private VisaoPainelSimulacao vPS = null;
	//Controles do Painel de Configuração
		private ControlePainelConfiguracaoEntradaDeDados cpced = null;
		private ControlePainelConfiguracaoAtualizacoes cpca = null;
	
	public ControleOBAC(OBAC obac) {
		
		//Painel Principal
		painelPrincipal = new JPanel(null);
			painelPrincipal.setBackground(Color.yellow);
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
		painelAbas.add(vpc, "Configuração");
		
		//Painel de Fórmulas
		vpf = new VisaoPainelFormulas();
		painelAbas.add(vpf, "Fórmulas");
		
		//Controles do Painel de Configuração
		cpca = new ControlePainelConfiguracaoAtualizacoes(vpc, mpc, vpf);
		cpced = new ControlePainelConfiguracaoEntradaDeDados(vpc);
		new ControlePainelConfiguracaoExecucao(vpc, mpc, cpca, cpced);	
		
		//Painel de Informações
		vpi = new VisaoPainelInformacao();
		painelPrincipal.add(vpi);
		
		//Controle do painel de informações
		ControlePainelInformacao cpi = new ControlePainelInformacao(vpi);
		
		//Modelo Escala
		mA = new ModeloAmbiente(cpi);
		
		//Painel de Simulação
		vPS = new VisaoPainelSimulacao(mA);
		painelPrincipal.add(vPS);
		
		//Controle do Painel de Escalas
		new ControleEscala(vpi, vPS, vPS.getVisaoEscalaPri(), mA, vpc, mpc);
		
		//Repintar Applet
		obac.repaint();
	}
	
}
