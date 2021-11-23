package segurosxy.modelos.patrones;

import segurosxy.modelos.interfaces.IInspeccion;

public class InspeccionDecorator implements IInspeccion{
    
    protected IInspeccion inspeccion;

    public InspeccionDecorator(IInspeccion inspeccion){
        this.inspeccion = inspeccion;
    }

    public boolean realizarInspeccion(){
        return inspeccion.realizarInspeccion();
    }
}
