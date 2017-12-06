/***************************
 * class SuperArray
 * Wrapper class for array. Facilitates resizing,
 * getting and setting element values.
 ***************************/

/*
  Brian Lin 
  APCS1 pd8 
  HW41 -- Array Of Steel 
  2017-11-27
 */
public class SuperArray
{

    private int[] _data;  //underlying container
    private int _size;    //number of elements in this SuperArray


    //default constructor - initializes 10-item array
    public SuperArray()
    {
	_data = new int[10];
	_size = _data.length;
    }


    //output SuperArray in [a,b,c] format
    public String toString()
    {
	String output = "[  ";
	for (int i = 0; i < _size; i++) {
	    output +=  this._data[i] + "  ";  
	}
	output += "]";
	return output;
    }
  

    
    //double capacity of SuperArray
    private void expand() {
	int oldLength = _size;
	_size *= 2;
	int[] goop = new int[_size];
	for (int i = 0; i < oldLength; i++) {
	    goop[i] = _data[i];
	}
	this._data = goop;
    }

    //accessor -- return value at specified index
    public int get( int index ) {
	return _data[index];
    }

    //mutator -- set value at index to newVal,
    //           return old value at index
    public int set( int index, int newVal ) {
	_data[index] = newVal;
	return newVal;
    }
    
    //main method for testing
    public static void main( String[] args )
    {
	SuperArray curtis = new SuperArray();
	System.out.println( "Printing empty SuperArray curtis..." );
	System.out.println( curtis );
	System.out.println("\n");

	for( int i = 0; i < curtis._data.length; i++ ) {
	    curtis.set( i, i * 2 );
	}

	System.out.println("Printing populated SuperArray curtis...");
	System.out.println(curtis);
	System.out.println("\n");

	for( int i = 0; i < 3; i++ ) {
	    curtis.expand();
	    System.out.println("Printing expanded SuperArray curtis...");
	    System.out.println(curtis);
	    System.out.println("\n");
	}
    }//end main()


}//end class
