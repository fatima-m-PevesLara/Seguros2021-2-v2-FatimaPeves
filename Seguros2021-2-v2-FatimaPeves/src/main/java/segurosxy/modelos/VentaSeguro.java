package segurosxy.modelos;

//import segurosxy.modelos.patrones.InspeccionDecorator;
import segurosxy.modelos.patrones.InspeccionFinanciera;
import segurosxy.modelos.patrones.InspeccionViviendaDecorador;
import segurosxy.modelos.patrones.InspeccionJudicialDecorator;
import segurosxy.modelos.patrones.InspeccionSaludDecorator;
import segurosxy.modelos.interfaces.IInspeccion;

public class VentaSeguro {
    
    public void inspeccionarCliente(){
       IInspeccion inspeccion = new InspeccionFinanciera(4500.00, 1638.00);
       boolean consulta1 = inspeccion.realizarInspeccion();

       inspeccion = new InspeccionViviendaDecorador(inspeccion, 350000.00);
       boolean consulta2 = inspeccion.realizarInspeccion();

       inspeccion = new InspeccionJudicialDecorator(inspeccion, "sinAntecedentes");
       boolean consulta3 = inspeccion.realizarInspeccion();

       inspeccion = new InspeccionSaludDecorator(inspeccion, "sano");
       boolean consulta4 = inspeccion.realizarInspeccion();

       System.out.println("El resultado de la inspeccion devuelve: ");
       resultadoInspeccionFinanciera(consulta1);
       resultadoInspeccionVivienda(consulta2);
       resultadoInspeccionJudicial(consulta3);
       resultadoInspeccionSalud(consulta4);
      
    }

    public void resultadoInspeccionFinanciera(boolean consulta){
        System.out.println("Inspeccion financiera aprobada");
    }

    public void resultadoInspeccionVivienda(boolean consulta){
        System.out.println("Inspeccion de vivienda aprobada");
    }

    public void resultadoInspeccionJudicial(boolean consulta){
        System.out.println("Inspeccion Judicial aprobada");
    }

    public void resultadoInspeccionSalud(boolean consulta){
        System.out.println("Inspeccion de Salud aprobada");
    }

}
