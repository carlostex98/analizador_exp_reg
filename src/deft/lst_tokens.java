package deft;

import java.util.LinkedList;

public class lst_tokens {
    LinkedList<String[]> item = new LinkedList<String[]>();
    //set de instrucciones
    LinkedList<String[]> grupos = new LinkedList<String[]>();//nombre, contenido
    
    public lst_tokens(){
        //algo jajaja
    }
    public void insertar(String tipo,String valor){
        String[] c={tipo,valor};
        item.add(c);
    }
    public void n_grupo(String nombre, String valor){
        String[] c={nombre,valor};
        item.add(c);
    }
    
}
