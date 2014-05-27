package br.edu.ifg.formosa.obac.controle.paineis;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import br.edu.ifg.formosa.obac.visao.VisaoPainelConfiguracao;

public class ControlePainelConfiguracaoAtualizacoes {
	
	public ControlePainelConfiguracaoAtualizacoes(final VisaoPainelConfiguracao vpc) {
		
		//Mudança nos rótulos de dados da propulsão e nas simulações disponíveis
		vpc.getCsPropulsao().addActionListener(new ActionListener() {
			private String canhao = "Canhão";
			private String mola = "Mola";
			private String dado1Canhao = "Ângulo (°)"; 
			private String dado2Canhao = "Energia (J)";
			private String dado1Mola = "Tamaho da Mola(m)";
			private String dado2Mola = "Constante Elástica (N/m)";
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(vpc.getCsPropulsao().getSelectedItem().equals(canhao)){
					//Rótulos
					vpc.getrPropulsaoDado1().setText(dado1Canhao);
					vpc.getrPropulsaoDado2().setText(dado2Canhao);
					//Caixa de seleção das simulações
				}
				else if(vpc.getCsPropulsao().getSelectedItem().equals(mola)){
					//Rótulos
					vpc.getrPropulsaoDado1().setText(dado1Mola);
					vpc.getrPropulsaoDado2().setText(dado2Mola);
					//Caixa de seleção das simulações
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
				//Em seguida é passado para um rótulo (JLabel), afim do usuário saber o valor que a simulação usará
			}
		});
	}

}
