import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Salam! \uD83D\uDC4B\n" +
"“Azərbaycanın Tarixi Abidələri” viktorinasına xoş gəlmisiniz. Oyun 10 sualdan ibarətdir. Qaydaları oxumaq istəyirsiniz? (Hə / Yox)");
        String heYoxCavabi = scan.nextLine();
        String he = "Hə";
        heYoxCavabi=heYoxCavabi.trim();

    if (he.equalsIgnoreCase(heYoxCavabi)){
        System.out.println("Qaydalar:\n" +
    "Sual 1–3: Bu mərhələdə asan suallar soruşulacaq, bu sualları cavablandırmaq olduqca asandır.\n" +
    "Sual 4–6: Bu mərhələdə orta suallar soruşulacaq, burada tarixi və coğrafi biliklərin lazım olacaq. Həmçinin bu mərhələyə keçdikdən sonra iki Joker qazanırsan\n" +
    "Sual 7–9: Bu mərhələdə çətin suallar soruşulacaq, burada tarix və coğrafi biliklərivi zorlamalı olacaqsan və bu mərhələyə keçdikdən sonra bir Joker qazanacaqsan.\n" +
    "Sual 10: Final sual — bu sualı cavablandırmaq üçün professor olmalısan 😏.\n" +
    "Hər sual A/B/C/D variantlıdır. Səhv cavab verəndə yarışma bitir. İstəsən geri çəkilə və yığdığın xalları götürə bilərsən.\n");
    }
    else {
        System.out.println("Cavabınız yox olaraq qeyd edildi, oyuna keçə bilərik...");
    }
        System.out.println();
        System.out.println("Başlayırıq! Uğurlar! \uD83C\uDF40"); // BURDA AD YAZMASINI ISTE


        //interface ve ya abstract ile yazmaq
        String [][] asanSuallar =
                {//her seviyyede bir dene cox cetin sual qoy
                        {"Azərbaycanın paytaxtı hansıdır?", "A) Bakı B) Gəncə C) Sumqayıt D) Lənkəran", "A"},
                        {"Azərbaycanın ən böyük gölü hansıdır?", "A) Sərsəng B) Xəzər C) Göygöl D) Baykal", "C"},
                        {"Azərbaycanın milli musiqi aləti hansıdır?", "A) Tar B) Piano C) Nərə D) Piano", "A"},
                        {"Azərbaycanın ən yüksək dağ zirvəsi hansıdır?", "A) Tufandağ B) Bazardüzü C) Şahdağ D) Everest", "B"},
                        {"Azərbaycanda ən uzun müddətli hökm sürmüş Türk dövləti hansıdır?", "A) Səfəvilər B) Əfşarlar C) Şirvanşahlar D) Salarilər", "C"}
                };

        String [][] ortaSuallar =
                {//her seviyyede bir dene cox cetin sual qoy
                        {"Azərbaycanın paytaxtı hansıdır?", "A) Bakı B) Gəncə C) Sumqayıt D) Lənkəran", "A"},
                        {"Azərbaycanın ən böyük gölü hansıdır?", "A) Sərsəng B) Xəzər C) Göygöl D) Baykal", "C"},
                        {"Azərbaycanın milli musiqi aləti hansıdır?", "A) Tar B) Piano C) Nərə D) Piano", "A"},
                        {"Azərbaycanın ən yüksək dağ zirvəsi hansıdır?", "A) Tufandağ B) Bazardüzü C) Şahdağ D) Everest", "B"},
                        {"Azərbaycanda ən uzun müddətli hökm sürmüş Türk dövləti hansıdır?", "A) Səfəvilər B) Əfşarlar C) Şirvanşahlar D) Salarilər", "C"}
                };

        String [][] cetinSuallar =
                {//her seviyyede bir dene cox cetin sual qoy
                        {"Azərbaycanın paytaxtı hansıdır?", "A) Bakı B) Gəncə C) Sumqayıt D) Lənkəran", "A"},
                        {"Azərbaycanın ən böyük gölü hansıdır?", "A) Sərsəng B) Xəzər C) Göygöl D) Baykal", "C"},
                        {"Azərbaycanın milli musiqi aləti hansıdır?", "A) Tar B) Piano C) Nərə D) Piano", "A"},
                        {"Azərbaycanın ən yüksək dağ zirvəsi hansıdır?", "A) Tufandağ B) Bazardüzü C) Şahdağ D) Everest", "B"},
                        {"Azərbaycanda ən uzun müddətli hökm sürmüş Türk dövləti hansıdır?", "A) Səfəvilər B) Əfşarlar C) Şirvanşahlar D) Salarilər", "C"}
                };

        //asan suallar ucun olan hisse burada olacaq
        // Random methodu ile 3 random sual sececek ve buna uygun olaraq hemin suallari ekranda cavab edecek

        int duzgunCavab=0;
        int sehvCavab=0;
        boolean[] used = new boolean[asanSuallar.length];

        for (int k = 0;k < 3; k++) {
            int rand =(int)( Math.random() * asanSuallar.length ); //burda xeta var, array 0-1-2 men ise 0-1-2-3
            System.out.println(rand);
            boolean answeredCorrected=false;

            while (true){
                if (used[rand]){
                    rand =(int)( Math.random() * asanSuallar.length );
                    System.out.println(rand);
                }
                else {
                    used[rand]=true;
                    break;
                }
            }

            String dogru = asanSuallar[rand][2].trim().toUpperCase();
                    System.out.println((k+1)+". " + asanSuallar[rand][0]);
            System.out.println(asanSuallar[rand][1]);

                System.out.print("Cavab (A/B/C/D): ");
                String cavab = scan.nextLine().trim().toUpperCase();
            if (cavab.equals(dogru)) {
                System.out.println("Doğru!");
                duzgunCavab++;
                answeredCorrected = true; // sualdan çıx
            } else {
                System.out.println("Səhv! Təəssüf ki, yarışmamız sona çatdı.");
                sehvCavab++;
            }
        }





    }
}