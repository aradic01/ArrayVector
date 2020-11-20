package main;

import vector.java.VectorArray;
import vector.java.VectorArrayImpl;

public class Application {
    public static void main(String[] args) {

        VectorArray vectorArray = new VectorArrayImpl(10);

        vectorArray.add("Object1");
        vectorArray.add("Object2");
        vectorArray.add("Object3");

        for(Object object : vectorArray.getArray()) {
            try {
                System.out.println(object.toString());
            }catch(NullPointerException ex) {
                break;
            }
        }

        System.out.println();

        vectorArray.addObject(1, "Object4");

        for(Object object : vectorArray.getArray()) {
            try {
                System.out.println(object.toString());
            }catch(NullPointerException ex) {
                break;
            }
        }

        System.out.println();

        vectorArray.remove(2);

        for(Object object : vectorArray.getArray()) {
            try {
                System.out.println(object.toString());
            }catch(NullPointerException ex) {
                break;
            }
        }

        System.out.println();

        //try-catch
        System.out.println(vectorArray.elementAt(1).toString());

        System.out.println();

        vectorArray.remove("Object3");

        for(Object object : vectorArray.getArray()) {
            try {
                System.out.println(object.toString());
            }catch(NullPointerException ex) {
                break;
            }
        }

        System.out.println();
        System.out.println(vectorArray.size());
    }
}
