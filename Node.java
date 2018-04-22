/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hecto
 */
public class Node {
    private Association key;
    private Node left, right;
    
    public Node(Association item){
        key = item;
        left = right = null;
    }
    
    public Association getKey(){
        return key;
    }
    
    public Node getLeft(){
        return left;
    }
    
    public Node getRight(){
        return right;
    }
    
    public void setLeft(Node i){
        left = i;
    }
    
    public void setRight(Node i){
        right = i;
    }
    
    public void setKey(Association i){
        key = i;
    }
}
