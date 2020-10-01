package bswanepo.Model;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.validation.constraints.*;
@Entity
public class PlayerInfo implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @NotNull(message = "Name cannot be null.")
    private String name;
    @NotNull(message = "HeroClass cannot be null.")
    private String heroClass;
    @NotNull(message = "Level cannot be null.")
    private String level;
    @NotNull(message = "XP cannot be null.")
    private String xp;
    @NotNull(message = "Attack cannot be null.")
    private String attack;
    @NotNull(message = "Defense cannot be null.")
    private String defense;
    @NotNull(message = "Hit Points cannot be null.")
    private String hitPoints;
    @NotNull(message = "Weapons cannot be null.")
    private String weapons;
    @NotNull(message = "Armor cannot be null.")
    private String armor;
    @NotNull(message = "Helm cannot be null.")
    private String helm;
    public ArrayList<String> player = new ArrayList<>();

    public PlayerInfo(@NotNull String name, String heroClass, String level, String xp, String attack, String defense,
            String hitPoints, String weapons, String armor, String helm) {
        this.name = name;
        this.heroClass = heroClass;
        this.level = level;
        this.xp = xp;
        this.attack = attack;
        this.defense = defense;
        this.hitPoints = hitPoints;
        this.weapons = weapons;
        this.armor = armor;
        this.helm = helm;
    }

    public ArrayList<String> getPlayer(){

        if(!player.equals(null)){
            player.clear();
        }
        player.add(name);
        player.add(heroClass);
        player.add(level);
        player.add(xp);
        player.add(attack);
        player.add(defense);
        player.add(hitPoints);
        player.add(weapons);
        player.add(armor);
        player.add(helm);

        return player;
    }
    public String getName() {
        return name;
    }

    public String getHeroClass() {
        return heroClass;
    }

    public String getLevel() {
        return level;
    }
    public void setXp(String xp){
        this.xp = xp;
    }
    public void setLevel(String level){
        this.level = level;
    }

    public String getXp() {
        return xp;
    }

    public String getAttack() {
        return attack;
    }

    public String getDefense() {
        return defense;
    }

    public String getHitPoints() {
        return hitPoints;
    }

    public String getWeapons() {
        return weapons;
    }

    public String getArmor() {
        return armor;
    }

    public String getHelm() {
        return helm;
    }
}
