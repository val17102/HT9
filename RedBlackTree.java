/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USUARIO
 */
public class RedBlackTree {
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    
    private RBNode root;
    public RedBlackTree(){
        
    }
    
    public boolean isRed(RBNode x){
        if (x == null) return false;
        return x.getColor() == RED;
    }
    
    public int size(RBNode x){
        if (x == null) return 0;
        return x.getSize();
    }
    
    public int size(){
        return size(root);
    }
    
    public boolean isEmpty(){
        return root == null;
    }
    
    public RBNode rotateLeft(RBNode h){
        RBNode x = h.getRight();
        h.setRight(x.getLeft());
        x.setLeft(h);
        x.setColor(x.getLeft().getColor());
        x.getLeft().setColor(RED);
        x.setSize(h.getSize());
        h.setSize(size(h.getLeft())+size(h.getRight())+1);
        return x;
        
    }
    
     public RBNode rotateRight(RBNode h){
        RBNode x = h.getLeft();
        h.setLeft(x.getRight());
        x.setRight(h);
        x.setColor(x.getRight().getColor());
        x.getRight().setColor(RED);
        x.setSize(h.getSize());
        h.setSize(size(h.getLeft())+size(h.getRight())+1);
        return x;
        
    }
     
     public void cambiarColor(RBNode h){
         h.setColor(!h.getColor());
         h.getLeft().setColor(!h.getLeft().getColor());
         h.getRight().setColor(!h.getRight().getColor());
     }
    
   /** public RBNode get(RBNode root, Association a){
        RBNode r = null;
        if (root == null || root.getKey().getEnglish().compareTo(a.getEnglish())==0){
            return root;
        }
        
        if (root.getLeft() != null){
            r = get(root.getLeft(), a);
        }
        
        if (r == null)
            r = get(root.getRight(), a);
        
        return r;
    }
    
    public RBNode geti(Association a){
        return get(root,a);
    }
    */
    public RBNode get(RBNode x, Association a){
        while (x != null){
            int cmp = a.getEnglish().compareTo(x.getKey().getEnglish());
            if (cmp < 0) x = x.getLeft();
            if (cmp > 0) x = x.getRight();
            else return x;
        }
        return null;
    }
    
    public String geti(Association a){
        if (get(root, a) != null)
        return get(root, a).getKey().getSpanish();
        else return "*"+a.getEnglish()+"*";
    }
     
    public RBNode insertar(RBNode h, Association a){
        if (h == null) return new RBNode(a, RED, 1);
        int cmp = a.getEnglish().substring(0, 1).compareTo(h.getKey().getEnglish().substring(0, 1));
        if (cmp < 0) h.setLeft(insertar(h.getLeft(), a));
        else if (cmp > 0) h.setRight(insertar(h.getRight(), a));
        else h.setKey(a);
        
        if (isRed(h.getRight()) && !isRed(h.getLeft())) h = rotateLeft(h);
        if (isRed(h.getLeft()) && isRed(h.getLeft().getLeft())) h = rotateRight(h);
        if (isRed(h.getLeft()) && isRed(h.getRight())) cambiarColor(h);
        h.setSize(size(h.getLeft())+size(h.getRight())+1);
        return h;
        
    }
    
    public void insertar(Association a){
        root = insertar(root, a);
        root.setColor(BLACK);
    }
    
    public void inOrderRec(RBNode root){
        if(root != null){
            inOrderRec(root.getLeft());
            System.out.println(root.getKey().getEnglish()+" "+root.getKey().getSpanish());
            inOrderRec(root.getRight());
        }
    }
  
   public void inOrder(){
        inOrderRec(root);
    }
}
