package br.edu.ifg.formosa.obac.controle.paineis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.edu.ifg.formosa.obac.modelo.ModeloPainelConfiguracao;
import br.edu.ifg.formosa.obac.visao.VisaoPainelConfiguracao;

public class ControlePainelConfiguracaoExecucao {

	public ControlePainelConfiguracaoExecucao(final VisaoPainelConfiguracao vpc, final ModeloPainelConfiguracao mpc) {
		
		//Botão Iniciar/Pausar
		vpc.getBaIniciaPausar().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Inicia simulação
				if (vpc.getBaIniciaPausar().getText().equals(mpc.getBotaoIniciar())==true
					&& ControlePainelConfiguracaoEntradaDeDados.verificaCampos()==true) {
				}
				//Pausa simulação
				else if(vpc.getBaIniciaPausar().getText().equals(mpc.getBotaoPausar())){}
				//Se vier para cá a simulação deu errado por uma falha no código
				else{}
			}
		});
		
		/*Botão nova simulação - Para simulação retornando-a para seu estado original,
		 *tornando possível a realização de uma nova simulação*/ 
		vpc.getBaNovaSimulacao().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			}
		});
	}
	
}
