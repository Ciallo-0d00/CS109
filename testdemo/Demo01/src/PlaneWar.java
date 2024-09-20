import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class PlaneWar extends JPanel implements ActionListener, KeyListener {
    private Timer timer;
    private int playerX = 300;
    private int playerY = 400;
    private int playerSize = 20;
    private int playerSpeed = 20;
    private int score = 0;
    private boolean gameOver = false;

    private ArrayList<Rectangle> bullets;
    private ArrayList<Rectangle> enemies;
    private Random random;

    public PlaneWar() {
        timer = new Timer(20, this);
        bullets = new ArrayList<>();
        enemies = new ArrayList<>();
        random = new Random();
        setFocusable(true);
        addKeyListener(this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (gameOver) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 36));
            g.drawString("Game Over", 200, 200);
            g.setFont(new Font("Arial", Font.PLAIN, 24));
            g.drawString("Score: " + score, 250, 250);
        } else {
            g.setColor(Color.BLUE);
            g.fillRect(playerX, playerY, playerSize, playerSize);
            g.setColor(Color.RED);
            for (Rectangle enemy : enemies) {
                g.fillRect(enemy.x, enemy.y, enemy.width, enemy.height);
            }
            g.setColor(Color.BLACK);
            for (Rectangle bullet : bullets) {
                g.fillRect(bullet.x, bullet.y, bullet.width, bullet.height);
            }
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.PLAIN, 18));
            g.drawString("Score: " + score, 10, 20);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameOver) {
            return;
        }

        for (int i = 0; i < bullets.size(); i++) {
            Rectangle bullet = bullets.get(i);
            bullet.y -= 10;
            if (bullet.y < 0) {
                bullets.remove(i);
                i--;
            }
        }

        if (random.nextInt(100) < 2) {
            int enemyX = random.nextInt(600 - playerSize);
            enemies.add(new Rectangle(enemyX, 0, playerSize, playerSize));
        }

        for (int i = 0; i < enemies.size(); i++) {
            Rectangle enemy = enemies.get(i);
            enemy.y += random.nextInt(5) + 1;
            if (enemy.y > 600) {
                enemies.remove(i);
                i--;
            }
        }

        for (int i = 0; i < bullets.size(); i++) {
            Rectangle bullet = bullets.get(i);
            for (int j = 0; j < enemies.size(); j++) {
                Rectangle enemy = enemies.get(j);
                if (bullet.intersects(enemy)) {
                    bullets.remove(i);
                    enemies.remove(j);
                    score++;
                    i--;
                    break;
                }
            }
        }

        for (Rectangle enemy : enemies) {
            if (enemy.intersects(new Rectangle(playerX, playerY, playerSize, playerSize))) {
                gameOver = true;
                timer.stop();
            }
        }

        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT && playerX > 0) {
            playerX -= playerSpeed;
        }
        if (key == KeyEvent.VK_RIGHT && playerX < getWidth() - playerSize) {
            playerX += playerSpeed;
        }
        if (key == KeyEvent.VK_UP && playerY > 0) {
            playerY -= playerSpeed;
        }
        if (key == KeyEvent.VK_DOWN && playerY < getHeight() - playerSize) {
            playerY += playerSpeed;
        }
        if (key == KeyEvent.VK_SPACE) {
            bullets.add(new Rectangle(playerX + playerSize / 2 - 2, playerY, 5, 10));
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Plane War");
        PlaneWar game = new PlaneWar();
        frame.add(game);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}