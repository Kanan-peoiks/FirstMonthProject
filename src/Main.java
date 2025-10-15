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
        String [][] asanSuallar = //HAZIRDI
                {//her seviyyede bir dene cox cetin sual qoy
                        {"Səfəvilərin ilk paytaxtı hansıdır?", "A) Təbriz B) Qəzvin C) İsfahan D) Tehran", "A"},
                        {"Şuşa şəhərinin banisi kim olub?", "A) Fətəli xan B) Nadir şah C) Pənahəli xan D) Cavad xan", "C"},
                        {"Gəncə şəhərinin tarixi “Gəncə qalası” hansı dövrdə salınıb?", "A) Monqolların dövründə B) Qafqaz Albaniyası dövründə C) Səfəvilər dövründə D) Şəddadilər dövründə", "D"},
                        {"Azərbaycan Respublikasının ilk paytaxtı hansı şəhər olub?", "A) Bakı B) Şəki C) Naxçıvan D) Gəncə", "D"},
                        {"Azərbaycanda ən uzun müddətli hökm sürmüş Türk dövləti hansıdır?", "A) Səfəvilər B) Əfşarlar C) Şirvanşahlar D) Salarilər", "C"}
                };

        int duzgunCavab=0;
        boolean sehvCavab=false;
        int xal=0;
        int sehvXal=0;
        int joker = 0; //EHTIYAC OLACAQMI BELKE BELE ETMEK OLAR KI, UMUMI OLAN JOKERINIZ BU QEDERDI KIMISINDEN
        int yariyariJokeri=1;
        int skipJoker=1;
        int hintJoker = 0;
        boolean[] usedAsan = new boolean[asanSuallar.length];


        for (int k = 0;k < 3; k++) {
            int rand =(int)( Math.random() * asanSuallar.length );

            boolean answeredCorrected=false; //EHTIYAC OLACAQMI

            while (true){
                if (usedAsan[rand]){
                    rand =(int)( Math.random() * asanSuallar.length );
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
            do {
            if (!(cavab.equals("A") || cavab.equals("B") || cavab.equals("C") || cavab.equals("D"))) {
                System.out.println("Zəhmət olmasa yalnız A, B, C və ya D daxil edin.");
                cavab = scan.nextLine().trim().toUpperCase();
            }}
            while (!(cavab.equals("A") || cavab.equals("B") || cavab.equals("C") || cavab.equals("D")));

//CAVABIN DOGRULUGUNU YOXLAMAQ
            if (cavab.equals(dogru)) {
                System.out.println("Doğrudur! Siz 10 xal qazandınız. ");

                if (k==0){ //BIRINCI SUALA CAVAB VERENDEN SONRA GERICEKILME HAQQINA SAHIB OLDU
    System.out.println("Sıradakı suallar üçün geriçəkilmə haqqına sahib oldunuz.");}

                xal = xal+10;
                duzgunCavab++;}  //SEHV CAVAB VERİLEN YERDE İSTİFADE ETMİSEM

            else {
                System.out.println("Səhv!");
                System.out.println("Doğru cavab: "+dogru);
                sehvCavab=true;
                sehvXal = xal / (2 + duzgunCavab); //SEHV CAVAB VERDIKDE XALINDA OYNAMALAR EDIRIK, YA RISK AL, YA DA Geri CEKIL
                break;
            }

//GERİCEKİLME METHODUNA GİRİS
            System.out.println("Seciminiz daxil edin: 1. Davam etmek 2. Gericekilme");
            int secim = scan.nextInt();
            switch (secim){
                case 1:
                    break;
                case 2:
                    System.out.println("Siz geri cekildiniz. Sizin xaliniz "+xal);
                    scan.close();
                    return;
                default:
                    System.out.println("Bele bir secim yoxdur.");
            }
            //BIRINCI FOR BAGLANIR
        }
    if (sehvCavab){
        System.out.println("Təəssüf ki, yarışmamız sona çatdı. Sizin xalınız: "+sehvXal);
        scan.close();
        return;
    }

//-------------------------------------------IKINCI MERHELE-------------------------------------------
        String[][] ortaSuallar = //HAZIRDI
                {//her seviyyede bir dene cox cetin sual qoy
                        {"Qız qalası hansı əsrdə tikilmişdir?", "A) XI əsr", "B) XII əsr", "C) IX əsr", "D) X əsr", "B"},
                        {"Şəki Xan Sarayı hansı hökmdarın dövründə inşa edilmişdir?", "A) Hüseyn xan Musəvi", "B) Fətəli xan", "C) Hacı Çələbi xan", "D) Məhəmmədhəsən xan", "C"},
                        {"Qobustan qayaüstü rəsmləri hansı dövrə aiddir?", "A) Eneolit dövrü", "B) Mezolit dövrü", "C) Tunc dövrü", "D) Orta əsrlər", "B"},
                        {"Xəzər dənizi tarix boyu “Kaspi dənizi” kimi də tanınıb. Bu ad haradan gəlir?", "A) Kaspi tayfaları bu ərazidə yaşamışdır", "B) Dəniz Kaspiya şəhərinin yaxınlığında yerləşirdi", "C) Kaspi qədim fars dilində “duzlu” deməkdir", "D) Məşhur Roma imperiyası sərkərdəsinin şərəfinə bu ad verilmişdir", "A"},
                        {"Səfəvilər dövlətinin paytaxtı əvvəlcə Təbriz idi. Lakin sonradan paytaxt İsfahana köçürüldü. Bunun əsas səbəbi nə idi?", "A) Təbrizdə zəlzələlərin baş verməsi", "B) Təbrizin Osmanlı hücumlarına açıq olması", "C) İsfahanın iqliminin daha əlverişli olması", "D) Təbrizin Tehrana uzaq olması", "B"},
                        {"Nadir şah Əfşarın Dehli yürüşü nəticəsində hansı məşhur tarixi əşyalar İran torpaqlarına gətirilmişdi?",  "A) Tavus taxtı və Köhlən Nur almazı",  "B) Qızıl Orda bayrağı və Şahnamə əlyazması",  "C) Babur ordusunun silahları",  "D) Hindistan qızılı və baharatı",  "A"}
                };
        System.out.println("Təbriklər!! Siz birinci mərhələni bitirdiniz. Sizin xalınız: "+xal);
        System.out.println("Yeni mərhələdə iki Jokeriniz olacaq, bir ədəd '50/50' Jokeri və bir ədəd 'Skip' Jokeri.\n" +
                "Jokerlər haqqında məlumat: '50/50' Jokeri sualdakı iki səhv cavabı silir, 'Skip' Jokeri isə yeni bir suala keçir.");

        boolean[] usedOrta = new boolean[ortaSuallar.length];
        for (int k = 0;k < 3; k++) {

            int rand =(int)( Math.random() * 5 ); //RANDOM SUAL VERMESI UCUN
            System.out.println(rand);

            boolean answeredCorrected=false;

            while (true){
                if (usedOrta[rand]){
                    rand =(int)( Math.random() * 5 );
                    System.out.println(rand);}
                else {
                    usedOrta[rand]=true;
                    break;}}

            String dogru = ortaSuallar[rand][5].trim().toUpperCase();
            for (int i = 0; i < 5; i++) {
                System.out.println(ortaSuallar[rand][i]);} //VARIANTLAR +Suallar

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
                    break;
                case 2:
                    System.out.println("Zehmet olmasa istifade etmek istediyiniz jokeri secin (1/2/3): 1. '50/50' Jokeri 2. 'Skip' Jokeri 3. 'Hint' Jokeri");
                    int secim2 = scan.nextInt();
//50/50 JOKERI
                    switch (secim2){
                        case 1:
                            if (yariyariJokeri==0){
                                System.out.println("50/50 Jokeri artıq istifadə edilib.");
                                for (int i = 0; i < 5; i++) {
                                    System.out.println(ortaSuallar[rand][i]);}
                            }
                            else {
                                System.out.println("Siz '50/50' Jokerini secdiniz ve sualdaki iki sehv cavab silinecek.");
                                System.out.println(ortaSuallar[rand][0]); //ISTIFADECI UCUN SUALI YENIDEN VERIREM
                                for (int j = 1; j < 5; j++) {
                                    String option = ortaSuallar[rand][j].trim(); //Cavabi ekrana cixardir
                                    char optionLetter = Character.toUpperCase(option.charAt(0));
                                    char correctLetter = Character.toUpperCase(dogru.charAt(0));
                                    if (optionLetter == correctLetter) {
                                        System.out.println(option); //cavabin variantini ekrana cixardir
                                    }
                                }
                                switch (dogru) {
                                    case "A", "D":
                                        System.out.println(ortaSuallar[rand][3]);
                                        break;
                                    case "B", "C":
                                        System.out.println(ortaSuallar[rand][4]);
                                        break;
                                    default:
                                        System.out.println();
                                }
                                yariyariJokeri=0;}
                            break;
//SKIP JOKERI------------------------------------------------------------------------------
                        case 2:
                            if (skipJoker==0){
                                System.out.println("Skip Jokeri artıq istifadə edilib.");
                                for (int i = 0; i < 5; i++) {
                                    System.out.println(ortaSuallar[rand][i]);}
                            }
                            else {
                                System.out.println("Siz 'Skip' JokerinDEN ISTIFADE ETDINIZ. SUALINIZ DEYISIR...");
                                for (int i = 0; i < 5; i++) {
                                    System.out.println(ortaSuallar[5][i]);}
                                dogru = ortaSuallar[5][5].trim().toUpperCase();
                                skipJoker=0;}
                            break;
                        case 3:
                            System.out.println("'Hint' Jokeri");
                            break;
                        default:
                            System.out.println("BELE JOKER YOXDUR DEYECEM");}
                    break;

                case 3:
                    System.out.println("Siz geri cekildiniz. Sizin xaliniz "+xal);
                    scan.close();
                    return;
                default:
                    System.out.println("Bele bir seciminiz yoxdur.");
            }
            System.out.print("Cavab (A/B/C/D): ");
            String cavab = scan.nextLine().trim().toUpperCase();

            do {
                if (!(cavab.equals("A") || cavab.equals("B") || cavab.equals("C") || cavab.equals("D"))) {
                    System.out.println("Zəhmət olmasa yalnız A, B, C və ya D daxil edin.");
                    cavab = scan.nextLine().trim().toUpperCase();
                }}
            while (!(cavab.equals("A") || cavab.equals("B") || cavab.equals("C") || cavab.equals("D")));

//CAVABIN DOGRULUGUNU YOXLAMAQ
            if (cavab.equals(dogru)) {
                System.out.println("Doğrudur! Siz 20 xal qazandınız. ");
                xal = xal+20;
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
        System.out.println();
System.out.println("Yeni mərhələdə əlavə bir Jokeriniz olacaq, bir ədəd 'Hint' Jokeri.\n" +
"Joker haqqında məlumat: 'Hint' Jokeri sualdakı cavabı tapmağa ipucu verir. J-yə basaraq jokerdən istifadə edə bilərsiniz.");

//-------------------------------------------UCUNCU MERHELE-------------------------------------------
//BURDA HINT JOKERI UCUN MASSIVE ELAVE YER TEYIN ETMEK LAZIMDIR, EGER ISTIFADECI HINT JOKERINI ISTIFADE ETMEK ISTESE ARRAYIN HEMIN HISSESINE MURACIET ETSIN

        String [][] cetinSuallar = //HAZIRDI
                {//her seviyyede bir dene cox cetin sual qoy
                        {"Səfəvilər dövründə Azərbaycan ərazisinin inzibati bölgüsü necə adlanırdı?", "A) Vilayətlər B) Bəylərbəyliklər C) Xanlıqlar D) Qəzalar", "B"},
                        {"Gülüstan sülh müqaviləsindən sonra Azərbaycanın hansı tarixi bölgələri Rusiya imperiyasına birləşdirildi?", "A) Qarabağ, Şəki, Gəncə B) Naxçıvan, Ordubad, Lənkəran C) Gəncə, Şamaxı, Bakı D) Qarabağ, Gəncə, Şirvan", "D"},
                        {"Azərbaycan ərazisində ilk dəfə xristianlıq dövlət dini kimi hansı dövlətdə qəbul edilib?", "A) Sabirlər B) Qafqaz Albaniyası C) Roma İmpersiyası D) Xəzərlər", "B"},
                        {"Xəzər xaqanlığının paytaxtı olan İtil şəhəri harada yerləşirdi?", "A) Xəzər dənizinin qərb sahilində B) Volqa çayının aşağı axarında C) Dərbəndin cənubunda D) Aral gölünün yaxınlığında", "B"},
                        {"Ərəblərin Qafqaza yürüşləri zamanı Azərbaycan torpaqlarında ən güclü müqavimət hansı bölgədə göstərilmişdi?", "A) Şirvan B) Qarabağ C) Gülüstan qalası D) Cavanşir qalası", "D"}
                };
        //------------------
        //HİNT JOKERİ

        boolean[] usedCetin = new boolean[cetinSuallar.length];

        for (int k = 0;k < 3; k++) {
            int rand =(int)( Math.random() * 5 );
            System.out.println(rand);

            boolean answeredCorrected=false;

            while (true){
                if (usedCetin[rand]){
                    rand =(int)( Math.random() * 5 );
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
            do {
                if (!(cavab.equals("A") || cavab.equals("B") || cavab.equals("C") || cavab.equals("D"))) {
                    System.out.println("Zəhmət olmasa yalnız A, B, C və ya D daxil edin.");
                    cavab = scan.nextLine().trim().toUpperCase();
                }}
            while (!(cavab.equals("A") || cavab.equals("B") || cavab.equals("C") || cavab.equals("D")));

//CAVABIN DOGRULUGUNU YOXLAMAQ
            if (cavab.equals(dogru)) {
                System.out.println("Doğrudur! Siz 30 xal qazandınız. ");
                xal = xal+30;
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