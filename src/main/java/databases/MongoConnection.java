package databases;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import static other.Constants.COSMOS_ADMIN_CACHE_MONGO_TEST_CONNECTION_STRING;

public class MongoConnection {

    public static void main(String[] args) {
        cosmosDBConnectionByMeTest();
    }

    private static void cosmosDBConnectionByMeTest() {

        MongoClient mongoClient = new MongoClient(new MongoClientURI(COSMOS_ADMIN_CACHE_MONGO_TEST_CONNECTION_STRING.getVariable()));

        MongoDatabase database = mongoClient.getDatabase("db");

        MongoIterable<String> dbCollections = database.listCollectionNames();
        System.out.println("Collection names: ");
        for (String i : dbCollections) {
            System.out.println(i);
        }

        System.out.println("- - - - -");

        MongoCollection<Document> collection = database.getCollection("eventlayers");
        Document queryResult = collection.find(Filters.eq("eventType", "CAMERA")).first();
        System.out.println("name: " + queryResult.get("name"));
        System.out.println("eventType: " + queryResult.get("eventType"));
        System.out.println("- - - - -");

        FindIterable<Document> queryResult2 = collection.find();
        for (Document i : queryResult2) {
            System.out.println(i.get("name"));
            System.out.println("- - - - -");
        }
    }
}