package segurosxy.modelos.patrones;

public class PaisContext {
    
    private String codigoPais;

    private PaisFlyweight flyweight;

    public PaisContext(String codigoPais) {

      //  this.flyweight = PaisFactory.getInstance().getPais(codigoPais);

        this.codigoPais = codigoPais;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getPais(){
        return this.flyweight.getPais();
    }
    
}
