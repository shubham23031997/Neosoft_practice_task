package singlton;

public class DatabaseLayer {
    private static volatile DatabaseLayer db;

    private DatabaseLayer() {

    }

    public static DatabaseLayer getDb() {
        return db;
    }
}

class DbImpl {
    public static void main(String[] args) {
        DatabaseLayer databaseLayer = DatabaseLayer.getDb();
        DatabaseLayer databaseLayer1 = DatabaseLayer.getDb();
        System.out.println(databaseLayer);
        System.out.println(databaseLayer1);
    }
}
