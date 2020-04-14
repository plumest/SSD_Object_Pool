import java.util.ArrayList;
import java.util.List;

public class BulletsPool {
    private static List<Bullet> _available = new ArrayList<Bullet>();
    private List<Bullet> _inUse = new ArrayList<Bullet>();

    private static BulletsPool instance;

    private BulletsPool() {}

    public static BulletsPool getInstance() {
        if (instance == null) {
            instance = new BulletsPool();
        }
        return instance;
    }

    public Bullet acquireReusable(int x, int y, int dx, int dy) {
        if (_available.size() != 0) {
            Bullet bullet = _available.get(0);
            bullet.setX(x);
            bullet.setY(y);
            bullet.setDx(dx);
            bullet.setDy(dy);
            _inUse.add(bullet);
            _available.remove(0);
            return bullet;
        } else {
            Bullet bullet = new Bullet(x, y, dx, dy);
            _inUse.add(bullet);
            return bullet;
        }
    }

    public void releaseReusable(Bullet bullet) {
        _available.add(bullet);
        _inUse.remove(bullet);
    }
}
