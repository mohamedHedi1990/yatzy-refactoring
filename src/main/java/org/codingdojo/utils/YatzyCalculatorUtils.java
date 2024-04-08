package org.codingdojo.utils;

import org.codingdojo.models.Dice;
import org.codingdojo.models.Roll;

import java.util.Arrays;

public class YatzyCalculatorUtils {
    public static int chance(Roll roll)
    {
        return roll.getSumDices();
    }

    public static int yatzy(Roll roll)
    {
        int targetValue = roll.getDices()[0].getSide().getValue();
        return roll.allDicesHaveTheSameValue(targetValue) ? Constants.YATZY_SUCESS_SCORE : Constants.LOSS_SCORE;
    }

    public static int ones(Roll roll) {
        return roll.getSumDeicesWithSameValue(Constants.ONE);
    }

    public static int twos(Roll roll) {
        return roll.getSumDeicesWithSameValue(Constants.TWO);
    }

    public static int threes(Roll roll) {
        return roll.getSumDeicesWithSameValue(Constants.THREE);
    }
    public static int fours(Roll roll) {
        return roll.getSumDeicesWithSameValue(Constants.FOUR);
    }

    public static int fives(Roll roll) {
        return roll.getSumDeicesWithSameValue(Constants.FIVE);
    }

    public static int sixes(Roll roll) {
        return roll.getSumDeicesWithSameValue(Constants.SIX);
    }

    public static int scorePair(Roll roll)
    {
        return getSumOfHighestPair(roll.getDices());
    }
    public static int twoPair(Roll roll)
    {
        int sumOfHighestPair = getSumOfHighestPair(roll.getDices());
        if(sumOfHighestPair == Constants.LOSS_SCORE) return Constants.LOSS_SCORE;
        Dice[] remainingDices = Arrays.stream(roll.getDices()).filter(dice -> dice.getSide().getValue() != (sumOfHighestPair/2)).toArray(Dice[]::new);
        int sumOfPairInremainingDices = getSumOfHighestPair(remainingDices);
        if(sumOfPairInremainingDices == Constants.LOSS_SCORE) return Constants.LOSS_SCORE;
        return sumOfHighestPair + sumOfPairInremainingDices;
    }

    private static int getSumOfHighestPair(Dice[] dices) {
        int[] sortedValues =  Arrays.stream(dices).mapToInt(dice -> dice.getSide().getValue()).sorted().toArray();
        for(int index=sortedValues.length-1; index >= 1 ; index--) {
            if(sortedValues[index] == sortedValues[index-1]) {
                return 2*sortedValues[index];
            }
        }
        return Constants.LOSS_SCORE;
    }

    public static int fourOfAKind(Roll roll)
    {
        return getXOfAKind(roll, Constants.FOUR_OF_A_KIND_NUMBER);
    }

    public static int threeOfAKind(Roll roll)
    {
        return getXOfAKind(roll, Constants.THREE_OF_A_KIND_NUMBER);
    }

    private static int getXOfAKind(Roll roll, int xKind) {
        for(int index= 0; index <= Constants.DICE_NUMBER - xKind; index++) {
            int value = roll.getDiceValue(index);
            if( roll.getDeicesNumberWithSameValue(value) == xKind) {
                return value * xKind;
            }
        }
        return Constants.LOSS_SCORE;
    }

    public static int smallStraight(Roll roll)
    {
        int lastIndex = roll.getDiceValue(roll.getDices().length - 1) == Constants.SMALL_STRAIGHT_VALUE ? roll.getDices().length - 2 : roll.getDices().length - 1;
        for (int i = 0; i < lastIndex; i++) {
            if (roll.getDiceValue(i+1) != roll.getDiceValue(i) + 1) {
                return Constants.LOSS_SCORE;
            }
        }
        return roll.getSumDices();
    }
    public static int largeStraight(Roll roll) {
        int firstIndex = roll.getDiceValue(0) == Constants.LARGE_STRAIGHT_VALUE ? 1 : 0;
        for (int i = firstIndex; i < roll.getDices().length - 1; i++) {
            if (roll.getDiceValue(i+1) != roll.getDiceValue(i) + 1) {
                return Constants.LOSS_SCORE;
            }
        }
        return roll.getSumDices();
    }

    public static int fullHouse(Roll roll) {
        if(roll.allDicesHaveTheSameValue(roll.getDices()[0].getSide().getValue())) return Constants.LOSS_SCORE;
        int[] sortedValues =  Arrays.stream(roll.getDices()).mapToInt(dice -> dice.getSide().getValue()).sorted().toArray();
        if(sortedValues[0] * 3 + sortedValues[sortedValues.length-1] * 2 == roll.getSumDices() ||
            sortedValues[0] * 2 + sortedValues[sortedValues.length-1] * 3 == roll.getSumDices() ) {
            return roll.getSumDices();
        }
        return Constants.LOSS_SCORE;
    }

}
