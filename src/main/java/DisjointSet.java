import java.io.*;
import java.util.*;

//Index formula: let n = n index, N = max n, etc.
//i = n + m * N + k * M * N

public class DisjointSet extends Node{

    //Make a new set
    public void makeSet(Node x){
        x.setParent(x);
        x.setRank(0);
    }
    //Combine two disjoint sets to create a new set
    public void union(Node x, Node y) {
        Node x_parent = findSet(x);
        Node y_parent = findSet(y);

        if(x_parent.getRank() > y_parent.getRank()){
            y_parent.setParent(x_parent);
        }
        else if(x_parent.getParent() == y_parent){
            if(x_parent.getRank() == y_parent.getRank()){
                y_parent.setRank(y_parent.getRank() + 1);
            }
        }
    }

    //Find what set a particular member is in
    public Node findSet(Node x){
        if(x != x.getParent()){
            setParent(findSet(x.getParent()));
        }
        return getParent();
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
        return 0;
    }


    public static void main(String[] args) throws IOException{
        java.io.InputStreamReader inputStream 
                = new InputStreamReader(System.in);
        java.io.BufferedReader stdin = new java.io.BufferedReader(inputStream);
        
        String nextLine = stdin.readLine();
        
        //Get the number of problems to solve.
        int numProblems = Integer.parseInt(nextLine);
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
