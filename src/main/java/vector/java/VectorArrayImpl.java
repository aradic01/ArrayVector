package vector.java;

import java.util.Arrays;

public class VectorArrayImpl implements VectorArray {

    private Object[] array;

    public VectorArrayImpl(int size) {
        array  = new Object[size];
    }

    @Override
    public boolean addObject(int index, Object element) {
        Object[] copyArray = new Object[array.length + 1];

        try {
            System.arraycopy(array, 0, copyArray, 0, index);
            copyArray[index] = element;

            System.arraycopy(array, index, copyArray, index + 1, array.length - index);
            array = copyArray;

        } catch(IndexOutOfBoundsException ex) {
            System.out.println(ex.getMessage());
        }
        return array[index].equals(element);
    }

    @Override
    public boolean add(Object o) {

        int newElementIndex = 0;

        for(int i = 0; i < array.length; i++) {
            if(array[i] == null) {
                array[i] = o;
                newElementIndex = i;
                break;
            }
        }
        return array[newElementIndex].equals(o);
    }

    @Override
    public Object elementAt(int index) {
        return array[index];
    }

    @Override
    public Object remove(int index) {

        Object[] copyArray = new Object[array.length - 1];
        Object removedObject = array[index];

        try {
            System.arraycopy(array, 0, copyArray, 0, index);
            System.arraycopy(array, index + 1, copyArray, index, array.length - index - 1);
            array = copyArray;

            return removedObject;
        } catch(IndexOutOfBoundsException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public boolean remove(Object o) {

        Object[] copyArray = new Object[array.length - 1];
        int indexOfElementToBeRemoved = 0;
        boolean objectExists = false;

        for(int i = 0; i < array.length; i++) {
            if(array[i].equals(o)) {
                indexOfElementToBeRemoved = i;
                break;
            }
        }

        try {
            System.arraycopy(array, 0, copyArray, 0, indexOfElementToBeRemoved);
            System.arraycopy(array, indexOfElementToBeRemoved + 1, copyArray, indexOfElementToBeRemoved, array.length - indexOfElementToBeRemoved - 1);
            array = copyArray;
        } catch(IndexOutOfBoundsException ex) {
            System.out.println(ex.getMessage());
        }finally {
            for(Object object : array) {
                try {
                    if (object.equals(o)) {
                        objectExists = true;
                        break;
                    }
                }catch(NullPointerException ex) {
                    break;
                }
            }
        }
        return !objectExists;
    }

    @Override
    public int size() {
        int counter = 0;

        for(Object object : array) {
            if(object != null) {
                counter++;
            }
        }
        return counter;
    }

    @Override
    public String toString() {
        return "VectorArrayImpl{" +
                "array=" + Arrays.toString(array) +
                '}';
    }

    @Override
    public Object[] getArray() {
        return array;
    }
}
