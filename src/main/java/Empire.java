/**
 * This class represents monarchies that seceded from COBOL
 *
 * @author Samuel Copeland & David-Bryne Adedeji
 * @version 1.0
 * File: Empire.java
 * Created October 27, 2021
 * @copyright Cedarville University, its Computer Science faculty, and the
 * authors.
 * Summary of Modifications:
 *
 * Description: Contains a 3d array of nodes from monarchies that have seceded
 * and keeps track of how many disjoint sets there are.
 */
public class Empire {
    //3d array of all nodes, starts out as null pointers and is updated as
    //monarchies secede in backwards order.
    private Node[][][] monarchies;
    private int numSets;
    int N;
    int M;
    int K;
    
    /**
     * Constructor method
     * 
     * @param n n dimension
     * @param m m dimension
     * @param k k dimension
     */
    public Empire(int n, int m, int k){
        //Set dimensions
        N = n;
        M = m;
        K = k;
        
        //Initialize the 3d array size
        monarchies = new Node[n][m][k];
        
        //The number of disjoint sets starts as 0
        numSets = 0;
        
    }
    
    /**
     * Adds a set and unions with any adjacent sets
     * 
     * @param i The index of the node to add
     */
    public void addSet(int i){
        
        //Convert the index to coordinates n, m, and k
        int n = i % N;
        int m = ((i-n)/N) % M;
        int k = (i - n - m * N)/ (M * N);
        
        //Add to 3d array
        monarchies[n][m][k] = new Node();          
        DisjointSet.makeSet(monarchies[n][m][k]);
        numSets++;
        Node rep = monarchies[n][m][k];
        
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
    
    /**
     * Unions sets and decrements disjoint set counter if conditions are
     * correct
     * 
     * @param a Node 1
     * @param b Node adjacent to Node 1
     */
    private void checkAndUnion(Node a, Node b){
        Node parentA;
        Node parentB;
        
        //If the nodes aren't null, continue
        if(a != null && b != null){
            //Find the roots of the two sets
            parentA = DisjointSet.findSet(a);
            parentB = DisjointSet.findSet(b);
        
            //If the root isn't already the same, union and decrement counter
            if(parentA != parentB){
                DisjointSet.union(parentA, parentB);
                numSets--;
            }
        }
    }
    
    /**
     * Returns the number of disjoint sets
     * 
     * @return the number of disjoint sets
     */
    public int getNumSets(){
        return numSets;
    }
}
