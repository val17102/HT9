
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hecto
 */
public class Diccionario {
    
    private Association[] palabras = new Association[47];
    private SplayTree trees = new SplayTree();
    private RedBlackTree treer = new RedBlackTree();
    
    public Diccionario(){
        String[] palabrasSeparadas;
        int i = 0;

	//se separan las palabras
    File diccionario = new File(System.getProperty("user.dir")+"\\"+"diccionario.txt");
    try{
        
    FileReader leer = new FileReader(diccionario);
    BufferedReader buff = new BufferedReader(leer);
    String linea;
    while((linea = buff.readLine()) != null)
    {
   		palabrasSeparadas = linea.split(",");
                palabras[i] = new Association(palabrasSeparadas[0],palabrasSeparadas[1]);
               // System.out.println(i);
               // System.out.println(palabras[i].getEnglish());
                i++;
    }
    for (int j = 0; j< 47; j++){
            trees.insertar(palabras[j]);
            treer.insertar(palabras[j]);
        }
    }catch(IOException e){
        
    }
    }
    
    public String traducirS(String linea){
        String respuesta = "";
        String[] palabrasSeparadas = linea.split(" ");
        for (int i = 0; i< palabrasSeparadas.length; i++){
            if (trees.get(new Association(palabrasSeparadas[i]," ")).compareTo("*"+palabrasSeparadas[i]+"*")==0){
                respuesta = respuesta + trees.get(new Association(palabrasSeparadas[i]," ")) + " ";
            }else if (trees.get(new Association(palabrasSeparadas[i]," ")) != null )//&& palabrasSeparadas[i].compareTo(tree.buscare(palabrasSeparadas[i]).getKey().getSpanish())==0){
                respuesta = respuesta+trees.get(new Association(palabrasSeparadas[i]," ")) + " ";
            }//else{
             //   respuesta = respuesta+ tree.buscari(palabrasSeparadas[i]).getKey().getSpanish()+ " ";
            //}
        
        return respuesta;
    }
   
     public void mostrarInorderS(){
        trees.inOrder();
    }
     
     public void mostrarInorderR(){
        treer.inOrder();
    }
     
    public String traducirR(String linea){
        String respuesta = "";
        String[] palabrasSeparadas = linea.split(" ");
        for (int i = 0; i< palabrasSeparadas.length; i++){
            if (treer.geti(new Association(palabrasSeparadas[i]," ")).compareTo("*"+palabrasSeparadas[i]+"*") == 0){
                respuesta = respuesta + "*"+palabrasSeparadas[i]+"* ";
            //}else if (treer.geti(new Association(palabrasSeparadas[i]," ")) != null && palabrasSeparadas[i].compareTo(treer.geti(new Association(palabrasSeparadas[i],"")).getKey().getSpanish())==0){
            //    respuesta = respuesta+treer.geti(new Association(palabrasSeparadas[i]," ")) + " ";
            }else{
                respuesta = respuesta+ treer.geti(new Association(palabrasSeparadas[i]," "))+ " ";
            }
    }
         return respuesta;
    }
}
