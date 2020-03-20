/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Core;

/**
 *
 * @author meta
 */
public class Stack {
   private int maxSize=20;         // size of StackX array
   private int[] stackArray;
   private int top;             // top of stack
//--------------------------------------------------------------
   public Stack()         // constructor
      {
      //maxSize = 20;              // set array size
      stackArray = new int[maxSize];  // create array
      top = -1;                 // no items yet
      }
//--------------------------------------------------------------
   public void push(int p)   // put item on top of stack
      {
      stackArray[++top] = p;    // increment top, insert item
      }
//--------------------------------------------------------------
   public int pop()          // take item from top of stack
      {
      return stackArray[top--]; // access item, decrement top
      }
//--------------------------------------------------------------
   public int peek()         // peek at top of stack
      {
      return stackArray[top];
      }
  //--------------------------------------------------------------
   public int get(int i)
   {
       return stackArray[i];
   }
   //------------------------------------------------------------
   public int gettop()
   {
       return top;
   }
}
