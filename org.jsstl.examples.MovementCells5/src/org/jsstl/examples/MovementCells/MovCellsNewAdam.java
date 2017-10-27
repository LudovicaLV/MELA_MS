package org.jsstl.examples.MovementCells;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;

import org.jsstl.core.formula.Formula;
import org.jsstl.core.formula.Signal;
import org.jsstl.core.formula.SignalStatistics2;
import org.jsstl.core.formula.jSSTLScript;
import org.jsstl.core.monitor.SpatialQuantitativeSignal;
import org.jsstl.core.space.GraphModel;
import org.jsstl.core.space.Location;
import org.jsstl.io.FolderSignalReader;
import org.jsstl.io.TxtSpatialQuantSat;
import org.jsstl.io.TxtSpatialQuantSignal;
import org.jsstl.core.*;
//import org.jsstl.monitor.spatial.ThreeValues;
//import org.jsstl.monitor.spatial.SpatialThreeValues;
//import org.jsstl.monitor.spatial.SpatialThreeValuesTransducer;
//import org.jsstl.monitor.threevalues.ThreeValuesAtomic;
import org.jsstl.xtext.formulas.ScriptLoader;
import org.jsstl.xtext.formulas.sSTLSpecification.Model;

import Model.GlobalManager;
import ParserProg5Cells.ModelCells;

public class MovCellsNewAdam {

	public static void main(String[] args) throws Exception {
		
		int runs = 10;
		
		String propertyName = "cellL";
		
	    //Run simulation (to get the spatial structure)
		TotalCells.TotalCells.main(null);
					
		// %%%%%%%%%%  GRAPH  %%%%%%%%% //		
		// Designing the grid

		int valueX = GlobalManager.getLocationManager().TwoDx;
		int valueY = GlobalManager.getLocationManager().TwoDy;
		
		GraphModel graph = GraphModel.createGrid(valueX, valueY, 1.0);
		// Computing of the distance matrix
		graph.dMcomputation();

	// %%%%%%%%% PROPERTY %%%%%%% //		
	// loading the formulas files
	ScriptLoader loader  = new ScriptLoader();
	jSSTLScript script = loader.load("/afs/inf.ed.ac.uk/user/s13/s1372511/workspaceHogweed/org.jsstl.examples.MovementCells5/data/MovCellsNew3Sema.sstl");
	// Loading the variables. That we have defined in the formulas files.
	
//	/// %%%%%%%  DATA import %%%%%%%%%%%%/////////
	//String [] var = script.getVariables();
	
/////////////  many RUNS  //////////

	double endT = TotalCells.TotalCells.simulationTime;	
	double deltat = 0.1;
	//int steps = (int) (endT/deltat)+1;

	        TotalCells.TotalCells.main(null);
			double [][][] trajInit = ModelCellsSim.SimulatorCellsNewForAnalyser.data;
			double [] timeToInsertInit = ModelCellsSim.SimulatorCellsNewForAnalyser.timeArray;	
			
			Signal signalInit = new Signal(graph, timeToInsertInit, trajInit);
			String[] varInit = {"P", "D", "C", "M", "S", "A", "R", "L", "LN"};
			signalInit.setVariables(varInit);
			signalInit.transfomTimeStep(endT,deltat);
			
		    SpatialQuantitativeSignal qSignalInit = script.quantitativeCheck(new HashMap<>(), propertyName, graph, signalInit);
		    int steps = qSignalInit.getSteps();
			SignalStatistics2 statistic = new SignalStatistics2(graph.getNumberOfLocations(),steps);	
		    statistic.add(qSignalInit.quantTraj());
		    
	for ( int j=1 ; j<=runs ; j++) {
		ParserProg5Cells.ModelCells._SIMULATION_ID = j;
		TotalCells.TotalCells.main(null);
		ModelCellsSim.SimulatorCellsNewForAnalyser.sim = j;
			
		double [][][] traj = ModelCellsSim.SimulatorCellsNewForAnalyser.data;
		double [] timeToInsert = ModelCellsSim.SimulatorCellsNewForAnalyser.timeArray;		
		
		Signal signal = new Signal(graph, timeToInsert, traj);
		String[] var = {"P", "D", "C", "M", "S", "A", "R", "L", "LN"};
		signal.setVariables(var);
		signal.transfomTimeStep(endT,deltat);
		
	    SpatialQuantitativeSignal qSignal = script.quantitativeCheck(new HashMap<>(), propertyName, graph, signal);    
		statistic.add(qSignal.quantTraj());		    
	    
    }
	double [][] meanTraj = statistic.getAverageTraj();
	System.out.println(Arrays.toString(meanTraj[0]));
	

	double [][] sdTraj = statistic.getStandardDeviationTraj();
	System.out.println(Arrays.toString(sdTraj[0]));

    
/////  write  SSTL
String text = "";
for (int i=0; i<meanTraj.length;i++) {
	for (int j = 0; j < meanTraj[0].length; j++) {
			text += String.format(Locale.US, " %20.10f", meanTraj[i][j]);
			System.out.println("Done" + i + " " + j);
	}
	text += "\n";
}
PrintWriter printer = new PrintWriter("/afs/inf.ed.ac.uk/user/s13/s1372511/workspaceHogweed/org.jsstl.examples.MovementCells5/data/" + TotalCells.TotalCells.Model + ModelCells._EXPERIMENT_ID + "_P.txt");
printer.print(text);
printer.close();


}	
}
