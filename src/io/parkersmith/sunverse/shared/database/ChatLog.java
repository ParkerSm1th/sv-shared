package io.parkersmith.sunverse.shared.database;

import org.bson.Document;

import java.util.UUID;

public class ChatLog {

    public enum ChatType {
        GENERAL(0), STAFF(1), PARTY(2), PM(3);

        private int id;

        ChatType(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }

    private Database database;

    public ChatLog(Database database) {
        this.database = database;
    }

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }

    public void logChatMessage(UUID sender, ChatType chatType, String message) {
        logChatMessage(database, sender, chatType, message);
    }

    public void logChatMessage(Database database, UUID sender, ChatType chatType, String message) {
        Document document = new Document();
        document.put("timestamp", System.currentTimeMillis());
        document.put("chattype", chatType.getId());
        document.put("sender", sender + "");
        document.put("message", message);
        database.getMongoCollection(Database.Collection.CHAT_LOGS).insertOne(document);
    }

    public void logPm(UUID sender, UUID to, String message) {
        logPm(database, sender, to, message);
    }

    public void logPm(Database database, UUID sender, UUID to, String message) {
        Document document = new Document();
        document.put("timestamp", System.currentTimeMillis());
        document.put("chattype", ChatType.PM.getId());
        document.put("sender", sender + "");
        document.put("to", to + "");
        document.put("message", message);
        database.getMongoCollection(Database.Collection.CHAT_LOGS).insertOne(document);
    }

}
