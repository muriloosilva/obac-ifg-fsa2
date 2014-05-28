package br.edu.ifg.formosa.obac.controle.paineis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import br.edu.ifg.formosa.obac.modelo.ModeloPainelConfiguracao;
import br.edu.ifg.formosa.obac.visao.VisaoPainelConfiguracao;

public class ControlePainelConfiguracaoAtualizacoes {
	
	public ControlePainelConfiguracaoAtualizacoes(final VisaoPainelConfiguracao vpc, final ModeloPainelConfiguracao mpc) {
		
		//Mudança nos rótulos de dados da propulsão e nas simulações disponíveis
		vpc.getCsPropulsao().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(vpc.getCsPropulsao().getSelectedItem().equals(mpc.getCanhao())){
					//Rótulos
					vpc.getrPropulsaoDado1().setText(mpc.getDado1Canhao());
					vpc.getrPropulsaoDado2().setText(mpc.getDado2Canhao());
					//Caixa de seleção das simulações
					vpc.getCsAmbienteSimulacao().insertItemAt(mpc.getLancamentoObliquo(), 5);
				}
				else if(vpc.getCsPropulsao().getSelectedItem().equals(mpc.getMola())){
					//Rótulos
					vpc.getrPropulsaoDado1().setText(mpc.getDado1Mola());
					vpc.getrPropulsaoDado2().setText(mpc.getDado2Mola());
					//Caixa de seleção das simulações
					if(vpc.getCsAmbienteSimulacao().getItemCount()==6)
						vpc.getCsAmbienteSimulacao().removeItemAt(vpc.getCsAmbienteSimulacao().getItemCount()-1);//Remove a opção de lançamento oblíquo 
				}
				else{
					JOptionPane.showMessageDialog(null,
						"Falha catastrófica no funcionamento do programa", 
						"Aviso", JOptionPane.WARNING_MESSAGE, null);
				}
			}
		});
		
		//Coeficiente de restituição
		vpc.getdObjetoCoeficienteRestituicao().addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent arg0) {
				vpc.getrObjetoAtualCoefRest().setText(""+(vpc.getdObjetoCoeficienteRestituicao().getValue()/100.0));
				//O valor do Deslizante (JSlider) é pego e dividido por 100
				//Em seguida é passado para um rótulo (JLabel), a fim do usuário saber o valor que a simulação usará
			}
		});
	}

}
