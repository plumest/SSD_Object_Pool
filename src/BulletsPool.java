public class BulletsPool {
    private static BulletsPool instance;

    private BulletsPool() {}

    public static BulletsPool getInstance() {
        if (instance == null) {
            instance = new BulletsPool();
        }
        return instance;
    }
}
