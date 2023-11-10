import java.util.NoSuchElementException;
import java.util.*;
/**
 * An interface that describes a stack abstract data type
 *
 * @author Benjamin Kuperman (Spring 2005, Spring 2012, Spring 2014)
 */


public class MyStack<T> implements StackADT<T>{
    ArrayList<T> squares;

    /**
     * Constructs an empty stack.
    */
    public MyStack()
    {
        squares = new ArrayList<>();
    }

    /**
     * Adds an element to the top of the stack.
     *
     * @param element the element to add
    */
    public void push(T element){
        squares.add(0,element);
    }

  /**
        Removes the element from the top of the stack.
        @return the removed element
    */
    public T pop(){
        return squares.remove(0);
    }

    /**
     * Display the top item from the stack without removing it
     * @return the top item in the stack
     * @throws NoSuchElementException if the stack is empty
     */
    public T top()
    {
        if (squares.size() == 0)
            throw new NoSuchElementException();
        
            return squares.get(0);
    }

    /**
     * Find how many items are in the stack
     * @return the number of items in the stack
     */
    public int size()
    {
        return squares.size();
    }

    /**
     * Determine if the stack is empty
     * @return true if the size is 0, false otherwise
     */
    public boolean isEmpty()
    {
        return squares.size() == 0;
    }

    /**
     * Clear out the data structure
     */
    public void clear()
    {
        squares = new ArrayList<T>();
    }

}