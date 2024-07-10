import java.util.Random;

public class Zombie {
    private int x;
    private int y;

    public Zombie(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void deplacer() {
        Random random = new Random();
        int direction = random.nextInt(4); // 0: nord, 1: sud, 2: est, 3: ouest

        switch (direction) {
            case 0:
                y++;
                break;
            case 1:
                y--;
                break;
            case 2:
                x++;
                break;
            case 3:
                x--;
                break;
        }
    }

    // Les Getters et les Setters
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
