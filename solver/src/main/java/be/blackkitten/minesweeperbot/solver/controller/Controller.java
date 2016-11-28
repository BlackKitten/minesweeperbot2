package be.blackkitten.minesweeperbot.solver.controller;

import be.blackkitten.minesweeperbot.solver.controller.view.NNviewer;
import org.neuroph.core.data.DataSet;

public class Controller {

	protected NNHandler_MineSolverV2 nnhandler;
	protected NNviewer view;
	public Controller(DataSet d){
		nnhandler=new NNHandler_MineSolverV3();
		nnhandler.loadDataSet(d);
		view=new NNviewer(this);
	}
	public void startView(){
		view.start();
	}
	public void start() {
		nnhandler.learn();
		
	}
	public void stop() {
		nnhandler.stop();
		
	}
	public void pause() {
		//TODO
		
	}
	public double getError() {
		return nnhandler.getError();
	}
	
	public void toFile(String filename) {
		nnhandler.toFile(filename);
		
	}
	public double getLearningRate() {
		return nnhandler.getLearningRate();
	}
	public double getErrorChange() {
		return nnhandler.getErrorChange();
	}
	public double getItteration() {
		return nnhandler.getItteration();
	}
}
