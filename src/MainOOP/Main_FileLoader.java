package MainOOP;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main_FileLoader {
    public static Question[] loadFromCSV(String path) {
        ArrayList<Question> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                // Format: question|A) ...|B) ...|C) ...|D) ...|answer|hint(optional)
                String[] parts = line.split("\\|", -1);
                if (parts.length >= 6) {
                    String hint = parts.length >= 7 ? parts[6] : null;
                    list.add(new Question(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5], hint));
                }
            }
        } catch (IOException e) {
            System.out.println("CSV oxunarkən xəta: " + e.getMessage());
        }
        return list.toArray(new Question[0]);
    }

    public static void main(String[] args) {
        Question[] loaded = loadFromCSV("questions.csv");
        System.out.println("Yüklənmiş sual sayı: " + loaded.length);
        // Buradan sonra orijinal Main axarı eyni qalır — yüklənmiş sualları istifadə edərək.
    }
}
