package deft;
public class lexico {
    public lexico(){
        //def de vars
    }
    
    public void expected_sims(){
        
    }
    
    
    public void scan_x(String cadena){
        int e=0;
        char c;
        String aux="";
        String op1="";
        String op2="";
        for (int i = 0; i < cadena.length()-1; i++) {
            c=cadena.charAt(i);
            switch(e){
                case 0:
                    //inicial
                    if(c=='/'&&cadena.charAt(i+1)=='/'){
                        //estado comentario
                        e=1;
                        i=i+1;
                    }else if(c=='<'&&cadena.charAt(i+1)=='!'){
                        e=2;
                        i=i+1;
                    }else if(Character.isLetter(c)){
                        aux+=c;
                        e=3;
                    }else if(c=='%'&&cadena.charAt(i+1)=='%'){
                        //otro estado jajaja
                    }
                    
                    
                    break;
                    
                case 1:
                    if(c=='\n'){
                        e=0;
                    }
                    break;
                    
                case 2:
                    if(c=='!'&&cadena.charAt(i+1)=='>'){
                        e=2;
                        i=i+1;
                    }//aca no manejamos error, puesto que solo se saldra de aca hasta que exista !>
                    break;
      
                case 3:
                    if(c==':'){
                        if(aux.trim().equalsIgnoreCase("CONJ")){//definicion de una conj
                            aux="";
                            e=4;
                        }else{
                            //error porque si!
                        }
                        
                        
                       /* //mandamos al estado simbolo
                    }else if(c==':'){//expected sims
                        //tiene que venir conj
                        if(aux.equalsIgnoreCase("CONJ")){
                            //pasamos al estado de conj para alamacenar
                            aux="";
                            e=4;
                        }*/
                    }
                    break;
                    
                case 4:
                    //despues de los dos puntos
                    if(c=='-'&&cadena.charAt(i+1)=='>'){
                        //ok
                        op1=op1.trim();
                        i=i+1;
                        e=5;
                    }else if(Character.isLetterOrDigit(c)||c!=' '||c!='\t'||c!='\n'){
                        //error
                    }else{
                        op1+=c;
                    }
                    break;
                    
                case 5:
                    if(c==';'){
                        principal.listas.n_grupo(op1, op2.trim());
                        op1 = op2 = "";
                        e=0;
                    }else if(c!=','||Character.isLetterOrDigit(c)||c!='~'||c!=' '||c!='\t'||c!='\n'){
                        //error
                    }else{
                        op2+=c;
                    }
                    break;
                    
                default:
                    break;
            }
            
            
        }
    }
    
    
}
