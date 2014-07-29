package br.edu.ifg.formosa.obac.modelo;

public class ModeloPainelFormulas {
	
	//Fórmulas com variáveis
		//Propulsões
		public static String propMola = "V0 = √(K+x²/m) \n";//Mola
		public static String propCanhao = "V0 = (2 * e * m) \n";//Canhão
		//Força Normal
		public static String forcaNormal = "N = m * g \n";
		//Atrito
		public static String atrito = "Fat = N * μ \n";
		//Acelerações
		public static String aceleracaoPlano = "a = Fat/m * -1 \n";//No plano
		public static String aceleracaoQueda = "a = g";//Queda Livre
		public static String aceleracaoDescida = "a = [(g * Sen(θ)) + (μ * g * Cos(θ))] \n";//Descida
		public static String aceleracaoSubida = aceleracaoDescida + " * (-1) \n";//Subida
		//Posição final
		public static String posicaoFinalDescida = "Sf = (V0² * -1)/(2 * a) \n";
		public static String posicaoFinalPadrao = posicaoFinalDescida + " * (-1) \n";
		//Tempo
		public static String tempo = "t = (Vf - V0)/a \nt = ΔV/a \n";
		//Nova Posição
		public static String equaHorariaAbscissa = "s=s0+v0*t+(a*t²)/2 \n";
		
		//Colisão
			//Colisão
			public static String colisao ="Va'=((Va*(Ma-Mb*e))/(Ma-Mb)) \n"; 
			//Velocidade pós colisão - Equação de Torricceli
			public static String equaTorricceli = "V² = V0² + 2 * a * ΔS \nV = √(V0² + 2 * a * ΔS) \n";
		
		//Lançamento Obliquo
			//Tempo Total
			public static String tempoTotal = "t=(2*v*sen(θ))/g) \n";
			//Movimento Horizontal
			public static String movimentoHorizontal = "Mov.Horiz.=v*cos(θ)*t \n";
			//Movimento Vertical
			public static String movimentoVertical = "Mov.Vert.=(v*sen(θ)*t)-((g*t)/2) \n";
			//Alcance Horizontal
			public static String alcanceHorizontal = "Alc.T.Horiz.=(v^2*sen(2*θ))/g \n";
			//Altura Vertical
			public static String alturaVertical = "Alt.T.Vert.=(v*sen(θ))²/(2*g) \n";
		
}

