package MainOOP;

// FILE: FiftyFiftyJoker.java
public class FiftyFiftyJoker implements Joker {
    private final String levelName;

    public FiftyFiftyJoker(String levelName) {
        this.levelName = levelName;
    }

    @Override
    public int use(Question[] levelArr, int rand, GameState gs) {
        if (!available(gs)) {
            System.out.println("'50/50' Jokeri artıq istifadə edilib.");
            levelArr[rand].printFull();
            return rand;
        }
        System.out.println("Siz '50/50' Jokerini seçdiniz ve sualdaki iki səhv cavab silinəcək.");
        levelArr[rand].printQuestion();
        String correct = levelArr[rand].answer;
        for (String opt : levelArr[rand].options) {
            if (opt.trim().toUpperCase().charAt(0) == correct.charAt(0)) {
                System.out.println(opt);
                break;
            }
        }
        switch (levelName) {
            case "asan":
                for (String opt : levelArr[rand].options) {
                    if (opt.trim().toUpperCase().charAt(0) != correct.charAt(0)) {
                        System.out.println(opt);
                        break;
                    }
                }
                break;
            case "orta":
                if (correct.equals("A") || correct.equals("D")) {
                    System.out.println(levelArr[rand].options[2]);
                } else {
                    System.out.println(levelArr[rand].options[3]);
                }
                break;
            case "cetin":
                if (correct.equals("B") || correct.equals("D")) {
                    System.out.println(levelArr[rand].options[0]);
                } else {
                    System.out.println(levelArr[rand].options[3]);
                }
                break;
            case "final":
                if (correct.equals("B") || correct.equals("D")) {
                    System.out.println(levelArr[rand].options[0]);
                } else {
                    System.out.println(levelArr[rand].options[3]);
                }
                break;
            default:
                for (String opt : levelArr[rand].options) {
                    if (opt.trim().toUpperCase().charAt(0) != correct.charAt(0)) {
                        System.out.println(opt);
                        break;
                    }
                }
                break;
        }
        gs.consumeFifty();
        return rand;
    }

    @Override
    public boolean available(GameState gs) {
        return gs.yariyariJokeri > 0;
    }
}
