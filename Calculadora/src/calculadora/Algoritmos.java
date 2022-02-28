package calculadora;


public class Algoritmos {
    
    private static int getPrioridad(char elem){
        
        return switch (elem) {
            case '+' -> 1;
            case '-' -> 1;
            case '*' -> 2;
            case '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
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
            if(elem>47&&elem<58 || elem=='.')
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
                            while(!pila.isEmpty() && prioridad<=getPrioridad((char) pila.peek()))
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
