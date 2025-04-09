public class App {
    public static void main(String[] args) {
        // Membuat instance baru dari Menu untuk menampilkan menu utama terlebih dahulu
        Menu menu = new Menu();
        menu.setVisible(true);
    }

    // Metode untuk memulai permainan
    public static void startGame() {
        // Membuat JFrame
        javax.swing.JFrame frame = new javax.swing.JFrame("Flappy Bird");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        // Membuat panel FlappyBird
        FlappyBird flappyBird = new FlappyBird(frame);
        frame.add(flappyBird);

        // Fokus pada panel untuk input keyboard
        flappyBird.requestFocus();

        // Menampilkan frame
        frame.setVisible(true);
    }
}