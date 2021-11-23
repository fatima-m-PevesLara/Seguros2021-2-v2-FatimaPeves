package segurosxy.modelos.patrones;

import segurosxy.modelos.interfaces.IInspeccion;

public class InspeccionViviendaDecorador extends InspeccionDecorator{

    private Double valorVivienda;

    public InspeccionViviendaDecorador(IInspeccion inspeccion, Double valorVivienda){
        super(inspeccion);
        this.valorVivienda = valorVivienda;
    }
    
    public boolean realizarInspeccion(){
        if(valorVivienda >= 200000.00){
            return true;
        }
        else{
            return false;
        }
    }
}
