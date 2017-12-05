/***************************
 * interface List
 * Declares methods that will be implemented by any
 *  class wishing to adhere to this specification.
 * This interface specifies behaviors of a list of ints.
 ***************************/

public interface List
{
    // Return number of elements in the list
    int size();

    // Append an int to the end. Return true.
    public boolean add( Object x );

    // Inserts an item at index
    public void add( int index, Object x);
    
    // Retrieve the int at index
    public Object get( int index );

    // Overwrite the int at index
    public Object set( int index, Object x);

    // Removes the item at index
    // Shifts elements left to fill in newly-empted slot
    public Object remove( int index);
	
}//end interface ListInt
