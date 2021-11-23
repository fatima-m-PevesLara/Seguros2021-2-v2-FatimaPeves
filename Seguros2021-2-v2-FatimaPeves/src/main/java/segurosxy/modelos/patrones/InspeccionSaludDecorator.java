package segurosxy.modelos.patrones;

import segurosxy.modelos.interfaces.IInspeccion;

public class InspeccionSaludDecorator extends InspeccionDecorator {
    
    private String estadoSalud;

    public InspeccionSaludDecorator(IInspeccion inspeccion, String estadoSalud){
        super(inspeccion);
        this.estadoSalud = estadoSalud;
    }
      
    public boolean realizarInspeccion(){
        if (estadoSalud == "sano"){
            return true;
        }
        else{
            return false;
        }
    }
}
