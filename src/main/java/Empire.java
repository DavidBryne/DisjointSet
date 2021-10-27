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
    private Node[] monarchies;
    private int numSets;
    int N;
    int M;
    int K;
    
    public Empire(int n, int m, int k){
        N = n;
        M = m;
        K = k;
        monarchies = new Node[n*m*k];
        numSets = 0;
    }
    
    public void addSet(int i){
        int n = i % N;
        int m = ((i-n)/N) % M;
        int k = (i - n - m * N)/ M * N;
        
        Node rep;
        
        if(monarchies[i] == null){
            monarchies[i] = new Node();          
            DisjointSet.makeSet(monarchies[i]);
            numSets++;
        }
        rep = DisjointSet.findSet(monarchies[i]);
        
        //Check n direction
        if(n - 1 > 0){
            checkAndUnion(rep, monarchies[coordToIndex(n - 1, m, k)]);
        }
        if(n + 1 < N){
            checkAndUnion(rep, monarchies[coordToIndex(n + 1, m, k)]);
        }
        //Check m direction
        if(m - 1 > 0){
            checkAndUnion(rep, monarchies[coordToIndex(n, m - 1, k)]);
        }
        if(m + 1 < M){
            checkAndUnion(rep, monarchies[coordToIndex(n, m + 1, k)]);
        }
        //Check k direction
        if(k - 1 > 0){
            checkAndUnion(rep, monarchies[coordToIndex(n, m, k - 1)]);
        }
        if(k + 1 < K){
            checkAndUnion(rep, monarchies[coordToIndex(n, m, k + 1)]);
        }
        
    }
    
    private void checkAndUnion(Node a, Node b){
        if(a != null && b != null && a != b){
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
