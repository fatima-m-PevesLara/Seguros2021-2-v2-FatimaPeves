package segurosxy.modelos.patrones;

import java.util.ArrayList;

import segurosxy.modelos.Seguro;
import segurosxy.modelos.interfaces.IReporteSeguroArray;

public class ReporteSeguroCSVtoArray implements IReporteSeguroArray{
    
    private ReporteSeguroCSV adaptee;

    public ArrayList<Seguro> leerReporteSeguro(){
        
        ArrayList<Seguro> seguros = convertirCSVToArray();
        return seguros;
    }

    private ArrayList<Seguro> convertirCSVToArray(){
        //Revise el reporte de Seguro en formato CSV
        adaptee.emitirReporteSeguroCSV();
        //Convierte CSV a ArrayList
        return null; // Debería retornar un ArrayList de Seguros (reporte en formato Array)
    }

}
