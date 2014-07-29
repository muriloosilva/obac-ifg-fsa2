package br.edu.ifg.formosa.obac.visao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;

import br.edu.ifg.formosa.obac.modelo.ModeloPainelFormulas;
import br.edu.ifg.formosa.obac.utilidades.UtilidadeCores;

public class VisaoPainelFormulas extends JScrollPane{
	
	//Serial
	private static final long serialVersionUID = 1L;
	
	//Paineis interno
		//Simulações normais - Sem colisão
		private JPanel pFundo = null;
		private JPanel pVInicial = null;
		private JPanel pFNormal = null;
		private JPanel pAtrito = null;
		private JPanel pAceleracao = null;
		private JPanel pPosFinal = null;
		private JPanel pTempo = null;
		private JPanel pNovaPos = null;
		//Simulações normais - Com a colisão
		private JPanel pColisao = null;
		private JPanel pVelocidadePosColisao = null;
		private JPanel pNovaPosColisao = null;
		//Específicas dos lançamento obliquo
		private JPanel pMovimentoHorizontal = null;
		private JPanel pMovimentoVertical = null;
		private JPanel pAlcanceTotalHorizontal = null;
		private JPanel pAlcanceTotalVertical = null;
	
	//Rótulos
		//Simulações normais - Sem colisão
		private JLabel rVInicial = null;
		private JLabel rFNormal = null;
		private JLabel rAtrito = null;
		private JLabel rAceleracao = null;
		private JLabel rPosFinal = null;
		private JLabel rTempo = null;
		private JLabel rNovaPos = null;
		//Simulações normais - Com a colisão
		private JLabel rColisao = null;
		private JLabel rVelocidadePosColisao = null;
		private JLabel rNovaPosColisao = null;
		//Específicas dos lançamento obliquo
		private JLabel rMovimentoHorizontal = null;
		private JLabel rMovimentoVertical = null;
		private JLabel rAlcanceTotalHorizontal = null;
		private JLabel rAlcanceTotalVertical = null;
	
	//Paineis de rolagem
		//Simulações normais - Sem colisão
		private JScrollPane prVInicial = null;
		private JScrollPane prFNormal = null;
		private JScrollPane prAtrito = null;
		private JScrollPane prAceleracao = null;
		private JScrollPane prPosFinal = null;
		private JScrollPane prTempo = null;
		private JScrollPane prNovaPos = null;
		//Simulações normais - Com a colisão
		private JScrollPane prColisao = null;
		private JScrollPane prVelocidadePosColisao = null;
		private JScrollPane prNovaPosColisao = null;
		//Específicas dos lançamento obliquo
		private JScrollPane prMovimentoHorizontal = null;
		private JScrollPane prMovimentoVertical = null;
		private JScrollPane prAlcanceTotalHorizontal = null;
		private JScrollPane prAlcanceTotalVertical = null;
		
	//Áreas de Texto
		//Simulações normais - Sem colisão
		private JTextArea atVInicial = null;
		private JTextArea atFNormal = null;
		private JTextArea atAtrito = null;
		private JTextArea atAceleracao = null;
		private JTextArea atPosFinal = null;
		private JTextArea atTempo = null;
		private JTextArea atNovaPos = null;
		//Simulações normais - Com a colisão
		private JTextArea atColisao = null;
		private JTextArea atVelocidadePosColisao = null;
		private JTextArea atNovaPosColisao = null;
		//Específicas dos lançamento obliquo
		private JTextArea atMovimentoHorizontal = null;
		private JTextArea atMovimentoVertical = null;
		private JTextArea atAlcanceTotalHorizontal = null;
		private JTextArea atAlcanceTotalVertical = null;
	
	
	//Fontes
	private Font fonteTitulos  = null;
	private Font fonteFormulas = null;
	
	//Layout
	private BoxLayout layout = null;
	
	public VisaoPainelFormulas() {
		this.setSize(250, 800);
		
		//Painel
		pFundo = new JPanel();
		this.setViewportView(pFundo);
		
		//Layout do painel de Fundo
		layout = new BoxLayout(pFundo, BoxLayout.Y_AXIS);
		pFundo.setLayout(layout);
		
		//Fontes
		fonteTitulos = new Font("Arial", Font.BOLD, 15);
		fonteFormulas = new Font("Arial", Font.BOLD, 13);
		
		//Velocidade Inicial
		rVInicial = new JLabel("Velocidade Inicial");//Rótulo
		atVInicial = new JTextArea(ModeloPainelFormulas.propCanhao);//Área de Texto
		addComponentes(pVInicial, rVInicial, prVInicial, atVInicial, UtilidadeCores.azulNaval, UtilidadeCores.amareloClaro, 5, true);
		
		//Força Normal
		rFNormal = new JLabel("Força Normal");
		atFNormal = new JTextArea(ModeloPainelFormulas.forcaNormal);
		addComponentes(pFNormal, rFNormal, prFNormal, atFNormal, UtilidadeCores.azulIndigo, UtilidadeCores.amareloKhaki, 3, true);
		
		//Atrito
		rAtrito = new JLabel("Atrito");
		atAtrito = new JTextArea(ModeloPainelFormulas.atrito);
		addComponentes(pAtrito, rAtrito, prAtrito, atAtrito, UtilidadeCores.azulEscuro, UtilidadeCores.amareloLimao, 3, true);
		
		//Aceleração
		rAceleracao = new JLabel("Aceleração");
		atAceleracao = new JTextArea(ModeloPainelFormulas.aceleracaoDescida);
		addComponentes(pAceleracao, rAceleracao, prAceleracao, atAceleracao, UtilidadeCores.azul, UtilidadeCores.amarelo, 7, true);
		
		//Posição final
		rPosFinal = new JLabel("Posição Final");
		atPosFinal = new JTextArea(ModeloPainelFormulas.posicaoFinalPadrao);
		addComponentes(pPosFinal, rPosFinal, prPosFinal, atPosFinal, UtilidadeCores.azulCobalto, UtilidadeCores.amareloAcafrao, 6, true);
		
		//Tempo
		rTempo = new JLabel("Tempo");
		atTempo = new JTextArea(ModeloPainelFormulas.tempo +"\n" +ModeloPainelFormulas.tempoTotal);
		addComponentes(pTempo, rTempo, prTempo, atTempo, UtilidadeCores.azulMetalico, UtilidadeCores.amareloOuro, 6, true);
		
		//Nova Posição
		rNovaPos = new JLabel("Nova Posição");
		rNovaPos.setToolTipText("Equação horária das abscissas");
		atNovaPos = new JTextArea(ModeloPainelFormulas.equaHorariaAbscissa);
		addComponentes(pNovaPos, rNovaPos, prNovaPos, atNovaPos, UtilidadeCores.azulMedio, UtilidadeCores.amareloQueimado, 6, true);
		
		//Colisão
			//Colisão
			rColisao = new JLabel("Colisão");
			atColisao = new JTextArea(ModeloPainelFormulas.colisao);
			addComponentes(pColisao, rColisao, prColisao, atColisao, UtilidadeCores.azulNeon, UtilidadeCores.laranja, 6, false);
			
			//Velocidade pós Colosão - Criar os componentes e refazer o esquema de cores
			rVelocidadePosColisao = new JLabel("Velocidade Após Colisão");
			rVelocidadePosColisao.setToolTipText("Equação de Torricceli");
			atVelocidadePosColisao = new JTextArea(ModeloPainelFormulas.equaTorricceli);
			addComponentes(pVelocidadePosColisao, rVelocidadePosColisao, prVelocidadePosColisao, atVelocidadePosColisao, UtilidadeCores.azulCeu, UtilidadeCores.laranjaAvermelhado, 6, false);
			
			//Nova Posição Após Colisão
			rNovaPosColisao = new JLabel("Nova Posição Após Colisão");
			rNovaPosColisao.setToolTipText("Equação horária das abscissas");
			atNovaPosColisao = new JTextArea(ModeloPainelFormulas.equaHorariaAbscissa);
			addComponentes(pNovaPosColisao, rNovaPosColisao, prNovaPosColisao, atNovaPosColisao, UtilidadeCores.azulClaro, UtilidadeCores.vermelho, 6, false);
		
		
		//Lançamento Oblíquo
			//Movimento Horizontal
			rMovimentoHorizontal = new JLabel("Movimento Horizontal");
			atMovimentoHorizontal = new JTextArea(ModeloPainelFormulas.movimentoHorizontal);
			addComponentes(pMovimentoHorizontal, rMovimentoHorizontal, prMovimentoHorizontal, atMovimentoHorizontal, UtilidadeCores.azulEscuro, UtilidadeCores.amarelo, 5, false);
			
			//Movimento Vertical
			rMovimentoVertical = new JLabel("Movimento Vertical");
			atMovimentoVertical = new JTextArea(ModeloPainelFormulas.movimentoVertical);
			addComponentes(pMovimentoVertical, rMovimentoVertical, prMovimentoVertical, atMovimentoVertical, UtilidadeCores.azul, UtilidadeCores.amareloAcafrao, 5, false);
			
			//Alcance Total Horizontal
			rAlcanceTotalHorizontal = new JLabel("Alcance Total Horizontal");
			atAlcanceTotalHorizontal = new JTextArea(ModeloPainelFormulas.alcanceHorizontal);
			addComponentes(pAlcanceTotalHorizontal, rAlcanceTotalHorizontal, prAlcanceTotalHorizontal, atAlcanceTotalHorizontal, UtilidadeCores.azulCobalto, UtilidadeCores.amareloQueimado, 5, false);
			
			//Altura Total Vertical
			rAlcanceTotalVertical = new JLabel("Altura Total Vertical");
			atAlcanceTotalVertical = new JTextArea(ModeloPainelFormulas.alturaVertical);
			addComponentes(pAlcanceTotalVertical, rAlcanceTotalVertical, prAlcanceTotalVertical, atAlcanceTotalVertical, UtilidadeCores.azulMetalico, UtilidadeCores.amareloOuro, 5, false);
		
	}
	
	//Este método Recebe os três componentes que se referem a uma fórmula
	//Passa suas posições, tamanhos e outras configurações
	private void addComponentes(JPanel p, JLabel r, JScrollPane pr, JTextArea at, Color corFundo, Color corFonte, int numLinhasAT, boolean painelVisivel){
		//Painel - Contém todos os componentes a seguir e é adicionado no painel de fundo
		p = new JPanel(new BorderLayout());
			p.setBackground(corFundo);//Muda a cor de fundo
			p.setBorder(new LineBorder(Color.BLACK, 1));//Define a borda dos paineis para que seja vista a delimitação que existe entre cada painel
			p.setVisible(painelVisivel);//Utilizado para que os paineis que não pertencem a imulação principal não apareçam, caso eles sejeam nexesário fica a cargo do controle decidir quais seram vistao. Isso é feito assim que a simulação é iniciada. 
		pFundo.add(p);
		
		//Rótulo - Indica a fórmula pressa, é adicionado no painel de sua fórmula
		r.setFont(fonteTitulos);//Define a fonte utilizada nos nomes das fórmulas
		r.setForeground(corFonte);//Muda a cor da fonte
		p.add(r, BorderLayout.NORTH);
		
		//Área de Texto - Área onde as fórmulas são exibidas, é adicionado no painel de rolagen da sua fórmula
		at.setFont(fonteFormulas);
			at.setBackground(corFundo);//Muda a cor de fundo
			at.setDisabledTextColor(corFonte);//Muda a cor da fonte
			at.setEnabled(false);//Impossibilita a edição do texto pelo usuário
		
		//Painel de Rolagem - Recebe a área de texto e eé adicionado no painel da fórmula
		pr = new JScrollPane(at);
			pr.setBorder(null);//Retira a borda do painel de rolagem da fórmula 
			pr.setPreferredSize(new Dimension(220, (numLinhasAT*15)));//Define as proporções máximas do Painel de Rolagem considerando o número de linhas nescessárias para ele (15 pix por linha)
			pr.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);//Retira a rolagem vertical do painel
		p.add(pr, BorderLayout.CENTER);
	}
	
//Getters das Areas de Texto___________________________________________________
	//Estas tem o texto modificado durante a execução
	public JTextArea getAtVInicial() {return atVInicial;}
	public JTextArea getAtFNormal() {return atFNormal;}
	public JTextArea getAtAtrito() {return atAtrito;}
	public JTextArea getAtAceleracao() {return atAceleracao;}
	public JTextArea getAtPosFinal() {return atPosFinal;}
	public JTextArea getAtTempo() {return atTempo;}
	public JTextArea getAtNovaPos() {return atNovaPos;}
	public JTextArea getAtColisao() {return atColisao;}
	public JTextArea getAtNovaPosColisao() {return atNovaPosColisao;}
	public JTextArea getAtMovimentoHorizontal() {return atMovimentoHorizontal;}
	public JTextArea getAtMovimentoVertical() {return atMovimentoVertical;}
	public JTextArea getAtAlcanceTotalHorizontal() {return atAlcanceTotalHorizontal;}
	public JTextArea getAtAlcanceTotalVertical() {return atAlcanceTotalVertical;}

//Setter dos Paineis de Rolagem_______________________________________________
	//dependendo da simulação estes paineis podem ou não aparecer
	public void setPVInicial(boolean visivel) {pVInicial.setVisible(visivel);}
	public void setPFNormal(boolean visivel) {pFNormal.setVisible(visivel);}
	public void setPAtrito(boolean visivel) {pAtrito.setVisible(visivel);}
	public void setPAceleracao(boolean visivel) {pAceleracao.setVisible(visivel);}
	public void setPPosFinal(boolean visivel) {pPosFinal.setVisible(visivel);}
	public void setPTempo(boolean visivel) {pTempo.setVisible(visivel);}
	public void setPNovaPos(boolean visivel) {pNovaPos.setVisible(visivel);}
	public void setPColisao(boolean visivel) {pColisao.setVisible(visivel);}
	public void setPNovaPosColisao(boolean visivel) {pNovaPosColisao.setVisible(visivel);}
	public void setpMovimentoHorizontal(boolean visivel) {pMovimentoHorizontal.setVisible(visivel);}
	public void setpMovimentoVertical(boolean visivel) {pMovimentoVertical.setVisible(visivel);}
	public void setpAlcanceTotalHorizontal(boolean visivel) {pAlcanceTotalHorizontal.setVisible(visivel);}
	public void setpAlcanceTotalVertical(boolean visivel) {pAlcanceTotalVertical.setVisible(visivel);}
	
//Modificador do tempo para as simulções
	public void modificaPTempo(boolean lancamentoObliq){
		if(lancamentoObliq){
			atTempo.setBackground(UtilidadeCores.azulIndigo);//área de texto
			atTempo.setForeground(UtilidadeCores.amareloKhaki);
			rTempo.setBackground(UtilidadeCores.azulIndigo);//rótulo
			rTempo.setForeground(UtilidadeCores.amareloKhaki);
			pTempo.setBackground(UtilidadeCores.azulIndigo);//painel
		}
		else{
			atTempo.setBackground(UtilidadeCores.azulMetalico);//área de texto
			atTempo.setForeground(UtilidadeCores.amareloOuro);
			rTempo.setBackground(UtilidadeCores.azulMetalico);//rótulo
			rTempo.setForeground(UtilidadeCores.amareloOuro);
			pTempo.setBackground(UtilidadeCores.azulMetalico);//painel}
		}
	}
	
}