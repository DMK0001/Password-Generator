package io.github.dmk0001.passgen;

import io.github.dmk0001.passgen.utils.CharUtils;
import io.github.dmk0001.passgen.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class PasswordGenerator {

    private final int length;
    private final LetterType letterType;
    private final boolean numbers;
    private final boolean specialCharacters;

    public PasswordGenerator(int length, LetterType letterType, boolean numbers, boolean specialCharacters) throws PasswordException {
        if (length < 1){
            throw new PasswordException("Password is too short.");
        }
        if (length > 256){
            throw new PasswordException("Password is too long.");
        }
        if (letterType == null){
            throw new PasswordException("Wrong letter type.");
        }
        this.length = length;
        this.letterType = letterType;
        this.numbers = numbers;
        this.specialCharacters = specialCharacters;
    }

    public String generate(){
        StringBuilder stringBuilder = new StringBuilder();
        List<Integer> allowedChars = new ArrayList<>();

        switch (letterType) {
            case ONLY_SMALL -> allowedChars.addAll(CharUtils.getSmallLetter());
            case ONLY_BIG -> allowedChars.addAll(CharUtils.getBigLetter());
            case MIXED -> {
                allowedChars.addAll(CharUtils.getSmallLetter());
                allowedChars.addAll(CharUtils.getBigLetter());
            }
        }

        if (numbers)
            allowedChars.addAll(CharUtils.getNumbers());

        if (specialCharacters)
            allowedChars.addAll(CharUtils.getSpecialCharacters());

        for (int i = 0; i < length; i++){
            int randomId = Utils.randomInt(allowedChars.size());
            stringBuilder.append((char)(int)allowedChars.get(randomId));
        }

        return stringBuilder.toString();
    }
}