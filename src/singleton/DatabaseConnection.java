package singleton;

/**
 * CREATIONAL - Singleton Pattern.
 * Guarantees only ONE database connection exists for the entire application.
 * Any class that needs the DB calls getInstance() and always gets the same object.
 */
public class DatabaseConnection {
    private static DatabaseConnection instance;
    private String  connectionUrl;
    private boolean connected;

    private DatabaseConnection() {
        this.connectionUrl = "jdbc:mysql://localhost:3306/bus_reservation";
        this.connected     = true;
        System.out.println("[Singleton] DB connection created: " + connectionUrl);
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public boolean isConnected()        { return connected; }
    public String  getConnectionUrl()   { return connectionUrl; }

    public void query(String sql) {
        System.out.println("  [DB Query] " + sql);
    }
}
