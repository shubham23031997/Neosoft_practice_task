package singlton;

public class DatabaseLayer {
    private static volatile DatabaseLayer db;

    private DatabaseLayer() {

    }

    public static DatabaseLayer getDb() {
        return db;
    }
}


