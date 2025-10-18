package MainOOP;
class JokerFactory {
    public static Joker create(String type, String levelName) {
        switch (type) {
            case "50": return new FiftyFiftyJoker(levelName);
            case "skip": return new SkipJoker();
            case "hint": return new HintJoker();
            default: return null;
        }
    }
}

public class Main_ModularJokers {
    public static void main(String[] args) {
        // Bu versiyada jokerlər yaradılarkən factory istifadə olunur.
        GameState gs = new GameState();
        gs.yariyariJokeri = 1;
        gs.skipJoker = 1;
        gs.hintJoker = 1;

        Joker fifty = JokerFactory.create("50", "orta");
        Joker skip = JokerFactory.create("skip", "orta");
        Joker hint = JokerFactory.create("hint", "orta");

        // Sonra bunlar original Main axarında olduğu kimi çağırılır.
    }
}
