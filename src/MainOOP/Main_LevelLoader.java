package MainOOP;
public class Main_LevelLoader {
    public static void main(String[] args) {
        Question[] asan = Main_FileLoader.loadFromCSV("asan.csv");
        Question[] orta = Main_FileLoader.loadFromCSV("orta.csv");
        Question[] cetin = Main_FileLoader.loadFromCSV("cetin.csv");
        Question[] finalQ = Main_FileLoader.loadFromCSV("final.csv");

        Level asanLevel = new Level("asan", asan);
        Level ortaLevel = new Level("orta", orta);
        Level cetinLevel = new Level("cetin", cetin);

        System.out.println("Level və Loader birləşməsi hazırdır.");
    }
}