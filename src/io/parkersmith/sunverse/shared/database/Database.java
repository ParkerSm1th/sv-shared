package io.parkersmith.sunverse.shared.database;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.UpdateOptions;
import io.parkersmith.sunverse.shared.framework.ServerGameType;
import io.parkersmith.sunverse.shared.config.ServerConfiguration;
import org.bson.Document;

import java.util.Arrays;
import java.util.HashMap;

public class Database {

    private MongoClient client;
    private MongoDatabase database;

    private HashMap<Database.Collection, MongoCollection<Document>> dataCollections;
    private HashMap<String, MongoCollection<Document>> gameCollections;

    public Database(ServerConfiguration serverConfiguration) {

        dataCollections = new HashMap<>();
        gameCollections = new HashMap<>();

        try {
            MongoCredential credential = MongoCredential.createCredential(serverConfiguration.getMongoUsername(), "admin", serverConfiguration.getMongoPassword().toCharArray());
            client = new MongoClient(new ServerAddress(serverConfiguration.getMongoHost(), serverConfiguration.getMongoPort()), Arrays.asList(credential));
            database = client.getDatabase(serverConfiguration.getMongoDatabase());

        } catch (Exception e) {
            System.err.println("Unable to connect to one or more database(s)!");
        }
    }

    public MongoCollection<Document> getMongoCollection(Database.Collection collectionId) {
        if (!dataCollections.containsKey(collectionId))
            dataCollections.put(collectionId, database.getCollection(collectionId.id));

        return dataCollections.get(collectionId);
    }

    public MongoCollection<Document> getMongoCollection(ServerGameType gameType) {

        String id = gameType.getDisplay().replace(" ", "");

        if (!gameCollections.containsKey(id))
            gameCollections.put(id, database.getCollection(id));

        return gameCollections.get(id);
    }

    public static UpdateOptions upsert() {
        return new UpdateOptions().upsert(true);
    }

    public enum Collection {
        USERS("Users"),
        CORE_USER("Core"),
        HUB_USER("Hub"),
        INFRACTIONS("Infractions"),
        PUNISHMENTS("Punishments"),
        GAME_BOOSTERS("GameBoosters"),
        EVENT_BOOSTERS("EventBoosters"),
        SERVER_STATUS("ServerStatus"),
        CHAT_LOGS("ChatLogs"),
        GAME_DATA("GameData"),
        PLAYER_COUNTS("PlayerCounts");

        private String id;

        Collection(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }
    }

}
