import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Main extends JPanel implements KeyListener {

    private Mario mario;
    private Ground ground;
    private Ground ground2;
    private ArrayList<Enemy> enemies;
    private JFrame frame;
    private ArrayList<Tree> trees;
    boolean moving = false;

    public Main() {
        mario = new Mario(30, 370, ground, 40, 60);
        trees = new ArrayList<Tree>();
        trees.add(new Tree(0, 0, 100, 500));
       // trees.add(new Tree(200, 9, 500, 800));
        enemies = new ArrayList<Enemy>();
        enemies.add(new Enemy(100,370,10,10));
        //trees.add(new Tree(40, 370, 1, 1));

        ground = new Ground(0, 490, 800, 50);
        ground2 = new Ground(200, 440, 100, 50);
        frame = new JFrame();
        frame.add(this);
        frame.addKeyListener(this);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }

  
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.BLUE);
       
        // draw ground
        g.setColor(Color.GREEN);
        g.fillRect(ground.getX(), ground.getY(), ground.getWidth(), ground.getHeight());
      
         g.fillRect(ground2.getX(), ground2.getY(), ground2.getWidth(), ground2.getHeight());
    
       for (Tree tree : trees) {
        
        BufferedImage newImage = new BufferedImage(tree.getWidth(), tree.getHeight(), tree.getTree().getType());
         Graphics2D g2d = newImage.createGraphics();
        g2d.drawImage(tree.getTree(), tree.getX(), tree.getY(), tree.getWidth(), tree.getHeight(), null);
          mario.setBackgroundX(tree.getX());
         
          if(mario.getBackgroundMoving() && mario.isMoving()){
        
          int treePosition = tree.getX();
          treePosition += -5;
          tree.setX(treePosition);
         // System.out.println(tree.getX());
         }
         g2d.dispose();

        // draw the resized image onto the JPanel
        g.drawImage(newImage, tree.getX(), tree.getY(), null);
         
        }
        for(Enemy enemy: enemies){
        g.fillRect(enemy.getX(),enemy.getY(), enemy.getWidth(), enemy.getHeight());
          
        }
        // draw mario
        if (mario.isJumping() || mario.isFreeFalling()) {
            g.drawImage(mario.getJumpingImage(), mario.getX(), mario.getY(), null);
        } else if (mario.isMoving() || moving) {
            g.drawImage(mario.getRunningImage(), mario.getX(), mario.getY(), null);
        } else {
            g.drawImage(mario.getStillImage(), mario.getX(), mario.getY(), null);
        }
    }

    public void run() {
        while (true) {
            // update mario position
            mario.move();

            // repaint the screen
            repaint();
            ground.isColliding(mario);
            // wait for a short period
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

   
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
        case KeyEvent.VK_LEFT:
            mario.moveLeft();
            moving = true;
            break;
        case KeyEvent.VK_RIGHT:
            mario.moveRight();
            moving = true;
            break;
        case KeyEvent.VK_UP:
            mario.jump();
            break;
        }
    }


    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
        case KeyEvent.VK_LEFT:
        case KeyEvent.VK_RIGHT:
            mario.stopMoving();
            moving = false;
            break;
        case KeyEvent.VK_UP:
            mario.stopJump();
            break;
        }
    }

    public void keyTyped(KeyEvent e) {
        // do nothing
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }
}
