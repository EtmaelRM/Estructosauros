package calculadora;

public class ColeccionVaciaExcepcion extends RuntimeException{

    public ColeccionVaciaExcepcion() {
        super();
    }

    public ColeccionVaciaExcepcion(String message) {
        super(message);
    }
    
    
    
}
