package segurosxy.modelos.patrones;

import segurosxy.modelos.interfaces.IInspeccion;

public class InspeccionJudicialDecorator extends InspeccionDecorator{

    private String situacionJudicial;

    public InspeccionJudicialDecorator(IInspeccion inspeccion, String situacionJudicial){
        super(inspeccion);
        this.situacionJudicial = situacionJudicial;
    }

    public boolean realizarInspeccion(){
        if (situacionJudicial == "sinAntecedentes"){
            return true;
        }
        else{
            return false;
        }
    }
}
