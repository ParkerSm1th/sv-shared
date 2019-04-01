package me.chasertw123.minigames.shared.config;

import net.md_5.bungee.api.ChatColor;
import org.bson.Document;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ServerConfiguration {

    private static final String SERVER_URL = "http://hiett.digital/minecraft/?authcode=C823AE65C85A8FC9965B2D0F499086A475119" +
            "853D257C0486B4F0B6912C1E6614CE88CE250A81748E07639D4D31F2895FFEF8E51AC0810834AE8E47F97EE25E3";

    // MYSQL LOGIN INFO
    private String sqlUsername, sqlPassword, sqlHost, sqlDatabase;
    private int sqlPort;

    // MONGO LOGIN INFO
    private String mongoUsername, mongoPassword, mongoHost, mongoDatabase;
    private int mongoPort;

    // SERVER INFO
    private String prefix, sbTitle, sbNormalFormat, sbHighligtedFormat;

    // BOSS BAR MESSAGES
    private HashMap<String, String[]> bossBarMessages;

    public ServerConfiguration() {
        try {

            Scanner scanner = new Scanner(new URL(SERVER_URL).openStream());

            StringBuilder sb = new StringBuilder();
            while(scanner.hasNext()) {
                sb.append(scanner.next());
                sb.append(" ");
            }

            Document document = Document.parse(sb.toString());
            Document databases = (Document) document.get("databases");

            Document sqlInfo = (Document) databases.get("sql");
            this.sqlUsername = sqlInfo.getString("username");
            this.sqlPassword = sqlInfo.getString("password");
            this.sqlHost = sqlInfo.getString("host");
            this.sqlPort = sqlInfo.getInteger("port");
            this.sqlDatabase = sqlInfo.getString("database");

            Document mongoInfo = (Document) databases.get("mongo");
            this.mongoUsername = mongoInfo.getString("username");
            this.mongoPassword = mongoInfo.getString("password");
            this.mongoHost = mongoInfo.getString("host");
            this.mongoPort = mongoInfo.getInteger("port");
            this.mongoDatabase = mongoInfo.getString("database");

            Document serverInfo = (Document) document.get("server-info");
            this.prefix = ChatColor.translateAlternateColorCodes('&', serverInfo.getString("prefix"));

            Document sbInfo = (Document) serverInfo.get("sb-title");
            this.sbTitle = sbInfo.getString("name");
            this.sbNormalFormat = ChatColor.translateAlternateColorCodes('&', sbInfo.getString("normal-format"));
            this.sbHighligtedFormat = ChatColor.translateAlternateColorCodes('&', sbInfo.getString("highlight-format"));

            Document bossBar = (Document) document.get("boss-bar");
            this.bossBarMessages = new HashMap<>();
            for (String key : bossBar.keySet()) {

                List<String> animations = new ArrayList<>();
                for (String values : (List<String>) bossBar.get(key))
                    animations.add(ChatColor.translateAlternateColorCodes('&', values));

                this.getBossBarMessages().put(key, animations.toArray(new String[animations.size()]));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getSqlUsername() {
        return sqlUsername;
    }

    public String getSqlPassword() {
        return sqlPassword;
    }

    public String getSqlHost() {
        return sqlHost;
    }

    public int getSqlPort() {
        return sqlPort;
    }

    public String getSqlDatabase() {
        return sqlDatabase;
    }

    public String getMongoUsername() {
        return mongoUsername;
    }

    public String getMongoPassword() {
        return mongoPassword;
    }

    public String getMongoHost() {
        return mongoHost;
    }

    public int getMongoPort() {
        return mongoPort;
    }

    public String getMongoDatabase() {
        return mongoDatabase;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getScoreboardTitle() {
        return sbTitle;
    }

    public String getScoreboardNormalFormat() {
        return sbNormalFormat;
    }

    public String getScoreboardHighligtedFormat() {
        return sbHighligtedFormat;
    }

    public HashMap<String, String[]> getBossBarMessages() {
        return bossBarMessages;
    }
}
