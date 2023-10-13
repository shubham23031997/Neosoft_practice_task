package singlton;

class DbImpl {
    public static void main(String[] args) {
        DatabaseLayer databaseLayer = DatabaseLayer.getDb();
        DatabaseLayer databaseLayer1 = DatabaseLayer.getDb();
        System.out.println(databaseLayer);
        System.out.println(databaseLayer1);
    }
}
