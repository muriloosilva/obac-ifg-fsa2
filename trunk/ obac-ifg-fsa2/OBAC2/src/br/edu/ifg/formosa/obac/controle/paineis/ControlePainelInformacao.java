package br.edu.ifg.formosa.obac.controle.paineis;

import br.edu.ifg.formosa.obac.utilidades.UtilidadeArredondamento;
import br.edu.ifg.formosa.obac.visao.VisaoPainelInformacao;

public class ControlePainelInformacao {

	private static VisaoPainelInformacao vpi = null;
	
	public ControlePainelInformacao(VisaoPainelInformacao vpi) {
		ControlePainelInformacao.vpi = vpi;
	}
	
	//Gravidade
	public void mudaValorGravidade(double valor){vpi.getrGravidadeValor().setText("" + UtilidadeArredondamento.arredondamento(1, valor));}
	//Coeficiente de Atrito
	public void mudaValorCoefAtrito(double valor){vpi.getrCoefAtritoValor().setText("" + UtilidadeArredondamento.arredondamento(1, valor));}
	//Força de Atrito
	public void mudaValorForcaAtrito(double valor){vpi.getrForcaAtritoValor().setText("" + UtilidadeArredondamento.arredondamento(1, valor));}
	//Força Normal
	public void mudaValorForcaNormal(double valor){vpi.getrForcaNormalValor().setText("" + UtilidadeArredondamento.arredondamento(1, valor));}
	//Posição Final
	public void mudaValorPosFinal(double valor){vpi.getrPosFinalValor().setText("" + UtilidadeArredondamento.arredondamento(1, valor));}
	//Aceleração
	public void mudaValorAceleracao(double valor){vpi.getrAceleracaoValor().setText("" + UtilidadeArredondamento.arredondamento(1, valor));}
	//Posição Atual Eixo X
	public void mudaValorPosAtualX(double valor){vpi.getrPosAtualEixoXValor().setText("" + UtilidadeArredondamento.arredondamento(1, valor));}
	//Posição Atual Eixo Y
	public void mudaValorPosAtualY(double valor){vpi.getrPosAtualEixoYValor().setText("" + UtilidadeArredondamento.arredondamento(1, valor));}
	//Tempo
	public void mudaValorTempo(double valor){vpi.getrTempoValor().setText("" + UtilidadeArredondamento.arredondamento(1, valor));}
	
	//Metódo que zera os valores do Painel de Informação
	public static void resertaPInfo(){
		vpi.getrGravidadeValor().setText("0.0");
		vpi.getrCoefAtritoValor().setText("0.0");
		vpi.getrForcaAtritoValor().setText("0.0");
		vpi.getrForcaNormalValor().setText("0.0");
		vpi.getrPosFinalValor().setText("0.0");
		vpi.getrAceleracaoValor().setText("0.0");
		vpi.getrPosAtualEixoXValor().setText("0.0");
		vpi.getrPosAtualEixoYValor().setText("0.0");
		vpi.getrTempoValor().setText("0.0");
	}
}
