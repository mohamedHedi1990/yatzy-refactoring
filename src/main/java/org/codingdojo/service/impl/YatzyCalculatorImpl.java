package org.codingdojo.service.impl;

import org.codingdojo.models.Roll;
import org.codingdojo.service.YatzyCalculator;
import org.codingdojo.enumeration.YatzyCategory;
import org.codingdojo.utils.YatzyCalculatorUtils;

public class YatzyCalculatorImpl implements YatzyCalculator {

    @Override
    public int score(Roll roll, YatzyCategory category) {
        return switch (category) {
            case CHANCE -> YatzyCalculatorUtils.chance(roll);
            case YATZY -> YatzyCalculatorUtils.yatzy(roll);
            case ONES -> YatzyCalculatorUtils.ones(roll);
            case TWOS -> YatzyCalculatorUtils.twos(roll);
            case THREES -> YatzyCalculatorUtils.threes(roll);
            case FOURS -> YatzyCalculatorUtils.fours(roll);
            case FIVES -> YatzyCalculatorUtils.fives(roll);
            case SIXES -> YatzyCalculatorUtils.sixes(roll);
            case PAIR -> YatzyCalculatorUtils.scorePair(roll);
            case THREE_OF_A_KIND -> YatzyCalculatorUtils.threeOfAKind(roll);
            case FOUR_OF_A_KIND -> YatzyCalculatorUtils.fourOfAKind(roll);
            case SMALL_STRAIGHT -> YatzyCalculatorUtils.smallStraight(roll);
            case LARGE_STRAIGHT -> YatzyCalculatorUtils.largeStraight(roll);
            case TWO_PAIRS -> YatzyCalculatorUtils.twoPair(roll);
            case FULL_HOUSE -> YatzyCalculatorUtils.fullHouse(roll);
        };
    }

}

