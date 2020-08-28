package decipher;

import exceptions.CipherIsTooShortException;
import exceptions.NotEnoughCharactersException;

import java.util.HashMap;
import java.util.Scanner;

public class Decipher {

    public void run() throws CipherIsTooShortException, NotEnoughCharactersException {
        String cipher = "";
        {
            System.out.println("The password stored in the cipher text:");
            Scanner scanner = new Scanner(System.in);
            cipher = scanner.next();
            if (cipher.length() < 4) throw new CipherIsTooShortException("The cipher lenght is too short : " + cipher);
            HashMap<String, Integer> numberOfOccurrences = findNumberOfOccurrences(cipher);
            if (numberOfOccurrences.size() < 4)
                throw new NotEnoughCharactersException("The cipher needs to contain more than 4 characters in order to form a password!");
            System.out.println("is");
            getPadlockKey(cipher);
        }

    }

    public void getPadlockKey(String cipher) {
        HashMap<String, Integer> numberOfOccurrences = findNumberOfOccurrences(cipher);
        String padlockKey[] = new String[4];
        for (int i = 0; i < 4; i++) {
            int max = 0;
            String tempKey = "";
            for (String key : numberOfOccurrences.keySet()) {
                if (max < numberOfOccurrences.get(key)) {
                    max = numberOfOccurrences.get(key);
                    tempKey = key;
                }
                if (max == numberOfOccurrences.get(key) && cipher.indexOf(tempKey) > cipher.indexOf(key)) tempKey = key;
                padlockKey[i] = tempKey;
            }
            numberOfOccurrences.remove(tempKey);
        }
        System.out.println(padlockKey[0] + padlockKey[1] + padlockKey[2] + padlockKey[3]);
    }

    public HashMap<String, Integer> findNumberOfOccurrences(String cipher) {
        HashMap<String, Integer> numberOfOccurrences = new HashMap<>();
        char symbols[] = cipher.toCharArray();
        for (char symbol : symbols) {
            String character = String.valueOf(symbol);
            if (numberOfOccurrences.containsKey(character)) {
                int newValue = numberOfOccurrences.get(character) + 1;
                numberOfOccurrences.put(character, newValue);
            } else {
                numberOfOccurrences.put(character, 1);
            }
        }
        return numberOfOccurrences;
    }
}
