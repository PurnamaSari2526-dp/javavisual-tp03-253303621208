# Character Manager — TP5 (Java Visual SIH-6406)

**Nama:** [Purnama Sari]  
**NIM:** [253303621208]  
**Kelas:** [semester 3 pagi A]

## 1. Deskripsi Proyek

Character Manager adalah program berbasis Java untuk mengelola data karakter dengan menerapkan konsep Pemrograman Berorientasi Objek (PBO). Pada TP5, program dikembangkan dengan menambahkan fitur pengelolaan karakter, pencarian, penghapusan, serta pengujian perilaku object dan reference.

## 2. Fitur Baru TP5

- `addCharacter()` untuk menambahkan karakter dan menolak nama duplikat.
- `findByName()` untuk mencari karakter berdasarkan nama.
- `removeCharacter()` untuk menghapus karakter.
- `getTotalCharacters()` untuk menghitung jumlah karakter.
- `getAllCharacters()` untuk memperoleh daftar karakter.
- `getAverageLevel()` untuk menghitung rata-rata level, dengan hasil 0 jika daftar kosong.
- `findByType()` untuk mencari karakter berdasarkan tipe.
- `equals()` dan `hashCode()` untuk mendukung perbandingan karakter berdasarkan nama secara konsisten.
- Eksperimen defensive copy untuk memeriksa apakah perubahan pada salinan daftar memengaruhi daftar asli.

## 3. Screenshot Output CRUD

Screenshot hasil program disimpan pada folder `screenshot/`.

### 3.1 Pengujian CRUD

![Screenshot/output_tp05.png]

Screenshot ini memperlihatkan hasil pengujian penambahan karakter, pencarian karakter, penghapusan karakter, dan penghitungan jumlah karakter.

### 3.2 Eksperimen Reference

![![alt text](output_tp5.png)]

Screenshot ini memperlihatkan hasil eksperimen reference atau defensive copy untuk mengamati perbedaan antara daftar asli dan salinannya.

## 4. Penjelasan Bagian C

Bagian C membahas pengembangan dan pengujian fitur Character Manager. Pengujian CRUD digunakan untuk memastikan data karakter dapat ditambahkan, dicari, dihapus, dan dihitung dengan benar. Pemeriksaan nama duplikat membantu mencegah data karakter dengan nama yang sama dimasukkan berulang kali.

Eksperimen reference digunakan untuk memahami bahwa beberapa variabel dapat merujuk pada object yang sama. Defensive copy membantu melindungi koleksi internal agar perubahan pada daftar yang diberikan kepada pengguna tidak langsung mengubah data internal. Pengujian tambahan dilakukan pada pencarian berdasarkan tipe, rata-rata level, serta perbandingan karakter.

## 5. Struktur Folder

```text
CharacterManager_/
├── src/
│   └── com/unpri/charactermanager/
│       ├── Main.java
│       └── model/
│           ├── Character.java
│           ├── CharacterType.java
│           └── CharacterManager.java
├── screenshots/
│   ├── output-crud.png
│   └── eksperimen-reference.png
└── README.md
```

## 6. Google Docs — Bagian D

Dokumen laporan Bagian D berisi penjelasan dan analisis sesuai instruksi tugas TP5.

**Link Google Docs:** [https://1drv.ms/w/c/EF681E4F4E3CE288/IQA4FnerNc4XQYRnqw-o7hjPAVMCIdGQ8HeboFBjTKYvF40?e=7jOjEw]

Pastikan akses dokumen diatur menjadi *Anyone with the link — Viewer*.

## 7. Kesimpulan

Melalui TP5, proyek Character Manager dikembangkan dengan fitur pengelolaan karakter dan pengujian perilaku object. Tugas ini juga membantu memahami pengelolaan koleksi, encapsulation, reference, defensive copy, serta penggunaan Git dan GitHub untuk menyimpan riwayat pengembangan program.
