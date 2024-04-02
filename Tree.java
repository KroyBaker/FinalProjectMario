import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.File;


public class Tree {
  private int x, y, width, height;
  private BufferedImage treeImage;

  public Tree(int x, int y, int width, int height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
     try {
          treeImage = ImageIO.read(new File("treething.png"));
        } catch (IOException e) {
            System.out.println("Error loading Mario sprites");
        }
  }
  public void setX(int x){
    this.x = x;
  }
  public int getX() {
    return x;
  }
  public int getWidth(){
    return width;
  }
  public int getHeight(){
    return height;
  }
  public BufferedImage getTree(){
    return treeImage;
  }
  public int getY() {
    return y;
  }
}