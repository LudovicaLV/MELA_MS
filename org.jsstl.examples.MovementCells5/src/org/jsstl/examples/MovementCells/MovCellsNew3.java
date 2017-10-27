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

public class MovCellsNew3 {

	public static void main(String[] args) throws Exception {
		
		int runs = 2;
		String propertyName = "cellP";
		String propertyName2 = "cellC";
		String propertyName3 = "cellM";
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
			
			double [][][] trajInit2 = ModelCellsSim.SimulatorCellsNewForAnalyser.data;
    		double [] timeToInsertInit2 = ModelCellsSim.SimulatorCellsNewForAnalyser.timeArray;	
			
			double [][][] trajInit3 = ModelCellsSim.SimulatorCellsNewForAnalyser.data;
    		double [] timeToInsertInit3 = ModelCellsSim.SimulatorCellsNewForAnalyser.timeArray;	
    		
			double [][][] trajInit4 = ModelCellsSim.SimulatorCellsNewForAnalyser.data;
    		double [] timeToInsertInit4 = ModelCellsSim.SimulatorCellsNewForAnalyser.timeArray;	
    		
//			double [][][] trajInit5 = ModelCellsSim.SimulatorCellsNew.data;
//    		double [] timeToInsertInit5 = ModelCellsSim.SimulatorCellsNew.timeArray;	
			
			Signal signalInit = new Signal(graph, timeToInsertInit, trajInit);
			String[] varInit = {"P", "D", "C", "M", "S", "A", "R", "L", "LN"};
			signalInit.setVariables(varInit);
			signalInit.transfomTimeStep(endT,deltat);
			
			Signal signalInit2 = new Signal(graph, timeToInsertInit2, trajInit2);
			String[] varInit2 = {"P", "D", "C", "M", "S", "A", "R", "L", "LN"};
			signalInit2.setVariables(varInit2);
			signalInit2.transfomTimeStep(endT,deltat);
			
			Signal signalInit3 = new Signal(graph, timeToInsertInit3, trajInit3);
			String[] varInit3 = {"P", "D", "C", "M", "S", "A", "R", "L", "LN"};
			signalInit3.setVariables(varInit3);
			signalInit3.transfomTimeStep(endT,deltat);
			
			Signal signalInit4 = new Signal(graph, timeToInsertInit4, trajInit4);
			String[] varInit4 = {"P", "D", "C", "M", "S", "A", "R", "L", "LN"};
			signalInit4.setVariables(varInit4);
			signalInit4.transfomTimeStep(endT,deltat);
			
//			Signal signalInit5 = new Signal(graph, timeToInsertInit5, trajInit5);
//			String[] varInit5 = {"P", "D", "C", "M", "S", "A", "R", "L", "LN"};
//			signalInit5.setVariables(varInit5);
//			signalInit5.transfomTimeStep(endT,deltat);
			
		    SpatialQuantitativeSignal qSignalInit = script.quantitativeCheck(new HashMap<>(), propertyName, graph, signalInit);
		    int steps = qSignalInit.getSteps();
			SignalStatistics2 statistic = new SignalStatistics2(graph.getNumberOfLocations(),steps);	
		    statistic.add(qSignalInit.quantTraj());
		    
		    SpatialQuantitativeSignal qSignalInit2 = script.quantitativeCheck(new HashMap<>(), propertyName2, graph, signalInit2);
		    int steps2 = qSignalInit2.getSteps();
			SignalStatistics2 statistic2 = new SignalStatistics2(graph.getNumberOfLocations(),steps2);	
		    statistic2.add(qSignalInit2.quantTraj());
		    
		    SpatialQuantitativeSignal qSignalInit3 = script.quantitativeCheck(new HashMap<>(), propertyName3, graph, signalInit3);
		    int steps3 = qSignalInit3.getSteps();
			SignalStatistics2 statistic3 = new SignalStatistics2(graph.getNumberOfLocations(),steps3);	
		    statistic3.add(qSignalInit3.quantTraj());
		    
		    SpatialQuantitativeSignal qSignalInit4 = script.quantitativeCheck(new HashMap<>(), propertyName4, graph, signalInit4);
		    int steps4 = qSignalInit4.getSteps();
			SignalStatistics2 statistic4 = new SignalStatistics2(graph.getNumberOfLocations(),steps4);	
		    statistic4.add(qSignalInit4.quantTraj());
		    
//		    SpatialQuantitativeSignal qSignalInit5 = script.quantitativeCheck(new HashMap<>(), propertyName5, graph, signalInit5);
//		    int steps5 = qSignalInit5.getSteps();
//			SignalStatistics2 statistic5 = new SignalStatistics2(graph.getNumberOfLocations(),steps5);	
//		    statistic5.add(qSignalInit5.quantTraj());
		    
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
		
	    SpatialQuantitativeSignal qSignal2 = script.quantitativeCheck(new HashMap<>(), propertyName2, graph, signal);
		statistic2.add(qSignal2.quantTraj());	
		
	    SpatialQuantitativeSignal qSignal3 = script.quantitativeCheck(new HashMap<>(), propertyName3, graph, signal);
		statistic3.add(qSignal3.quantTraj());	
		
	    SpatialQuantitativeSignal qSignal4 = script.quantitativeCheck(new HashMap<>(), propertyName4, graph, signal);
		statistic4.add(qSignal4.quantTraj());
		
//	    SpatialQuantitativeSignal qSignal5 = script.quantitativeCheck(new HashMap<>(), propertyName5, graph, signal);
//		statistic5.add(qSignal5.quantTraj());	
	    
	    
    }
	double [][] meanTraj = statistic.getAverageTraj();
	System.out.println(Arrays.toString(meanTraj[0]));
	
	double [][] meanTraj2 = statistic2.getAverageTraj();
	System.out.println(Arrays.toString(meanTraj2[0]));
	
	double [][] meanTraj3 = statistic3.getAverageTraj();
	System.out.println(Arrays.toString(meanTraj3[0]));
	
	double [][] meanTraj4 = statistic4.getAverageTraj();
	System.out.println(Arrays.toString(meanTraj4[0]));
	
//	double [][] meanTraj5 = statistic5.getAverageTraj();
//	System.out.println(Arrays.toString(meanTraj5[0]));

	
	double [][] sdTraj = statistic.getStandardDeviationTraj();
	System.out.println(Arrays.toString(sdTraj[0]));
	
	double [][] sdTraj2 = statistic2.getStandardDeviationTraj();
	System.out.println(Arrays.toString(sdTraj2[0]));
	
	double [][] sdTraj3 = statistic3.getStandardDeviationTraj();
	System.out.println(Arrays.toString(sdTraj3[0]));
	
	double [][] sdTraj4 = statistic4.getStandardDeviationTraj();
	System.out.println(Arrays.toString(sdTraj4[0]));
	
//	double [][] sdTraj5 = statistic5.getStandardDeviationTraj();
//	System.out.println(Arrays.toString(sdTraj5[0]));

    
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

String text2 = "";
for (int i=0; i<meanTraj2.length;i++) {
	for (int j = 0; j < meanTraj2[0].length; j++) {
			text2 += String.format(Locale.US, " %20.10f", meanTraj2[i][j]);
	}
	text2 += "\n";
}
PrintWriter printer2 = new PrintWriter("/afs/inf.ed.ac.uk/user/s13/s1372511/workspaceHogweed/org.jsstl.examples.MovementCells5/data/" + TotalCells.TotalCells.Model + ModelCells._EXPERIMENT_ID + "_C.txt");
printer2.print(text2);
printer2.close();

String text3 = "";
for (int i=0; i<meanTraj3.length;i++) {
	for (int j = 0; j < meanTraj3[0].length; j++) {
			text3 += String.format(Locale.US, " %20.10f", meanTraj3[i][j]);
	}
	text3 += "\n";
}
PrintWriter printer3 = new PrintWriter("/afs/inf.ed.ac.uk/user/s13/s1372511/workspaceHogweed/org.jsstl.examples.MovementCells5/data/" + TotalCells.TotalCells.Model + ModelCells._EXPERIMENT_ID + "_M.txt");
printer3.print(text3);
printer3.close();


String text4 = "";
for (int i=0; i<meanTraj4.length;i++) {
	for (int j = 0; j < meanTraj4[0].length; j++) {
			text4 += String.format(Locale.US, " %20.10f", meanTraj4[i][j]);
	}
	text4 += "\n";
}
PrintWriter printer4 = new PrintWriter("/afs/inf.ed.ac.uk/user/s13/s1372511/workspaceHogweed/org.jsstl.examples.MovementCells5/data/" + TotalCells.TotalCells.Model + ModelCells._EXPERIMENT_ID + "_L.txt");
printer4.print(text4);
printer4.close();


//String text5 = "";
//for (int i=0; i<meanTraj5.length;i++) {
//	for (int j = 0; j < meanTraj5[0].length; j++) {
//			text4 += String.format(Locale.US, " %20.10f", meanTraj5[i][j]);
//	}
//	text4 += "\n";
//}
//PrintWriter printer5 = new PrintWriter("/afs/inf.ed.ac.uk/user/s13/s1372511/workspaceHogweed/org.jsstl.examples.MovementCells5/data/CentreStop_" + ModelCells._EXPERIMENT_ID + "_LS.txt");
//printer5.print(text5);
//printer5.close();


}	
}
