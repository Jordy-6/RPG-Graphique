package IHM.rpg.game;

import java.util.ArrayList;

public class GameInputs {

    private WeaponStore weaponStore;
    private Player player;

    public GameInputs() {
        this.player = new Player("", null);
        this.weaponStore = new WeaponStore();
    }

    public void setPlayerName(String n) {
        this.player.setName(n);
    }

    public void setPlayerCast(PlayerCast c) {
        this.player.setCast(c);
    }

    public WeaponStore getWeaponStore() {
        return this.weaponStore;
    }

    public void addWeapon(Weapons w) {
        this.player.buyWeapon(w);
    }

    public Player getPlayer() {
        return this.player;
    }

}
