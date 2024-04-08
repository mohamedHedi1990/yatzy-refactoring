package org.codingdojo.service;

import org.codingdojo.enumeration.SideValue;
import org.codingdojo.enumeration.YatzyCategory;
import org.codingdojo.models.Dice;
import org.codingdojo.models.Roll;
import org.codingdojo.service.impl.YatzyCalculatorImpl;
import org.codingdojo.utils.Constants;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class YatzyCalculatorTest {

    YatzyCalculator service = new YatzyCalculatorImpl();


    @Test
    public void shouldReturnSumOfAllDicesIfCategoryIsChance() {
        Roll roll = initiateRoll(2,3,4,5,1);

        int actual = service.score(roll, YatzyCategory.CHANCE);

        assertEquals(15, actual);
    }

    @Test
    public void shouldReturnFiftyIfCategoryIsYatzyAndAllDicesHaveTheSameValue() {
        Roll roll = initiateRoll(2,2,2,2,2);

        int actual = service.score(roll, YatzyCategory.YATZY);

        assertEquals(50, actual);
    }

    @Test
    public void shouldReturnZeroIfCategoryIsYatzyAndDicesHaveNotAllTheSameValue() {
        Roll roll = initiateRoll(2,2,2,2,1);

        int actual = service.score(roll, YatzyCategory.YATZY);

        assertEquals(0, actual);
    }

    @Test
    public void shouldReturnTwoIfCategoryIsOnesAndDicesHaveTwoValuesOfOne() {
        Roll roll = initiateRoll(2,2,2,1,1);

        int actual = service.score(roll, YatzyCategory.ONES);

        assertEquals(2, actual);
    }

    @Test
    public void shouldReturnSixIfCategoryIsTwosAndDicesHaveThreeValuesOfTwo() {
        Roll roll = initiateRoll(2,2,2,1,1);

        int actual = service.score(roll, YatzyCategory.TWOS);

        assertEquals(6, actual);
    }

    @Test
    public void shouldReturnZeroIfCategoryIsThreesAndDicesHaveNoValuesOfThree() {
        Roll roll = initiateRoll(2,2,2,1,1);

        int actual = service.score(roll, YatzyCategory.THREES);

        assertEquals(0, actual);
    }

    @Test
    public void shouldReturnFourIfCategoryIsFoursAndDicesHaveOneValuesOfFour() {
        Roll roll = initiateRoll(4,2,2,1,1);

        int actual = service.score(roll, YatzyCategory.FOURS);

        assertEquals(4, actual);
    }

    @Test
    public void shouldReturnFifteenIfCategoryIsFivesAndDicesHaveThreeValuesOfFive() {
        Roll roll = initiateRoll(5,5,5,1,1);

        int actual = service.score(roll, YatzyCategory.FIVES);

        assertEquals(15, actual);
    }

    @Test
    public void shouldReturnThirtyIfCategoryIsSixesAndAllValuesOfDiceAreSix() {
        Roll roll = initiateRoll(6,6,6,6,6);

        int actual = service.score(roll, YatzyCategory.SIXES);

        assertEquals(30, actual);
    }

    @Test
    public void shouldReturnSixIfCategoryIsOnePaireAndThereIsOnlyThwoDicesWithTheSameValueThree() {
        Roll roll = initiateRoll(3,4,3,5,6);

        int actual = service.score(roll, YatzyCategory.PAIR);

        assertEquals(6, actual);
    }

    @Test
    public void shouldReturnZeroIfCategoryIsOnePaireAndThereIsNoDicesWithTheSameValues() {
        Roll roll = initiateRoll(1,4,3,5,6);

        int actual = service.score(roll, YatzyCategory.PAIR);

        assertEquals(0, actual);
    }

    @Test
    public void shouldReturnTheSumOfThwoPairesIfCategoryIsTwoPaireAndThereIsTwoPaires() {
        Roll roll = initiateRoll(3,3,5,4,5);

        int actual = service.score(roll, YatzyCategory.TWO_PAIRS);

        assertEquals(16, actual);
    }

    @Test
    public void shouldReturnZeroIfCategoryIsTwoPaireAndThereIsNoDicesWithOnlyOnePaire() {
        Roll roll = initiateRoll(3,3,1,4,5);

        int actual = service.score(roll, YatzyCategory.TWO_PAIRS);

        assertEquals(0, actual);
    }

    @Test
    public void shouldReturnNineIfCategoryIsThreeOfKindAndThereIsThreeDicesWithTheValueThree() {
        Roll roll = initiateRoll(3,3,3,4,5);

        int actual = service.score(roll, YatzyCategory.THREE_OF_A_KIND);

        assertEquals(9, actual);
    }

    @Test
    public void shouldReturnZeroIfCategoryIsThreeOfKindAndThereIsNoThreeDicesWithTheSameValue() {
        Roll roll = initiateRoll(3,3,6,4,5);

        int actual = service.score(roll, YatzyCategory.THREE_OF_A_KIND);

        assertEquals(0, actual);
    }

    @Test
    public void shouldReturnFourIfCategoryIsFourOfKindAndThereIsFourDicesWithTheValueOne() {
        Roll roll = initiateRoll(1,1,1,1,5);

        int actual = service.score(roll, YatzyCategory.FOUR_OF_A_KIND);

        assertEquals(4, actual);
    }

    @Test
    public void shouldReturnZeroIfCategoryIsFourOfKindAndThereIsNoFourDicesWithTheSameValue() {
        Roll roll = initiateRoll(1,1,1,3,5);

        int actual = service.score(roll, YatzyCategory.FOUR_OF_A_KIND);

        assertEquals(0, actual);
    }

    @Test
    public void shouldReturnTheSumOfDicesIfCategoryIsSmallStraightAndDicesRespcetTheRuleOfSmallStraight() {
        Roll roll = initiateRoll(1,2,3,4,5);

        int actual = service.score(roll, YatzyCategory.SMALL_STRAIGHT);

        assertEquals(15, actual);
    }
    @Test
    public void shouldReturnTheSumOfDicesIfCategoryIsSmallStraightAndDicesRespcetTheRuleOfSmallStraightWithAValueOfOneAtLastDice() {
        Roll roll = initiateRoll(2,3,4,5,1);

        int actual = service.score(roll, YatzyCategory.SMALL_STRAIGHT);

        assertEquals(15, actual);
    }


    @Test
    public void shouldReturnZeroIfCategoryIsSmallStraightAndDicesDontRespcetTheRuleOfSmallStraight() {
        Roll roll = initiateRoll(1,2,6,4,5);

        int actual = service.score(roll, YatzyCategory.SMALL_STRAIGHT);

        assertEquals(0, actual);
    }


    @Test
    public void shouldReturnTheSumOfDicesIfCategoryIsLargeStraightAndDicesRespcetTheRuleOfLargeStraight() {
        Roll roll = initiateRoll(2,3,4,5,6);

        int actual = service.score(roll, YatzyCategory.LARGE_STRAIGHT);

        assertEquals(20, actual);
    }

    @Test
    public void shouldReturnTheSumOfDicesIfCategoryIsLargeStraightAndDicesRespcetTheRuleOfLargeStraightWithAValueOfSixAtTheFirstDice() {
        Roll roll = initiateRoll(6,3,4,5,6);

        int actual = service.score(roll, YatzyCategory.LARGE_STRAIGHT);

        assertEquals(24, actual);
    }

    @Test
    public void shouldReturnZeroIfCategoryIsLargeStraightAndDicesDontRespcetTheRuleOfLargeStraight() {
        Roll roll = initiateRoll(6,2,3,4,4);

        int actual = service.score(roll, YatzyCategory.LARGE_STRAIGHT);

        assertEquals(0, actual);
    }
    @Test
    public void shouldReturnTheSumOfDicesIfCategoryIsFullHouseAndThereIsThreeDicesWithSameValueAndTheOtherTwoDicesWithTHeSameValue() {
        Roll roll = initiateRoll(6,2,2,2,6);

        int actual = service.score(roll, YatzyCategory.FULL_HOUSE);

        assertEquals(18, actual);
    }

    @Test
    public void shouldReturnZeroIfCategoryIsFullHouseAndThereIsThreeDicesWithSameValueAndTheOtherTwoDiceshaveDifferentValues() {
        Roll roll = initiateRoll(3,2,2,2,6);

        int actual = service.score(roll, YatzyCategory.FULL_HOUSE);

        assertEquals(0, actual);
    }

    @Test
    public void shouldReturnZeroIfCategoryIsFullHouseAndAllDicesHaveTheSameValue() {
        Roll roll = initiateRoll(2,2,2,2,2);

        int actual = service.score(roll, YatzyCategory.FULL_HOUSE);

        assertEquals(0, actual);
    }


    private Roll initiateRoll(int d1, int d2, int d3, int d4, int d5) {
        Dice[] dices = new Dice[Constants.DICE_NUMBER];
        dices[0] = new Dice(SideValue.getByValue(d1));
        dices[1] = new Dice(SideValue.getByValue(d2));
        dices[2] = new Dice(SideValue.getByValue(d3));
        dices[3] = new Dice(SideValue.getByValue(d4));
        dices[4] = new Dice(SideValue.getByValue(d5));
        return new Roll(dices);
    }

}
