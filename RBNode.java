/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USUARIO
 */
public class RBNode {
    private Association key;
    private RBNode left, right;
    private boolean color;
    private int size;
    
    public RBNode(Association a, boolean c, int s){
        key = a;
        color = c;
        size = s;
        left = right = null;
    }
    
    public Association getKey(){
        return key;
    }
    
    public RBNode getLeft(){
        return left;
    }
    
    public RBNode getRight(){
        return right;
    }
    
    public void setLeft(RBNode i){
        left = i;
    }
    
    public void setRight(RBNode i){
        right = i;
    }
    
    public void setKey(Association i){
        key = i;
    }
    
    public void setSize(int i){
        size = i;
    }
    
    public void setColor(boolean b){
        color = b;
    }
    
    public boolean getColor(){
        return color;
    }
    
    public int getSize(){
        return size;
    }
}
