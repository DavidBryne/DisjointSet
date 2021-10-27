/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author samue
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
