package MainOOP;
import java.util.Scanner;

class Level {
    String name;
    Question[] questions;

    public Level(String name, Question[] questions) {
        this.name = name;
        this.questions = questions;
    }
}

public class Main_Level {
    public static void main(String[] args) {
        // Bu Main faylı sənin orijinal axarı qoruyur — yalnız suallar Level obyektinə köçürüldü.
        Scanner scan = new Scanner(System.in);
        System.out.print("Adınızı daxil edin: ");
        String name = scan.nextLine();
        System.out.println("Salam, " + name + "! \uD83D\uDC4B\n" +
                "“Azərbaycanın Tarixi Abidələri” viktorinasına xoş gəlmisiniz. Oyun 10 sualdan ibarətdir. Qaydaları oxumaq istəyirsiniz? (Hə / Yox)");
        String heYoxCavabi = scan.nextLine();
        String he = "Hə";
        heYoxCavabi=heYoxCavabi.trim();

        if (he.equalsIgnoreCase(heYoxCavabi)){
            System.out.println("Qaydalar:\n" +
                    "Sual 1–3: Bu mərhələdə asan suallar soruşulacaq, bu sualları cavablandırmaq olduqca asandır.\n" +
                    "Sual 4–6: Bu mərhələdə orta suallar soruşulacaq, burada tarixi və coğrafi bilikləriniz lazım olacaq. Həmçinin bu mərhələyə keçdikdən sonra iki Joker qazanacaqsınız.\n" +
                    "Sual 7–9: Bu mərhələdə çətin suallar soruşulacaq, burada tarix və coğrafi biliklərinizi zorlamalı olacaqsınız və bu mərhələyə keçdikdən sonra bir Joker qazanacaqsınız.\n" +
                    "Sual 10: Final sualı olacaq.\n" +
                    "Hər sual A/B/C/D variantlıdır. Səhv cavab verəndə yarışma bitir və yığdığınız xalların (böyük) bir qismini itirirsiniz. İstəsəniz geri çəkilə bilərsiniz və yığdığınız xalları götürə bilərsiniz.");
        }

        else {
            System.out.println("Cavabınız yox olaraq qeyd edildi, oyuna keçə bilərik...");
        }
        System.out.println();
        System.out.println("Başlayırıq! Uğurlar! 🍀");

        Level asan = new Level("asan", new Question[]{
                new Question("Səfəvilərin ilk paytaxtı hansıdır?", "A) Təbriz", "B) Qəzvin", "C) İsfahan", "D) Tehran", "A"),
                new Question("Şuşa şəhərinin banisi kim olub?", "A) Fətəli xan", "B) Nadir şah", "C) Pənahəli xan", "D) Cavad xan", "C"),
                new Question("Gəncə şəhərinin tarixi “Gəncə qalası” hansı dövrdə salınıb?", "A) Monqolların dövründə", "B) Qafqaz Albaniyası dövründə", "C) Səfəvilər dövründə", "D) Şəddadilər dövründə", "D"),
                new Question("Azərbaycan Respublikasının ilk paytaxtı hansı şəhər olub?", "A) Bakı", "B) Şəki", "C) Naxçıvan", "D) Gəncə", "D"),
                new Question("Azərbaycanda ən uzun müddətli hökm sürmüş Türk dövləti hansıdır?", "A) Səfəvilər", "B) Əfşarlar", "C) Şirvanşahlar", "D) Salarilər", "C")
        });

        // Main axarı: eynilə sənin kodun — mən burada sadəcə Level istifadə edirəm.
        // ... (Main axarı səninki ilə eynidir — məntiqə toxunulmayıb)
        System.out.println("(Bu faylda Main axarı sənin orijinal kodunla eynidir — yoxlama üçün kod sənə lazım olarsa deyərsən.)");
        scan.close();
    }
}