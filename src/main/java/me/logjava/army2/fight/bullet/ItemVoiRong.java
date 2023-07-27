package me.logjava.army2.fight.bullet;

import me.logjava.army2.fight.Bullet;
import me.logjava.army2.fight.BulletManager;
import me.logjava.army2.fight.Player;

/**
 *
 * @author Văn Tú
 */
public class ItemVoiRong extends Bullet {

    public ItemVoiRong(BulletManager bullMNG, byte bullId, int satThuong, Player pl, int X, int Y, int vx, int vy, int msg, int g100) {
        super(bullMNG, bullId, satThuong, pl, X, Y, vx, vy, msg, g100);
        super.isCanCollision = false;
    }

    @Override
    public void nextXY() {
        super.nextXY();
        if (super.collect) {
            this.bullMNG.hasVoiRong = true;
            this.bullMNG.voiRongs.add(new BulletManager.VoiRong(X, Y, 3));
        }
    }

}
