package br.edu.ifg.formosa.obac.modelo;

public class ModeloPainelFormulas {
	
	//Fórmulas em texto - se não for encontrado uso idica-se total remoção das linas 5-24
//		//Propulsões
//		public static String propMolaTextual = "Velocidade_Inicial = [(Constante_Elastica + Compresão_da_mola^2)/Massa]";//Mola
//		public static String propCanhaoTextual = "Velocidade_Inicial = (2 * energia * massa)";//Canhão
//		//Força Normal
//		public static String forcaNormalTextual = "Força_Normal = Massa * Gravidade";
//		//Atrito
//		public static String atritoTextual = "Atrito = Força_Normal * Coeficiente_de_Ficção";
//		//Acelerações
//		public static String aceleracaoPlanoTextual = "Aceleração = Atrito/Massa * -1";//No plano
//		public static String aceleracaoQuedaTextual = "Aceleração = Gravidade";//Queda Livre
//		public static String aceleracaoDescidaTextual = "Aceleração = [(Gravidade * Seno_do_Ângulo) + (Coeficiente_de_Ficção * Gravidade * Coseno_do_Ângulo)]";//Descida
//		public static String aceleracaoSubidaTextual = aceleracaoDescidaTextual + " * (-1)";//Subida
//		//Posição final
//		public static String posicaoFinalDescidaTextual = "Posição_Final = (Velocidade_Inicial^2 * -1)/(2 * Aceleração)";
//		public static String posicaoFinalPlanoTextual = posicaoFinalDescidaTextual + " * (-1)";
//		//Tempo
//		public static String tempoTextual = "Tempo = (Velocidade_Final - Velocidade_Inicial)/Aceleração \nTempo = Variação_Velocidade/Aceleração";
//		//Nova Posição
//		public static String novaPosicaoTextual = "Espaço_Atual = Espaço_Inicial + Velocidade_Inicial * Tempo + (Aceleração * Tempo^2)/2";
	
	//Fórmulas com variáveis
		//Propulsões
		public static String propMola = "V0 = √(K+x²/m) \n";//Mola
		public static String propCanhao = "V0 = (2 * e * m)";//Canhão
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
		public static String tempo = "t = (Vf - V0)/a \nt = ΔV/a";
		//Nova Posição
		public static String equaHorariaAbscissa = "s=s0+v0*t+(a*t²)/2 \n";
		
		//Colisão
			//Colisão
			public static String colisao ="Va'=((Va*(Ma-Mb*e))/(Ma-Mb))"; 
			//Velocidade pós colisão - Equação de Torricceli
			public static String equaTorricceli = "V² = V0² + 2 * a * ΔS \nV = √(V0² + 2 * a * ΔS)";
		
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
		
	//Propulção pela mola	
	public String propulsaoMola(double k, double x, double m){
		//V0= (K+x^2/Massa)
		String s = "V0 = (" +k +"+" +x+"²/" +m +")\n";
		s += "V0 = (" +k +"+" +Math.pow(x, 2) +"/" +m +")\n";
		s += "V0 = (" +(k+ Math.pow(x, 2)) +"/" +m +")\n";
		s += "V0 = (" +((k +Math.pow(x, 2) )/m) +")";
		return s;
	}

	//Propulsão pelo canhão
	public String propulsaoCanhao(double e, double m){
		//V0 = (2 * energia * massa)
		String s = "V0 = 2 * "+e+" * "+m +"\n";
		s += "V0 = 2 * "+(e*m) +"\n";
		s += "V0 = "+(2*e*m);
		return s;
	}

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
		s += "a = [(" +(g*Math.sin(angulo))+") + (" +coefAtr +" * " +(g*Math.cos(angulo))+")]\n";
		s += "a = [" +(g*Math.sin(angulo))+" + "+(coefAtr*g*Math.cos(angulo))+"]\n";
		s += "a = " +((g*Math.sin(angulo))+(coefAtr*g*Math.cos(angulo)));
		return s;
	}

	//Aceleração Subida
	public String aceleracaoSubida(double g, double angulo, double coefAtr){
		//a = [(g * Sen(?)) + (µ * g * Cos(?))] * (-1)
		String s = "a = [(" +g +" * Sen(" +angulo+")) + ("+coefAtr+" * "+g+" * Cos("+angulo+"))] * (-1)\n";
		s += "a = [(" +g +" * " +Math.sin(angulo)+") + ("+coefAtr+" * "+g+" * "+Math.cos(angulo)+")] * (-1)\n";
		s += "a = [(" +(g*Math.sin(angulo))+") + (" +coefAtr +" * " +(g*Math.cos(angulo))+")] * (-1)\n";
		s += "a = [" +(g*Math.sin(angulo))+" + "+(coefAtr*g*Math.cos(angulo))+"] * (-1)\n";
		s += "a = " +((g*Math.sin(angulo))+(coefAtr*g*Math.cos(angulo))) +"\n";
		s += "a = " +(((g*Math.sin(angulo))+(coefAtr*g*Math.cos(angulo)))*-1);
		return s;
	}

	//Posição final na descida
	public String posicaoFinalDescida(double v0, double a){
		//Sf = (V0^2 * -1)/(2 * a)
		String s = "Sf = ("+v0+"² * -1)/(2 * "+a+")\n";
		s += "Sf = ("+Math.pow(v0, 2) +"* -1)/"+(2*a) +"\n";
		s += "Sf = "+(Math.pow(v0,2) * -1)+"/"+(2*a) +"\n";
		s += "Sf = "+((Math.pow(v0,2) * -1)/(2*a));
		return s;
	}
	
	//Posição final no plano
	public String posicaoFinalPlano(double v0, double a){
		//Sf = (V0^2 * -1)/(2 * a) * (-1)
		String s = "Sf = ("+v0+"² * -1)/(2 * "+a+") * (-1)\n";
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
		String s = equaHorariaAbscissa +"\n"; 
		s += "s = "+s0+" + "+v0+" * "+t+" + ("+a+" * "+t+"²)/2 \n";
		s += "s = "+s0+" + "+(v0*t)+" + ("+a+" * "+Math.pow(t,2)+")/2 \n";
		s += "s = "+(s0+(v0*t))+" + ("+(a*Math.pow(t,2))+")/2 \n";
		s += "s = "+(s0+(v0*t))+" + "+((a*Math.pow(t,2))/2) +"\n";
		s += "s = "+((s0+(v0*t))+((a*Math.pow(t,2))/2));
		return s;
	}

	//Colisão
	public String colisao(double va, double ma, double mb, double e){
		//Va'=((Va*(Ma-Mb*e))/(Ma-Mb))
		String s = "Va'=((" +va +"*(" +ma +"-" +mb +"*" +e+"))/(" +ma +"-" +mb +"))\n";
		s += "Va'=((" +va +"*(" +ma +"-" +(mb*e) +"))/" +(ma-mb) +")\n";
		s += "Va'=((" +va +"*" +(ma-(mb*e) )+")/" +(ma-mb) +")\n";
		s += "Va'=(" +(va*(ma-(mb*e))) +"/" +(ma-mb) +")\n";
		s += "Va'=" +((va*(ma-(mb*e)))/(ma-mb));
		return s;
	}
	
	//Equação de Torricceli
	public String equTorricceli(double v0, double a, double deltaS){
		//V = √(V0^2 + 2 * a * ΔS)
		String s = "V = " +"(" +v0 +"² + 2 *" +a +" * Δ" +deltaS +")\n";
		s += "V = (" +Math.pow(v0, 2) +" + 2 *" +(a*deltaS) +"\n";
		s += "V = (" +Math.pow(v0, 2) +" + " +(2*(a*deltaS)) +"\n";
		s += "V = " +(Math.pow(v0, 2)+(2*(a*deltaS)));
		return s;
	}
	
	//Tempo Total Lançamento Oblíquo
	public String tempoTotal(double v, double angulo, double g){
		//t=(2*v*sen(θ))/g)
		String s = "t Total = ((2 * " +v +" * sen(" +angulo +"))/" +g+")\n";
		s += "t Total = ((2 * " +v +" * "+Math.sin(angulo) +")/" +g+")\n";
		s += "t Total = ((2 * " +(v*Math.sin(angulo)) +")/" +g+")\n";
		s += "t Total = (" +(2*(v*Math.sin(angulo))) +"/" +g+")\n";
		s += "t Total = "+((2*(v*Math.sin(angulo)))/g);
		return s;
	}
	
	
	public String movimentoHorizontal(double v, double angulo, double t){
		//Mov.Horiz.=v*cos(θ)*t
		String s = "Mov. Horiz. = " +v +" * cos(" +angulo +") * " +t +"\n";
		s += "Mov. Horiz. = " +v +" * " +Math.cos(angulo) +" * " +t +"\n";
		s += "Mov. Horiz. = " +v +" * " +(Math.cos(angulo)*t) +"\n";
		s += "Mov. Horiz. = " +(v*Math.cos(angulo)*t);
		return s;
	}

	public String movimentoVetical(double v, double angulo, double t, double g){
		//Mov.Vert.=(v*sen(θ)*t)-((g*t)/2)
		String s = "Mov.Vert. = ( " +v +" * sen(" +angulo +") * " +t +") - ((" +g +" * " +t +")/2) \n";
		s += "Mov.Vert. = ( " +v +" * " +Math.sin(angulo) +" * " +t +") - (" +(g*t) +")/2) \n";
		s += "Mov.Vert. = ( " +v +" * " +(Math.sin(angulo)*t) +") - " +((g*t)/2) +" \n";
		s += "Mov.Vert. = " +(v*Math.sin(angulo)*t) +" - " +((g*t)/2) +" \n";
		s += "Mov.Vert. = " +((v*Math.sin(angulo)*t)-((g*t)/2));
		return s;
	}

	public String alcanceTHorizontal(double v, double angulo, double g){
		//Alc.T.Horiz.=(v^2*sen(2*θ))/g
		String s = "Alc.T.Horiz. = ( " +v +"² * sen(2 * " +angulo +"))/" +g +"\n";
		s += "Alc.T.Horiz. = ( " +(v*v) +" * sen(" +(2*angulo) +"))/" +g +"\n";
		s += "Alc.T.Horiz. = ( " +(v*v) +" * " +(Math.sin(2*angulo)) +")/" +g +"\n";
		s += "Alc.T.Horiz. = " +((v*v)*Math.sin(2*angulo)) +"/" +g +"\n";
		s += "Alc.T.Horiz. = " +(((v*v)*Math.sin(2*angulo))/g);
		return s;
	}

	public String alturaTVertical(double v, double angulo, double g){
		//Alt.T.Vert.=(v*sen(θ))^2/(2*g)
		String s = "Alt.T.Vert. = (" +v +" * sen(" +angulo +"))² / (2 * " +g+")\n";
		s += "Alt.T.Vert. = (" +v +" * " +Math.sin(angulo) +")² / " +(2*g)+"\n";
		s += "Alt.T.Vert. = " +(v*Math.sin(angulo)) +"² / " +(2*g)+"\n";
		s += "Alt.T.Vert. = " +Math.pow((v*Math.sin(angulo)), 2) +" / " +(2*g)+"\n";
		s += "Alt.T.Vert. = " +(Math.pow((v*Math.sin(angulo)), 2)/+(2*g));
		return s;
	}
}

