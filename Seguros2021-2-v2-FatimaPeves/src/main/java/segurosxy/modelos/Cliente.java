package segurosxy.modelos;

import java.util.ArrayList;
import java.util.List;

import segurosxy.modelos.patrones.PaisContext;
import segurosxy.modelos.patrones.UbigeoContext;

public class Cliente {

    private String nombre;
    private UbigeoContext ubigeoCasa;
    private UbigeoContext ubigeoTrabajo;
    private PaisContext paisDomicilio;
    private PaisContext paisNacimiento;
    private List<Seguro> seguros;

    public Cliente(String nombre)   {

        this.nombre = nombre;
        this.seguros = new ArrayList<Seguro>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCompraSeguro(Seguro seguro) {

        this.seguros.add( seguro );
    }

    public void getListaSeguroCliente()    {

        System.out.println("Nombre: " + this.nombre );
        for (Seguro seguro : seguros )  {

            System.out.println( "Seguro: " + seguro.getDetalleSeguro());
        }

    }

    public UbigeoContext getUbigeoCasa() {
        return ubigeoCasa;
    }

    public void setUbigeoCasa(UbigeoContext ubigeoCasa) {
        this.ubigeoCasa = ubigeoCasa;
    }

    public UbigeoContext getUbigeoTrabajo() {
        return ubigeoTrabajo;
    }

    public void setUbigeoTrabajo(UbigeoContext ubigeoTrabajo) {
        this.ubigeoTrabajo = ubigeoTrabajo;
    }

    public void printUbigeos(){
        if (ubigeoCasa!=null)
            System.out.println("[Ubigeo] Casa: "+ ubigeoCasa.getDepartamento() +", "+ ubigeoCasa.getProvincia() +", "+ ubigeoCasa.getDistrito());
        if (ubigeoTrabajo!=null)
            System.out.println("[Ubigeo] Trabajo: "+ ubigeoTrabajo.getDepartamento() +", "+ ubigeoTrabajo.getProvincia() +", "+ ubigeoTrabajo.getDistrito());
    }

    public PaisContext getPaisDomicilio() {
        return paisDomicilio;
    }

    public void setPaisDomicilio(PaisContext paisDomicilio) {
        this.paisDomicilio = paisDomicilio;
    }

    public PaisContext getPaisNacimiento() {
        return paisNacimiento;
    }

    public void setPaisNacimiento(PaisContext paisNacimiento) {
        this.paisNacimiento = paisNacimiento;
    }

    public void printPaises(){
        if (paisDomicilio!=null)
            System.out.println("[Pais] Domicilio: "+ paisDomicilio.getPais());
            if (paisNacimiento!=null)
            System.out.println("[Pais] Nacimiento: "+ paisNacimiento.getPais());
    }

}
