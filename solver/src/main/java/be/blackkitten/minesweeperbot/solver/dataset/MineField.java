package be.blackkitten.minesweeperbot.solver.dataset;

import be.blackkitten.commons.utilities.InstanceBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Arrays.asList;

public class MineField {

    public int x;
    public int y;
    public List<MineField> surroundingFields = new ArrayList<>();
    private boolean bomb = false;
    private boolean known = false;

    public MineField() {
    }

    public MineField(int x, int y, boolean bomb) {
        this.x = x;
        this.y = y;
        this.bomb = bomb;
    }

    public boolean isBomb() {
        return this.bomb;
    }

    public void setBomb(boolean bomb) {
        this.bomb = bomb;
    }

    public Optional<Integer> getValue() {
        if (!this.known) {
            return Optional.empty();
        }

        return (Optional.of((int) surroundingFields.stream()
                .filter(MineField::isBomb)
                .count()));
    }

    public boolean isKnown() {
        return known;
    }

    public void setKnown(boolean known) {
        this.known = known;
    }

    public void setSurroundingFields(List<MineField> surroundingFields) {
        this.surroundingFields = surroundingFields;
    }

    public String getText() {
        return isBomb() ? "B" : ("" + getValue());
    }

    public static class Builder extends InstanceBuilder<MineField> {

        @Override
        protected MineField createInstance() {
            return new MineField();
        }

        public Builder withCoordinates(int x, int y) {
            instance().x = x;
            instance().y = y;
            return this;
        }

        public Builder withIsBomb(boolean isBomb) {
            instance().bomb = isBomb;
            return this;
        }

        public Builder withIsKnown(boolean isKnown) {
            instance().known = isKnown;
            return this;
        }

        public Builder withSurroundingFields(MineField... mineFields) {
            instance().surroundingFields = asList(mineFields);
            return this;
        }
    }

}
