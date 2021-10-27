import java.io.*;
import java.util.*;

/**
 * This class contains all the main methods of the Disjoint Set, as well as the sort algorithm
 *
 * @author Samuel Copeland & David-Bryne Adedeji
 * @version 1.0
 * File: DisjointSet.java
 * Created October 27, 2021
 * @copyright Cedarville University, its Computer Science faculty, and the
 * authors.
 * Summary of Modifications:
 *
 * Description: PLS COMPLETE ONCE YOU ARE DONE MODIFYING
 */

//Index formula: let n = n index, N = max n, etc.
//i = n + m * N + k * M * N

public class DisjointSet{

    /**
     * Makes a new disjoint set with one node as its own root
     * 
     * @param x Node to put in set
     */
    public static void makeSet(Node x){
        x.setParent(x);
        x.setRank(0);
    }
    
    /**
     * Combines two disjoint sets into one set
     * 
     * @param x root of one set
     * @param y root of the other set
     */
    public static void union(Node x, Node y) {

        if(x.getRank() > y.getRank()){
            y.setParent(x);
        }
        else if(x.getRank() < y.getRank()){
            x.setParent(y);
        }
        else{
            x.setParent(y);
            y.setRank(y.getRank() + 1);
        }
    }

    //Find what set a particular member is in
    public static Node findSet(Node x){
        if(x != x.getParent()){
            x.setParent(findSet(x.getParent()));
        }
        return x.getParent();
    }
    
    /**
     * Solves a galactic breakup problem and returns the number of months
     * COBOL was separated.
     * 
     * @param monarchies A 2d int array of the dominions in each monarchy
     * in chronological order of secession.
     * @param N
     * @param M
     * @param K
     * 
     * @return number of months separated
     */
    public static int solve(int[][] monarchies, int N, int M, int K){
        int result = 0;
        Empire empire = new Empire(N, M, K);
        for(int i = monarchies.length - 1; i >= 0; i--){
            for(int j = 0; j < monarchies[i].length; j++){
                empire.addSet(monarchies[i][j]);
            }
            
            if(empire.getNumSets() > 1){
                
                result++;
            }
        }
        
        return result;
    }


    public static void main(String[] args) throws IOException{
        java.io.InputStreamReader inputStream 
                = new InputStreamReader(System.in);
        java.io.BufferedReader stdin = new java.io.BufferedReader(inputStream);
        
        String nextLine;// = stdin.readLine();
        
        //Get the number of problems to solve.
        int numProblems = 1;//Integer.parseInt(nextLine);
        int[] answers = new int[numProblems];
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
            int[][] monarchies = new int[l][];
            for(int j = 0; j < l; j++){
                nextLine = stdin.readLine();
                String[] dominionsAndNum = nextLine.split(" ");
                int num = Integer.parseInt(dominionsAndNum[0]);
                monarchies[j] = new int[num];
                for(int k = 1; k <= num; k++){
                    monarchies[j][k-1] = Integer.parseInt(dominionsAndNum[k]);
                }
            }
            
            answers[i] = solve(monarchies, N, M, K);
        }
        
        for(int i = 0; i < numProblems; i++){
            System.out.println(answers[i]);
        }
        
    }
}
