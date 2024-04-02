import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;

public class Mario {
    private int x;
    private int y;
    private int backgroundX;
    private int backgroundXSpeed;
    private int realMovement;
    private int speedX;
    private int speedY;
    private boolean isJumping;
    private int jumpHeight;
    private int heightX;
    private Ground ground;
    private int vel;
    private boolean freeFall;
    private int marioHeight;
    private int marioWidth;
    private BufferedImage marioStillSprite;
    private BufferedImage marioRunSprite;
    private boolean isMoving;
    private int frame;

    private boolean backgroundMoving;
    public Mario(int x, int y, Ground ground, int width, int height) {
        this.x = x;
        this.y = y;
        this.frame = 0;
        this.vel = 0;
        this.speedX = 0;
        this.speedY = 0;
        this.isJumping = false;
        this.freeFall = false;
        this.jumpHeight = 0;
        this.ground = ground;
        this.marioWidth = width;
        this.marioHeight = height;
        this.backgroundMoving = false;
        this.backgroundX = 0;
        this.isMoving = false;
        this.backgroundXSpeed = 0;
        this.realMovement = 0;
        // Load Mario sprites
        try {
            marioStillSprite = ImageIO.read(new File("frame_00_delay-0.1s.gif"));
            marioRunSprite = ImageIO.read(new File("run0.png"));
        } catch (IOException e) {
            System.out.println("Error loading Mario sprites");
        }
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setFreeFall(boolean freeFall) {
        this.freeFall = freeFall;
    }
  public void setBackgroundX(int backgroundX){
      this.backgroundX = backgroundX;
  }
    public int getX() {
        return x;
    }
    public int getBackgroundX(){
      return backgroundX;
    }
    public BufferedImage getJumpingImage(){
      return marioRunSprite; 
    }
   public BufferedImage getRunningImage(){
      return marioRunSprite; 
    }
    public BufferedImage getStillImage(){
      return marioStillSprite; 
    }
  
    public int getY() {
        return y;
    }
    public boolean getBackgroundMoving(){
      return backgroundMoving;
    }

    public void setX(int x) {
        this.x = x;
    }
   public boolean isJumping(){
    return isJumping;
   }
   public boolean isFreeFalling(){
     return freeFall;
   }
    public boolean isMoving(){
      return isMoving;
    }
    public int getWidth() {
        return marioWidth;
    }

    public int getHeight() {
        return marioHeight;
    }

    public void moveLeft() {
        speedX = -4;
     
        isMoving = true;
    }

    public void moveRight() {
        if(x >= 200 && realMovement < 800){
          speedX = 0;
          backgroundXSpeed = -4;
          backgroundMoving = true;
        }
        else{
          speedX = 4;
          backgroundXSpeed = 0;
          backgroundMoving = false;
        }
        
       
        isMoving = true;
    }

    public void stopMoving() {
        speedX = 0;
        isMoving = false;
    }

    public void jump() {
        if (!isJumping) {
            isJumping = true;
            jumpHeight = 10;
            speedY = 1;
            vel = 20;
            freeFall = true;
        }
    }

    public void still() {
        if (!freeFall) {
            isJumping = false;
            jumpHeight = 0;
            freeFall = false;
            speedY = 0;
            heightX = 0;
            isMoving = false;
        }
    }

    public void stopJump() {
        if (isJumping && freeFall) {

            if (freeFall == false) {
                isJumping = true;
            }

            jumpHeight = 0;
            speedY = 1;
            vel = 0;
            heightX = 0;
        }
    }

    public void move() {
      frame += 1;
      if(frame == 34){
        frame = 0;
      }
        switch (frame) {
          case 0:
               try {
              marioStillSprite = ImageIO.read(new File("frame_00_delay-0.1s.gif"));
              marioRunSprite = ImageIO.read(new File("run0.png"));
          } catch (IOException e) {
              System.out.println("Error loading Mario sprites");
          }
          break;
          case 3:
                try {
            marioStillSprite = ImageIO.read(new File("frame_01_delay-0.1s.gif"));
            marioRunSprite = ImageIO.read(new File("run1.png"));
        } catch (IOException e) {
            System.out.println("Error loading Mario sprites");
         }
          break;
          case 6:
             try {
            marioStillSprite = ImageIO.read(new File("frame_02_delay-0.1s.gif"));
            marioRunSprite = ImageIO.read(new File("run2.png"));
        } catch (IOException e) {
            System.out.println("Error loading Mario sprites");
        }
            break;
          case 9:
             try {
            marioStillSprite = ImageIO.read(new File("frame_03_delay-0.1s.gif"));
            marioRunSprite = ImageIO.read(new File("run3.png"));
        } catch (IOException e) {
            System.out.println("Error loading Mario sprites");
        }
          break;
          case 12:
             try {
            marioStillSprite = ImageIO.read(new File("frame_04_delay-0.1s.gif"));
            marioRunSprite = ImageIO.read(new File("run4.png"));
        } catch (IOException e) {
            System.out.println("Error loading Mario sprites");
        }
          break;
          case 15:
            try {
            marioStillSprite = ImageIO.read(new File("frame_05_delay-0.1s.gif"));
            marioRunSprite = ImageIO.read(new File("run5.png"));
        } catch (IOException e) {
            System.out.println("Error loading Mario sprites");
        }
          break;
          case 18:
             try {
            marioStillSprite = ImageIO.read(new File("frame_06_delay-0.1s.gif"));
            marioRunSprite = ImageIO.read(new File("run6.png"));
        } catch (IOException e) {
            System.out.println("Error loading Mario sprites");
        }
          break;
          case 21:
             try {
            marioStillSprite = ImageIO.read(new File("frame_07_delay-0.1s.gif"));
            marioRunSprite = ImageIO.read(new File("run7.png"));
        } catch (IOException e) {
            System.out.println("Error loading Mario sprites");
        }
          break;
          case 24:
             try {
            marioStillSprite = ImageIO.read(new File("frame_08_delay-0.1s.gif"));
            marioRunSprite = ImageIO.read(new File("run8.png"));
        } catch (IOException e) {
            System.out.println("Error loading Mario sprites");
        }
          break;
          case 27:
             try {
            marioStillSprite = ImageIO.read(new File("frame_09_delay-0.1s.gif"));
            marioRunSprite = ImageIO.read(new File("run9.png"));
        } catch (IOException e) {
            System.out.println("Error loading Mario sprites");
        }
            break;
          case 30:
             try {
            marioStillSprite = ImageIO.read(new File("frame_11_delay-0.1s.gif"));
            marioRunSprite = ImageIO.read(new File("run0.png"));
        } catch (IOException e) {
            System.out.println("Error loading Mario sprites");
        }
            break;
          case 33:
             try {
            marioStillSprite = ImageIO.read(new File("frame_11_delay-0.1s.gif"));
            marioRunSprite = ImageIO.read(new File("run1.png"));
        } catch (IOException e) {
            System.out.println("Error loading Mario sprites");
        }
            break;
        }
           
       x += speedX;
       backgroundX += backgroundXSpeed;
       realMovement -= backgroundXSpeed;
       //System.out.println(backgroundX);
        // check for collision with platform
        
      if (isJumping || freeFall) {
        heightX += speedY;
        y += heightX;
        y -= vel;
        jumpHeight -= Math.abs(speedY);
        if (jumpHeight <= 0) {
          //isJumping = false;
          //speedY = 3;
        }
      } 
    }
  }

        // adjust y position based
