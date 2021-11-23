package segurosxy.modelos.patrones;

import segurosxy.modelos.interfaces.IInspeccion;

public class InspeccionFinanciera implements IInspeccion{
    
    private Double ingresos;
    private Double deuda;

    public InspeccionFinanciera(Double ingresos, Double deuda){
        this.ingresos = ingresos;
        this.deuda = deuda;
    }

    public boolean realizarInspeccion(){
        if(deuda <= (0.5*ingresos)){
            return true;
        }
        else{
            return false;
        }
    }
}
