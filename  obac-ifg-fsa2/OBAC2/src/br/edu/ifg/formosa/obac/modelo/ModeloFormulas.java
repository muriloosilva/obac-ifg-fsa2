package br.edu.ifg.formosa.obac.modelo;

public class ModeloFormulas {
	
	//Fórmulas em texto
		//Propulsões
		public static String propMolaTextual = "Velocidade_Inicial = [(Constante_Elastica + Compresão_da_mola^2)/Massa]";//Mola
		public static String propCanhaoTextual = "Velocidade_Inicial = ";//Canhão
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
		public static String propMola = "V0= (K+x^2/m) \n";//Mola
		public static String propCanhao = "V0 = m";//Canhão
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
		
	//Propulção pela mola	
	public String propulsaoMola(double k, double x, double m){
		//V0= (K+x^2/Massa)
		String s = "V0 = (" +k +"+" +x+"^2/" +m +")\n";
		s += "V0 = (" +k +"+" +Math.pow(x, 2) +"/" +m +")\n";
		s += "V0 = (" +(k+ Math.pow(x, 2)) +"/" +m +")\n";
		s += "V0 = (" +((k +Math.pow(x, 2) )/m) +")";
		return s;
	}

//	public String propulsaoCanhao(){}

	//Força normal
	public String forcaNormal(double m, double g){
		//N = m * g
		String s = "N = " +m +" * " +g +"\n";
		s += "N = " +(m*g);
		return s;
	}

	//Atrito
	public String atrito(double fNormal, double coefAtr){
		//Fat = N * µ
		String s = "Fat = " +fNormal +" * " +coefAtr +"\n";
		s += "Fat = " +(fNormal*coefAtr);
		return s;
	}

	//Aceleração no Plano
	public String aceleracaoPlano(double fAtr, double m){
		//a = Fat/m * (-1)
		String s = "a = " +fAtr +"/" +m +" * -1\n";
		s += "a = " +(fAtr/m) +" * -1\n";
		s += "a = " +(-(fAtr/m));
		return s;
	}

	//Aceleração na Queda
	public String aceleracaoQueda(double g){
		//a = g
		String s = "a = " +g;
		return s;
	}
	
	//Aceleração descida
	public String aceleracaoDescida(double g, double angulo, double coefAtr){
		//a = [(g * Sen(?)) + (µ * g * Cos(?))]
		String s = "a = [(" +g +" * Sen(" +angulo+")) + ("+coefAtr+" * "+g+" * Cos("+angulo+"))]\n";
		s += "a = [(" +g +" * " +Math.sin(angulo)+") + ("+coefAtr+" * "+g+" * "+Math.cos(angulo)+")]\n";
		s += "a = [" +(g*Math.sin(angulo))+") + ("+(coefAtr*g*Math.cos(angulo))+"]\n";
		s += "a = " +((g*Math.sin(angulo))+(coefAtr*g*Math.cos(angulo)));
		return s;
	}

	//Aceleração Subida
	public String aceleracaoSubida(double g, double angulo, double coefAtr){
		//a = [(g * Sen(?)) + (µ * g * Cos(?))] * (-1)
		String s = "a = [(" +g +" * Sen(" +angulo+")) + ("+coefAtr+" * "+g+" * Cos("+angulo+"))] * (-1)\n";
		s += "a = [(" +g +" * " +Math.sin(angulo)+") + ("+coefAtr+" * "+g+" * "+Math.cos(angulo)+")] * (-1)\n";
		s += "a = [" +(g*Math.sin(angulo))+") + ("+(coefAtr*g*Math.cos(angulo))+"] * (-1)\n";
		s += "a = " +((g*Math.sin(angulo))+(coefAtr*g*Math.cos(angulo))) +"\n";
		s += "a = " +(((g*Math.sin(angulo))+(coefAtr*g*Math.cos(angulo)))*-1);
		return s;
	}

	//Posição final na descida
	public String posicaoFinalDescida(double v0, double a){
		//Sf = (V0^2 * -1)/(2 * a)
		String s = "Sf = ("+v0+"^2 * -1)/(2 * "+a+")\n";
		s += "Sf = ("+Math.pow(v0, 2) +"* -1)/"+(2*a) +"\n";
		s += "Sf = "+(Math.pow(v0,2) * -1)+"/"+(2*a) +"\n";
		s += "Sf = "+((Math.pow(v0,2) * -1)/(2*a));
		return s;
	}
	
	//Posição final no plano
	public String posicaoFinalPlano(double v0, double a){
		//Sf = (V0^2 * -1)/(2 * a) * (-1)
		String s = "Sf = ("+v0+"^2 * -1)/(2 * "+a+") * (-1)\n";
		s += "Sf = ("+Math.pow(v0,2) +"* -1)/"+(2*a) +"* (-1)\n";
		s += "Sf = "+(Math.pow(v0,2) * -1)+"/"+(2*a) +" * (-1)\n";
		s += "Sf = "+((Math.pow(v0,2) * -1)/(2*a)) +"\n";
		s += "Sf = "+(((Math.pow(v0,2) * -1)/(2*a)) * -1);
		return s;
	}

	//Tempo
	public String tempo(double v0, double a){
		//t = (Vf - V0)/a
		String s = "t = (0 - " +v0+")/"+a+"\n";
		s += "t = " +(0-v0)+"/"+a+"\n";
		s += "t = " +((0-v0)/a);
		return s;
	}
	
	//Nova posição
	public String novaPosicao(double s0, double v0, double t, double a){
		//s=s0+v0*t+(a*t^2)/2
		String s = novaPosicao +"\n"; 
		s += "s = "+s0+" + "+v0+" * "+t+" + ("+a+" * "+t+"^2)/2 \n";
		s += "s = "+s0+" + "+(v0*t)+" + ("+a+" * "+Math.pow(t,2)+")/2 \n";
		s += "s = "+(s0+(v0*t))+" + ("+(a*Math.pow(t,2))+")/2 \n";
		s += "s = "+(s0+(v0*t))+" + "+((a*Math.pow(t,2))/2) +"\n";
		s += "s = "+((s0+(v0*t))+((a*Math.pow(t,2))/2));
		return s;
	}

//	public String colisao(){}
}
