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

        try {
            vectorArray.addObject(1, "Object4");
        }catch(IndexOutOfBoundsException ex) {
            ex.printStackTrace();
        }

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

        try {
            System.out.println(vectorArray.elementAt(1).toString());
        }catch(IndexOutOfBoundsException ex) {
            ex.printStackTrace();
        }

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
