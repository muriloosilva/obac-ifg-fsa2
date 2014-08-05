package br.edu.ifg.formosa.obac.controle.obac;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import br.edu.ifg.formosa.obac.controle.escala.ControleEscala;
import br.edu.ifg.formosa.obac.controle.objetoAmbienteSuperficie.ControleAmbiente;
import br.edu.ifg.formosa.obac.controle.objetoAmbienteSuperficie.ControleFormulasObjeto;
import br.edu.ifg.formosa.obac.controle.objetoAmbienteSuperficie.ControleFormulasSuperficie;
import br.edu.ifg.formosa.obac.controle.objetoAmbienteSuperficie.ControleInicioSimulacoes;
import br.edu.ifg.formosa.obac.controle.obstaculo.ControleObstaculoMouse;
import br.edu.ifg.formosa.obac.controle.paineis.ControlePainelConfiguracaoAtualizacoes;
import br.edu.ifg.formosa.obac.controle.paineis.ControlePainelConfiguracaoEntradaDeDados;
import br.edu.ifg.formosa.obac.controle.paineis.ControlePainelConfiguracaoExecucao;
import br.edu.ifg.formosa.obac.controle.paineis.ControlePainelFormulas;
import br.edu.ifg.formosa.obac.controle.paineis.ControlePainelInformacao;
import br.edu.ifg.formosa.obac.controle.propulsao.ControleMolaMouse;
import br.edu.ifg.formosa.obac.modelo.ModeloAmbiente;
import br.edu.ifg.formosa.obac.modelo.ModeloPainelConfiguracao;
import br.edu.ifg.formosa.obac.principal.OBAC;
import br.edu.ifg.formosa.obac.visao.VisaoPainelConfiguracao;
import br.edu.ifg.formosa.obac.visao.VisaoPainelFormulas;
import br.edu.ifg.formosa.obac.visao.VisaoPainelInformacao;
import br.edu.ifg.formosa.obac.visao.VisaoPainelSimulacao;

public class ControleOBAC {
	
	//Paineis desta Classe
		//Painel Principal
		private JPanel painelPrincipal = null;
		//Painel de Abas
		private JTabbedPane painelAbas = null;
		//Painel para o pSimulação e o pInformação para tentar evitar o problema da sobreposição que ococrre durante o uso dos métodos repaint de ambos os paineis
		private JPanel painelDeRepintar = null;
	
	//Modelos
		//Modelo Painel de Configuração - Contém os arrays de string utilizados e as strings que são modificadas durante o código
		private ModeloPainelConfiguracao mpc = null;
		//Modelo do Ambiente
		private ModeloAmbiente mA = null;
		
	//Visão
		//Painel de Configuração
		private VisaoPainelConfiguracao vpc = null;
		//Painel de Informações
		private VisaoPainelInformacao vpi = null;
		//Painel de Fórmulas
		private VisaoPainelFormulas vpf = null;
		//Painel de Simulação
		private VisaoPainelSimulacao vPS = null;
		
	//Controles
		//Controles do Painel de Fórmulas
		private ControlePainelFormulas cpf = null;
		//Controle Fórmulas Objeto
		private ControleFormulasObjeto cFO = null;
		//Controle Fórmulas Superfície
		private ControleFormulasSuperficie cFS = null;
		//Controle Inicio Simulações
		private ControleInicioSimulacoes cIS = null;
		//Controles do Painel de Configuração
		private ControlePainelConfiguracaoEntradaDeDados cpced = null;
		private ControlePainelConfiguracaoAtualizacoes cpca = null;
		//ControleInicioSimulacoes Painel de Informação
		private ControlePainelInformacao cpi = null;
		//ControleInicioSimulacoes da Mola
		private ControleMolaMouse cmm = null;
		//ControleObstáculoMouse
		private ControleObstaculoMouse com = null;
	
	public ControleOBAC(OBAC obac) {
		
		//Painel Principal
		painelPrincipal = new JPanel(null);
			painelPrincipal.setBackground(Color.black);
			painelPrincipal.setSize(1000, 600);
		obac.add(painelPrincipal);
		
		//Paienl de Abas
		painelAbas = new JTabbedPane();
			painelAbas.setBounds(0, 0, 250, 600);
			painelAbas.setFont(new Font("Arial", Font.BOLD, 15));
		painelPrincipal.add(painelAbas);
		
		//Painel de Repintar
		painelDeRepintar = new JPanel(null);
		painelDeRepintar.setBackground(Color.blue);
		painelDeRepintar.setBounds(251, 0, 750, 600);
		painelPrincipal.add(painelDeRepintar);
		
		
		//Painel de Informações
			vpi = new VisaoPainelInformacao();
			painelDeRepintar.add(vpi);
		//ControleInicioSimulacoes do painel de informações
			cpi = new ControlePainelInformacao(vpi);
		//Painel de Configuração
			//Modelo Painel de Configuração
			mpc = new ModeloPainelConfiguracao();
			//Visão Painel de Configuração
			vpc = new VisaoPainelConfiguracao(mpc);
			painelAbas.add(vpc, "Configuração");
			
		//Painel de Fórmulas
			//Visão Painel de Fórmulas
			vpf = new VisaoPainelFormulas();
			painelAbas.add(vpf, "Fórmulas");
			//Controle painel de fórmulas
			cpf = new ControlePainelFormulas(vpf, vpc);
			
		//Modelos das Simulações
			//Modelo Escala
			mA = new ModeloAmbiente(cpi, vpf, cpf);
			
		//Painel de Simulação
			vPS = new VisaoPainelSimulacao(mA, vpc);
			painelDeRepintar.add(vPS);
			
		//Controles de fórmulas
			cFO = new ControleFormulasObjeto(mA, vpf, cpf);
			cFS = new ControleFormulasSuperficie(mA);//Adicionar o vpf nesta classe para atualizar o pFormulas
			//Instanciar o Controle de início das simulações
		//Controle do início das simulações
			cIS = new ControleInicioSimulacoes(mA, vpc, vpf, this, cFO, cFS, cpf);
			
		//Controle da propulsão por mola
			cmm = new ControleMolaMouse(this, vPS.getVisaoPropulsao(), vpc, mA, cIS);
		
		//ControleObstaculoMouse
			com = new ControleObstaculoMouse(vPS.getVisaoObstaculo(), mA.getmObs(), this); 
			
		//Controles do Painel de Configuração
			cpca = new ControlePainelConfiguracaoAtualizacoes(vpc, mpc, vpf, vpi, vPS,mA.getmP().getModeloMola(), com, this);
			cpced = new ControlePainelConfiguracaoEntradaDeDados(vpc);
			new ControlePainelConfiguracaoExecucao(mA, vpc, mpc, cpca, cpced, cIS, cmm);
			
		//Controles - Escala/Ambiente
			new ControleEscala(vpi, vPS, mA, vpc, mpc);
			new ControleAmbiente(mA, vpc, mpc, this, vPS, cpca);
			
		vpc.getCsPropulsao().setSelectedIndex(1);
			
		//Repintar Applet
			obac.repaint();
	}
	
	//Metodo para repintar o painel de informações e o de simulação
	public void repinta() {
		this.painelPrincipal.repaint();
	}
}
