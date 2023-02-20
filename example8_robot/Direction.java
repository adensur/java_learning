public enum Direction {
    UP,
    DOWN,
    LEFT,
    RIGHT;

    static Direction rotateRight(Direction dir) {
        switch (dir) {
            case UP:
                return Direction.RIGHT;
            case RIGHT:
                return Direction.DOWN;
            case DOWN:
                return Direction.LEFT;
            case LEFT:
                return Direction.UP;
            default:
                throw new RuntimeException();
        }
    }

    static Direction rotateLeft(Direction dir) {
        switch (dir) {
            case UP:
                return Direction.LEFT;
            case RIGHT:
                return Direction.UP;
            case DOWN:
                return Direction.RIGHT;
            case LEFT:
                return Direction.DOWN;
            default:
                throw new RuntimeException();
        }
    }
}