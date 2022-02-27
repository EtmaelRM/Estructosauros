package calculadora;


public class Algoritmos {
    
    private boolean esOperando(String s){
        boolean res;
        
        try{
            Double.parseDouble(s);
            res=true;
        }catch(Exception e){
            res=false;
        }
        return res;
    }
    
    private static int getPrioridad(char elem){
        int prioridad;
        
        switch(elem){
            case '+':
                prioridad=1;
                break;
            case '-':
                prioridad=1;
                break;
            case '*':
                prioridad=2;
                break;
            case '/':
                prioridad=2;
                break;
            default :
                prioridad=-1;
                break;
        }
        return prioridad;
    }
    
    public static String infijaAPostfija(String infija){
        String postfija;
        char elem;
        int prioridad;
        PilaA pila;
        
        postfija="";
        pila=new PilaA();
        for(int i=0; i<infija.length(); i++){
            elem=infija.charAt(i);
            if(elem>47&&elem<58)
                postfija+=elem;
            else
                if(elem=='(')
                    pila.push(elem);
                else
                    if(elem==')'){
                        while(!pila.isEmpty() && !pila.peek().equals('('))
                            postfija+=pila.pop();
                        pila.pop();
                    }else{
                        prioridad=getPrioridad(elem);
                        if(prioridad!=-1){
                            while(!pila.isEmpty() && prioridad<=getPrioridad((char)pila.peek()))
                                postfija+=pila.pop();
                            pila.push(elem);
                        }
                    }
        }
        while(!pila.isEmpty())
            postfija+=pila.pop();
        return postfija;
    }    
}
