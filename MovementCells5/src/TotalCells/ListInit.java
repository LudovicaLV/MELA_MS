package TotalCells;

import java.util.ArrayList;
import java.util.Random;

public class ListInit {

	
	public static void main(String[] args){
	
		int value = 0;
		for (int i=0; i<15; i++){
			for (int j=0; j<15; j++){
				if (value < 149){
			
				ArrayList<ArrayList<Integer>> list = list();
				
				ArrayList<Integer> listxy = new ArrayList<>();
				listxy.add(i);
				listxy.add(j);
				if (list.contains(listxy)){
				listxy.clear();

	     }else{
	    	 Random ran = new Random();
	    	 int x = ran.nextInt(10);
	    	 if (x < 7){
	    	 System.out.print("P(" + i + "," + j + ")[1]||");
	    	 listxy.clear();
	    	 value++;}else{
	    		 listxy.clear();
	    	 }
	    }
				}}}
		}
	
	public static 		ArrayList<ArrayList<Integer>> list (){
		
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		int[] x = {5,6,6,6,7,7,7,7,7,8,8,8,9};
		int[] y = {7,6,7,8,5,6,7,8,9,6,7,8,7};
		
		for (int i=0; i<x.length; i++){	
		ArrayList<Integer> listxy = new ArrayList<>();
		listxy.add(x[i]);
		listxy.add(y[i]);
		list.add(listxy);
}
		return list;}
}
