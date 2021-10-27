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
    public int value;
    public int rank;
    public Node parent;
    
    public Node(){
        value = -1;
        rank = 0;
        parent = null;
    }
    
    public Node(int v, int r, Node p){
        value = v;
        rank = r;
        parent = p;
    } 
    
    public void setParent(Node p){
        parent = p;
    }
    
    public Node getParent(){
        return parent;
    }
    
    public void setValue(int v){
        value = v;
    }
    
    public int getValue(){
        return value;
    }
    
    public void setRank(int r){
        rank = r;
    }
    
    public int getRank(){
        return rank;
    }
}
