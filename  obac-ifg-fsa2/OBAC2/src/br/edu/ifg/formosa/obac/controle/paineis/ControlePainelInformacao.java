package br.edu.ifg.formosa.obac.controle.paineis;

import br.edu.ifg.formosa.obac.utilidades.UtilidadeArredondamento;
import br.edu.ifg.formosa.obac.visao.VisaoPainelInformacao;

public class ControlePainelInformacao {

	private static VisaoPainelInformacao vpi = null;
	
	public ControlePainelInformacao(VisaoPainelInformacao vpi) {
		ControlePainelInformacao.vpi = vpi;
	}
	

	//Primeira Linha
		//Gravidade
		public void mudaValorGravidade(double valor){vpi.getrGravidadeValor().setText("" + UtilidadeArredondamento.arredondamento(1, valor));}
		//Coeficiente de Atrito
		public void mudaValorCoefAtrito(double valor){vpi.getrCoefAtritoValor().setText("" + UtilidadeArredondamento.arredondamento(1, valor));}
		//Aceleração
		public void mudaValorAceleracao(double valor){vpi.getrAceleracaoValor().setText("" + UtilidadeArredondamento.arredondamento(1, valor));}
		//Posição Final X
		public void mudaValorPosFinalX(double valor){vpi.getrPosFinalXValor().setText("" + UtilidadeArredondamento.arredondamento(1, valor));}
		//Posição Final Y
		public void mudaValorPosFinalY(double valor){vpi.getrPosFinalYValor().setText("" + UtilidadeArredondamento.arredondamento(1, valor));}
	//Segunda Linha
		//Força Normal
		public void mudaValorForcaNormal(double valor){vpi.getrForcaNormalValor().setText("" + UtilidadeArredondamento.arredondamento(1, valor));}
		//Força de Atrito
		public void mudaValorForcaAtrito(double valor){vpi.getrForcaAtritoValor().setText("" + UtilidadeArredondamento.arredondamento(1, valor));}
		//Velocidade
		public void mudaValorVelocidade(double valor){vpi.getrVelocidadeValor().setText("" + UtilidadeArredondamento.arredondamento(1, valor));}
		//Posição Atual Eixo X
		public void mudaValorPosAtualX(double valor){vpi.getrPosAtualEixoXValor().setText("" + UtilidadeArredondamento.arredondamento(1, valor));}
		//Posição Atual Eixo Y
		public void mudaValorPosAtualY(double valor){vpi.getrPosAtualEixoYValor().setText("" + UtilidadeArredondamento.arredondamento(1, valor));}
	//Terceira Linha
		//Tempo
		public void mudaValorTempo(double valor){vpi.getrTempoValor().setText("" + UtilidadeArredondamento.arredondamento(1, valor));}
		//Contante Elástica
		public void mudaValorConstanteElastica(double valor){vpi.getrKValor().setText("" + UtilidadeArredondamento.arredondamento(1, valor));}
		//Taxa de Deformação
		public void mudaValorTaxaDeDeformacao(double valor){vpi.getrXValor().setText("" + UtilidadeArredondamento.arredondamento(1, valor));}
		//Energia
		public void mudaValorEnergia(double valor){
			String v = valor+"";
			if(v.length()>3){
				vpi.getrJValor().setText(UtilidadeArredondamento.notacaoCientifica(valor));
			}
			else{
				vpi.getrJValor().setText("" + UtilidadeArredondamento.arredondamento(1, valor));
			}
			vpi.getrXValor().setText("");
		}
		//Ângulo
		public void mudaValorAngulo(double valor){vpi.getrAValor().setText("" + UtilidadeArredondamento.arredondamento(1, valor));}
		//Velocidade Pós Colisão
		public void mudaValorVelocidadePosColisao(double valor){vpi.getrVelocidadePosColisaoColisao().setText("" + UtilidadeArredondamento.arredondamento(1, valor));}
	
	//Metódo que zera os valores do Painel de Informação
	public static void resertaPInfo(){
		//Primeira Linha
		vpi.getrGravidadeValor().setText("0.0");
		vpi.getrCoefAtritoValor().setText("0.0");
		vpi.getrAceleracaoValor().setText("0.0");
		vpi.getrPosFinalXValor().setText("0.0");
		vpi.getrPosFinalYValor().setText("0.0");
		//Segunda Linha
		vpi.getrForcaNormalValor().setText("0.0");
		vpi.getrForcaAtritoValor().setText("0.0");
		vpi.getrVelocidadeValor().setText("0.0");
		vpi.getrPosAtualEixoXValor().setText("0.0");
		vpi.getrPosAtualEixoYValor().setText("0.0");
		//Terceira Linha
		vpi.getrTempoValor().setText("0.0");
		vpi.getrXValor().setText("0.0");
		vpi.getrKValor().setText("0.0");
		vpi.getrJValor().setText("0.0");
		vpi.getrAValor().setText("0.0");
		vpi.getrVelocidadePosColisaoColisao().setText("0.0");
	}
}
