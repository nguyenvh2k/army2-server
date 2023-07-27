package me.logjava.army2.fight.bullet;

import me.logjava.army2.fight.Bullet;
import me.logjava.army2.fight.BulletManager;
import me.logjava.army2.fight.Player;
import me.logjava.army2.server.ServerManager;
import me.logjava.army2.server.Until;

import java.util.ArrayList;

/**
 *
 * @author văn tú
 * @maintain Hoàng Nguyên
 */
public class BigRocKet extends Bullet {

    private short toX;
    private boolean flyshoot;

    public BigRocKet(BulletManager bullMNG, byte bullId, int satThuong, Player pl) {
        super(bullMNG, bullId, satThuong, pl, pl.X, pl.Y - (pl.height + 12), 0, -50, 0, 0);
        super.g100 = 80;
        ArrayList<Short> ar = new ArrayList();
        for (int i = 0; i < ServerManager.maxPlayers; i++) {
            if (this.fm.players[i] != null && !this.fm.players[i].isDie) {
                ar.add(this.fm.players[i].X);
            }
        }
        this.toX = ar.get(Until.nextInt(ar.size()));
        this.flyshoot = true;
    }

    @Override
    public void nextXY() {
        if (this.flyshoot) {
            this.vy = -50;
            if (this.Y < -1200) {
                vy = 0;
                for (byte i = 0; i < 21; i++) {
                    X = (short) (X - (pl.X - toX) / 20);
                    super.frame++;
                    this.XArray.add(X);
                    this.YArray.add(Y);
                }
                X = toX;
                this.flyshoot = false;
            }
        }
        super.nextXY();
    }

}
