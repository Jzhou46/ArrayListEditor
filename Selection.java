/* @Jeffrey Zhou
 * Jzhou46
 * CS 342
 * Prof. Buy
 * 3/9/15
 * Homework 3
 * Selection Class
 */
package edu.uic.Jzhou46.cs342;
import java.util.ArrayList;

public class Selection implements SortBehavior{
	public Selection(){
	}
	
	/*
	 * Selection sort method borrowed from http://www.algolist.net/Algorithms/Sorting/Selection_sort
	 * But I modified the original code to work with my program. 
	 */
	@Override
	public void sort(ArrayList<Integer> list) {//Selection sort method
		String type = display();
		System.out.println("Sorted with " + type);
		for(int i = 0; i < list.size() - 1; i++){
			int index = i;
			for(int j = i + 1; j < list.size(); j++){
				if(list.get(j) < list.get(index)){
						index = j;
				}
			}
			int tmp = list.get(i);
			list.set(i, list.get(index));
			list.set(index, tmp); 
		}
	}

	@Override
	public String display() {
		return "Selection sort";
	}
	

}
