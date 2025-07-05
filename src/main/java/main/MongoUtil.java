// Import MongoDB client interfaces (MongoClient, MongoDatabase, etc.)
package main;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoUtil {

    // MongoDB connection string (replace with your actual Atlas URI)
    private static final String URI = "mongodb+srv://sujoy:sujoy2025@cluster0.vmtjnbd.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";

    // Name of the MongoDB database
    private static final String DB_NAME = "BankDB";

    // Name of the collection inside the database
    private static final String COLLECTION_NAME = "accounts";

    // This will hold the collection reference so we can insert documents
    private static MongoCollection<Document> collection;

    // 🔁 Static block runs once when the class is first loaded
    static {
        // Create a MongoDB client using the URI
        MongoClient client = MongoClients.create(URI);

        // Get a reference to the database named "BankDB"
        MongoDatabase database = client.getDatabase(DB_NAME);

        // Get a reference to the "accounts" collection in the database
        collection = database.getCollection(COLLECTION_NAME);
    }

    // Public method to save an Account object to the MongoDB collection
    public static void saveAccount(Account acc) {

        // Create a MongoDB document with all fields from the Account object
        Document doc = new Document("accountNumber", acc.getAccountNumber())
            .append("name", acc.getName())
            .append("dob", acc.getDob())
            .append("address", acc.getAddress())
            .append("state", acc.getState())
            .append("pinCode", acc.getPinCode())
            .append("phone", acc.getPhone())
            .append("maritalStatus", acc.getMaritalStatus())
            .append("balance", acc.getBalance());

        // Insert the document into the MongoDB collection
        collection.insertOne(doc);
    }

    // Fetch all accounts from MongoDB and return as a List of Account objects
    public static List<Account> getAllAccounts() {
    List<Account> accounts = new ArrayList<>();
    FindIterable<Document> docs = collection.find();

    for (Document doc : docs) {
        Account acc = new Account(
            doc.getString("name"),
            doc.getInteger("accountNumber"),
            doc.getDouble("balance"),
            doc.getString("dob"),
            doc.getString("address"),
            doc.getString("state"),
            doc.getString("pinCode"),
            doc.getString("phone"),
            doc.getString("maritalStatus")
        );
        accounts.add(acc);
    }

    return accounts;
}

}
