package IHM.rpg.game;

import java.util.ArrayList;

public class Player {

    private String name;
    private PlayerCast cast;

    protected ArrayList<IHM.rpg.game.Weapons> weapons;
    protected double money;
    protected double HP;

    public Player(String n, PlayerCast c) {
        this.name = n;
        this.cast = c;
        this.money = 50;
        this.weapons = new ArrayList<Weapons>();
        this.HP = 100.;
    }

    public String getName() {
        return this.name;
    }

    public PlayerCast getCast() {
        return this.cast;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCast(PlayerCast cast) {
        this.cast = cast;
    }

    public double getMoney() {
        return money;
    }
    public ArrayList<IHM.rpg.game.Weapons> getWeapons() {
        return this.weapons;
    }

    public double getHP(){
        return this.HP;
    }

    public String infoPlayer() {
        return "Name: " + this.name + " Cast : " + this.cast + " Money : "
                + this.money + "$  Life : " + this.HP + "HP" + " Weapons : " + this.weapons;
    }


    public void buyWeapon(Weapons w) {
        if (w.getPrice() <= this.money) {
            this.weapons.add(w);
            this.money -= w.getPrice();
        } else {
            System.out.println("Vous n'avez pas assez d'argent " +
                    "(Votre argent : " + this.money + " - prix de l'arme : " + w.getPrice());
        }
    }


}
