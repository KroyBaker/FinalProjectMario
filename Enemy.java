public class Enemy {
  private int x, y;
  private int velX, velY;
  private int width, height;

  public Enemy(int x, int y, int width, int height) {
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    this.velX = 0;
    this.velY = 0;
  }
   public void moveTowardsPlayer(Mario player) {
        int playerX = player.getX();
        int playerY = player.getY();
        
        // Calculate the difference between the player's and enemy's positions
        int dx = playerX - x;
        int dy = playerY - y;
        
        // Normalize the difference vector
        double magnitude = Math.sqrt(dx * dx + dy * dy);
        double normalizedDx = dx / magnitude;
        double normalizedDy = dy / magnitude;
        
        // Define the enemy's movement speed
        int speed = 2; // Adjust as needed
        
        // Update the enemy's position towards the player
        x += normalizedDx * speed;
        y += normalizedDy * speed;
    }

  public void move() {
    // update enemy's position based on velocity
    x += velX;
    y += velY;
  }

  public void setVelocity(int vx, int vy) {
    // set enemy's velocity
    velX = vx;
    velY = vy;
  }
  public int getX(){
    return x;
  }
  public int getY(){
    return y;
  }
  public int getWidth(){
    return width;
  }
  public int getHeight(){
    return height;
  }
}

