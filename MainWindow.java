package com.unpri.charactermanager.view;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterManager;
import com.unpri.charactermanager.model.CharacterType;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainWindow extends JFrame {

    private final CharacterManager manager;
    private final JPanel characterPanel;
    private final JLabel averageLabel;

    public MainWindow(CharacterManager manager) {
        this.manager = manager;

        setTitle("Character Manager - TP8");
        setSize(850, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout(10, 10));

        // Judul aplikasi
        JLabel titleLabel = new JLabel(
                "CHARACTER MANAGER",
                SwingConstants.CENTER
        );

        titleLabel.setFont(new Font("Arial", Font.BOLD, 22));
        add(titleLabel, BorderLayout.NORTH);

        // Daftar karakter
        characterPanel = new JPanel();
        characterPanel.setLayout(
                new BoxLayout(characterPanel, BoxLayout.Y_AXIS)
        );

        JScrollPane scrollPane = new JScrollPane(characterPanel);
        add(scrollPane, BorderLayout.CENTER);

        // Statistik dan tombol
        JPanel bottomPanel = new JPanel(new BorderLayout());

        averageLabel = new JLabel("", SwingConstants.CENTER);
        averageLabel.setFont(new Font("Arial", Font.BOLD, 16));

        JButton addButton = new JButton("Tambah Karakter");
        addButton.addActionListener(e -> showAddCharacterDialog());

        bottomPanel.add(averageLabel, BorderLayout.CENTER);
        bottomPanel.add(addButton, BorderLayout.SOUTH);

        add(bottomPanel, BorderLayout.SOUTH);

        refreshData();

        setVisible(true);
    }

    private void showAddCharacterDialog() {

        JTextField nameField = new JTextField(15);

        JComboBox<CharacterType> typeComboBox =
                new JComboBox<>(CharacterType.values());

        JSpinner levelSpinner =
                new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));

        JSpinner manaSpinner =
                new JSpinner(new SpinnerNumberModel(0, 0, 10000, 1));

        JPanel form = new JPanel(new GridLayout(4, 2, 5, 5));

        form.add(new JLabel("Nama karakter:"));
        form.add(nameField);

        form.add(new JLabel("Tipe karakter:"));
        form.add(typeComboBox);

        form.add(new JLabel("Level:"));
        form.add(levelSpinner);

        form.add(new JLabel("Mana:"));
        form.add(manaSpinner);

        int result = JOptionPane.showConfirmDialog(
                this,
                form,
                "Tambah Karakter Baru",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (result != JOptionPane.OK_OPTION) {
            return;
        }

        String name = nameField.getText().trim();

        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Nama karakter tidak boleh kosong!",
                    "Peringatan",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        CharacterType type =
                (CharacterType) typeComboBox.getSelectedItem();

        int level = (Integer) levelSpinner.getValue();
        int mana = (Integer) manaSpinner.getValue();

        Character newCharacter =
                new Character(name, type, level, mana);

        boolean added = manager.addCharacter(newCharacter);

        if (added) {
            refreshData();

            JOptionPane.showMessageDialog(
                    this,
                    "Karakter berhasil ditambahkan!"
            );
        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "Nama karakter sudah ada atau data tidak valid.",
                    "Gagal Menambahkan",
                    JOptionPane.WARNING_MESSAGE
            );
        }
    }

    public void refreshData() {

        characterPanel.removeAll();

        ArrayList<Character> characters = manager.getAllCharacters();

        for (Character character : characters) {

            JLabel characterLabel = new JLabel(
                    "Nama: " + character.getName()
                    + " | Tipe: " + character.getType()
                    + " | Level: " + character.getLevel()
                    + " | HP: " + character.getHitPoints()
                    + " | Attack: " + character.getAttack()
                    + " | Mana: " + character.getMana()
            );

            characterLabel.setBorder(
                    BorderFactory.createEmptyBorder(10, 12, 10, 12)
            );

            characterPanel.add(characterLabel);
        }

        averageLabel.setText(
                String.format(
                        "Rata-rata Level: %.2f",
                        manager.getAverageLevel()
                )
        );

        characterPanel.revalidate();
        characterPanel.repaint();
    }
}