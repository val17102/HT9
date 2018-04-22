/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USUARIO
 */
public class SplayTree {
   private Node root;
   
   public Node rotarR(Node h){
       Node x = h.getLeft();
       h.setLeft(x.getRight());
       x.setRight(h);
       return x;
   }
   
   public Node rotarL(Node h){
       Node x = h.getRight();
       h.setRight(x.getLeft());
       x.setLeft(h);
       return x;
   }
   
   public Node splay(Node h, Association a){
       if (h == null) return null;
       int cmp1 = a.getEnglish().substring(0, 1).compareTo(h.getKey().getEnglish().substring(0, 1));
       if (cmp1 < 0){
           if(h.getLeft() == null){
               return h;
           }
           int cmp2 = a.getEnglish().substring(0, 1).compareTo(h.getLeft().getKey().getEnglish().substring(0, 1));
           if(cmp2 < 0){
               h.getLeft().setLeft(splay(h.getLeft().getLeft(),a));
               h = rotarR(h);
           }else if(cmp2>0){
               h.getLeft().setRight(splay(h.getLeft().getRight(), a));
               if (h.getLeft().getRight() != null)
                   h.setLeft(rotarL(h.getLeft()));
           }
           if (h.getLeft() == null) return h;
           else return rotarR(h);
       }
       else if(cmp1 > 0){
           if (h.getRight() == null){
               return h;
           }
           int cmp2 = a.getEnglish().substring(0, 1).compareTo(h.getRight().getKey().getEnglish().substring(0, 1));
           if(cmp2 < 0){
               h.getRight().setLeft(splay(h.getRight().getLeft(),a));
               if(h.getRight().getLeft() != null)
                   h.setRight(rotarR(h.getRight()));
           }
           else if(cmp2 > 0){
               h.getRight().setRight(splay(h.getRight().getRight(),a));
               h = rotarL(h);
           }
           if (h.getRight() == null) return h;
           else return rotarL(h);
       }
       else return h;         
   }
   
   public void insertar(Association a){
       if (root == null){
           root = new Node(a);
           return;
       }
       
       root = splay(root,a);
       int cmp = a.getEnglish().substring(0, 1).compareTo(root.getKey().getEnglish().substring(0, 1));
       
       if (cmp < 0){
           Node n = new Node(a);
           n.setLeft(root.getLeft());
           n.setRight(root);
           root.setLeft(null);
           root = n;
       }else if(cmp > 0){
           Node n = new Node(a);
           n.setRight(root.getRight());
           n.setLeft(root);
           root.setRight(null);
           root = n;
       }else
           root.setKey(a);
       
   }
  public String get(Association a){
      root = splay(root, a);
      int cmp = a.getEnglish().compareTo(root.getKey().getEnglish());
      if (cmp == 0) return root.getKey().getSpanish();
      else return "*"+a.getEnglish()+"*";
  }
  
  public void inOrderRec(Node root){
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
