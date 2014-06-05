package br.edu.ifg.formosa.obac.modelo;

public class ModeloFormulas {
	
	//Fórmulas em texto
		//Propulsões
		public static String propMolaTextual = "Velocidade_Inicial = v[(Constante_Elastica + Compresão_da_mola^2)/Massa]";//Mola
		//Força Normal
		public static String forcaNormalTextual = "Força_Normal = Massa * Gravidade";
		//Atrito
		public static String atritoTextual = "Atrito = Força_Normal * Coeficiente_de_Ficção";
		//Acelerações
		public static String aceleracaoPlanoTextual = "Aceleração = Atrito/Massa * -1";//No plano
		public static String aceleracaoQuedaTextual = "Aceleração = Gravidade";//Queda Livre
		public static String aceleracaoDescidaTextual = "Aceleração = [(Gravidade * Seno_do_Ângulo) + (Coeficiente_de_Ficção * Gravidade * Coseno_do_Ângulo)]";//Descida
		public static String aceleracaoSubidaTextual = aceleracaoDescidaTextual + " * (-1)";//Subida
		//Posição final
		public static String posicaoFinalDescidaTextual = "Posição_Final = (Velocidade_Inicial^2 * -1)/(2 * Aceleração)";
		public static String posicaoFinalPlanoTextual = posicaoFinalDescidaTextual + " * (-1)";
		//Tempo
		public static String tempoTextual = "Tempo = (Velocidade_Final - Velocidade_Inicial)/Aceleração \nTempo = Variação_Velocidade/Aceleração";
		//Nova Posição
		public static String novaPosicaoTextual = "Espaço_Atual = Espaço_Inicial + Velocidade_Inicial * Tempo + (Aceleração * Tempo^2)/2";
	
	//Fórmulas com variáveis
		//Propulsões
		public static String propMola = "V0= v(K+x^2/Massa) \n";//Mola
		//Força Normal
		public static String forcaNormal = "N = m * g";
		//Atrito
		public static String atrito = "Fat = N * μ";
		//Acelerações
		public static String aceleracaoPlano = "a = Fat/m * -1";//No plano
		public static String aceleracaoQueda = "a = g";//Queda Livre
		public static String aceleracaoDescida = "a = [(g * Sen(θ)) + (μ * g * Cos(θ))]";//Descida
		public static String aceleracaoSubida = aceleracaoDescida + " * (-1)";//Subida
		//Posição final
		public static String posicaoFinalDescida = "Sf = (V0^2 * -1)/(2 * a)";
		public static String posicaoFinalPlano = posicaoFinalDescida + " * (-1)";
		//Tempo
		public static String tempo = "t = (Vf - V0)/a \nt = ΔV/a";
		//Nova Posição
		public static String novaPosicao = "s=s0+v0*t+(a*t^2)/2 \n";
	/*
	 -+-+-+- incluir macetes em alguma parte???
	*/
	
}
