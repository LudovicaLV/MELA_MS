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

public class MovCellsNew3Faster {

	public static void main(String[] args) throws Exception {
		
		int runs = 100;
		String propertyName4 = "cellL";
		//String propertyName5 = "cellLS";
		
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
	jSSTLScript script = loader.load("/afs/inf.ed.ac.uk/user/s13/s1372511/eclipse-workspace/org.jsstl.examples.MovementCells5/data/MovCellsNew3Sema.sstl");
	// Loading the variables. That we have defined in the formulas files.
	
//	/// %%%%%%%  DATA import %%%%%%%%%%%%/////////
	//String [] var = script.getVariables();
	
/////////////  many RUNS  //////////

	double endT = TotalCells.TotalCells.simulationTime;	
	double deltat = 0.1;
	//int steps = (int) (endT/deltat)+1;

	        TotalCells.TotalCells.main(null);
    		
			double [][][] trajInit4 = ModelCellsSim.SimulatorCellsNewForAnalyserFaster.data;
    		double [] timeToInsertInit4 = ModelCellsSim.SimulatorCellsNewForAnalyserFaster.timeArray;	
    		
			
			Signal signalInit4 = new Signal(graph, timeToInsertInit4, trajInit4);
			String[] varInit4 = {"P", "D", "C", "M", "S", "A", "R", "L", "LN"};
			signalInit4.setVariables(varInit4);
			signalInit4.transfomTimeStep(endT,deltat);
			
		    
		    SpatialQuantitativeSignal qSignalInit4 = script.quantitativeCheck(new HashMap<>(), propertyName4, graph, signalInit4);
		    int steps4 = qSignalInit4.getSteps();
			SignalStatistics2 statistic4 = new SignalStatistics2(graph.getNumberOfLocations(),steps4);	
		    statistic4.add(qSignalInit4.quantTraj());
		    
		    
	for ( int j=1 ; j<=runs ; j++) {
		ParserProg5Cells.ModelCells._SIMULATION_ID = j;
		TotalCells.TotalCells.main(null);
		ModelCellsSim.SimulatorCellsNewForAnalyserFaster.sim = j;
			
		double [][][] traj = ModelCellsSim.SimulatorCellsNewForAnalyserFaster.data;
		double [] timeToInsert = ModelCellsSim.SimulatorCellsNewForAnalyserFaster.timeArray;		
		
		Signal signal = new Signal(graph, timeToInsert, traj);
		String[] var = {"P", "D", "C", "M", "S", "A", "R", "L", "LN"};
		signal.setVariables(var);
		signal.transfomTimeStep(endT,deltat);
		
		
	    SpatialQuantitativeSignal qSignal4 = script.quantitativeCheck(new HashMap<>(), propertyName4, graph, signal);
		statistic4.add(qSignal4.quantTraj());
  
	    
    }
	
	double [][] meanTraj4 = statistic4.getAverageTraj();
	System.out.println(Arrays.toString(meanTraj4[0]));


	double [][] sdTraj4 = statistic4.getStandardDeviationTraj();
	System.out.println(Arrays.toString(sdTraj4[0]));

    
/////  write  SSTL

String text4 = "";
for (int i=0; i<meanTraj4.length;i++) {
	for (int j = 0; j < meanTraj4[0].length; j++) {
			text4 += String.format(Locale.US, " %20.10f", meanTraj4[i][j]);
	}
	text4 += "\n";
}
PrintWriter printer4 = new PrintWriter("/afs/inf.ed.ac.uk/user/s13/s1372511/eclipse-workspace/org.jsstl.examples.MovementCells5/data/" + TotalCells.TotalCells.Model + ModelCells._EXPERIMENT_ID + "_L.txt");
printer4.print(text4);
printer4.close();


}	
}
