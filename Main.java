
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hecto
 */
public class Main {
     public static void main(String[] args) {
        Diccionario m = new Diccionario();
        boolean x = true;
        Scanner sc = new Scanner(System.in);
        String respuesta = "";
        while(x){
            
            System.out.println("MENU");
            System.out.println("1. SplayTree");
            System.out.println("2. RedBlackTree");
            System.out.println("3. Salir");
            int ope =  sc.nextInt();
            if (ope == 1){
                while(ope == 1){
                    System.out.println("MENU");
                    System.out.println("1. Mostrar InOrder");
                    System.out.println("2. Traducir");
                    System.out.println("3. Salir");
                    int ope1 = sc.nextInt();
                    if (ope1 == 1){
                        m.mostrarInorderS();
                        ope1 = 0;
                    }
                    if (ope1 == 2){
                        System.out.println("Traduccion SplayTree");
                  File texto = new File(System.getProperty("user.dir")+"\\"+"texto.txt");
            try{
                  FileReader leer = new FileReader(texto);
                  BufferedReader buff = new BufferedReader(leer);
                  String linea;
                  while((linea = buff.readLine()) != null)
                  {
                      System.out.println("Original: "+linea);
                      System.out.println(m.traducirS(linea));
                      
                  }
            }catch(IOException e){
        
            }
                ope1 = 0;
                  }
            if (ope1 == 3)
                ope = 0;
                    }
                }
            if (ope == 2){
                while(ope == 2){
                    System.out.println("MENU");
                    System.out.println("1. Mostrar InOrder");
                    System.out.println("2. Traducir");
                    System.out.println("3. Salir");
                    int ope2 = sc.nextInt();
                    if (ope2 == 1){
                        m.mostrarInorderR();
                        ope2 = 0;
                    }
                    if (ope2 == 2){
                        System.out.println("Traduccion RedBlackTree");
                  File texto = new File(System.getProperty("user.dir")+"\\"+"texto.txt");
            try{
                  FileReader leer = new FileReader(texto);
                  BufferedReader buff = new BufferedReader(leer);
                  String linea;
                  while((linea = buff.readLine()) != null)
                  {
                      System.out.println("Original: "+linea);
                      System.out.println(m.traducirS(linea));
                      
                  }
            }catch(IOException e){
        
            }
                ope2 = 0;
                  }
            if (ope2 == 3)
                ope = 0;
                    }
                }
            if (ope == 3){
                x = false;
            }
            }
         //m.mostrarInorder();
         //System.out.println(m.traducir("the dog toma water adentro de su house"));
         /**
         BinarySearchTree tree = new BinarySearchTree();
         Association a1 = new Association("dog","perro");
         Association a2 = new Association("homework","tarea");
         Association a3 = new Association("house","casa");
         Association a4 = new Association("town","pueblo");
         Association a5 = new Association("woman","mujer");
         tree.insert(a1);
         tree.insert(a2);
         tree.insert(a3);
         tree.insert(a4);
         tree.insert(a5);
         tree.inOrder();
         * */
     }
}
