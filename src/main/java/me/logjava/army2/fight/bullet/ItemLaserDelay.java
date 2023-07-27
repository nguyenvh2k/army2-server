package me.logjava.army2.fight.bullet;

import me.logjava.army2.fight.Bullet;
import me.logjava.army2.fight.BulletManager;
import me.logjava.army2.fight.Player;

/**
 *
 * @author Văn Tú
 */
public class ItemLaserDelay extends Bullet {

    public ItemLaserDelay(BulletManager bullMNG, byte id, int satThuong, Player pl, int X, int Y) {
        super(bullMNG, id, satThuong, pl, X, Y, 0, 0, 0, 0);
    }

    @Override
    public void nextXY() {
        super.nextXY();
    }

}
