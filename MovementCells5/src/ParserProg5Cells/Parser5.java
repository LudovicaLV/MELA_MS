package ParserProg5Cells;

import ParserRulesFarms.MELArules;
import ParserStatMC.StatMCrules;
import TraceAnalyser.Analyser;

public class Parser5 {

	public static int _SIMULATION_ID = 1;
	
	public static int numberOfRuns = 1;
	
	public static void main(String[] args) throws Exception {
		
		for(int i = 1; i <= numberOfRuns; i++)
		{   MELAprog5 Parser= new MELAprog5();
			Parser.parseFromFile("/afs/inf.ed.ac.uk/user/s13/s1372511/Desktop/FARMS_MODELS/MELATotalDistance/Project2.mela");
	        System.out.println("Model parsed correctly.");      
			MELArules Parser2= new MELArules();
			Parser2.parseFromFile("/afs/inf.ed.ac.uk/user/s13/s1372511/Desktop/FARMS_MODELS/MELATotalDistance/Rules.txt");
			_SIMULATION_ID++;
		}	
				
		    StatMCrules Parser3= new StatMCrules();
		    Parser3.parseFromFile("/afs/inf.ed.ac.uk/user/s13/s1372511/Desktop/FARMS_MODELS/MELATotalDistance/RulesStatMCProject2.txt");
        
			Analyser.numberRuns = numberOfRuns;
			Analyser.main(null);
		    
	}	
}


