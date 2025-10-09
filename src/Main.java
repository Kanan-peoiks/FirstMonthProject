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
    "Sual 4–6: Bu mərhələdə orta suallar soruşulacaq, burada tarixi və coğrafi biliklərin lazım olacaq. Həmçinin bu mərhələyə keçdikdən sonra iki Joker qazanacaqsınız.\n" +
    "Sual 7–9: Bu mərhələdə çətin suallar soruşulacaq, burada tarix və coğrafi biliklərivi zorlamalı olacaqsan və bu mərhələyə keçdikdən sonra bir Joker qazanacaqsınız.\n" +
    "Sual 10: Final sualı — bu sualı cavablandırmaq üçün professor olmalısan 😏.\n" +
    "Hər sual A/B/C/D variantlıdır. Səhv cavab verəndə yarışma bitir. İstəsən geri çəkilə və yığdığın xalları götürə bilərsən.");
    }
    else {
        System.out.println("Cavabınız yox olaraq qeyd edildi, oyuna keçə bilərik...");
    }
        System.out.println();
        System.out.println("Başlayırıq! Uğurlar! \uD83C\uDF40"); // BURDA AD YAZMASINI ISTE


        //interface ve ya abstract ile yazmaq
        String [][] asanSuallar =
                {//her seviyyede bir dene cox cetin sual qoy
                        {"Səfəvilərin ilk paytaxtı hansıdır?", "A) Təbriz B) Qəzvin C) İsfahan D) Tehran", "A"},
                        {"Azərbaycanın ən böyük gölü hansıdır?", "A) Sərsəng B) Xəzər C) Göygöl D) Baykal", "C"},
                        {"Azərbaycanın milli musiqi aləti hansıdır?", "A) Tar B) Piano C) Nərə D) Gitara", "A"},
                        {"Azərbaycanın ən yüksək dağ zirvəsi hansıdır?", "A) Tufandağ B) Bazardüzü C) Şahdağ D) Everest", "B"},
                        {"Azərbaycanda ən uzun müddətli hökm sürmüş Türk dövləti hansıdır?", "A) Səfəvilər B) Əfşarlar C) Şirvanşahlar D) Salarilər", "C"}
                };

        String [][] ortaSuallar =
                {//her seviyyede bir dene cox cetin sual qoy
                        {"Azərbaycanın paytaxtı hansıdır?", "A) Bakı B) Gəncə C) Sumqayıt D) Lənkəran", "A"},
                        {"Azərbaycanın ən böyük gölü hansıdır?", "A) Sərsəng B) Xəzər C) Göygöl D) Baykal", "C"},
                        {"Azərbaycanın milli musiqi aləti hansıdır?", "A) Tar B) Piano C) Nərə D) Gitara", "A"},
                        {"Azərbaycanın ən yüksək dağ zirvəsi hansıdır?", "A) Tufandağ B) Bazardüzü C) Şahdağ D) Everest", "B"},
                        {"Azərbaycanda ən uzun müddətli hökm sürmüş Türk dövləti hansıdır?", "A) Səfəvilər B) Əfşarlar C) Şirvanşahlar D) Salarilər", "C"}
                };

        String [][] cetinSuallar =
                {//her seviyyede bir dene cox cetin sual qoy
                        {"Azərbaycanın paytaxtı hansıdır?", "A) Bakı B) Gəncə C) Sumqayıt D) Lənkəran", "A"},
                        {"Azərbaycanın ən böyük gölü hansıdır?", "A) Sərsəng B) Xəzər C) Göygöl D) Baykal", "C"},
                        {"Azərbaycanın milli musiqi aləti hansıdır?", "A) Tar B) Piano C) Nərə D) Gitara", "A"},
                        {"Azərbaycanın ən yüksək dağ zirvəsi hansıdır?", "A) Tufandağ B) Bazardüzü C) Şahdağ D) Everest", "B"},
                        {"Azərbaycanda ən uzun müddətli hökm sürmüş Türk dövləti hansıdır?", "A) Səfəvilər B) Əfşarlar C) Şirvanşahlar D) Salarilər", "C"}
                };

        //asan suallar ucun olan hisse burada olacaq
        // Random methodu ile 3 random sual sececek ve buna uygun olaraq hemin suallari ekranda cavab edecek

        int duzgunCavab=0;
        boolean sehvCavab=false;
        int xal=0;
        int joker = 0;
        boolean[] usedAsan = new boolean[asanSuallar.length];


        for (int k = 0;k < 3; k++) {
            int rand =(int)( Math.random() * asanSuallar.length );
            System.out.println(rand);

            boolean answeredCorrected=false;

            while (true){
                if (usedAsan[rand]){
                    rand =(int)( Math.random() * asanSuallar.length );
                    System.out.println(rand);
                }
                else {
                    usedAsan[rand]=true;
                    break;
                }
            }
            String dogru = asanSuallar[rand][2].trim().toUpperCase();
            System.out.println((k+1)+". " + asanSuallar[rand][0]); //SUALLAR
            System.out.println(asanSuallar[rand][1]); //VARIANTLAR

                System.out.print("Cavab (A/B/C/D): ");
                String cavab = scan.nextLine().trim().toUpperCase();

//SADECE VARIANTLARDAKI HERFLERI DAXIL ETMEK
            if (!(cavab.equals("A") || cavab.equals("B") || cavab.equals("C") || cavab.equals("D"))) {
                System.out.println("Zəhmət olmasa yalnız A, B, C və ya D daxil edin.");
                cavab = scan.nextLine().trim().toUpperCase();
            }

//CAVABIN DOGRULUGUNU YOXLAMAQ
            if (cavab.equals(dogru)) {
                System.out.println("Doğrudur! Siz 10 xal qazandınız. ");
                if (k==0){
                    System.out.println("Sıradakı suallar üçün geriçəkilmə haqqını da sahib oldunuz."); //GERİCEKİLME METHODUNA GİRİS
                }
                xal = xal+10;
                duzgunCavab++; //HELE KI LAZIM DEYIL
            } else {
                System.out.println("Səhv!");
                System.out.println("Doğru cavab: "+cavab);
                sehvCavab=true;
                break;
            }
            System.out.println();
        }
    if (sehvCavab){
        System.out.println("Təəssüf ki, yarışmamız sona çatdı. Sizin xalınız: "+xal);
        scan.close();
        return;
    }

//-------------------------------------------IKINCI MERHELE-------------------------------------------

        System.out.println("Təbriklər!! Siz birinci mərhələni bitirdiniz. Sizin xalınız: "+xal);
        System.out.println("Yeni mərhələdə iki Jokeriniz olacaq, bir ədəd '50/50' Jokeri və bir ədəd 'Skip' Jokeri.\n" +
"Jokerlər haqqında məlumat: '50/50' Jokeri sualdakı iki səhv cavabı silir, 'Skip' Jokeri isə yeni bir suala keçir. J-yə basaraq jokerdən istifadə edə bilərsiniz.");
        boolean[] usedOrta = new boolean[ortaSuallar.length];
        for (int k = 0;k < 3; k++) {
            int rand =(int)( Math.random() * ortaSuallar.length );
            System.out.println(rand);

            boolean answeredCorrected=false;

            while (true){
                if (usedOrta[rand]){
                    rand =(int)( Math.random() * ortaSuallar.length );
                    System.out.println(rand);
                }
                else {
                    usedOrta[rand]=true;
                    break;
                }
            }
            String dogru = ortaSuallar[rand][2].trim().toUpperCase();
            System.out.println((k+1)+". " + ortaSuallar[rand][0]); //SUALLAR
            System.out.println(ortaSuallar[rand][1]); //VARIANTLAR

            System.out.print("Cavab (A/B/C/D): ");
            String cavab = scan.nextLine().trim().toUpperCase();

//SADECE VARIANTLARDAKI HERFLERI DAXIL ETMEK
            if (!(cavab.equals("A") || cavab.equals("B") || cavab.equals("C") || cavab.equals("D"))) {
                System.out.println("Zəhmət olmasa yalnız A, B, C və ya D daxil edin.");
                cavab = scan.nextLine().trim().toUpperCase();
            }

//CAVABIN DOGRULUGUNU YOXLAMAQ
            if (cavab.equals(dogru)) {
                System.out.println("Doğrudur! Siz 20 xal qazandınız. ");
                xal = xal+20;
                duzgunCavab++; //HELE KI LAZIM DEYIL
            } else {
                System.out.println("Səhv!");
                sehvCavab=true;
                break;
            }
            System.out.println();
        }
        if (sehvCavab){
            System.out.println("Təəssüf ki, yarışmamız sona çatdı. Sizin xalınız: "+xal);
            scan.close();
            return;
        }





        scan.close();
    }
}