import java.util.ArrayList;

public class Ground {
  private int x, y;
  private int width, height;
  private ArrayList<Ground> grounds;
  private int groundAmount;

  public Ground(int x, int y, int width, int height) {
    this.groundAmount = 1;
    this.grounds = new ArrayList<>(groundAmount);
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public void isColliding(Mario mario) {
    int marioX = mario.getX();
    int marioY = mario.getY();
    int marioWidth = mario.getWidth();
    int marioHeight = mario.getHeight();
     
    if (marioY >= y - 50&& marioY <= y + height) {         
      if (marioX + marioWidth >= x && marioX <= x + width) {
        int overlapTop = Math.abs((y + height) - marioY);
        int overlapBottom = Math.abs((marioY + marioHeight) - y);
        int overlapLeft = Math.abs((x + width) - marioX);
        int overlapRight = Math.abs((marioX + marioWidth) - x);

        int minOverlap = Math.min(Math.min(overlapTop, overlapBottom), Math.min(overlapLeft, overlapRight));
        if (minOverlap == overlapTop) {
          mario.setY(y - marioHeight - 30);
        } else if (minOverlap == overlapBottom) {
          mario.setY(y + height);
        } else if (minOverlap == overlapLeft) {
          mario.setX(x - marioWidth);
        } else {
          mario.setX(x + width);
        }
        mario.setFreeFall(false);
        mario.still();
      }
    }
  }
}
