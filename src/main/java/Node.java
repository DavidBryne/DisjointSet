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
    private int value;
    private Node parent;
    
    public Node(){
        value = -1;
        parent = null;
    }
    
    public Node(int v, Node p){
        value = v;
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
}
