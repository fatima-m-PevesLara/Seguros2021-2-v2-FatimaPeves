package segurosxy;

import segurosxy.modelos.Cliente;
import segurosxy.modelos.Impresora;
import segurosxy.modelos.Poliza;
import segurosxy.modelos.SeguroTarjeta;
import segurosxy.modelos.SeguroVehicular;
import segurosxy.modelos.interfaces.ICobertura;
import segurosxy.modelos.interfaces.IImprimible;
import segurosxy.modelos.patrones.*;

public class App {

    public static void main( String[] args ) throws Exception
    {

        Cliente cliente = new Cliente("Juan Perez");

        SeguroVehicular seguro = new SeguroVehicular("Toyota","Yaris");
        seguro.cacularRiesgo();

        // Agregrando cobertura al seguro
        ICobertura cobertura = new CoberturaTodoRiesgoDecorator( new CoberturaPorRoboDecorator( new CoberturaBasicaVehicular() ) );
        seguro.calcularCobeturaVehicular( cobertura );

        cliente.setCompraSeguro(seguro);

        // Imprimiendo la Poliza
        //Poliza poliza = new Poliza(1111, cliente.getNombre(), cliente.getNombre() );
        //PolizaXML adaptadorXML = new PolizaXML(poliza);
        //Impresora.imprimir( adaptadorXML.armarSalidaTexto() );
        Impresora.imprimir( new PolizaXML(new Poliza(1111, cliente.getNombre(), cliente.getNombre())).armarSalidaTexto() );

        Impresora.imprimir( new PolizaJSON(2222, cliente.getNombre(), cliente.getNombre()).armarSalidaTexto() );

        SeguroTarjeta seguro2 = new SeguroTarjeta("BCP");
        seguro2.cacularRiesgo();
        cliente.setCompraSeguro(seguro2);

        cliente.getListaSeguroCliente();

        // Agregar Ubigeos para el cliente
        UbigeoContext ubigeoCasa = new UbigeoContext( "15", "01", "25");
        cliente.setUbigeoCasa( ubigeoCasa );
        UbigeoContext ubigeoTrabajo = new UbigeoContext( "15", "01", "25");
        cliente.setUbigeoTrabajo( ubigeoTrabajo );

        cliente.printUbigeos();


        SeguroVehicular seguro3 = new SeguroVehicular("Nissan","Sentra");
        ICobertura cobertura2 = new CoberturaPorChoqueDecorator( new CoberturaBasicaVehicular() );
        seguro3.calcularCobeturaVehicular( cobertura2 );
    }

}
