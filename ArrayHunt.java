/*
NAME: Alex Thoenens
If you worked with someone:
	List individuals: Jesse Kemmerling
	
	What was your contribution: shared code ideas


If you helped someone, for each person, list who and how you helped.
Jesse Kemmerling, shared code ideas



If someone helped you, for each person, list who and how you helped.
Jesse Kemmerling, sharing code ideas
*/
   import java.io.*;
   import java.util.*;

/**
* An array implementation of the Hunt interface
*
*/
    public class ArrayHunt implements Hunt
    {
      private SteppingStone[] path = new SteppingStone[150];
      
      private int size;
      private int start;
   	
       public void initialize(String fileName) throws IOException 
       {
       	// Sets up a buffer and links the file to the buffer
         BufferedReader buffer = new BufferedReader(new FileReader(fileName));
      	// Reads the first line, which contains a number, translate the string to a number and places it in start
         this.start = Integer.valueOf(buffer.readLine()).intValue();
      	// index keep track of the array position being filled
         int index = 0;
      	// Loop until the buffer runs out of records
         while (buffer.ready())
         {
         	// Place the buffer contents into a string tokenizer using the tab token
            StringTokenizer token = new StringTokenizer(buffer.readLine(), "\t");
         	// first token is a char, second in an int, use them to construct a SteppingStone
            SteppingStone Stone = new SteppingStone(token.nextToken(), Integer.valueOf(token.nextToken()));
         	// Place the stone in the array
            this.path[index] = Stone;
         	// increment the array index
            index++;
         }
      	// index is the count of the number of SteppingStones placed in the path
         this.size = index;
      }
   
       public String toString()
       {
         String answer = "";
      	// for each SteppingStone
         for(int i=0; i < this.size; i++)
         {
         	// Place string representation of first SteppingStone into the answer
            if(answer == "") answer = this.path[i].toString();
            // Append all other SteppingStones with a dash in between
            else answer += " - "+this.path[i].toString();
         }
      	// Return the string representation
         return answer;
      }
   
       
       //EDIT 
       public String hunt()
       {
         String answer = "";
         
         // integer used to continue through the loop
         int comtinuation = 0;
         
         // runs as long as there is at least one more stone
         while (comtinuation < this.size)
         {
        	 // add the current symbol to the string answer
        	 answer = answer + path[start].getSymbol();
        	 
        	 // get the next direction to move int
        	 int move = path[start].getDirection();
        	 
        	 // move backwards
        	 if (move < 0)
        	 {
        		 // next symbol to append to answer
        		 start = start + move;
        		 
        		 // add 1 because you looked at this stone
        		 // and can not go back
        		 comtinuation ++;
        	 }
        	 // move forwards
        	 else if (move > 0)
        	 {
        		 start = start + move;
        		 comtinuation ++;
        	 }
        	 // end of the movement (last letter)
        	 else if(move == 0)
        	 {
        		 comtinuation = this.size;
        		 //break;
        	 }
         }
         
         return answer;
      }
   
   }
