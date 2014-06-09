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

import br.edu.ifg.formosa.obac.modelo.ModeloFormulas;
import br.edu.ifg.formosa.obac.utilidades.UtilidadeCores;

public class VisaoPainelFormulas extends JScrollPane{
	
	//Serial
	private static final long serialVersionUID = 1L;
	
	//Paineis interno
	private JPanel pFundo = null;
	private JPanel pVInicial = null;
	private JPanel pFNormal = null;
	private JPanel pAtrito = null;
	private JPanel pAceleracao = null;
	private JPanel pPosFinal = null;
	private JPanel pTempo = null;
	private JPanel pNovaPos = null;
	private JPanel pColisao = null;
	private JPanel pNovaPosColisao = null;
	
	//Rótulos
	private JLabel rVInicial = null;
	private JLabel rFNormal = null;
	private JLabel rAtrito = null;
	private JLabel rAceleracao = null;
	private JLabel rPosFinal = null;
	private JLabel rTempo = null;
	private JLabel rNovaPos = null;
	private JLabel rColisao = null;
	private JLabel rNovaPosColisao = null;
	
	//Paineis de rolagem
	private JScrollPane prVInicial = null;
	private JScrollPane prFNormal = null;
	private JScrollPane prAtrito = null;
	private JScrollPane prAceleracao = null;
	private JScrollPane prPosFinal = null;
	private JScrollPane prTempo = null;
	private JScrollPane prNovaPos = null;
	private JScrollPane prColisao = null;
	private JScrollPane prNovaPosColisao = null;
		
	//Áreas de Texto
	private JTextArea atVInicial = null;
	private JTextArea atFNormal = null;
	private JTextArea atAtrito = null;
	private JTextArea atAceleracao = null;
	private JTextArea atPosFinal = null;
	private JTextArea atTempo = null;
	private JTextArea atNovaPos = null;
	private JTextArea atColisao = null;
	private JTextArea atNovaPosColisao = null;
	
	
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
		fonteTitulos = new Font("Arial", Font.BOLD, 14);
		fonteFormulas = new Font("Arial", Font.BOLD, 12);
		
		//Velocidade Inicial
		rVInicial = new JLabel("Velocidade Inicial");//Rótulo
		atVInicial = new JTextArea(ModeloFormulas.propCanhao);//Área de Texto
		addComponentes(pVInicial, rVInicial, prVInicial, atVInicial, UtilidadeCores.azulNaval, UtilidadeCores.amareloClaro);
		
		
		//Força Normal
		rFNormal = new JLabel("Força Normal");
		atFNormal = new JTextArea(ModeloFormulas.forcaNormal);
		addComponentes(pFNormal, rFNormal, prFNormal, atFNormal, UtilidadeCores.azulIndigo, UtilidadeCores.amareloKhaki);
		
		//Atrito
		rAtrito = new JLabel("Atrito");
		atAtrito = new JTextArea(ModeloFormulas.atrito);
		addComponentes(pAtrito, rAtrito, prAtrito, atAtrito, UtilidadeCores.azulEscuro, UtilidadeCores.amarelo);
		
		//Aceleração
		rAceleracao = new JLabel("Aceleração");
		atAceleracao = new JTextArea(ModeloFormulas.aceleracaoDescida);
		addComponentes(pAceleracao, rAceleracao, prAceleracao, atAceleracao, UtilidadeCores.azul, UtilidadeCores.amareloAcafrao);
		
		//Posição final
		rPosFinal = new JLabel("Posição Final");
		atPosFinal = new JTextArea(ModeloFormulas.posicaoFinalDescida);
		addComponentes(pPosFinal, rPosFinal, prPosFinal, atPosFinal, UtilidadeCores.azulCobalto, UtilidadeCores.amareloQueimado);
		
		//Tempo
		rTempo = new JLabel("Tempo");
		atTempo = new JTextArea(ModeloFormulas.tempo);
		addComponentes(pTempo, rTempo, prTempo, atTempo, UtilidadeCores.azulMetalico, UtilidadeCores.amareloOuro);
		
		//Nova Posição
		rNovaPos = new JLabel("Nova Posição");
		atNovaPos = new JTextArea(ModeloFormulas.novaPosicao);
		addComponentes(pNovaPos, rNovaPos, prNovaPos, atNovaPos, UtilidadeCores.azulRoyal, UtilidadeCores.laranja);
		
		//Colisão
		rColisao = new JLabel("Colisão");
		atColisao = new JTextArea();
		addComponentes(pColisao, rColisao, prColisao, atColisao, UtilidadeCores.azulCeu, UtilidadeCores.laranjaAvermelhado);
		
		//Nova Posição Após Colisão
		rNovaPosColisao = new JLabel("Nova Posição Após Colisão");
		atNovaPosColisao = new JTextArea(ModeloFormulas.novaPosicao);
		addComponentes(pNovaPosColisao, rNovaPosColisao, prNovaPosColisao, atNovaPosColisao, UtilidadeCores.azulClaro, UtilidadeCores.vermelho);
	}
	
	//Este método Recebe os três componentes que se referem a uma fórmula
	//Passa suas posições, tamanhos e outras configurações
	private void addComponentes(JPanel p, JLabel r, JScrollPane pr, JTextArea at, Color corFundo, Color corFonte){
		//Painel - Contém todos os componentes a seguir e é adicionado no painel de fundo
		p = new JPanel(new BorderLayout());
			p.setMaximumSize(new Dimension(230, 100));//Define as proporções máximas do Painel
			p.setBackground(corFundo);//Muda a cor de fundo
			p.setBorder(new LineBorder(Color.BLACK, 1));//Define a borda dos paineis para que seja vista a delimitação que existe entre cada painel
		pFundo.add(p);
		
		//Rótulo - Indica a fórmula pressa, é adicionado no painel de sua fórmula
		r.setFont(fonteTitulos);//Define a fonte utilizada nos nomes das fórmulas
		r.setForeground(corFonte);//Muda a cor da fonte
		r.setMaximumSize(new Dimension(230, 20));//Define as proporções máximas do Rótulo
		p.add(r, BorderLayout.NORTH);
		
		//Área de Texto - Área onde as fórmulas são exibidas, é adicionado no painel de rolagen da sua fórmula
		at.setFont(fonteFormulas);
			at.setBackground(corFundo);//Muda a cor de fundo
			at.setDisabledTextColor(corFonte);//Muda a cor da fonte
			at.setEnabled(false);//Impossibilita a edição do texto pelo usuário
//		at.setText(" Jerônimo,"+ "\n Matheus e"+ "\n Murilo"+ "\n part. Jefferson"+ "\n Em:"+ "\n OBAC 2.0"	+ "\n Patrocionado por: CNPQ"+ "\n e JAVA");
		
		//Painel de Rolagem - Recebe a área de texto e eé adicionado no painel da fórmula
		pr = new JScrollPane(at);
			pr.setBorder(null);//Retira a borda do painel de rolagem da fórmula 
			pr.setPreferredSize(new Dimension(220, 80));//Define as proporções máximas do Painel de Rolagem
		p.add(pr, BorderLayout.CENTER);
	}
	
//Getters____________________________________________________________
	public JTextArea getAtVInicial() {
		return atVInicial;
	}

	public JTextArea getAtFNormal() {
		return atFNormal;
	}

	public JTextArea getAtAtrito() {
		return atAtrito;
	}

	public JTextArea getAtAceleracao() {
		return atAceleracao;
	}

	public JTextArea getAtPosFinal() {
		return atPosFinal;
	}

	public JTextArea getAtTempo() {
		return atTempo;
	}

	public JTextArea getAtNovaPos() {
		return atNovaPos;
	}

	public JTextArea getAtColisao() {
		return atColisao;
	}

	public JTextArea getAtNovaPosColisao() {
		return atNovaPosColisao;
	}
	
}
