package game;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class BullCow {
    private String guessed_number;
    private List<String> logs;
    private boolean win;

    public BullCow() {
        generatedNumber();
        logs = new ArrayList<>(0);
        win = false;
    }

    public void generatedNumber() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        HashSet<Integer> ints = new HashSet<>(3);
        int i;
        while (ints.size() != 4) {
            i = random.nextInt(9);
            ints.add(i);
        }
        for (Integer anInt : ints) {
            stringBuilder.append(anInt);
        }
        guessed_number = stringBuilder.toString();
    }

    public String getGuessed_number() {
        return guessed_number;
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
        if (bull_point == 4)
            win = true;
        logs.add(bull_point + "Б" + cow_point + "К");
        return bull_point + "Б" + cow_point + "К";
    }

    public List<String> getLogs() {
        return logs;
    }

    public boolean isWin() {
        return win;
    }
}
