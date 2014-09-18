package br.edu.ifg.formosa.obac.controle.propulsao;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import br.edu.ifg.formosa.obac.controle.obac.ControleOBAC;
import br.edu.ifg.formosa.obac.controle.objetoAmbienteSuperficie.ControleInicioSimulacoes;
import br.edu.ifg.formosa.obac.modelo.ModeloAmbiente;
import br.edu.ifg.formosa.obac.visao.VisaoPropulsao;

public class MolaDeslisanteLitener implements ChangeListener, MouseListener{

	//Referencias
	private final VisaoPropulsao vP;
	private final ModeloAmbiente mA;
	private final ControleOBAC cOBAC;
	private final ControleInicioSimulacoes cIS;
	private ControleMolaSoltura cMS = null;
	
	//Variável de controle
	private boolean mousePressionando = true; 
	
	public MolaDeslisanteLitener(VisaoPropulsao vP, ModeloAmbiente mA, ControleOBAC cOBAC, ControleInicioSimulacoes cIS) {
		this.vP = vP;
		this.mA = mA;
		this.cOBAC = cOBAC;
		this.cIS = cIS;
		
		this.vP.getDeslizanteMola().setValue(100);
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
			this.vP.getRotuloCompressao().setText("" +this.vP.getDeslizanteMola().getValue());
			vP.setImagemPropulsao(
					new ImageIcon(
							mA.getmP().getImagemPropulsao().getImage().getScaledInstance(
									this.vP.getDeslizanteMola().getValue(), 30, Image.SCALE_DEFAULT)));
			mA.getmO().setPosicaoXPx(this.vP.getDeslizanteMola().getValue()+31);
			mA.getmP().getModeloMola().setTamanhoMolaAtualPix(this.vP.getDeslizanteMola().getValue());
		}
		else{
//			this.vP.getpCompressor().setVisible(false);
//			cMS = new ControleMolaSoltura(vP, mA, cOBAC, cIS);
		}
		this.cOBAC.repinta();
		mousePressionando=true;
	}
	
	private void testeLogico(){
		if(this.vP.getDeslizanteMola().getValue()<100){
			this.mousePressionando=false;
			this.vP.getDeslizanteMola().setValue(100);
			this.vP.getRotuloCompressao().setText("" +100);
		}
	}
	
//Não usados_________________________________________________________
	@Override
	public void mouseClicked(MouseEvent arg0) {}
	@Override
	public void mouseEntered(MouseEvent arg0) {}

}
