package be.blackkitten.minesweeperbot.solver.dataset;

public class PositionComparator {

    private int x;
    private int y;

    private PositionComparator(int x, int y){
        this.x = x;
        this.y = y;
    }
    public static PositionComparator of(MineField object) {
        return new PositionComparator(object.x, object.y);
    }

    public boolean isSurroundingField(MineField subject) {
        if(this.equals(subject)) {
            return false;
        }
        return isRight(subject) && ( isUp(subject) || isSameVertical(subject) || isBelow(subject))
                || isSameHorizontal(subject) && ( isUp(subject) || isBelow(subject) )
                || isLeft(subject) && (isUp(subject) || isBelow(subject) || isSameVertical(subject));
    }

    private boolean isLeft(MineField mineField) {
        return this.x == mineField.x - 1;
    }

    private boolean isSameHorizontal(MineField mineField) {
        return this.x == mineField.x;
    }

    private boolean isBelow(MineField mineField) {
        return this.y == mineField.y-1;
    }

    private boolean isSameVertical(MineField mineField) {
        return this.y == mineField.y;
    }

    private boolean isUp(MineField mineField) {
        return this.y == mineField.y + 1;
    }

    private boolean isRight(MineField mineField) {
        return this.x == mineField.x + 1;
    }

}
