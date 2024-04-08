package org.codingdojo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.codingdojo.utils.Constants;

import java.util.Arrays;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Roll {
    private Dice[] dices = new Dice[Constants.DICE_NUMBER];

    public int getSumDices() {
        return Arrays.stream(dices).mapToInt(dice -> dice.getSide().getValue()).sum();
    }

    public boolean allDicesHaveTheSameValue(int targetValue) {
        return Arrays.stream(dices)
            .mapToInt(dice -> dice.getSide().getValue())
            .filter(value -> value != targetValue)
            .findAny()
            .isEmpty();
    }

    public int getSumDeicesWithSameValue(int targetValue) {
        return Arrays.stream(dices)
            .mapToInt(dice -> dice.getSide().getValue())
            .filter(value -> value == targetValue)
            .sum();
    }

    public int getDeicesNumberWithSameValue(int targetValue) {
        return (int) Arrays.stream(dices)
            .mapToInt(dice -> dice.getSide().getValue())
            .filter(value -> value == targetValue)
            .count();
    }
    public int getDiceValue(int index) {
        if (index >= Constants.DICE_NUMBER) return 0;
        return dices[index].getSide().getValue();
    }
}
