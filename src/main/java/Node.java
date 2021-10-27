/**
 * Node data structure that keeps track of it's rank
 * 
 * @author Samuel Copeland & David-Bryne Adedeji
 * @version 1.0
 * File: Node.java
 * Created October 27, 2021
 * @copyright Cedarville University, its Computer Science faculty, and the
 * authors.
 * Summary of Modifications:
 *
 * Description: This is the base data structure we use to access and modify the
 * Disjoint Set (based on a linked-list)
 *
 */
public class Node {
    public int rank;
    public Node parent;
    
    /**
     * Default constructor
     */
    public Node(){
        rank = 0;
        parent = null;
    }
    
    /**
     * Constructor
     * 
     * @param r initial rank
     * @param p initial parent pointer
     */
    public Node(int r, Node p){
        rank = r;
        parent = p;
    } 
    
    /**
     * Set a new parent pointer
     * 
     * @param p new parent
     */
    public void setParent(Node p){
        parent = p;
    }
    
    /**
     * Get the parent pointer
     * 
     * @return the parent pointer
     */
    public Node getParent(){
        return parent;
    }
    
    /**
     * Set the rank of the node
     * 
     * @param r rank
     */
    public void setRank(int r){
        rank = r;
    }
    
    /**
     * Return the rank of the node
     * 
     * @return rank
     */
    public int getRank(){
        return rank;
    }
}
