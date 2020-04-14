import java.util.ArrayList;
import java.util.List;

public class BulletsPool {
    private static List<Bullet> _available = new ArrayList<Bullet>();
    private List<Bullet> _inUse = new ArrayList<Bullet>();

    private int counter = 0;
    private int MAXTotalBullets;

    private static BulletsPool instance;

    private BulletsPool() {}

    public static BulletsPool getInstance() {
        if (instance == null) {
            instance = new BulletsPool();
        }
        return instance;
    }

    public Bullet acquireReusable() {
        if (_available.size() != 0 && _available.size() < 10) {
            Bullet bullet = _available.get(0);
            _inUse.add(bullet);
            _available.remove(0);
            counter--;
            return bullet;
        } else {
            Bullet bullet = new Bullet(0, 0, 1, 0);
            _inUse.add(bullet);
            return bullet;
        }
    }

    public void ReleaseReusable(Bullet bullet) {
        if (counter <= MAXTotalBullets) {
            _available.add(bullet);
            counter++;
            _inUse.remove(bullet);
        }
    }

    public void setMAXTotalBullets(int maxBullets) {
        MAXTotalBullets = maxBullets;
    }
}
