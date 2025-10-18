package MainOOP;
public class SkipJoker implements Joker {
    @Override
    public int use(Question[] levelArr, int rand, GameState gs) {
        if (!available(gs)) {
            System.out.println("'Skip' Jokeri artıq istifadə edilib.");
            levelArr[rand].printFull();
            return rand;
        }
        System.out.println("Siz 'Skip' Jokerindən istifadə edtiniz. Sualınız dəyişir...");
        int newIndex = levelArr.length - 1;
        levelArr[newIndex].printFull();
        gs.consumeSkip();
        return newIndex;
    }

    @Override
    public boolean available(GameState gs) {
        return gs.skipJoker > 0;
    }
}