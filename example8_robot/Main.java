import javax.management.RuntimeErrorException;

public class Main {
    public static void moveRobot(Robot robot, int toX, int toY) {
        int deltaX = toX - robot.getX();
        if (deltaX != 0) {
            if (deltaX > 0) {
                turnAbsolute(robot, Direction.RIGHT);
            } else {
                turnAbsolute(robot, Direction.LEFT);
            }
            for (int i = 0; i < Math.abs(deltaX); ++i) {
                robot.stepForward();
            }
        }
        int deltaY = toY - robot.getY();
        if (deltaY != 0) {
            if (deltaY > 0) {
                turnAbsolute(robot, Direction.UP);
            } else {
                turnAbsolute(robot, Direction.DOWN);
            }
            for (int i = 0; i < Math.abs(deltaY); ++i) {
                robot.stepForward();
            }
        }
    }

    public static void main(String[] args) {
        if (args.length != 5) {
            throw new IllegalArgumentException(
                    "Expected 6 args: args: current direction, curX, curY, tar_x, tar_y");
        }
        Direction curDir = Direction.valueOf(args[0]);
        int curX = Integer.parseInt(args[1]);
        int curY = Integer.parseInt(args[2]);
        int toX = Integer.parseInt(args[3]);
        int toY = Integer.parseInt(args[4]);
        Robot robot = new Robot(curDir, curX, curY);
        moveRobot(robot, toX, toY);
        if (robot.getX() != toX) {
            throw new Error("Incorrect final x pos. Expected " + toX + "; got " + robot.getX());
        }
        if (robot.getY() != toY) {
            throw new Error("Incorrect final y pos. Expected " + toY + "; got " + robot.getY());
        }
        System.out.println("Success!");
    }

    public static void turnAbsolute(Robot robot, Direction toDirection) {
        switch (robot.getDirection()) {
            case UP:
                switch (toDirection) {
                    case UP:
                        return;
                    case RIGHT:
                        robot.turnRight();
                        return;
                    case DOWN:
                        robot.turnRight();
                        robot.turnRight();
                        return;
                    case LEFT:
                        robot.turnLeft();
                        return;
                    default:
                        throw new RuntimeException();
                }
            case RIGHT:
                switch (toDirection) {
                    case UP:
                        robot.turnLeft();
                        return;
                    case RIGHT:
                        return;
                    case DOWN:
                        robot.turnRight();
                        return;
                    case LEFT:
                        robot.turnLeft();
                        robot.turnLeft();
                        return;
                    default:
                        throw new RuntimeException();
                }
            case DOWN:
                switch (toDirection) {
                    case UP:
                        robot.turnLeft();
                        robot.turnLeft();
                        return;
                    case RIGHT:
                        robot.turnLeft();
                        return;
                    case DOWN:
                        return;
                    case LEFT:
                        robot.turnRight();
                        return;
                    default:
                        throw new RuntimeException();
                }
            case LEFT:
                switch (toDirection) {
                    case UP:
                        robot.turnRight();
                        return;
                    case RIGHT:
                        robot.turnLeft();
                        robot.turnLeft();
                        return;
                    case DOWN:
                        robot.turnLeft();
                        return;
                    case LEFT:
                        return;
                    default:
                        throw new RuntimeException();
                }
            default:
                throw new RuntimeException();
        }
    }
}