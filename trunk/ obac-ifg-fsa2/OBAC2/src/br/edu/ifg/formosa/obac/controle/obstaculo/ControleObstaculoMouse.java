package br.edu.ifg.formosa.obac.controle.obstaculo;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;

import br.edu.ifg.formosa.obac.controle.obac.ControleOBAC;
import br.edu.ifg.formosa.obac.modelo.ModeloObstaculo;
import br.edu.ifg.formosa.obac.visao.VisaoObstaculo;

public class ControleObstaculoMouse {

	private boolean objetoPressionado = false;
	private final VisaoObstaculo vObs;
	private final ModeloObstaculo modeloObstaculo;
	private final ControleOBAC cOBAC;
	
	private MouseListener listener = new MouseAdapter() {
		@Override
		public void mousePressed(MouseEvent e) {
			//PLANA
				//if(configView.getPlane().isSelected()){
				if((e.getX() >= modeloObstaculo.getPosicaoXPx()) &&
						(e.getX() <= modeloObstaculo.getPosicaoXPx() + 50)){ //CONFIGURA X

					objetoPressionado = true;
				}
				//}	
				//SUBIDA
				//else if(configView.getPlaneClimb().isSelected()){

				/*if((e.getX() >= xOculto) &&
							(e.getX() <= xOculto + 90)){ //CONFIGURA X

						objetoPressionado = true;
					}
					//}
					//DESCIDA
					//else if(configView.getPlaneDescent().isSelected()){

					/*if((e.getX() >= objeto.getPosicaoXPx() + 50) &&
							(e.getX() <= objeto.getPosicaoXPx() + 100)){ //CONFIGURA X

						objetoPressionado = true;
					}*/
				//}
		}

		@Override
		public void mouseReleased(MouseEvent e) {

			objetoPressionado = false;
		}
	};
	
	private MouseMotionListener mListener = new MouseMotionAdapter() {

		@Override
		public void mouseDragged(MouseEvent e) {

			if(objetoPressionado){

				modeloObstaculo.setPosicaoXPx(e.getX() - 15); //O MOUSE FICA CENTRALIZADO NO OBJETO

				//AREA LIMITADA
				if(modeloObstaculo.getPosicaoXPx() < 175) //POSICAO MÍNIMA DO OBJETO
					modeloObstaculo.setPosicaoXPx(175);
				else if((modeloObstaculo.getPosicaoXPx() + 50) > 720)//POSICAO MÁXIMA DO OBJETO
					modeloObstaculo.setPosicaoXPx(720-50);

				cOBAC.repinta();		
			}
		}
	};

	public ControleObstaculoMouse(VisaoObstaculo vObs, ModeloObstaculo modeloObstaculo,
			ControleOBAC cObac){
		
		this.vObs = vObs;
		this.modeloObstaculo = modeloObstaculo;
		this.cOBAC = cObac;
	}
	
	public void setListener(boolean listener){
		if (listener) {
			vObs.addMouseListener(this.listener);
			vObs.addMouseMotionListener(mListener);
		}
		else {
			vObs.removeMouseListener(this.listener);
			vObs.removeMouseMotionListener(mListener);
		}
	}
}
