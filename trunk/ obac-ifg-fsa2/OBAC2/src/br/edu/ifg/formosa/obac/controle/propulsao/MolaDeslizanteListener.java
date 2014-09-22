package br.edu.ifg.formosa.obac.controle.propulsao;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import br.edu.ifg.formosa.obac.controle.obac.ControleOBAC;
import br.edu.ifg.formosa.obac.controle.objetoAmbienteSuperficie.ControleInicioSimulacoes;
import br.edu.ifg.formosa.obac.modelo.ModeloAmbiente;
import br.edu.ifg.formosa.obac.utilidades.UtilidadeConvercoesEscala;
import br.edu.ifg.formosa.obac.visao.VisaoPropulsao;

public class MolaDeslizanteListener implements ChangeListener, MouseListener{

	//Referencias
	private final VisaoPropulsao vP;
	private final ModeloAmbiente mA;
	private final ControleOBAC cOBAC;
	private final ControleInicioSimulacoes cIS;
	private ControleMolaSolturaDeslizante cMSD = null;
	
	//Variável de controle
	private boolean mousePressionando = true; 
	
	public MolaDeslizanteListener(VisaoPropulsao vP, ModeloAmbiente mA, ControleOBAC cOBAC, ControleInicioSimulacoes cIS) {
		this.vP = vP;
		this.mA = mA;
		this.cOBAC = cOBAC;
		this.cIS = cIS;
		
		this.vP.getDeslizanteMola().setValue(this.vP.getDeslizanteMola().getMaximum());
		this.vP.getDeslizanteMola().addChangeListener(this);
		this.vP.getDeslizanteMola().addMouseListener(this);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {this.mousePressionando=true; }
	@Override
	public void mouseReleased(MouseEvent e) {testeLogico();}
	@Override
	public void mouseExited(MouseEvent e) {testeLogico();}
	@Override
	public void stateChanged(ChangeEvent e) {comandos();}
	
	
	private void comandos(){
		if (mousePressionando==true) {
			
			//Atualiza a imagem da mola com o tamnho adequado
			vP.setImagemPropulsao(new ImageIcon(mA.getmP().getImagemPropulsao().getImage().getScaledInstance(this.vP.getDeslizanteMola().getValue(), 30, Image.SCALE_DEFAULT)));
			//Move o objeto para que ele acompanhe os novos tamanhos da mola
			mA.getmO().setPosicaoXPx(this.vP.getDeslizanteMola().getValue()+31);
			//Seta o tamnho atual em pixels da mola
			mA.getmP().getModeloMola().setTamanhoMolaAtualPix(this.vP.getDeslizanteMola().getValue());
			//Seta o tamnho atual em metros da mola
			mA.getmP().getModeloMola().setTamanhoMolaAtualM(
					(UtilidadeConvercoesEscala.convertePixelMetro(//COnversão de Pixel para Metros
							mA.getmP().getModeloMola().getTamanhoMolaTotalM(),//Tamanho total em M
							mA.getmP().getModeloMola().getTamanhoMolaAtualPix(),//Tamanho atual em PX
							mA.getmP().getModeloMola().getTamanhoMolaTotalPix())));//Tamanho Total Px

			//Label que exibe o tamnho atual da mola
			this.vP.getRotuloCompressao().setText(this.vP.getDeslizanteMola().getValue()+"%");
			
			this.vP.getDeslizanteMola().setBackground(Color.blue);
		}
		else{
			this.vP.getDeslizanteMola().setBackground(Color.red);
//			this.vP.getpCompressor().setVisible(false);
			cMSD = new ControleMolaSolturaDeslizante(vP, mA, cOBAC, cIS);
		}
		this.cOBAC.repinta();
		mousePressionando=true;
	}
	
	private void testeLogico(){
		if(this.vP.getDeslizanteMola().getValue()<this.vP.getDeslizanteMola().getMaximum()){
			this.mousePressionando=false;
			this.vP.getDeslizanteMola().setValue(this.vP.getDeslizanteMola().getMaximum());
			this.vP.getRotuloCompressao().setText("" +100);
		}
	}
	
//Não usados_________________________________________________________
	@Override
	public void mouseClicked(MouseEvent arg0) {}
	@Override
	public void mouseEntered(MouseEvent arg0) {}

}
