package bswanepo.Model;

import javax.validation.constraints.*;

public class PlayerInfo {
    @NotNull
    private String name;
    @NotNull
    private String heroClass;
    @NotNull
    private String level;
    @NotNull
    private String xp;
    @NotNull
    private String attack;
    @NotNull
    private String defense;
    @NotNull
    private String hitPoints;
    @NotNull
    private String weapons;
    @NotNull
    private String armor;
    @NotNull
    private String helm;

    public PlayerInfo(String name, String heroClass, String level, String xp, String attack, String defense,
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
