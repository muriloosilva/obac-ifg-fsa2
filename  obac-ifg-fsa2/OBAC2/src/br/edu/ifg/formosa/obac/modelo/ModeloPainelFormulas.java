package br.edu.ifg.formosa.obac.modelo;

public class ModeloPainelFormulas {
	
	//Fórmulas com variáveis
		//Propulsões
		public static String propMola = "V0 = √(K*x²/m)";//Mola
		public static String propCanhao = "V0 = √((2 * energia) * massa)";//Canhão
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
		public static String posicaoFinalDescida = "Sf = (V0² * -1)/(2 * a)";
		public static String posicaoFinalPadrao = posicaoFinalDescida + " * (-1)";
		//Tempo
		public static String tempo = "t = (Vf - V0)/a";
		//Nova Posição
		public static String equaHorariaAbscissa = "s=s0+(v0*t)+((a*t²)/2)";
		
		
		//Queda Livre
			public static String velocidadeColisaoQL = "V0=V*e";
		
		//Colisão
			//Colisão c/ Muro
			public static String colisao ="Va'=((Va*(Ma-Mb*e))/(Ma-Mb))";
			//Colisão QL
			public static String colisaoQL ="V'=V*e";
			//Velocidade pós colisão - Equação de Torricceli
			public static String equaTorricceli = "V²=V0²+2*a*ΔS\nV=√(V0²+2*a*ΔS)";
		
		//Lançamento Obliquo
			//Tempo Total
			public static String tempoTotal = "t=(2*v*sen(θ))/g)";
			//Movimento Horizontal
			public static String movimentoHorizontal = "Mov.Horiz.=v*cos(θ)*t";
			//Movimento Vertical
			public static String movimentoVertical = "Mov.Vert.=(v*sen(θ)*t)-((g*t)/2)";
			//Alcance Horizontal
			public static String alcanceHorizontal = "Alc.T.Horiz.=(v^2*sen(2*θ))/g";
			//Altura Vertical
			public static String alturaVertical = "Alt.T.Vert.=(v*sen(θ))²/(2*g)";
		
}

