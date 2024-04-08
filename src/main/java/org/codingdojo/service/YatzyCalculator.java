package org.codingdojo.service;

import org.codingdojo.enumeration.YatzyCategory;
import org.codingdojo.models.Roll;

public interface YatzyCalculator {
    int score(Roll roll, YatzyCategory category);
}
