package org.codingdojo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.codingdojo.enumeration.SideValue;
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Dice {
    private SideValue side;
}
