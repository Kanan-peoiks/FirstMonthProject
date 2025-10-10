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
    "Sual 4–6: Bu mərhələdə orta suallar soruşulacaq, burada tarixi və coğrafi bilikləriniz lazım olacaq. Həmçinin bu mərhələyə keçdikdən sonra iki Joker qazanacaqsınız.\n" +
    "Sual 7–9: Bu mərhələdə çətin suallar soruşulacaq, burada tarix və coğrafi biliklərinizi zorlamalı olacaqsan və bu mərhələyə keçdikdən sonra bir Joker qazanacaqsınız.\n" +
    "Sual 10: Final sualı — bu sualı cavablandırmaq üçün professor olmalısınız 😏.\n" +
    "Hər sual A/B/C/D variantlıdır. Səhv cavab verəndə yarışma bitir və yığdığınız xalların (böyük) bir qismini itirirsiniz. İstəsəniz geri çəkilə bilərsiniz və yığdığınız xalları götürə bilərsiniz.");
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
        int sehvXal=0;
        int joker = 0; //EHTIYAC OLACAQMI BELKE BELE ETMEK OLAR KI, UMUMI OLAN JOKERINIZ BU QEDERDI KIMISINDEN
        int yariyariJokeri=0;
        int skipJoker=0;
        int hintJoker = 0;
        boolean[] usedAsan = new boolean[asanSuallar.length];


        for (int k = 0;k < 3; k++) {
            int rand =(int)( Math.random() * asanSuallar.length );
            System.out.println(rand); //SİLİNECEK HİSSE

            boolean answeredCorrected=false;

            while (true){
                if (usedAsan[rand]){
                    rand =(int)( Math.random() * asanSuallar.length );
                    System.out.println(rand); //SİLİNECEK HİSSE
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
    System.out.println("Sıradakı suallar üçün geriçəkilmə haqqına sahib oldunuz.");
    //---------------------------------------------------------------------------------
                    //GERİCEKİLME METHODUNA GİRİS
                //---------------------------------------------------------------------------------
                }
                xal = xal+10;
                duzgunCavab++; //SEHV CAVAB VERİLEN YERDE İSTİFADE ETMİSEM
            } else {
                System.out.println("Səhv!");
                System.out.println("Doğru cavab: "+dogru);
                sehvCavab=true;
                sehvXal = xal / (2 + duzgunCavab); //SEHV CAVAB VERDIKDE XALINDA OYNAMALAR EDIRIK, YA RISK AL, YA DA Geri CEKIL
                break;
            }
            System.out.println();
        }
    if (sehvCavab){
        System.out.println("Təəssüf ki, yarışmamız sona çatdı. Sizin xalınız: "+sehvXal);
        scan.close();
        return;
    }

//-------------------------------------------IKINCI MERHELE-------------------------------------------

System.out.println("Təbriklər!! Siz birinci mərhələni bitirdiniz. Sizin xalınız: "+xal);
System.out.println("Yeni mərhələdə iki Jokeriniz olacaq, bir ədəd '50/50' Jokeri və bir ədəd 'Skip' Jokeri.\n" +
"Jokerlər haqqında məlumat: '50/50' Jokeri sualdakı iki səhv cavabı silir, 'Skip' Jokeri isə yeni bir suala keçir.");
yariyariJokeri++;
skipJoker++;

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
//------------------------------------------------------------------------------------------------------
//JOKERLER UCUN HISSE BURADA OLACAQ
            //------------------------------------------------------------------------------------------------------
            System.out.println("Seciminiz daxil edin: 1. Suala cavab vermek 2. Joker istifade etmek 3. Gericekilme");
            int secim = scan.nextInt();
            scan.nextLine();
//        do { //EGER CASELERDEN BASQA BIR SEY DESE MESELEN A VE SAIR KIMI YENIDEN ISLETSIN BURANI VE SECIM ETSIN
//
//        }
//        while ();
            switch (secim){ //CAVAB VERMEK, JOKER ISTIFADE ETMEK VE GERICEKILME
                case 1:
//                    System.out.print("Cavab (A/B/C/D): ");
//                    String cavab = scan.nextLine().trim().toUpperCase();
                    break;

                case 2:
                    System.out.println("Zehmet olmasa istifade etmek istediyiniz jokeri secin (1/2/3): 1. '50/50' Jokeri 2. 'Skip' Jokeri 3. 'Hint' Jokeri");
                    int secim2 = scan.nextInt();
                    if (secim2 == 1){
                        if (yariyariJokeri == 1){ //do while salmaliyam ki hemise true olmasin
                            System.out.println("Siz '50/50' Jokerini secdiniz ve sualdaki iki sehv cavab silinecek.");
                            int randSual =(int)( Math.random() * 4 );
                            System.out.println(randSual);
                            switch (randSual){
                                case 0:
                                    System.out.println("A"); //SUALLARIN CAVAB OLAN YER
                                    break;
                                case 1:
                                    System.out.println("B");
                                    break;
                                case 2:
                                    System.out.println("C");
                                    break;
                                case 3:
                                    System.out.println("D");
                                    break;
                                default:
                                    System.out.println();
                            }
                            yariyariJokeri=0;}
                        else {
                            System.out.println("Siz bu Jokeri istifade etmisiniz...");
                        }
                    }
                    else if (secim2==2){
                        System.out.println("Siz 'Skip' Jokerini secdiniz ve basqa bir suala kecid edilecek");
                        skipJoker=0;
                    }
                    else if (secim2==3){
                        //HINT BURDA OLACAQ
                        hintJoker = 0;
                    }
                    else {
                        System.out.println("Teessuf ki, bele bir seciminiz yoxdur.");
                    }
                    break;

                case 3:
                    System.out.println("Siz gericekilme haqqinizdan istifade edirsiniz. Sizin xaliniz "+ "xal");
                    break;

                default:
                    System.out.println("Bele bir seciminiz yoxdur.");
            }
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
                xal = xal+10;
                duzgunCavab++;
            } else {
                System.out.println("Səhv!");
                System.out.println("Doğru cavab: "+dogru);
                sehvCavab=true;
                sehvXal = xal / (2 + duzgunCavab); //SEHV CAVAB VERDIKDE XALINDA OYNAMALAR EDIRIK, YA RISK AL, YA DA Geri CEKIL
                break;
            }
            System.out.println();
        }
        if (sehvCavab){
            System.out.println("Təəssüf ki, yarışmamız sona çatdı. Sizin xalınız: "+sehvXal);
            scan.close();
            return;
        }
System.out.println("Təbriklər!! Siz ikinci mərhələni bitirdiniz. Sizin xalınız: "+xal);
System.out.println("Yeni mərhələdə əlavə bir Jokeriniz olacaq, bir ədəd 'Hint' Jokeri.\n" +
"Joker haqqında məlumat: 'Hint' Jokeri sualdakı cavabı tapmağa ipucu verir. J-yə basaraq jokerdən istifadə edə bilərsiniz.");

//-------------------------------------------UCUNCU MERHELE-------------------------------------------
//BURDA HINT JOKERI UCUN MASSIVE ELAVE YER TEYIN ETMEK LAZIMDIR, EGER ISTIFADECI HINT JOKERINI ISTIFADE ETMEK ISTESE ARRAYIN HEMIN HISSESINE MURACIET ETSIN


System.out.println("Təbriklər!! Siz birinci mərhələni bitirdiniz. Sizin xalınız: "+xal);
System.out.println("Yeni mərhələdə iki Jokeriniz olacaq, bir ədəd '50/50' Jokeri və bir ədəd 'Skip' Jokeri.\n" +
"Jokerlər haqqında məlumat: '50/50' Jokeri sualdakı iki səhv cavabı silir, 'Skip' Jokeri isə yeni bir suala keçir. J-yə basaraq jokerdən istifadə edə bilərsiniz.");
        hintJoker++;

        boolean[] usedCetin = new boolean[cetinSuallar.length];

        for (int k = 0;k < 3; k++) {
            int rand =(int)( Math.random() * cetinSuallar.length );
            System.out.println(rand);

            boolean answeredCorrected=false;

            while (true){
                if (usedCetin[rand]){
                    rand =(int)( Math.random() * cetinSuallar.length );
                    System.out.println(rand);
                }
                else {
                    usedCetin[rand]=true;
                    break;
                }
            }
            String dogru = cetinSuallar[rand][2].trim().toUpperCase();
            System.out.println((k+1)+". " + cetinSuallar[rand][0]); //SUALLAR
            System.out.println(cetinSuallar[rand][1]); //VARIANTLAR

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
                xal = xal+10;
                duzgunCavab++;
            } else {
                System.out.println("Səhv!");
                System.out.println("Doğru cavab: "+dogru);
                sehvCavab=true;
                sehvXal = xal / (2 + duzgunCavab); //SEHV CAVAB VERDIKDE XALINDA OYNAMALAR EDIRIK, YA RISK AL, YA DA Geri CEKIL
                break;
            }
            System.out.println();
        }
        if (sehvCavab){
            System.out.println("Təəssüf ki, yarışmamız sona çatdı. Sizin xalınız: "+sehvXal);
            scan.close();
            return;
        }

System.out.println("Təbriklər!! Siz üçüncü mərhələni bitirdiniz. Sizin xalınız: "+xal);
System.out.println("Son mərhələyə xoş gəldiniz, cənab Professor...");




        scan.close();
    }
}