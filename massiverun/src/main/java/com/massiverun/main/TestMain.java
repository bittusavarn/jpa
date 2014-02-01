package com.massiverun.main;


public class TestMain 
{

   public static void main(String[] args) 
   {
	   int A = 1;
	   int B = -7;
	   int C = 10;
	   System.out.println("Terry Peters");//Thats my Name
       
       System.out.println(findSolutions(A,B,C));
   }
   
   
   //Sets integers to easily testable numbers
   {
        
   } 
   //Runs and Prints out the solution found below

   private static int discriminant (int A, int B, int C)  
   {
       //sets the discriminate with appropriate equation

       return (B * B)-(4*A*C);         
   }

   private static int numberOfSolutions (int A, int B, int C) 
   {
       //The actual numerOfSolutions, checks if the discriminant is positive negative or zero
       if (discriminant (A, B, C) > 0)
           return 2;
       if (discriminant (A, B, C) == 0 )
           return 1;
       else
           return 0;
       
    }

   //This performs the find Solutions String mentioned in the beginning
   //For whatever reason All return statements are showing errors, but says Eclipse has a quick fix.
   //This is a lie as all it says is "No Suggestions Avalible"
   private static String findSolutions (int A, int B, int C) 
   {
       if (numberOfSolutions (A, B, C) == 0)
       {
    	   System.out.println ("There are no solutions");
    	   return "There are no solutions";
       }   
       else if (numberOfSolutions (A, B, C) == 1)
       { 
    	   return ("There is one solution and it is" + plusSolution (A, B, C));
       }
       else
           return "There are two solutions and they are " + plusSolution (A, B, C) + "and" + minusSolution (A, B, C);
   }   

   private static double plusSolution(int A, int B, int C) 
   {
       return ((B * -1) +  Math.sqrt((B * B)-(4*A*C))) / (2 * A);

   }

   private static double minusSolution (int A, int B, int C) throws RuntimeException
   {
	  	   new Float("");
	   return ((B * -1) - Math.sqrt((B * B)-(4*A*C))) / (2* A);
     // Integer i=new Integer(2);
      
   }
   
   static interface A
   {
	   int b=27;
	   void s();
   }
}