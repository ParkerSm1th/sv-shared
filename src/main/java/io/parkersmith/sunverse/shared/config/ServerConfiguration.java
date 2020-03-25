package io.parkersmith.sunverse.shared.config;

import net.md_5.bungee.api.ChatColor;


public class ServerConfiguration {

    private static final String SERVER_URL = "http://sunverse.parkersmith.io/creds/399jd9sdjasd29da-e2iduasd-23dasd";

    // MONGO LOGIN INFO
    private String mongoUsername, mongoPassword, mongoHost, mongoDatabase;
    private int mongoPort;

    // SERVER INFO
    private String prefix, sbTitle, sbNormalFormat, sbHighligtedFormat;

    public ServerConfiguration() {
        this.mongoUsername = "server";
        this.mongoPassword = "Qfpd36I1CbmvxKnj2ZsvRv5cvUChsT";
        this.mongoHost = "104.128.49.45";
        this.mongoPort = 27017;
        this.mongoDatabase = "Server";

        this.prefix = ChatColor.translateAlternateColorCodes('&', "&6&lSV &r&8» ");

        this.sbTitle = "Sunverse";
        this.sbNormalFormat = ChatColor.translateAlternateColorCodes('&', "&6");
        this.sbHighligtedFormat = ChatColor.translateAlternateColorCodes('&', "&c");
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

    public String getScoreboardHiglightedFormat() {
        return sbHighligtedFormat;
    }

}
