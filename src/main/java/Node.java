/**
 *
 * @author Samuel Copeland & David-Bryne Adedeji
 * @version 1.0
 * File: DisjointSet.java
 * Created October 27, 2021
 * @copyright Cedarville University, its Computer Science faculty, and the
 * authors.
 * Summary of Modifications:
 *
 * Description: This is the base data structure we use to access and modify the Disjoint Set (based on a linked-list)
 *
 */
public class Node {
    public int rank;
    public Node parent;
    
    public Node(){
        rank = 0;
        parent = null;
    }
    
    public Node(int r, Node p){
        rank = r;
        parent = p;
    } 
    
    public void setParent(Node p){
        parent = p;
    }
    
    public Node getParent(){
        return parent;
    }
    
    public void setRank(int r){
        rank = r;
    }
    
    public int getRank(){
        return rank;
    }
}
