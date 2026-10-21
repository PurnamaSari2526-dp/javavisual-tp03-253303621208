package com.unpri.charactermanager.model;

import java.util.ArrayList;

public class CharacterManager {

    private ArrayList<Character> characters = new ArrayList<>();

    public boolean addCharacter(Character character) {
        if (character == null) {
            return false;
        }

        if (findByName(character.getName()) != null) {
            System.out.println("Karakter duplikat ditolak: "
                    + character.getName());
            return false;
        }

        characters.add(character);
        return true;
    }

    public Character findByName(String name) {
        if (name == null) {
            return null;
        }

        for (Character character : characters) {
            if (character.getName() != null
                    && character.getName().equalsIgnoreCase(name)) {
                return character;
            }
        }

        return null;
    }

    public boolean removeCharacter(String name) {
        Character character = findByName(name);

        if (character == null) {
            return false;
        }

        characters.remove(character);
        return true;
    }

    public int getTotalCharacters() {
        return characters.size();
    }

    public ArrayList<Character> getAllCharacters() {
        return new ArrayList<>(characters);
    }
    public double getAverageLevel() {
    if (characters.isEmpty()) {
        return 0;
    }

    int totalLevel = 0;

    for (Character character : characters) {
        totalLevel += character.getLevel();
    }

    return (double) totalLevel / characters.size();
}

public ArrayList<Character> findByType(CharacterType type) {
    ArrayList<Character> result = new ArrayList<>();

    if (type == null) {
        return result;
    }

    for (Character character : characters) {
        if (character.getType() == type) {
            result.add(character);
        }
    }

    return result;
}
/**
 * Mencari karakter dengan nilai attack tertinggi.
 *
 * @return karakter terkuat, atau null jika daftar kosong.
 */
public Character findStrongest() {
    if (characters.isEmpty()) {
        return null;
    }

    Character strongest = characters.get(0);

    for (Character character : characters) {
        if (character.getAttack() > strongest.getAttack()) {
            strongest = character;
        }
    }

    return strongest;
}
}