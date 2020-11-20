package vector.java;

public interface VectorArray {
    boolean addObject (int index, Object element);
    boolean add (Object o);
    Object elementAt (int index);
    Object remove (int index);
    boolean remove (Object o);
    int size ();
    Object[] getArray(); //Declared for accessing from main method for demonstration purposes
    //it is usually implemented in Impl class
}
