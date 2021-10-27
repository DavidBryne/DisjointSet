/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author samue
 */
public class Empire {
    private Node[][][] monarchies;
    private int numSets;
    int N;
    int M;
    int K;
    
    public Empire(int n, int m, int k){
        N = n;
        M = m;
        K = k;
        monarchies = new Node[n][m][k];
        numSets = 0;
        /*
        System.out.println("N = " + n);
        System.out.println("M = " + m);
        System.out.println("K = " + k);
        System.out.println("");
        */
        
    }
    
    public void addSet(int i){
        
        //System.out.println("i = " + i);
        
        int n = i % N;
        int m = ((i-n)/N) % M;
        int k = (i - n - m * N)/ (M * N);
        /*
        System.out.println("n = " + n);
        System.out.println("m = " + m);
        System.out.println("k = " + k);
        System.out.println("");
        */
        
       
        
        monarchies[n][m][k] = new Node();          
        DisjointSet.makeSet(monarchies[n][m][k]);
        numSets++;
        Node rep = monarchies[n][m][k];
        rep = DisjointSet.findSet(monarchies[n][m][k]);
        
        //Check n direction
        if(n - 1 >= 0){
            checkAndUnion(rep, monarchies[n-1][m][k]);
        }
        if(n + 1 < N){
            checkAndUnion(rep, monarchies[n+1][m][k]);
        }
        //Check m direction
        if(m - 1 >= 0){
            checkAndUnion(rep, monarchies[n][m-1][k]);
        }
        if(m + 1 < M){
            checkAndUnion(rep, monarchies[n][m+1][k]);
        }
        //Check k direction
        if(k - 1 >= 0){
            checkAndUnion(rep, monarchies[n][m][k-1]);
        }
        if(k + 1 < K){
            checkAndUnion(rep, monarchies[n][m][k+1]);
        }
        
        
    }
    
    private void checkAndUnion(Node a, Node b){
        if(a != null && b != null && DisjointSet.findSet(a) 
            != DisjointSet.findSet(b)){
            DisjointSet.union(a, b);
            numSets--;
        }
    }
    
    private int coordToIndex(int n, int m, int k){
        return n + m * N + k * M * N;
    }
    
    public int getNumSets(){
        return numSets;
    }
}
