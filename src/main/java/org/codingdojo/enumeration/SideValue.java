package org.codingdojo.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum SideValue {
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6);

    private final int value;

    public static SideValue getByValue(int targetValue) {
        return  Arrays.stream(SideValue.values()).filter(e -> e.getValue() == targetValue).findFirst().orElse(null);
    }


}
