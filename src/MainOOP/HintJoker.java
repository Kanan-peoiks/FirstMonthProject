// FILE: HintJoker.java
package MainOOP;
public class HintJoker implements Joker {
    @Override
    public int use(Question[] levelArr, int rand, GameState gs) {
        if (!available(gs)) {
            System.out.println("Hint Jokeri artıq istifadə edilib.");
            levelArr[rand].printFull();
            return rand;
        }
        System.out.println("Siz 'Hint' Jokerindən istifadə etdiniz. Sualınız üçün ipucu verilir...");
        levelArr[rand].printFull();
        if (levelArr[rand].hint != null) {
            System.out.println("Hint: " + levelArr[rand].hint);
        } else {
            System.out.println("Hint mövcud deyil.");
        }
        gs.consumeHint();
        return rand;
    }

    @Override
    public boolean available(GameState gs) {
        return gs.hintJoker > 0;
    }
}