package io.github.dmk0001.passgen.utils;

import java.util.ArrayList;
import java.util.List;

public class CharUtils {

    private static final List<Integer> SMALL_LETTER = new ArrayList<>(List.of(
            97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108,
            109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122));

    private static final List<Integer> BIG_LETTER = new ArrayList<>(List.of(
            65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79,
            80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90));

    private static final List<Integer> NUMBERS = new ArrayList<>(List.of(48, 49, 50, 51, 52, 53, 54, 55, 56, 57));

    private static final List<Integer> SPECIAL_CHARACTERS = new ArrayList<>(List.of(
            33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47,
            58, 59, 60, 61, 62, 63, 64, 91, 92, 93, 94, 95, 96, 123, 124, 125, 126));

    public static List<Integer> getBigLetter() {
        return BIG_LETTER;
    }

    public static List<Integer> getNumbers() {
        return NUMBERS;
    }

    public static List<Integer> getSmallLetter() {
        return SMALL_LETTER;
    }

    public static List<Integer> getSpecialCharacters() {
        return SPECIAL_CHARACTERS;
    }
}