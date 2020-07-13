package main.java;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class BullCow {
    private String guessed_number;
    private List<String> logs;

    public BullCow() {
        logs = new ArrayList<String>(0);
    }

    public BullCow(int i) {
        generatedNumber();
        logs = new ArrayList<String>(0);
    }

    public void generatedNumber() {
        Random random = new Random();
        guessed_number = "";
        HashSet<Integer> ints = new HashSet<Integer>(3);
        int i = 0;
        while (ints.size() != 4) {
            i = random.nextInt(9);
            ints.add(i);
        }
        for (Integer anInt : ints) {
            guessed_number+=(String.valueOf(anInt));
        }
    }

    public String getGuessed_number() {
        return guessed_number;
    }

    public void setGuessed_number(String guessed_number) {
        this.guessed_number = guessed_number;
    }

    public String pushVersion(String s) {
        char[] vn = s.toCharArray();
        char[] gn = guessed_number.toCharArray();
        int bull_point = 0;
        int cow_point = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (gn[j] == vn[i]) {
                    if (i == j) {
                        bull_point++;
                    } else cow_point++;
                }
            }
        }

        logs.add(bull_point + "Б" + cow_point + "К");
        return bull_point + "Б" + cow_point + "К";
    }

    public List<String> getLogs() {
        return logs;
    }
}
