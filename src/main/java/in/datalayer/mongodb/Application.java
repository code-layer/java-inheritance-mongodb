package in.datalayer.mongodb;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) throws JsonProcessingException {
        MongoClient mc = MongoConfig.getClient();
        MongoDatabase md = mc.getDatabase("mymongo");
        md.getCollection("test");
        MongoCollection<Document> collection = md.getCollection("test");

        ApplicationService service = new ApplicationService();

        Integer _id = 2001;
        service.addIndianCitizen(collection,_id);

        _id = 2002;
        service.addUsaCitizen(collection,_id);

        List<Integer> _idList = new ArrayList<>();
        _idList.add(2001);
        _idList.add(2002);
        service.readDocuments(collection,_idList);
    }

}