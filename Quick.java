/* @Jeffrey Zhou
 * Jzhou46
 * CS 342
 * Prof. Buy
 * 3/9/15
 * Homework 3
 * Quick Class
 */
package edu.uic.Jzhou46.cs342;
import java.util.ArrayList;

public class Quick implements SortBehavior{
	public Quick(){
	}
	
	/*
	 * Quick sort method borrowed from http://www.algolist.net/Algorithms/Sorting/Quicksort
	 * But I modified the original code to work with my program.
	 */
	public void quickSort(ArrayList<Integer> list, int start, int end){
		int i = start, j = end;
		int tmp;
		int pivot = list.get(start + (end - start)/2);
		if(list == null || list.size() == 0){
			return;
		}
		if(start >= end){
			return;
		}
		while(i <= j){
			while(list.get(i) < pivot)
				i++;
			while(list.get(j) > pivot)
				j--;
			if(i <= j){
				tmp = list.get(i);
				list.set(i, list.get(j));
				list.set(j, tmp);
				i++;
				j--;				
			}
		}//End of while
		if(start < j)
			quickSort(list, start, j);
		if(end > i)
			quickSort(list, i, end);
	}
	@Override 
	public void sort(ArrayList<Integer> list){//Quick sort method
		String type = display(); 
		System.out.println("Sorted with " + type);
		int length = list.size();
		quickSort(list, 0, length - 1); 
	}

	@Override
	public String display() {
		return "Quick sort";
	}

}
