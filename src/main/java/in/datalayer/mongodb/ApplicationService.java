package in.datalayer.mongodb;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;
import in.datalayer.mongodb.models.IndiaCitizen;
import in.datalayer.mongodb.models.UsaCitizen;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.List;

public class ApplicationService {
    private  ObjectMapper mapper = new ObjectMapper();

    public ApplicationService() {
        mapper.registerModule(new JavaTimeModule());
    }

    public void readDocuments(MongoCollection<Document> collection, List<Integer> _idList){
        Bson filter = Filters.in("_id",_idList);
        FindIterable<Document> fIterator = collection.find(filter);
        MongoCursor<Document> mCursor = fIterator.cursor();
        while(mCursor.hasNext()){
            Document document = mCursor.next();
            System.out.println("mongo document: " + document);
        }
    }

    public void addIndianCitizen(MongoCollection<Document> collection, Integer _id) throws JsonProcessingException {
        IndiaCitizen ic = prepareIndiaCitizen(_id);
        String json =  mapper.writeValueAsString(ic);
        collection.insertOne(Document.parse(json));
    }

    public void addUsaCitizen(MongoCollection<Document> collection, Integer _id) throws JsonProcessingException {
        UsaCitizen uc = prepareUsaCitizen(_id);
        String json =  mapper.writeValueAsString(uc);
        collection.insertOne(Document.parse(json));
    }

    private IndiaCitizen prepareIndiaCitizen(Integer _id){
        IndiaCitizen ic = new IndiaCitizen();
        ic.set_id(_id);
        ic.setDescriminator("Indian");
        ic.setAadharNo("AADHAR-102939-1092");
        ic.setName("Krishna Kumar");
        ic.setPassport("IND-393-4974");
        return ic;
    }

    private UsaCitizen prepareUsaCitizen(Integer _id){
        UsaCitizen uc = new UsaCitizen();
        uc.set_id(_id);
        uc.setName("Gopala Krishna");
        uc.setDescriminator("American");
        uc.setPassport("USA-3948-39383");
        uc.setSsn("135-09-1192");
        return uc;
    }
}
