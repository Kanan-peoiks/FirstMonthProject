package MainOOP;
public class GameState {
    int yariyariJokeri = 0; // 50/50
    int skipJoker = 0;
    int hintJoker = 0;

    public void consumeFifty() { yariyariJokeri = 0; }
    public void consumeSkip() { skipJoker = 0; }
    public void consumeHint() { hintJoker = 0; }
}