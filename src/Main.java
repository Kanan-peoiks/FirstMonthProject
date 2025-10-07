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
        System.out.println("Başlayırıq! Uğurlar! \uD83C\uDF40");

        //interface ve ya abstract ile yazmaq
        String [][] asanSuallar =
                {//her seviyyede bir dene cox cetin sual qoy
                        {"Azərbaycanın paytaxtı hansıdır?", "A", "A) Bakı B) Gəncə C) Sumqayıt"},
                        {"Azərbaycanın ən böyük gölü hansıdır?", "C", "A) Sərsəng B) Xəzər C) Göygöl"},
                        {"Azərbaycanın milli musiqi aləti hansıdır?", "A", "A) Tar B) Piano C) Nərə"},
                        {"Azərbaycanın ən yüksək dağ zirvəsi hansıdır?", "B", "A) Tufandağ B) Bazardüzü C) Şahdağ"},
                        {"Azərbaycanda ən uzun müddətli hökm sürmüş Türk dövləti hansıdır?", "C", "A) Səfəvilər B) Əfşarlar C) Şirvanşahlar"}
                };

        String [][] ortaSuallar =
                {
                        {"Azərbaycanın paytaxtı hansıdır?", "C", "A) Bakı B) Gəncə C) Sumqayıt"},
                        {"Azərbaycanın ən böyük gölü hansıdır?", "C", "A) Sərsəng B) Xəzər C) Göygöl"},
                        {"Azərbaycanın milli musiqi aləti hansıdır?", "A", "A) Tar B) Piano C) Nərə"},
                        {"Azərbaycanın ən yüksək dağ zirvəsi hansıdır?", "B", "A) Tufandağ B) Bazardüzü C) Şahdağ"},
                        {"Azərbaycanda ən uzun müddətli hökm sürmüş Türk dövləti hansıdır?", "C", "A) Səfəvilər B) Əfşarlar C) Şirvanşahlar"}
                };

        String [][] cetinSuallar =
                {
                        {"Azərbaycanın paytaxtı hansıdır?", "C", "A) Bakı B) Gəncə C) Sumqayıt"},
                        {"Azərbaycanın ən böyük gölü hansıdır?", "C", "A) Sərsəng B) Xəzər C) Göygöl"},
                        {"Azərbaycanın milli musiqi aləti hansıdır?", "A", "A) Tar B) Piano C) Nərə"},
                        {"Azərbaycanın ən yüksək dağ zirvəsi hansıdır?", "B", "A) Tufandağ B) Bazardüzü C) Şahdağ"},
                        {"Azərbaycanda ən uzun müddətli hökm sürmüş Türk dövləti hansıdır?", "C", "A) Səfəvilər B) Əfşarlar C) Şirvanşahlar"}
                };

        int sehvSay=0;
        //asan suallar ucun olan hisse burada olacaq
        // Random methodu ile 3 random sual sececek ve buna uygun olaraq hemin suallari ekranda cavab edecek

        for (int i =0; i<asanSuallar.length; i++) {
            //int sualIndeksi = 0;
            String dogru = asanSuallar[i][1].trim().toUpperCase();
            do {
                System.out.println((i + 1) + ". Sual: " + asanSuallar[i][0]);
                for (int j = 2; j < asanSuallar[i].length; j++) {
                    System.out.println(asanSuallar[i][j]);
                }
                System.out.print("Cavab (A/B/C): ");
                String cavab = scan.nextLine().trim().toUpperCase();

                if (!(cavab.equals("A") || cavab.equals("B") || cavab.equals("C"))) {
                    System.out.println("Zəhmət olmasa yalnız A, B və ya C daxil edin.");
                    continue; // do-while davam etsin
                }


                if (cavab.equals(dogru)) {
                    System.out.println("Doğru!");
                   // duzgunSay++;
                   //yo answeredCorrected = true; // sualdan çıx
                } else {
                    System.out.println("Səhv! Yenidən cəhd edin.");
                    sehvSay++;
                }
            } while (sehvSay==0);// sehv cavab verse sehvSay bir vahid artacaq ve proqram bitsin
        }






    }
}