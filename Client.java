/* @Jeffrey Zhou
 * Jzhou46
 * CS 342
 * Prof. Buy
 * 3/9/15
 * Homework 3
 * Client Class
 */
package edu.uic.Jzhou46.cs342;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;


/* The pattern that I will be implementing for this assignment is Strategy 
 * -The interface, SortBehavior, will declare a sort method
 * -Depending on the size of the list, different sort behavior will be delegated for the sort method
 * */

public class Client {
	//Method to display the commands of this program
	public static void menu(){
		System.out.println("\nThe commands for this program are: ");
		System.out.println("c — This command resets the list maintained by editor to be an empty array list "); 
		System.out.println("a <aNumber> ... <aNumber> — This command adds the numbers appearing in the command line to the front of the list "); 
		System.out.println("r <aString> — This command reads numbers from a file whose name is passed as a string "); 
		System.out.println("d — This command prints the content of the list on the standard output stream "); 
		System.out.println("s — This command sorts the list. It first checks what the length of the list is, then decides what sorting algorithm to use ");
		System.out.println("q — This command quits the list editor "); 
		System.out.println("? — Displays the commands");
	}
	
	//Method to diplay all the content(s) of the list
	public static void display(ArrayList<Integer> list){
		for(Integer i: list )
			System.out.print(i + " ");		
		System.out.print("\n");
	}
	
	//Method to adds number(s) appearing in the command line to the front of the list
	public static void addList(ArrayList<Integer> list, String sentence){
		StringTokenizer st = new StringTokenizer(sentence);//Splits the string into tokens
		while(st.hasMoreTokens()){
			Integer i = Integer.parseInt(st.nextToken());//Convert each string tokens into Integer
			list.add(i);//Adds Integer to front of list
		}
	}
	
	//Method to add all the content(s) in a file to the list
	public static void readFromFile(ArrayList<Integer> list, String filename) throws FileNotFoundException{
		System.out.println("Content(s) have been added to the list from " + filename);
		Scanner input = new Scanner(new File(filename));//New scanner to get the file
		while(input.hasNextInt()){
			list.add(input.nextInt()); //Add number to front of list
		}
		input.close();
	}
	public static void main(String[] args) throws FileNotFoundException{
	    ArrayList<Integer> list = new ArrayList<Integer>();//Create a new ArrayList instance
		Scanner input = new Scanner(System.in);//Declare a new Scanner for input called input
		System.out.println("Welcome to the List Editor\n");//Now prompt the user for commands		
		menu();//Display commands
		System.out.println("\nNOTE: The design pattern that I will be using/identifying with is Strategy");
		System.out.println("\nNOTE: Selection sort will be used when the size of the list is less than or equal to 50");
		System.out.println("NOTE: Insertion sort will be used when the size of the list is greater than 50 and less than or equal to 100");
		System.out.println("NOTE: Quick sort will be used when the size of the list is greater than 100");
		System.out.println("Feel free to change the numbers on these contraints however you like");
		while(true){
			System.out.print("\nPlease enter a command: ");			
			//Get the character input
			char c = input.next(".").charAt(0);
			if(c == 'c'){
				System.out.println("\nLIST HAVE BEEN RESETTED TO AN EMPTY LIST");
				list.clear(); 
			}
			else if(c == 'a'){
				System.out.println("\nADDING NEW INTEGER(S) TO THE FRONT OF THE LIST: ");
				String sentence = input.nextLine();//Get the string after the command letter 'a'
				addList(list, sentence);//Use the string in this method
			}
			else if(c == 'r'){	
				System.out.println("\nREADING INTEGER(S) FROM A FILE: ");
				String filename = input.next();//Get the string after the letter 'r' 
				readFromFile(list, filename);//Use the string in this method
			}
			else if(c == 'd'){	
				System.out.print("\nPRINTING THE CONTENT(S) OF THE LIST: \n");
				if(list.isEmpty()){//Check if list if empty
					System.out.print("List is empty");
				}
				display(list); //display list
			}
			else if(c == 's'){	
				System.out.print("\nSORTING THE LIST: \n");
				SortBehavior sortBehavior;
				if(!list.isEmpty()){//Check if list is empty
					if(list.size() <= 50){//Use Selection sort
						sortBehavior = new Selection();
					}
					else if(list.size() > 50 && list.size() <= 100){//Use Insertion sort
						sortBehavior = new Insertion();
					}
					else{//Use Quick sort
						sortBehavior = new Quick();
					}
					sortBehavior.sort(list);//Use appropriate sort method
				}
				else{
					System.out.println("Nothing to sort. List is empty");
				}
			}
			else if(c == 'q'){//quit program
				System.out.println("\nLIST EDITOR HAS BEEN TERMINATED"); 
				return;
			}
			else if(c == '?'){//Display menu
				menu(); 
			}
			else{
				System.out.println("\nYou entered an invalid command. Please try again."); 	
			}
		}//End of while loop
	}//End of main
}//End of class
