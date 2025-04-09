# Janji
Saya Syahraini Revita Puri dengan NIM 2301895 berjanji mengerjakan TP6 DPBO dengan keberkahan-Nya, maka saya tidak akan melakukan kecurangan sesuai yang telah di spesifikasikan, Aamiin

# Desain Program
Program ini adalah permainan Flappy Bird yang diimplementasikan dengan bahasa Java menggunakan Swing untuk antarmuka grafis pengguna. Game ini menampilkan burung yang dikendalikan pemain untuk menavigasi melalui pipa, mendapatkan poin untuk setiap pipa yang berhasil dilewati sambil menghindari tabrakan.


**Komponen Utama**


**1.Class App**: 

- **Tujuan**: Titik masuk utama untuk aplikasi

- **Metode Utama**:
  - `main()` : Menginisialisasi aplikasi dan menampilkan menu
  - `startGame()` : Membuat jendela game dan memulai permainan baru


**2. Class FlappyBird**:

- **Tujuan:** Mesin game inti yang menangani rendering, status game, dan input

- **Atribut:**
  - `player` : Burung yg dikendalikan oleh pemain
  - `pipes` : Kumpulan rintangan pipa
  - `score` : Skor pemain saat ini
  - `gameOver` : Indikator status permainan

- **Metode:**
  - `placePip()` : Menghasilkan rintangan pipa baru
  - `move()` : Memperbarui posisi objek game
  - `paintComponent()` : Merender elemen game
  - `restartGame()` : Mengatur ulang status permainan


**3.Class Player**: 

- **Tujuan**: Merepresentasikan karakter burung

- **Atribut**:
  - `x,y` : Koordinat posisi
  - `width, height` : Dimensi
  - `velocityY` : Kecepatan gerakan vertikal
  - `image` : Grafik burung


**4.Class Pipe**: 

- **Tujuan**: Merepresentasikan rintangan pipa

- **Atribut**:
  - `x,y` : Koordinat posisi
  - `width, height` : Dimensi
  - `passed` : Penanda untuk melacak apakah pemain telah melewati pipa ini
  - `image` : Grafik pipa


**5.Class Menu**: 

- **Tujuan**: Menampilkan menu game

- **Atribut**:
  - `mainPanel` : Panel utama untuk komponen UI
  - `startButton` : Tombol untuk memulai permainan

# Alur Program
**1.Inisialisasi Program:**
- Program dimulai dari method main() di class App
- Membuat instance Menu dan menampilkan

**2.Memulai Permaina:**
- Saat tombol "Start Game" diklik, menu tertutup
- Method startGame() dipanggil unuk membuat jendela game
- Panel FlappyBird diinisialisasi dan ditambahkan ke frame

**3.Permainan Berjalan:**
- Timer game dimulai untuk menggerakkan objek
- Timer pipa dimulai untuk memunculkan pipa secara berkala
- Pemain menggunakan tombol spasi untuk melompat

**4.Mekanisme Game:**

**a. Pergerakkan Burung**: 
- Gravitasi menarik burung ke bawah
- Pemain menekan spasi unuk melompat ke atas
- Posisi burung diperbarui setiap tick timer

**b. Generasi Pipa:**
- Pipa muncul di sebelah kanan layar
- Tinggi pipa bagian atas ditentukan secara acak
- Celah tetap (150px) antara pipa atas dan bawah

**c. Pergerakkan Pipa:**
- Pipa bergerak dari kanan ke kiri
- Pipa dihapus setelah keluar dari layar di sisi kiri

**d. Perhitungan Skor:**
- Skor bertambah saat burung melewati sepasang pipa
- Skor ditampilkan di layar

**e. Deteksi Tabrakan:**
- Game berakhir jika burung menabrak pipa
- Game berakhir jika burung keluar dari layar (atas/bawah)

**5.Game Over:**
- Timer dihentikan
- Pesan "Game Over" ditampilkan
- Instruksi "Press R to Restart" ditampilkan
- Pemain dapat memulai ulang dengan menekan tombol R

**6. Restart Game:**
- Mengatur ulang posisi burung
- Menghapus semua pipa yang ada
- Mengatur ulang skor menjadi 0
- Memulai ulang timer game dan pipa


# Dokumentasi

![WhatsApp Image 2025-04-09 at 20 02 47_bb2f967b](https://github.com/user-attachments/assets/041211cf-7d58-4418-87b5-5071a34ed424)

![WhatsApp Image 2025-04-09 at 20 05 26_b79b4ce5](https://github.com/user-attachments/assets/cc10a3c3-d211-4cb4-b26a-613b61bf38bd)

![WhatsApp Image 2025-04-09 at 20 05 00_3215268f](https://github.com/user-attachments/assets/2c0b7423-1093-4786-9a9a-bd6811b39dab)

![WhatsApp Image 2025-04-09 at 20 03 37_205da24e](https://github.com/user-attachments/assets/53e5f059-3f23-4a07-8b8a-c4089b5e62c2)




