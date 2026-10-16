
package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

public class Main {

    public static void main(String[] args) {

        // Membuat tiga karakter
        Character karakter1 = new Character(
            "Arjuna", CharacterType.WARRIOR
        );

        Character karakter2 = new Character(
            "Srikandi", CharacterType.ARCHER
        );

        Character karakter3 = new Character(
            "Bima", CharacterType.MAGE, 3, 40
        );

        System.out.println("=== TIGA KARAKTER ===");
        System.out.println(karakter1);
        System.out.println(karakter2);
        System.out.println(karakter3);

        // Demo level up
        System.out.println("\n=== DEMO LEVEL UP ===");
        karakter1.setLevel(2);
        System.out.println(karakter1);

        // Fitur tambahan: mana dan isAlive
        Character karakter4 = new Character(
            "Naga", CharacterType.ASSASSIN
        );

        karakter4.setMana(50);

        System.out.println("\n=== FITUR TAMBAHAN ===");
        System.out.println(karakter4);
        System.out.println(
            "Apakah karakter hidup? "
            + karakter4.isAlive()
        );
    }
}
