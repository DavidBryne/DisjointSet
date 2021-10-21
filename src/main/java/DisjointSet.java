import java.io.*;
import java.util.*;


public class DisjointSet {
    Map<Object, Object> rank = new HashMap<>();
    Map<Object, Object> parent = new HashMap<>();

    //Make a new set
    public Object makeSet(Object x){
        return null;
    }
    //Combine two disjoint sets to create a new set
    public void union(Set x, Set y) {
    }

    //Print the content of the set
    public static void printSet(DisjointSet dS){

    }

    //Find what set a particular member is in
    public Object findSet(Object x){
        //If x is not the root
        if (parent.get(x) != x) {
            parent.put(x, findSet(parent.get(x)));
        }
        return parent.get(x);
    }


    public static void main(String[] args){

    }
}
