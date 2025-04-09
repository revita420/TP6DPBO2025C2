import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    private JPanel mainPanel;
    private JButton startButton;

    public Menu() {
        // Mengatur frame
        setTitle("Flappy Bird Menu");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Membuat komponen
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // Membuat label judul
        JLabel titleLabel = new JLabel("FLAPPY BIRD");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));

        // Membuat panel tombol start (untuk pemusatan)
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        // Membuat tombol start
        startButton = new JButton("Start Game");
        startButton.setFont(new Font("Arial", Font.BOLD, 16));
        startButton.setPreferredSize(new Dimension(150, 50));

        // Menambahkan listener aksi ke tombol
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Menutup menu dan memulai permainan
                dispose();
                App.startGame();
            }
        });

        // Menambahkan komponen ke panel
        buttonPanel.add(startButton);

        // Menambahkan panel ke panel utama
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);

        // Menambahkan panel utama ke frame
        add(mainPanel);

        // Mengatur warna latar belakang
        mainPanel.setBackground(new Color(255, 182, 193)); // Warna pink untuk latar belakang
        buttonPanel.setBackground(new Color(255, 182, 193));
    }
}