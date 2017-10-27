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

public class MovCellsNew3Stop {

	public static void main(String[] args) throws Exception {
		
		int runs = 10;
		String propertyName = "cellP";
		String propertyName2 = "cellC";
		String propertyName3 = "cellM";
		String propertyName4 = "cellL";
		String propertyName5 = "cellW";
		
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
	jSSTLScript script = loader.load("/afs/inf.ed.ac.uk/user/s13/s1372511/workspaceHogweed/org.jsstl.examples.MovementCells5/data/MovCellsNew3SemaStop.sstl");
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
    		
			double [][][] trajInit5 = ModelCellsSim.SimulatorCellsNewForAnalyser.data;
    		double [] timeToInsertInit5 = ModelCellsSim.SimulatorCellsNewForAnalyser.timeArray;	
    		
//			double [] val000= new double[traj.length];
//			double [] val0time= new double[traj[0].length];
//			for(int i=0; i < traj.length; i++){
//				val000[i]=traj[i][0][1];
//			}
//			for(int i=0; i < traj[0].length; i++){
//				val0time[i]=traj[0][i][0];
//			}
//			System.out.println("loc "+Arrays.toString(val000));
//			System.out.println("trajloc0 "+Arrays.toString(val0time));
			
			Signal signalInit = new Signal(graph, timeToInsertInit, trajInit);
			String[] varInit = {"P", "D", "C", "W", "M", "S", "A", "R", "L", "LN"};
			signalInit.setVariables(varInit);
			signalInit.transfomTimeStep(endT,deltat);
			
			Signal signalInit2 = new Signal(graph, timeToInsertInit2, trajInit2);
			String[] varInit2 = {"P", "D", "C","W", "M", "S", "A", "R", "L", "LN"};
			signalInit2.setVariables(varInit2);
			signalInit2.transfomTimeStep(endT,deltat);
			
			Signal signalInit3 = new Signal(graph, timeToInsertInit3, trajInit3);
			String[] varInit3 = {"P", "D", "C","W", "M", "S", "A", "R", "L", "LN"};
			signalInit3.setVariables(varInit3);
			signalInit3.transfomTimeStep(endT,deltat);
			
			Signal signalInit4 = new Signal(graph, timeToInsertInit4, trajInit4);
			String[] varInit4 = {"P", "D", "C","W", "M", "S", "A", "R", "L", "LN"};
			signalInit4.setVariables(varInit4);
			signalInit4.transfomTimeStep(endT,deltat);
			
			Signal signalInit5 = new Signal(graph, timeToInsertInit5, trajInit5);
			String[] varInit5 = {"P", "D", "C","W", "M", "S", "A", "R", "L", "LN"};
			signalInit5.setVariables(varInit5);
			signalInit5.transfomTimeStep(endT,deltat);
			
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
		    
		    SpatialQuantitativeSignal qSignalInit5 = script.quantitativeCheck(new HashMap<>(), propertyName5, graph, signalInit5);
		    int steps5 = qSignalInit5.getSteps();
			SignalStatistics2 statistic5 = new SignalStatistics2(graph.getNumberOfLocations(),steps5);	
		    statistic5.add(qSignalInit5.quantTraj());
		    
	for ( int j=1 ; j<=runs ; j++) {
		ParserProg5Cells.ModelCells._SIMULATION_ID = j;
		TotalCells.TotalCells.main(null);
			
		double [][][] traj = ModelCellsSim.SimulatorCellsNewForAnalyser.data;
		double [] timeToInsert = ModelCellsSim.SimulatorCellsNewForAnalyser.timeArray;		
		
//		double [] val000= new double[traj.length];
//		double [] val0time= new double[traj[0].length];
//		for(int i=0; i < traj.length; i++){
//			val000[i]=traj[i][0][1];
//		}
//		for(int i=0; i < traj[0].length; i++){
//			val0time[i]=traj[0][i][0];
//		}
//		System.out.println("loc "+Arrays.toString(val000));
//		System.out.println("trajloc0 "+Arrays.toString(val0time));
		
		Signal signal = new Signal(graph, timeToInsert, traj);
		String[] var = {"P", "D", "C","W", "M", "S", "A", "R", "L", "LN"};
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
		
	    SpatialQuantitativeSignal qSignal5 = script.quantitativeCheck(new HashMap<>(), propertyName5, graph, signal);
		statistic5.add(qSignal5.quantTraj());	
    }
	double [][] meanTraj = statistic.getAverageTraj();
	System.out.println(Arrays.toString(meanTraj[0]));
	
	double [][] meanTraj2 = statistic2.getAverageTraj();
	System.out.println(Arrays.toString(meanTraj2[0]));
	
	double [][] meanTraj3 = statistic3.getAverageTraj();
	System.out.println(Arrays.toString(meanTraj3[0]));
	
	double [][] meanTraj4 = statistic4.getAverageTraj();
	System.out.println(Arrays.toString(meanTraj4[0]));	
	
	double [][] meanTraj5 = statistic5.getAverageTraj();
	System.out.println(Arrays.toString(meanTraj5[0]));
	
//	double [][] sq = statistic.getSquareTraj();
//	System.out.println(Arrays.toString(sq[0]));
	
	double [][] sdTraj = statistic.getStandardDeviationTraj();
	System.out.println(Arrays.toString(sdTraj[0]));
	
	double [][] sdTraj2 = statistic2.getStandardDeviationTraj();
	System.out.println(Arrays.toString(sdTraj2[0]));
	
	double [][] sdTraj3 = statistic3.getStandardDeviationTraj();
	System.out.println(Arrays.toString(sdTraj3[0]));
	
	double [][] sdTraj4 = statistic4.getStandardDeviationTraj();
	System.out.println(Arrays.toString(sdTraj4[0]));	
	
	double [][] sdTraj5 = statistic5.getStandardDeviationTraj();
	System.out.println(Arrays.toString(sdTraj5[0]));


//	for (int i=0; i< graph.getNumberOfLocations(); i++){
//	System.out.println(graph.getLocation(i) + " -> " + meanTraj[i][0]);
//}
	
	//double [][] confInterval = statistic.getConfIntervalTraj(runs, 1.96);
//	
//	for (int i=0; i< graph.getNumberOfLocations(); i++){
//		System.out.print(meanTraj[i][0] + ", ");
//	}
//	System.out.println(" ");
//	
//	
//	for (int i=0; i< graph.getNumberOfLocations(); i++){
//		System.out.print(sdTraj[i][0] + ", ");
//	}
//	
//	System.out.println(" ");
//	
//
//	HashMap<Integer,SpatialThreeValues> TimeTSLValues1 = new HashMap<>();
//	
//	for (int j=0; j < meanTraj[0].length; j++){
//	SpatialThreeValues resultFireTSL1 = new SpatialThreeValues(graph);
//	for (int i=0; i < meanTraj.length; i++){		
//		double a = meanTraj[i][j] - sdTraj[i][j];
//		double b = meanTraj[i][j] + sdTraj[i][j];
//		double k = 0.8;
//		String check = ">";
//		ThreeValues value1 = ThreeValuesAtomic.checkIneq(a, b, k, check);
//		resultFireTSL1.addLoc(graph.getLocation(i), value1);
//		TimeTSLValues1.put(j, resultFireTSL1);
//	}
//	}
//	
//	HashMap<Integer,SpatialThreeValues> TimeTSLValues2 = new HashMap<>();
//	
//	for (int j=0; j < meanTraj2[0].length; j++){
//	SpatialThreeValues resultFireTSL2 = new SpatialThreeValues(graph);
//	for (int i=0; i < meanTraj2.length; i++){		
//		double a = meanTraj2[i][j] - sdTraj2[i][j];
//		double b = meanTraj2[i][j] + sdTraj2[i][j];
//		double k = 0.8;
//		String check = ">";
//		ThreeValues value2 = ThreeValuesAtomic.checkIneq(a, b, k, check);
//		resultFireTSL2.addLoc(graph.getLocation(i), value2);
//		TimeTSLValues2.put(j, resultFireTSL2);
//	}
//	}
//	
//
//	HashMap<Integer,SpatialThreeValues> TimeTSLValues3 = new HashMap<>();
//	
//	for (int j=0; j < meanTraj3[0].length; j++){
//	SpatialThreeValues resultFireTSL3 = new SpatialThreeValues(graph);
//	for (int i=0; i < meanTraj3.length; i++){		
//		double a = meanTraj3[i][j] - sdTraj3[i][j];
//		double b = meanTraj3[i][j] + sdTraj3[i][j];
//		double k = 0.8;
//		String check = ">";
//		ThreeValues value3 = ThreeValuesAtomic.checkIneq(a, b, k, check);
//		resultFireTSL3.addLoc(graph.getLocation(i), value3);
//		TimeTSLValues3.put(j, resultFireTSL3);
//	}
//	}
//	
//	HashMap<Integer,SpatialThreeValues> TimeTSLValues4 = new HashMap<>();
//	
//	for (int j=0; j < meanTraj4[0].length; j++){
//	SpatialThreeValues resultFireTSL4 = new SpatialThreeValues(graph);
//	for (int i=0; i < meanTraj4.length; i++){		
//		double a = meanTraj4[i][j] - sdTraj4[i][j];
//		double b = meanTraj4[i][j] + sdTraj4[i][j];
//		double k = 0.2;
//		String check = "<";
//		ThreeValues value4 = ThreeValuesAtomic.checkIneq(a, b, k, check);
//		resultFireTSL4.addLoc(graph.getLocation(i), value4);
//		TimeTSLValues4.put(j, resultFireTSL4);
//	}
//	}
//	
//	  		
//	HashMap<Integer,SpatialThreeValues> Mapformula34 = new HashMap<>();
//
//    for (int j=0; j < meanTraj3[0].length; j++){
//    for (int i=0; i < meanTraj3.length; i++){		
//	SpatialThreeValues formula1 = SpatialThreeValuesTransducer.and(TimeTSLValues3.get(j), TimeTSLValues4.get(j));
//	Mapformula34.put(j, formula1);
//}
//}



//	
//	String text = "";	
//	
//	for (int i=0; i< graph.getNumberOfLocations(); i++){
//		for (int j=0; j<TimeTSLValues1.size();j++) {
//		if (TimeTSLValues1.get(j).spatialThreeValues.get(graph.getLocation(i))==ThreeValues.FALSE){
//			text += String.format(Locale.US, " %20.10f", 0.2);}else{
//				if(TimeTSLValues1.get(j).spatialThreeValues.get(graph.getLocation(i))==ThreeValues.TRUE){
//					text += String.format(Locale.US, " %20.10f", 0.8);
//				}else{
//					text += String.format(Locale.US, " %20.10f", 0.5);
//				}
//			}			
//	}
//	text += "\n";
//}
//PrintWriter printer = new PrintWriter("/afs/inf.ed.ac.uk/user/s13/s1372511/workspaceHogweed/org.jsstl.examples.MovementCells5/data/TSTL1.txt");
//printer.print(text);
//printer.close();
//
//String text2 = "";	
//
//for (int i=0; i< graph.getNumberOfLocations(); i++){
//	for (int j=0; j<TimeTSLValues2.size();j++) {
//	if (TimeTSLValues2.get(j).spatialThreeValues.get(graph.getLocation(i))==ThreeValues.FALSE){
//		text2 += String.format(Locale.US, " %20.10f", 0.2);}else{
//			if(TimeTSLValues2.get(j).spatialThreeValues.get(graph.getLocation(i))==ThreeValues.TRUE){
//				text2 += String.format(Locale.US, " %20.10f", 0.8);
//			}else{
//				text2 += String.format(Locale.US, " %20.10f", 0.5);
//			}
//		}			
//}
//text2 += "\n";
//}
//PrintWriter printer2 = new PrintWriter("/afs/inf.ed.ac.uk/user/s13/s1372511/workspaceHogweed/org.jsstl.examples.MovementCells5/data/TSTL2.txt");
//printer2.print(text2);
//printer2.close();

//String text3 = "";	
//
//for (int i=0; i< graph.getNumberOfLocations(); i++){
//	for (int j=0; j<Mapformula34.size();j++) {
//	if (Mapformula34.get(j).spatialThreeValues.get(graph.getLocation(i))==ThreeValues.FALSE){
//		text3 += String.format(Locale.US, " %20.10f", 0.2);}else{
//			if(Mapformula34.get(j).spatialThreeValues.get(graph.getLocation(i))==ThreeValues.TRUE){
//				text3 += String.format(Locale.US, " %20.10f", 0.8);
//			}else{
//				text3 += String.format(Locale.US, " %20.10f", 0.5);
//			}
//		}			
//}
//text3 += "\n";
//}
//PrintWriter printer3 = new PrintWriter("/afs/inf.ed.ac.uk/user/s13/s1372511/workspaceHogweed/org.jsstl.examples.MovementCells5/data/TSTL34.txt");
//printer3.print(text3);
//printer3.close();

    
    
    
/////  write  SSTL
String text = "";
for (int i=0; i<meanTraj.length;i++) {
	for (int j = 0; j < meanTraj[0].length; j++) {
			text += String.format(Locale.US, " %20.10f", meanTraj[i][j]);
			System.out.println("Done" + i + " " + j);
	}
	text += "\n";
}
PrintWriter printer = new PrintWriter("/afs/inf.ed.ac.uk/user/s13/s1372511/workspaceHogweed/org.jsstl.examples.MovementCells5/data/SSTLRateStop_" + ModelCells._EXPERIMENT_ID + "_P.txt");
printer.print(text);
printer.close();

String text2 = "";
for (int i=0; i<meanTraj2.length;i++) {
	for (int j = 0; j < meanTraj2[0].length; j++) {
			text2 += String.format(Locale.US, " %20.10f", meanTraj2[i][j]);
	}
	text2 += "\n";
}
PrintWriter printer2 = new PrintWriter("/afs/inf.ed.ac.uk/user/s13/s1372511/workspaceHogweed/org.jsstl.examples.MovementCells5/data/SSTLRateStop_" + ModelCells._EXPERIMENT_ID + "_C.txt");
printer2.print(text2);
printer2.close();

String text3 = "";
for (int i=0; i<meanTraj3.length;i++) {
	for (int j = 0; j < meanTraj3[0].length; j++) {
			text3 += String.format(Locale.US, " %20.10f", meanTraj3[i][j]);
	}
	text3 += "\n";
}
PrintWriter printer3 = new PrintWriter("/afs/inf.ed.ac.uk/user/s13/s1372511/workspaceHogweed/org.jsstl.examples.MovementCells5/data/SSTLRateStop_" + ModelCells._EXPERIMENT_ID + "_M.txt");
printer3.print(text3);
printer3.close();


String text4 = "";
for (int i=0; i<meanTraj4.length;i++) {
	for (int j = 0; j < meanTraj4[0].length; j++) {
			text4 += String.format(Locale.US, " %20.10f", meanTraj4[i][j]);
	}
	text4 += "\n";
}
PrintWriter printer4 = new PrintWriter("/afs/inf.ed.ac.uk/user/s13/s1372511/workspaceHogweed/org.jsstl.examples.MovementCells5/data/SSTLRateStop_" + ModelCells._EXPERIMENT_ID + "_L.txt");
printer4.print(text4);
printer4.close();

String text5 = "";
for (int i=0; i<meanTraj5.length;i++) {
	for (int j = 0; j < meanTraj5[0].length; j++) {
			text5 += String.format(Locale.US, " %20.10f", meanTraj5[i][j]);
	}
	text5 += "\n";
}
PrintWriter printer5 = new PrintWriter("/afs/inf.ed.ac.uk/user/s13/s1372511/workspaceHogweed/org.jsstl.examples.MovementCells5/data/SSTLRateStop_" + ModelCells._EXPERIMENT_ID + "_W.txt");
printer5.print(text5);
printer5.close();




}	
}
