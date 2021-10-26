import java.io.*;
import java.util.*;

//Index formula: let n = n index, N = max n, etc.
//i = n + m * N + k * M * N

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


    public static void main(String[] args) throws IOException{
        java.io.InputStreamReader inputStream 
                = new InputStreamReader(System.in);
        java.io.BufferedReader stdin = new java.io.BufferedReader(inputStream);
        
        String nextLine = stdin.readLine();
        
        //Get the number of problems to solve.
        int numProblems = Integer.parseInt(nextLine);
        int N, M, K, l;
        for(int i = 0; i < numProblems; i++){            
            nextLine = stdin.readLine();
            
            //Get N, M, K, and L
            String[] strNums = nextLine.split(" ");
            
            N = Integer.parseInt(strNums[0]);
            M = Integer.parseInt(strNums[1]);
            K = Integer.parseInt(strNums[2]);
            l = Integer.parseInt(strNums[3]);
            
            //Iterate over the definitions of the new monarchies and store the
            //dominions of each monarcy in an array e.g. monarchies[0][1] would
            //represent the second dominion in the first monarchy.
            
        }
        
    }
}
