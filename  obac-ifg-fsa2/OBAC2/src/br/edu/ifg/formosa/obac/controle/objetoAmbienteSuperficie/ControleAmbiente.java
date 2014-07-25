package br.edu.ifg.formosa.obac.controle.objetoAmbienteSuperficie;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.edu.ifg.formosa.obac.controle.obac.ControleOBAC;
import br.edu.ifg.formosa.obac.modelo.ModeloAmbiente;
import br.edu.ifg.formosa.obac.modelo.ModeloPainelConfiguracao;
import br.edu.ifg.formosa.obac.principal.OBAC;
import br.edu.ifg.formosa.obac.visao.VisaoPainelConfiguracao;
import br.edu.ifg.formosa.obac.visao.VisaoPainelSimulacao;
import br.edu.ifg.formosa.obac.visao.VisaoSuperficie;

public class ControleAmbiente {
	
	//Constante do painel de configuração
	private final VisaoPainelConfiguracao vPC;
	private final VisaoPainelSimulacao vPS;
	
	//Métodos
	//--Construtor
	public ControleAmbiente(final ModeloAmbiente mA, final VisaoPainelConfiguracao vPC,
			final ModeloPainelConfiguracao mPC, final ControleOBAC cO, final VisaoSuperficie vS,
			VisaoPainelSimulacao vPS) {
		this.vPC = vPC;
		this.vPS = vPS;
		
		vPC.getCsAmbienteGravidade().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				switch (vPC.getCsAmbienteGravidade().getSelectedIndex()) { //Determina qual a imagem de fundo
					case 0:
						mA.setUrlGr("terra");
						break;
					case 1:
						mA.setUrlGr("lua");
						break;
					case 2:
						mA.setUrlGr("marte");
						break;
				}
				mudaImagem(cO, vS, mA);
			}
		});
		
		vPC.getCsAmbienteSimulacao().addActionListener(new ActionListener() { //Determina o guindaste de acordo com a simulação
			@Override
			public void actionPerformed(ActionEvent e) {
				switch (vPC.getCsAmbienteSimulacao().getSelectedIndex()) {
					case 0: //Plano
						componentesUsados(true, true);
						mA.setUrlA("plano");
						break;
					case 1: //Subida
						componentesUsados(true, true);
						mA.setUrlA("subida");
						break;
					case 2: //Descida
						componentesUsados(true, true);
						mA.setUrlA("descida");
						break;
					case 3: //P&P
						componentesUsados(false, true);
						mA.setUrlA("precipicio");
						break;
					case 4: //Queda
						componentesUsados(false, false);
						mA.setUrlA("plano");
						
						if (!vPC.getBaNovaSimulacao().isVisible()) 
							mA.setUrlGu("guindasteF");
						else
							mA.setUrlGu("guindasteA");
						
						break;
					case 5: //Projétil
						componentesUsados(false, true);
						mA.setUrlA("plano");
						break;
				}
				mudaImagem(cO, vS, mA);
			}
		});
	}
	
	//--Muda imagem fundo
	public void mudaImagem(ControleOBAC cO, VisaoSuperficie vS, ModeloAmbiente mA) {
		vS.novasImagens(mA.getUrlGr(), mA.getUrlA(), mA.getUrlGu());
		cO.repinta();
	}
	
	//--Ativa ou desativa o componentes do pConfig de acordo com a simulação
	private void componentesUsados(boolean obstaculo, boolean propulsao){
		//Obstáculo
			vPC.getBoColisaoNao().setSelected(true);
			vPC.getBoColisaoNao().setEnabled(obstaculo);
			vPC.getBoColisaoSim().setEnabled(obstaculo);
		//Propulsão
			vPC.getCsPropulsao().setEnabled(propulsao);
			vPC.getCtPropulsaoDado1().setEnabled(propulsao);
			vPC.getCtPropulsaoDado2().setEnabled(propulsao);
			if(!propulsao){
				vPC.getCtPropulsaoDado1().setText("");
				vPC.getCtPropulsaoDado2().setText("");
				vPS.getVisaoPropulsao().setVisible(propulsao);
			}
			else{vPS.getVisaoPropulsao().setVisible(propulsao);}
	}
	
}