import java.util.NoSuchElementException;
import java.util.*;
/**
 * An interface that describes a stack abstract data type
 *
 * @author Benjamin Kuperman (Spring 2005, Spring 2012, Spring 2014)
 */


public class MyStack{
    private ArrayList<Square> squares;
    /**
     * Add an item onto the stack
     * @param item the data item to add (of type T)
     */


    /**
     * Constructs an empty stack.
    */
    public MyStack()
    {
        squares = new ArrayList<Square>();
    }

    /**
     * Adds an element to the top of the stack.
     *
     * @param element the element to add
    */
    public void push(Square element){
        squares.add(element);
    }





    /**
        Removes the element from the top of the stack.
        @return the removed element
    */
    public Object pop(){
        return squares.remove(0);
    }







    /**
     * Checks whether this stack is empty.
     *
     * @return true if the stack is empty
    */

    static class Node
    {
        public Object data;
        public Node next;
    }


    /**
     * Display the top item from the stack without removing it
     * @return the top item in the stack
     * @throws NoSuchElementException if the stack is empty
     */
    public Square top() throws NoSuchElementException
    {
        return squares.get(0);
    }

    /**
     * Find how many items are in the stack
     * @return the number of items in the stack
     */
    public int size()
    {return squares.size();}

    /**
     * Determine if the stack is empty
     * @return true if the size is 0, false otherwise
     */
    boolean isEmpty()
    {return squares.size() == 0;}

    /**
     * Clear out the data structure
     */
    public void clear()
    {
        squares = new ArrayList<Square>();
    }

}