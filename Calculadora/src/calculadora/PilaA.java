package calculadora;

public class PilaA <T> implements PilaADT<T>{
    private T[] datosPila;
    private int tope;
    private final int MAXIMO=20;
    
    public PilaA() {
        datosPila= (T[]) new Object[MAXIMO];
        tope = -1; //Indica la pila vacía
    }

    @Override
    public void push(T dato) {
        if(tope==this.datosPila.length-1) //Pila esá llena
            expand();
        tope++;
        datosPila[tope]=dato;
    }
        
    private void expand(){
        T[] masGrande = (T[]) new Object[this.datosPila.length*2];
        
        for(int i=0; i<=tope; i++)
            masGrande[i]=datosPila[i];
        datosPila=masGrande;
    }

    @Override
    public T pop() {
        if(this.isEmpty())
            throw new ColeccionVaciaExcepcion("La pila está vacía");
        T resultado;
        
        resultado=this.datosPila[tope];
        this.datosPila[tope]=null;
        tope--;
        return resultado;
    }

    @Override
    public boolean isEmpty() {
        
        return tope==(-1);
    }

    @Override
    public T peek() {
        if(this.isEmpty())
            throw new ColeccionVaciaExcepcion("La pila está vacía");
        return this.datosPila[tope];
    }
    
    
    public String toString(){
        StringBuilder str = new StringBuilder();
        
        for(int i=tope; i<=0; i--)
            str.append(datosPila[i]).append("\n");
        return str.toString();
    }
    
}
