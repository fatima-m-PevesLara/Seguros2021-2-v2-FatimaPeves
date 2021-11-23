package segurosxy.modelos.patrones;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import segurosxy.config.Connection;

import java.util.HashMap;

public class PaisFactory {

    private static HashMap<String, String> babyCache = new HashMap<String, String>();
    private static HashMap<String, PaisFlyweight> paises = new HashMap<String, PaisFlyweight>();

    private static PaisFactory paisFactory = null;

    public static synchronized PaisFactory getInstance() {
        if (paisFactory == null)  {

            paisFactory = new PaisFactory();
        }
        return paisFactory;
    }

    private PaisFactory(){

        if(babyCache.isEmpty()){
            System.out.println("[PaisFactory] Cargando data desde mongo");
            MongoDatabase db = new Connection().getDatabase();
            MongoCollection<Document> paises = db.getCollection("pais");
            MongoCursor<Document> cursor = paises.find().iterator();
            try {
                while(cursor.hasNext()) {
                    Document pai = cursor.next();
                    String codPai = (String) pai.get("cod_pais_inei");
                    String descPai = (String) pai.get("desc_pais_inei");

                    if (babyCache.get(codPai) == null){
                        babyCache.put(codPai, descPai);
                    }
                }
            } finally {
                cursor.close();
            }

        }
        System.out.println("[PaisFactory] Data obtenida de la cache");

    }

    public PaisFlyweight getPais(String codigoPais){

        PaisFlyweight flyweight = null;

        if ( paises.get(codigoPais)==null  )   {

            String dato = babyCache.get(codigoPais);
            flyweight = new PaisFlyweight(dato);
            paises.put(codigoPais, flyweight);
            System.out.println("[PaisFactory] Creando y recuperando los datos de PaisFlyweight");
        }
        else{
            flyweight = (PaisFlyweight)paises.get(codigoPais);
        }
        return flyweight;
    }
}
