
public class Robot {
    Direction dir;
    int x;
    int y;

    Robot(Direction dir, int x, int y) {
        this.dir = dir;
        this.x = x;
        this.y = y;
    }

    Direction getDirection() {
        // текущее направление взгляда
        return dir;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    void turnLeft() {
        // повернуться на 90 градусов против часовой стрелки
        dir = Direction.rotateLeft(dir);
    }

    void turnRight() {
        // повернуться на 90 градусов по часовой стрелке
        dir = Direction.rotateRight(dir);
    }

    void stepForward() {
        // шаг в направлении взгляда
        // за один шаг робот изменяет одну свою координату на единицу
        switch (dir) {
            case UP:
                ++y;
                return;
            case RIGHT:
                ++x;
                return;
            case DOWN:
                --y;
                return;
            case LEFT:
                --x;
                return;
            default:
                throw new RuntimeException();
        }
    }
}