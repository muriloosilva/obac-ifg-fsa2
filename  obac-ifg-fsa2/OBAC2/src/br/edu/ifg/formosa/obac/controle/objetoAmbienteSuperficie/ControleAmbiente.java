package br.edu.ifg.formosa.obac.controle.objetoAmbienteSuperficie;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.edu.ifg.formosa.obac.controle.obac.ControleOBAC;
import br.edu.ifg.formosa.obac.controle.paineis.ControlePainelConfiguracaoAtualizacoes;
import br.edu.ifg.formosa.obac.modelo.ModeloAmbiente;
import br.edu.ifg.formosa.obac.modelo.ModeloPainelConfiguracao;
import br.edu.ifg.formosa.obac.visao.VisaoPainelConfiguracao;
import br.edu.ifg.formosa.obac.visao.VisaoPainelSimulacao;
import br.edu.ifg.formosa.obac.visao.VisaoSuperficie;

public class ControleAmbiente {
	
	//Constante do painel de configuração
	private final ModeloAmbiente mA;
	private final VisaoPainelConfiguracao vPC;
	private final ControlePainelConfiguracaoAtualizacoes cPCA;
	
	//Métodos
	//--Construtor
	public ControleAmbiente(final ModeloAmbiente mA, final VisaoPainelConfiguracao vPC,
			final ModeloPainelConfiguracao mPC, final ControleOBAC cO, final VisaoPainelSimulacao vPS,
			final ControlePainelConfiguracaoAtualizacoes cPCA) {
		this.mA = mA;
		this.vPC = vPC;
		this.cPCA = cPCA;
		
		vPC.getCsAmbienteGravidade().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				switch (vPC.getCsAmbienteGravidade().getSelectedIndex()) { //Determina qual a imagem de fundo
					case 0:
						mA.setUrlGr("terra");
						mA.cor = Color.black;
						
						mA.setGravSelecionada(mA.gravidadeTerra);
						break;
					case 1:
						mA.setUrlGr("lua");
						mA.cor = Color.white;
						
						mA.setGravSelecionada(mA.gravidadeLua);
						break;
					case 2:
						mA.setUrlGr("marte");
						mA.cor = Color.white;
						
						mA.setGravSelecionada(mA.gravidadeMarte);
						break;
				}
				mudaImagem(cO, vPS.getVisaoSuperficie(), mA);
			}
		});
		
		vPC.getCsAmbienteSimulacao().addActionListener(new ActionListener() { //Determina o guindaste de acordo com a simulação
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (vPC.getCsAmbienteSimulacao().getSelectedIndex()) {
					case 0: //Plano
						cPCA.ajustesPConfig();
						mA.setUrlA("plano");
						break;
					case 1: //Subida
						cPCA.ajustesPConfig();
						mA.setUrlA("subida");
						break;
					case 2: //Descida
						cPCA.ajustesPConfig();
						mA.setUrlA("descida");
						break;
					case 3: //P&P
						cPCA.ajustesPConfig();
						mA.setUrlA("precipicio");
						break;
					case 4: //Projétil
						cPCA.ajustesPConfig();
						mA.setUrlA("plano");
						break;
					case 5: //Queda
						cPCA.ajustesPConfig();
						mA.setUrlA("plano");
						if (!vPC.getBaNovaSimulacao().isVisible()) 
							mA.setUrlGu("guindasteF");
						else
							mA.setUrlGu("guindasteA");
						break;
						
				}
				mudaAtritoImagem();
				mudaImagem(cO, vPS.getVisaoSuperficie(), mA);
			}
		});
		
		vPC.getCsAmbienteAtrito().addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				mudaAtritoImagem();
				mudaImagem(cO, vPS.getVisaoSuperficie(), mA);
			}
		});
	}
		
	private void mudaAtritoImagem() {
		switch(vPC.getCsAmbienteAtrito().getSelectedIndex()) {
		case 0:
			mA.setUrlS("Asfalto - " + simulacaoAtiva());
			break;
		case 1:
			mA.setUrlS("Aluminio - " + simulacaoAtiva());
			break;
		case 2:
			mA.setUrlS("Madeira - " + simulacaoAtiva());
			break;					
		}
	}
	
	//--Verifica a simulação ativa (Utilizado para mudar a imagem da superficie
	private String simulacaoAtiva() {
		switch (vPC.getCsAmbienteSimulacao().getSelectedIndex()) {
		case 0:
			return "Plano";
		case 1:
			return "Subida";
		case 2:
			return "Descida";
		case 3:
			return "Precipicio";
		default:
			return "Plano";
		}
	}
	
	//--Muda imagem fundo
	public void mudaImagem(ControleOBAC cO, VisaoSuperficie vS, ModeloAmbiente mA) {
		vS.novasImagens(mA.getUrlGr(), mA.getUrlA(), mA.getUrlGu(), mA.getUrlS());
		cO.repinta();
	}
	
}