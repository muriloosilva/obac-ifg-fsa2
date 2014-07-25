package br.edu.ifg.formosa.obac.controle.obac;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import br.edu.ifg.formosa.obac.controle.escala.ControleEscala;
import br.edu.ifg.formosa.obac.controle.objetoAmbienteSuperficie.ControleAmbiente;
import br.edu.ifg.formosa.obac.controle.paineis.ControlePainelConfiguracaoAtualizacoes;
import br.edu.ifg.formosa.obac.controle.paineis.ControlePainelConfiguracaoEntradaDeDados;
import br.edu.ifg.formosa.obac.controle.paineis.ControlePainelConfiguracaoExecucao;
import br.edu.ifg.formosa.obac.controle.paineis.ControlePainelInformacao;
import br.edu.ifg.formosa.obac.controle.propulsao.ControleMolaMouse;
import br.edu.ifg.formosa.obac.modelo.ModeloAmbiente;
import br.edu.ifg.formosa.obac.modelo.ModeloEscala;
import br.edu.ifg.formosa.obac.modelo.ModeloMola;
import br.edu.ifg.formosa.obac.modelo.ModeloObjeto;
import br.edu.ifg.formosa.obac.modelo.ModeloPainelConfiguracao;
import br.edu.ifg.formosa.obac.modelo.ModeloSuperficie;
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
		//Modelo da Escala Primária
		private ModeloEscala mEPri = null;
		//Modelo da Escala Secundária
		private ModeloEscala mESec = null;
		///Modelo do Objeto
		private ModeloObjeto mO = null;
		//Modelo da Superfície
		private ModeloSuperficie mS = null;
		//Modelo do Ambiente
		private ModeloAmbiente mA = null;
		//Modelo Da propulsão por mola
		private ModeloMola mM = null;
		
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
		//Controles do Painel de Configuração
		private ControlePainelConfiguracaoEntradaDeDados cpced = null;
		private ControlePainelConfiguracaoAtualizacoes cpca = null;
		//Controle Painel de Informação
		private ControlePainelInformacao cpi = null;
		//Controle da Mola
		private ControleMolaMouse cmm = null;
	
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
		//Controle do painel de informações
			cpi = new ControlePainelInformacao(vpi);
			
		//Modelos das Simulações
			//Modelo da Escala Primária
			mEPri = new ModeloEscala();
			//Modelo da Escala Secundária
			mESec = new ModeloEscala();
			///Modelo do Objeto
			mO = new ModeloObjeto(cpi);
			//Modelo da Superfície
			mS = new ModeloSuperficie(cpi);
			//Modelo da Propulsão por Mola
			mM = new ModeloMola(mO, cpi);
			//Modelo Escala
			mA = new ModeloAmbiente(cpi, mEPri, mESec, mO, mS, mM);
			
		//Painel de Configuração
			//Modelo Painel de Configuração
			mpc = new ModeloPainelConfiguracao();
			//Visão Painel de Configuração
			vpc = new VisaoPainelConfiguracao(mpc);
			painelAbas.add(vpc, "Configuração");
			
		//Painel de Fórmulas
			vpf = new VisaoPainelFormulas();
			painelAbas.add(vpf, "Fórmulas");
			
		//Painel de Simulação
			vPS = new VisaoPainelSimulacao(mA, vpc);
			painelDeRepintar.add(vPS);
			
		//Controles - Escala/Ambiente
			new ControleEscala(vpi, vPS, vPS.getVisaoEscalaPri(), mA, vpc, mpc);
			new ControleAmbiente(mA, vpc, mpc, this, vPS.getVisaoSuperficie(), vPS);
			
		//Controle da propulsão por mola
			cmm = new ControleMolaMouse(this, vPS.getVisaoPropulsao(), vPS.getVisaoObjeto(), mA);
			
		//Controles do Painel de Configuração
			cpca = new ControlePainelConfiguracaoAtualizacoes(vpc, mpc, vpf, vpi, vPS.getVisaoPropulsao(),mM, cmm);
			cpced = new ControlePainelConfiguracaoEntradaDeDados(vpc);
			new ControlePainelConfiguracaoExecucao(vpc, mpc, cpca, cpced);
			
		vpc.getCsPropulsao().setSelectedIndex(1);
			
		//Repintar Applet
			obac.repaint();
	}
	
	//Metodo para repintar o painel de informações e o de simulação
	public void repinta() {
//		this.vpi.repaint();
//		this.vPS.repaint();
		this.painelPrincipal.repaint();
	}
}
