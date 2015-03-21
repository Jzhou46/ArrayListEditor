/* @Jeffrey Zhou
 * Jzhou46
 * CS 342
 * Prof. Buy
 * 3/9/15
 * Homework 3
 * Insertion Class
 */
package edu.uic.Jzhou46.cs342;
import java.util.ArrayList;

public class Insertion implements SortBehavior{
	public Insertion(){
	}
	
	/*
	 * Insertion sort method borrowed from http://courses.cs.washington.edu/courses/cse373/01wi/slides/Measurement/sld010.htm
	 * But I modified the original code to work with my program.
	 */
	@Override
	public void sort(ArrayList<Integer> list) {//Insertion sort method
		String type = display();
		System.out.println("Sorted with " + type);
		for(int i = 1; i < list.size(); i++ ){
			int tmp = list.get(i);
			int j;
			for(j = i - 1; j >= 0 && tmp < list.get(j); j --){
				list.set(j + 1, list.get(j));
			}		
			list.set(j + 1, tmp);
		}
	}
	@Override
	public String display() {
		return "Insertion sort";
	}
}
