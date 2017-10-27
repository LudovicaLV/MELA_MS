package ParserProg5Cells;


import java.util.ArrayList;
import java.util.HashMap;

import ParserRulesFarms.MELArules;
import TotalCells.TotalCells;

public class ModelCells {
	
	public static int _SIMULATION_ID;
	public static int _EXPERIMENT_ID;
	public static int numberOfRuns = TotalCells.numberOfRuns;

	public static void main(String[] args) throws Exception {
			
     //_SIMULATION_ID = 1;
		for(int i = 1; i <= numberOfRuns; i++)
		{   MELAprog5 Parser= new MELAprog5();
		    Parser.parseFromFile(TotalCells.Folder + TotalCells.Model + ".mela");
    		System.out.println("Model parsed correctly."); 
	        System.out.println("Simulation -> " + _SIMULATION_ID ); 
			MELArules Parser2= new MELArules();
			Parser2.parseFromFile("/afs/inf.ed.ac.uk/user/s13/s1372511/eclipse-workspace/MovementCells5/src/Rules.txt");
	 		//_SIMULATION_ID++;
		}	
	}
}




