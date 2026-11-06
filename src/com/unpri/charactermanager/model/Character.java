package com.unpri.charactermanager.model;

public class Character {

    // Atribut
    private String name;
    private CharacterType type;
    private int level;
    private int hitPoints;
    private int attack;
    private int mana;

    // Constructor pertama
    public Character(String name, CharacterType type) {
        this.name = name;
        this.type = type;
        this.level = 1;
        this.mana = 0;

        calculateStats();
    }

    // Constructor kedua
    public Character(String name, CharacterType type, int level, int mana) {
        this.name = name;
        this.type = type;
        setLevel(level);
        setMana(mana);
    }

    // Menghitung status berdasarkan level
    private void calculateStats() {
        this.hitPoints = this.level * 100;
        this.attack = this.level * 10;
    }

    // Getter dan Setter Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter dan Setter Type
    public CharacterType getType() {
        return type;
    }

    public void setType(CharacterType type) {
        this.type = type;
    }

    // Getter dan Setter Level
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if (level < 1) {
            throw new IllegalArgumentException(
                "Level minimal 1"
            );
        }

        this.level = level;
        calculateStats();
    }

    // Getter dan Setter HitPoints
    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    // Getter dan Setter Attack
    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    // Getter dan Setter Mana
    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        if (mana < 0) {
            throw new IllegalArgumentException(
                "Mana tidak boleh negatif!"
            );
        }

        this.mana = mana;
    }

    // Mengecek apakah karakter masih hidup
    public boolean isAlive() {
        return hitPoints > 0;
    }

    // Menampilkan informasi karakter
    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", level=" + level +
                ", hitPoints=" + hitPoints +
                ", attack=" + attack +
                ", mana=" + mana +
                '}';
    }
}