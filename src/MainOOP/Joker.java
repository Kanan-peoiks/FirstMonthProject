// FILE: Joker.java
package MainOOP;
public interface Joker {
    /**
     * Apply joker. Returns new question index to use (may be same as input rand)
     */
    int use(Question[] levelArr, int rand, GameState gs);

    boolean available(GameState gs);
}