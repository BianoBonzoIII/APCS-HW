// Brian Lin 
// APCS1 pd0
// HW43 -- Array of Titanium
// 2017-11-29

/***************************
 * class SuperArray version 3.0
 * ( SKELETON )
 * Wrapper class for array. Facilitates resizing,
 * resizing
 * expansion
 * read/write capability on elements
 * adding an element to end of array
 * adding an element at specified index
 * removing an element at specified index
 *
 * ...and now SuperArray complies with the specifications of the
 * ListInt interface. (ListInt.java must be in same dir as this file)
 ***************************/

public class SuperArray implements ListInt
{

    private int[] _data;  //underlying container
    private int _size;    //number of elements in this SuperArray


    //default constructor ¡V initializes 10-item array
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
	int oldVal = _data[index];
	_data[index] = newVal;
	return oldVal;
    }


    //adds an item after the last item
    public boolean add( int newVal )
    {
	add( _size, newVal );
	return true;
    }


    //inserts an item at index
    public void add( int index, int newVal )
    {
	//first expand if necessary
	if ( _size >= _data.length )
	    expand();
	for( int i = _size; i > index; i-- ) {
	    _data[i] = _data[i-1]; //each slot gets value of left neighbor
	}
	_data[index] = newVal;
	_size++;
    }


    //removes the item at index
    //shifts elements left to fill in newly-empted slot
    public int remove( int index )
    {
	int output = _data[index];
	for( int i = index; i < _size - 1; i++ ) {
	    _data[i] = _data[i+1];
	}
	_size--;
	return output;
    }


    //return number of meaningful items in _data
    public int size()
    {
	return _data.length;
    }



    //main method for testing
    public static void main( String[] args )
    {
	ListInt mayfield = new SuperArray();
	System.out.println();
	
	System.out.println("================ ListInt add() =============");
	System.out.println("Printing empty SuperArray mayfield...");
	System.out.println(mayfield + "\n");
	System.out.println("ListInt Specificiation Test: Everything Shall Be True" );
	System.out.println(mayfield.add(5));
	System.out.println(mayfield.add(4));
	System.out.println(mayfield.add(3));
	System.out.println(mayfield.add(2));
	System.out.println(mayfield.add(1) + "\n");
	System.out.println("Printing populated SuperArray mayfield...");
	System.out.println(mayfield);
	System.out.println("=========================================\n");
	
	System.out.println("========= ListInt get() and set()===========");
	System.out.println("Printing first element of SuperArray mayfield...");
	System.out.println(mayfield.get(0) + "\n");
	System.out.println("Printing SuperArray mayfield pre-set...");
	System.out.println(mayfield + "\n");
	System.out.println("Value Replaced: " + mayfield.set(4, 20));
	System.out.println("Printing SuperArray mayfield post-set...");
	System.out.println(mayfield);
	System.out.println("=========================================\n");

	System.out.println("============== ListInt remove() =============");
	System.out.println("Printing SuperArray mayfield pre-remove...");
	System.out.println(mayfield + "\n");
	System.out.println("Value Removed: " + mayfield.remove(3) + "\n");
	System.out.println("Printing SuperArray mayfield post-remove...");
	System.out.println(mayfield);
	System.out.println("=========================================\n");

	System.out.println("========== ListInt add-at-index() ===========");
	mayfield.add(3,99);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield + "\n");
	mayfield.add(2,88);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield + "\n");
	mayfield.add(1,77);
	System.out.println("Printing SuperArray mayfield post-insert...");
	System.out.println(mayfield);
	System.out.println("=========================================\n");
	
	System.out.println("========== ListInt size() ===========");
	System.out.println("Number of Elements in SuperArray mayfield: " + mayfield.size());
	System.out.println("=========================================");
	
    }//end main()


}//end class

/***
             ,,########################################,,
          .*##############################################*
        ,*####*:::*########***::::::::**######:::*###########,
      .*####:    *#####*.                 :*###,.#######*,####*.
     *####:    *#####*                      .###########*  ,####*
  .*####:    ,#######,                        ##########*    :####*
  *####.    :#########*,                       ,,,,,,,,.      ,####:
    ####*  ,##############****************:,,               .####*
     :####*#####################################**,        *####.
       *############################################*,   :####:
        .#############################################*,####*
          :#####:*****#####################################.
            *####:                  .,,,:*****###########,
             .*####,                            *######*
               .####* :*#######*               ,#####*
                 *###############*,,,,,,,,::**######,
                   *##############################:
                     *####*****##########**#####*
                      .####*.            :####*
                        :####*         .#####,
                          *####:      *####:
                           .*####,  *####*
                             :####*####*
                               *######
                                 *##


    -Miranda Chaiken '16

***/
