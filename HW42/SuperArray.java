// Bo-rian Luin 
// Brian Lin
// APCS1 pd8
// HW42 -- expanding SuperArray functionality, encapsulation
// 2017-11-29

/***************************
 * class SuperArray version 2.0
 * (SKELETON)
 * Wrapper class for array. Facilitates resizing,
 * resizing
 * expansion
 * read/write capability on elements
 * adding an element to end of array
 * adding an element at specified index
 * removing an element at specified index
 ***************************/

public class SuperArray
{

    private int[] _data;  //underlying container
    private int _size;    //number of elements in this SuperArray


    //default constructor - initializes 10-item array
    public SuperArray()
    {
	_data = new int[10];
	_size = 0;
    }


    //output SuperArray in [a,b,c] format
    public String toString()
    {
	String foo = "[";
	for( int i = 0; i < _size; i++ ) {
	    foo += _data[i] + ",";
	}
	if ( foo.length() > 1 )
	    //shave off trailing comma
	    foo = foo.substring( 0, foo.length()-1 );
	foo += "]";
	return foo;
    }


    //double capacity of SuperArray
    private void expand()
    {
	int[] temp = new int[ _data.length * 2 ];
	for( int i = 0; i < _data.length; i++ )
	    temp[i] = _data[i];
	_data = temp;
    }


    //accessor -- return value at specified index
    public int get( int index )
    {
	return _data[index];
    }


    //mutator -- set value at index to newVal,
    //           return old value at index
    public int set( int index, int newVal )
    {
	int temp = _data[index];
	_data[index] = newVal;
	return temp;
    }


    //adds an item after the last item
    public void add( int newVal )
    {
	_data[_size] = newVal; //assumes that there is no 0 b/w meaningful numbers
	_size+=1;  
    }


    //inserts an item at index
    public void add( int index, int newVal )
    {
	int[] temp = new int[ _data.length + 1 ];
	for( int i = 0; i < _data.length; i++ ) {
	    temp[i] = _data[i];
	}
	_data = temp;
	int oldVal = _data[index];
	for (int i = index; i < _data.length - 1; i++) { // Shifts all of the elements after the index one unit to the right
	    int nextVal = _data[i + 1];
	    _data[i + 1] = oldVal;
	    oldVal = nextVal;
	}
	_data[index] = newVal; // After the shift occurs, the value at index is replaced
    }


    //removes the item at index
    //shifts elements left to fill in newly-empted slot
    public void remove( int index )
    {
	int temp = set(index,0); //replaces value at index with placeholder, and saves old value
  	for(int i = index; i < _data.length - 1; i++ ){
	    _data[i] = _data[i+1];
	    if( i+1 == _data.length-1){
		_data[_data.length-1] = 0; //replaces last elem with 0, since everything was shifted left, but the last elem still needs a placeholder that is not meaningful
	    }

	}//ends loop
      
    }//ends remove


    //return number of meaningful items in _data. Assumes that 0 is not meaningful.
    public int size()
    {
    	int meaning = 0;
    	for (int i = 0; i < _data.length; i++) {
	    if (_data[i] > 0) {
        	meaning++;
	    }
	}
      	return meaning;
    }



    //main method for testing
    public static void main( String[] args )
    {
	  SuperArray curtis = new SuperArray();
	  System.out.println( "Printing empty SuperArray curtis..." );
	  System.out.println( curtis );
	  for( int i = 0; i < curtis._data.length; i++ ) {
	  curtis.set( i, i * 2 );
	  }
	  System.out.println("Printing populated SuperArray curtis...");
	  System.out.println(curtis);
	  for( int i = 0; i < 3; i++ ) {
	  curtis.expand();
	  System.out.println("Printing expanded SuperArray curtis...");
	  System.out.println(curtis);
	  System.out.println("new length of underlying array: "
	  + curtis._data.length );
	  }
	  SuperArray mayfield = new SuperArray();
	  System.out.println("Printing empty SuperArray mayfield...");
	  System.out.println(mayfield);
	  mayfield.add(5);
	  mayfield.add(4);
	  mayfield.add(3);
	  mayfield.add(2);
	  mayfield.add(1);
	  System.out.println("Printing populated SuperArray mayfield...");
	  System.out.println(mayfield);
	  mayfield.remove(3);
	  System.out.println("Printing SuperArray mayfield post-remove...");
	  System.out.println(mayfield);
	  mayfield.remove(3);
	  System.out.println("Printing SuperArray mayfield post-remove...");
	  System.out.println(mayfield);
	  mayfield.add(3,99);
	  System.out.println("Printing SuperArray mayfield post-insert...");
	  System.out.println(mayfield);
	  mayfield.add(2,88);
	  System.out.println("Printing SuperArray mayfield post-insert...");
	  System.out.println(mayfield);
	  mayfield.add(1,77);
	  System.out.println("Printing SuperArray mayfield post-insert...");
	  System.out.println(mayfield);
    }//end main()


}//end class
