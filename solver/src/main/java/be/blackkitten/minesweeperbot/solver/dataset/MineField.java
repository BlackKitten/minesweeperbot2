package be.blackkitten.minesweeperbot.solver.dataset;

import java.util.List;

public class MineField {

    public int x;
    public int y;
    private boolean bomb;
    public List<MineField> surroundingFields;

    public MineField(int x, int y, boolean bomb) {
        this.x = x;
        this.y = y;
        this.bomb = bomb;
    }

    public boolean isBomb() {
        return this.bomb;
    }

    public int getValue() {
        return ((int) surroundingFields.stream()
                .filter(field -> field.bomb)
                .count());
    }

    public void setBomb(boolean bomb) {
        this.bomb = bomb;
    }

    public void setSurroundingFields(List<MineField> surroundingFields) {
        this.surroundingFields = surroundingFields;
    }

    public String getText() {
        return isBomb()?"B": ("" + getValue());
    }


}
