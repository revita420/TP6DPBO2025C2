import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

public class FlappyBird extends JPanel implements ActionListener, KeyListener {
    private JFrame frame;
    private Player player;
    private Image backgroundImage;
    private Timer gameTimer;
    private Timer pipeTimer;
    private ArrayList<Pipe> pipes;
    private int gravity = 1;
    private JLabel scoreLabel;
    private int score = 0;
    private boolean gameOver = false;

    public FlappyBird(JFrame frame) {
        this.frame = frame;

        // Inisialisasi pemain
        player = new Player(100, 250, 50, 50);

        // Inisialisasi ArrayList pipes
        pipes = new ArrayList<>();

        // Memuat gambar latar belakang
        backgroundImage = new ImageIcon(getClass().getResource("/assets/background.png")).getImage();

        // Mengatur timer permainan (untuk pergerakan pemain)
        gameTimer = new Timer(20, this);
        gameTimer.start();

        // Mengatur timer pipa (untuk memunculkan pipa)
        pipeTimer = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placePipe();
            }
        });
        pipeTimer.start();

        // Menambahkan KeyListener untuk menangani input keyboard
        addKeyListener(this);
        setFocusable(true);

        // Mengatur label skor
        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 24));
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setBounds(10, 10, 150, 30);
        add(scoreLabel);
        setLayout(null);
    }

    public void placePipe() {
        // Membuat tinggi acak untuk pipa
        Random random = new Random();
        int height = random.nextInt(300) + 100;

        // Membuat pipa atas
        Pipe upperPipe = new Pipe(800, 0, 80, height);
        upperPipe.setImage(new ImageIcon(getClass().getResource("/assets/upperPipe.png")).getImage());
        pipes.add(upperPipe);

        // Membuat celah antara pipa (150px)
        int gap = 150;

        // Membuat pipa bawah
        Pipe lowerPipe = new Pipe(800, height + gap, 80, 600 - height - gap);
        lowerPipe.setImage(new ImageIcon(getClass().getResource("/assets/lowerPipe.png")).getImage());
        pipes.add(lowerPipe);
    }

    public void move() {
        // Memperbarui posisi pemain
        player.setVelocityY(player.getVelocityY() + gravity);
        player.setY(player.getY() + player.getVelocityY());

        // Memindahkan pipa
        for (int i = 0; i < pipes.size(); i++) {
            Pipe pipe = pipes.get(i);
            pipe.setX(pipe.getX() - 5);

            // Memeriksa apakah pipa telah dilewati
            if (pipe.getX() + pipe.getWidth() < player.getX() && !pipe.isPassed()) {
                pipe.setPassed(true);
                // Hanya menambah skor untuk pipa atas (untuk menghindari penghitungan ganda)
                if (pipe.getY() == 0) {
                    score++;
                    scoreLabel.setText("Score: " + score);
                }
            }

            // Menghapus pipa jika keluar dari layar
            if (pipe.getX() + pipe.getWidth() < 0) {
                pipes.remove(i);
                i--;
            }

            // Memeriksa tabrakan
            if (player.getX() + player.getWidth() > pipe.getX() &&
                    player.getX() < pipe.getX() + pipe.getWidth() &&
                    player.getY() + player.getHeight() > pipe.getY() &&
                    player.getY() < pipe.getY() + pipe.getHeight()) {
                gameOver = true;
                gameTimer.stop();
                pipeTimer.stop();
            }
        }

        // Memeriksa apakah pemain menabrak tanah atau keluar dari layar bagian atas
        if (player.getY() + player.getHeight() > frame.getHeight() || player.getY() < 0) {
            gameOver = true;
            gameTimer.stop();
            pipeTimer.stop();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Menggambar latar belakang
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

        // Menggambar pemain
        g.drawImage(player.getImage(), player.getX(), player.getY(), player.getWidth(), player.getHeight(), this);

        // Menggambar pipa
        for (Pipe pipe : pipes) {
            g.drawImage(pipe.getImage(), pipe.getX(), pipe.getY(), pipe.getWidth(), pipe.getHeight(), this);
        }

        // Menggambar pesan Game Over
        if (gameOver) {
            g.setColor(new Color(0, 0, 0, 150));
            g.fillRect(0, 0, getWidth(), getHeight());

            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 50));
            g.drawString("Game Over", getWidth() / 2 - 150, getHeight() / 2);

            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("Press R to Restart", getWidth() / 2 - 130, getHeight() / 2 + 50);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Melompat ketika tombol spasi ditekan
        if (e.getKeyCode() == KeyEvent.VK_SPACE && !gameOver) {
            player.setVelocityY(-10);
        }

        // Memulai ulang permainan ketika tombol R ditekan
        if (e.getKeyCode() == KeyEvent.VK_R && gameOver) {
            restartGame();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    private void restartGame() {
        // Mengatur ulang pemain
        player = new Player(100, 250, 50, 50);

        // Menghapus semua pipa
        pipes.clear();

        // Mengatur ulang skor
        score = 0;
        scoreLabel.setText("Score: " + score);

        // Mengatur ulang status permainan
        gameOver = false;

        // Memulai ulang timer
        gameTimer.start();
        pipeTimer.start();
    }
}
