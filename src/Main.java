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
        System.out.println("Qaydalar: \n" +
    "Sual 1–3: Bu mərhələdə asan suallar soruşulacaq, bu sualları cavablandırmaq olduqca asandır.\n" +
    "Sual 4–6: Bu mərhələdə orta suallar soruşulacaq, burada tarixi və coğrafi bilikləriniz lazım olacaq. Həmçinin bu mərhələyə keçdikdən sonra iki Joker qazanacaqsınız.\n" +
    "Sual 7–9: Bu mərhələdə çətin suallar soruşulacaq, burada tarix və coğrafi biliklərinizi zorlamalı olacaqsan və bu mərhələyə keçdikdən sonra bir Joker qazanacaqsınız.\n" +
    "Sual 10: Final sualı olacaq. \n" +
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
        int yariyariJokeri=0;
        int skipJoker=0;
        int hintJoker = 0;
        boolean[] usedAsan = new boolean[asanSuallar.length];


        for (int k = 0;k < 3; k++) {
            int rand =(int)( Math.random() * asanSuallar.length );

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
            System.out.println("Sual: "+ (k+1));
            System.out.println(asanSuallar[rand][0]); //SUALLAR
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
            int secim=0;
            String input;
            do {
                System.out.println("Seçiminizi daxil edin: 1. Suala cavab vermək 2. Joker istifadə etmək");
                input = scan.nextLine().trim();
                if (input.equals("1") || input.equals("2")){
                    secim = Integer.parseInt(input); //STRING TO INT
                    break;
                }
                else {
                    System.out.println("Zəhmət olmasa yalnız 1 və ya 2 daxil edin.");
                }}
            while (true);
            switch (secim){
                case 1:
                    break;
                case 2:
                    System.out.println("Siz geri çəkildiniz. Sizin xalınız: "+xal);
                    scan.close();
                    return;
                default:
                    System.out.println("Belə bir seçim yoxdur.");
            }
            //BIRINCI FOR BAGLANIR
        }
    if (sehvCavab){
        System.out.println("Təəssüf ki, yarışmamız sona çatdı. Sizin xalınız: "+sehvXal);
        scan.close();
        return;
    }

//-------------------------------------------IKINCI MERHELE-------------------------------------------
        yariyariJokeri++;
        skipJoker++;
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

            while (true){
                if (usedOrta[rand]){
                    rand =(int)( Math.random() * 5 );}
                else {
                    usedOrta[rand]=true;
                    break;}}

            String dogru = ortaSuallar[rand][5].trim().toUpperCase();
            System.out.println("Sual: "+ (k+4));
            for (int i = 0; i < 5; i++) {
                System.out.println(ortaSuallar[rand][i]);} //VARIANTLAR +Suallar

//------------------------------------------------------------------------------------------------------
//JOKERLER UCUN HISSE BURADA OLACAQ
            //------------------------------------------------------------------------------------------------------
            int secim=0;
            String input;
            do {
                System.out.println("Seçiminizi daxil edin: 1. Suala cavab vermək 2. Joker istifadə etmək 3. Geriçəkilmə");
                input = scan.nextLine().trim();
                if (input.equals("1") || input.equals("2") || input.equals("3")){
                    secim = Integer.parseInt(input); //STRING TO INT
                    break;
                }
                else {
                    System.out.println("Zəhmət olmasa yalnız 1, 2 və ya 3 daxil edin.");
                }}
            while (true);
            switch (secim){ //CAVAB VERMEK, JOKER ISTIFADE ETMEK VE GERICEKILME
                case 1:
                    break;
                case 2:
                    int secim2=0;
                    String input2;
                    do{
                        System.out.println("Zəhmət olmasa istifadə etmək istədiyiniz jokeri seçin (1/2): 1. '50/50' Jokeri 2. 'Skip' Jokeri");
                        input2=scan.nextLine().trim();
                        if (input2.equals("1") || input2.equals("2")){
                            secim2= Integer.parseInt(input2); //STRING TO INT
                            break;
                        }
                        else {
                            System.out.println("Zəhmət olmasa yalnız 1 və ya 2 daxil edin.");
                        }}
                    while (true);

                    switch (secim2){
//50/50 JOKERI
                        case 1:
                            if (yariyariJokeri==0){
                                System.out.println("'50/50' Jokeri artıq istifadə edilib.");
                                for (int i = 0; i < 5; i++) {
                                    System.out.println(ortaSuallar[rand][i]);}
                            }
                            else {
                                System.out.println("Siz '50/50' Jokerini seçdiniz ve sualdaki iki səhv cavab silinəcək.");
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
                                    case "A":
                                    case "D":
                                        System.out.println(ortaSuallar[rand][3]);
                                        break;
                                    case "B":
                                    case "C":
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
                                System.out.println("'Skip' Jokeri artıq istifadə edilib.");
                                for (int i = 0; i < 5; i++) {
                                    System.out.println(ortaSuallar[rand][i]);}
                            }
                            else {
                                System.out.println("Siz 'Skip' Jokerindən istifadə edtiniz. Sualınız dəyişir...");
                                for (int i = 0; i < 5; i++) {
                                    System.out.println(ortaSuallar[5][i]);}
                                dogru = ortaSuallar[5][5].trim().toUpperCase();
                                skipJoker=0;}
                            break;
                        default:
                            System.out.println("Belə Joker yoxdur");}
                    break;
                case 3:
                    System.out.println("Siz geriçəkildiniz. Sizin xaliniz: "+xal);
                    scan.close();
                    return;
                default:
                    System.out.println("Belə bir seçiminiz yoxdur.");
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
"Joker haqqında məlumat: 'Hint' Jokeri sualdakı cavabı tapmaq üçün ipucu verir.");

//-------------------------------------------UCUNCU MERHELE-------------------------------------------

    hintJoker++;
        String [][] cetinSuallar = {
                // {Sual, A variantı, B variantı, C variantı, D variantı, Doğru cavab, Hint}
                {"Səfəvilər dövründə Azərbaycan ərazisinin inzibati bölgüsü necə adlanırdı?", "A) Vilayətlər", "B) Bəylərbəyliklər", "C) Xanlıqlar", "D) Qəzalar", "B",
                        "Bəzi bölgələr böyük idarəetmə vahidlərinə bölünürdü və hər birinin rəhbəri mərkəzlə müəyyən qədər bağlı idi."},

                {"Gülüstan sülh müqaviləsindən sonra Azərbaycanın hansı tarixi bölgələri Rusiya imperiyasına birləşdirildi?", "A) Qarabağ, Şəki, Gəncə", "B) Naxçıvan, Ordubad, Lənkəran", "C) Gəncə, Şamaxı, Bakı", "D) Qarabağ, Gəncə, Şirvan", "D", "Qərb və şimal-qərb bölgələrinə diqqət yetirin."},

                {"Qaraqoyunlu və Ağqoyunlu dövlətlərinin Azərbaycan tarixində rolu hansı aspektdə fərqlənir?", "A) Qaraqoyunlular ticarətə üstünlük verirdi, Ağqoyunlular isə yalnız kənd təsərrüfatı ilə məşğul idi", "B) Qaraqoyunlular mərkəzləşmiş inzibati sistem qurmuşdular, Ağqoyunlular isə daha çox yerli hökmdarlara səlahiyyət vermişdilər",
                        "C) Hər iki dövlət eyni inzibati struktura malik idi, yalnız adları fərqli idi", "D) Qaraqoyunlular dini məsələlərdə sərt siyasət yürüdürdü, Ağqoyunlular isə tamamilə tolerant idi", "B", "Bir dövlət mərkəzləşmiş idarəetməyə üstünlük verirdi, digəri isə bəzi yerləri daha sərbəst buraxırdı."},

                {"XIV əsrdə Azərbaycan ərazisində yaranan Qaraqoyunlu dövlətinin inzibati və siyasi strukturu haqqında hansı ifadə doğrudur?", "A) Qaraqoyunlular ərazini vilayətlərə bölməmiş, mərkəzi hakimiyyət yalnız şahın sarayına bağlı idi", "B) Dövlət quruluşu mərkəzləşmişdi, amma hər bölgədə ayrı bir bəy və ya hakimi vardı",
                        "C) Qaraqoyunlular demokratik prinsiplərlə şəhər şurasını idarə edirdilər", "D) Dövlət yalnız kənd təsərrüfatı ilə məşğul olan kənd icmaları tərəfindən idarə olunurdu", "B", "Bəzi bölgələr özünü idarə etməkdə azad idi, amma mərkəzi hakimiyyət hələ də əsas rolu oynayırdı."},

                {"Ərəblərin Qafqaza yürüşləri zamanı Azərbaycan torpaqlarında ən güclü müqavimət hansı bölgədə göstərilmişdi?", "A) Şirvan", "B) Qarabağ", "C) Gülüstan qalası", "D) Cavanşir qalası", "D", "Ən güclü müqavimət dağlıq və strateji əhəmiyyətli bölgələrdə meydana gəldi."},

                {"Şirvanşahlar dövlətinin mövcud olduğu dövr hansı əsrləri əhatə edir?", "A) XI–XV əsrlər", "B) XII–XVIII əsrlər", "C) X–XIII əsrlər", "D) XIII–XVI əsrlər", "B", "Mövcudluq orta əsrlərin bir hissəsini əhatə edir, lakin daha erkən və daha gec dövrlərdən fərqlidir."}
        };

        System.out.println();
        boolean[] usedCetin = new boolean[cetinSuallar.length];
        for (int k = 0;k < 3; k++) {

            int rand =(int)( Math.random() * 5 ); //RANDOM SUAL VERMESI UCUN

            while (true){
                if (usedCetin[rand]){
                    rand =(int)( Math.random() * 5 );}
                else {
                    usedCetin[rand]=true;
                    break;}}

            String dogru = cetinSuallar[rand][5].trim().toUpperCase();
            System.out.println("Sual: "+ (k+7));
            for (int i = 0; i < 5; i++) {
                System.out.println(cetinSuallar[rand][i]);} //VARIANTLAR +Suallar

//------------------------------------------------------------------------------------------------------
//JOKERLER UCUN HISSE BURADA OLACAQ
            //------------------------------------------------------------------------------------------------------
            int secim=0;
            String input;
            do {
                System.out.println("Seçiminizi daxil edin: 1. Suala cavab vermək 2. Joker istifadə etmək 3. Geriçəkilmə");
                input = scan.nextLine().trim();
                if (input.equals("1") || input.equals("2") || input.equals("3")){
                    secim = Integer.parseInt(input); //STRING TO INT
                    break;
                }
                else {
                    System.out.println("Zəhmət olmasa yalnız 1, 2 və ya 3 daxil edin.");
                }}
            while (true);
            switch (secim){ //CAVAB VERMEK, JOKER ISTIFADE ETMEK VE GERICEKILME
                case 1:
                    break;
                case 2:
                    int secim2=0;
                    String input2;
                    do{
                        System.out.println("Zehmet olmasa istifadə etmək istədiyiniz jokeri seçin (1/2/3): 1. '50/50' Jokeri 2. 'Skip' Jokeri 3. 'Hint' Jokeri");
                        input2=scan.nextLine().trim();
                        if (input2.equals("1") || input2.equals("2") || input2.equals("3")){
                            secim2= Integer.parseInt(input2); //STRING TO INT
                            break;
                        }
                        else {
                            System.out.println("Zəhmət olmasa yalnız 1, 2 və ya 3 daxil edin.");
                        }}
                    while (true);
                    switch (secim2){
//50/50 JOKERI
                        case 1:
                            if (yariyariJokeri==0){
                                System.out.println("50/50'Jokeri artıq istifadə edilib.");
                                for (int i = 0; i < 5; i++) {
                                    System.out.println(cetinSuallar[rand][i]);}
                            }
                            else {
                                System.out.println("Siz '50/50' Jokerini seçdiniz ve sualdaki iki səhv cavab silinəcək.");
                                System.out.println(cetinSuallar[rand][0]); //ISTIFADECI UCUN SUALI YENIDEN VERIREM
                                switch (dogru) {
                                    case "B":
                                    case "D":
                                        System.out.println(cetinSuallar[rand][1]);
                                        break;
                                    case "A":
                                    case "C":
                                        System.out.println(cetinSuallar[rand][4]);
                                        break;
                                    default:
                                        System.out.println();
                                }
                                for (int j = 1; j < 5; j++) {
                                    String option = cetinSuallar[rand][j].trim(); //Cavabi ekrana cixardir
                                    char optionLetter = Character.toUpperCase(option.charAt(0));
                                    char correctLetter = Character.toUpperCase(dogru.charAt(0));
                                    if (optionLetter == correctLetter) {
                                        System.out.println(option); //cavabin variantini ekrana cixardir
                                    }
                                }
                                yariyariJokeri=0;}
                            break;
//SKIP JOKERI
                        case 2:
                            if (skipJoker==0){
                                System.out.println("'Skip' Jokeri artıq istifadə edilib.");
                                for (int i = 0; i < 5; i++) {
                                    System.out.println(cetinSuallar[rand][i]);}
                            }
                            else {
                                System.out.println("Siz 'Skip' Jokerindən istifadə etdiniz. Sualınız dəyişir...");
                                for (int i = 0; i < 5; i++) {
                                    System.out.println(cetinSuallar[5][i]);}
                                dogru = cetinSuallar[5][5].trim().toUpperCase();
                                skipJoker=0;}
                            break;
//HİNT JOKERİ
                        case 3:
                            if (hintJoker==0){
                                System.out.println("Hint Jokeri artıq istifadə edilib.");
                                for (int i = 0; i < 5; i++) {
                                    System.out.println(cetinSuallar[rand][i]);}
                            }
                            else {
                                System.out.println("Siz 'Hint' Jokerindən istifadə etdiniz. Sualınız üçün ipucu verilir...");
                                for (int i = 0; i < 5; i++) {
                                    System.out.println(cetinSuallar[rand][i]);
                                }
                                System.out.println("Hint: " + cetinSuallar[rand][6]);
                                hintJoker=0;}
                            break;
                        default:
                            System.out.println("Belə Joker yoxdur.");}
                    break;
                case 3:
                    System.out.println("Siz geriçəkildiniz. Sizin xalınız: "+xal);
                    scan.close();
                    return;
                default:
                    System.out.println("Belə bir seçiminiz yoxdur.");
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
        System.out.println();
        //---------------------------------------SON MƏRHƏLƏ------------------------------
        String [][] finalSuali = {
                {"“Ey gənclər! Siz gələcəyin sahibisiniz. Vətən sizdən ümidlidir. Torpağımızın azadlığı, xalqımızın tərəqqisi sizin əlinizdədir. " +
                        "Hər biriniz elmə, mədəniyyətə, milli ruhun qorunmasına sadiq olmalısınız. Dövlət qurmaq, xalqı birləşdirmək və milli azadlığı qorumaq sizin vəzifənizdir. " +
                        "Hər zaman dürüst, cəsarətli və vətənpərvər olun. Sizi gözləyən məsuliyyət böyükdür, amma sizin gücünüz də ona uyğun olmalıdır. Vətən üçün çalışın, onun adını yüksəldin və heç vaxt təslim olmayın!”" +
                        "'Gəncliyə Xitabə' kimi adlanan bu səsləniş kimə məxsusdur?", "A) Məmməd Əmin Rəsulzadə", "B) Heydər Əliyev", "C) Şah İsmayıl Xətai", "D) Elçibəy", "A",
                        "Bu şəxs Azərbaycanın yaranmasında mühim rol oynamışdır, Azərbaycanın qurucu lideri və ulu Öndəridir."},
                {"Əgər Rəsulzadə bu gün yaşasaydı, müasir Azərbaycana bir tövsiyə verə bilsəydi, hansı məsləhəti ən vacib sayardı?",
                        "A) Müstəqilliyi hər zaman qoruyun — suverenlikdən vazkeçməyin.", "B) Təhsilə və maarifçiliyə sərmayə qoyun — millətin gələcəyi üçün ən vacib investisiya.",
                        "C) Siyasi və ictimai dialoqu gücləndirin; qütbləri yumşaldın və birlik yaradın.", "D) İqtisadi rifah və praktiki islahatlara üstünlük verin — xalqın gündəlik həyatını yaxşılaşdırın.",
                        "B", "Rəsulzadə maarifçilik və maariflənməyə böyük önəm verirdi."
                }

        };

        System.out.println();

        for (int k = 0;k < 1; k++) {

            String dogru = finalSuali[0][5].trim().toUpperCase();
            System.out.println("Sual: 10");
            for (int i = 0; i < 5; i++) {
                System.out.println(finalSuali[0][i]);} //VARIANTLAR +Suallar

//------------------------------------------------------------------------------------------------------
//JOKERLER UCUN HISSE BURADA OLACAQ
            //------------------------------------------------------------------------------------------------------
            int secim=0;
            String input;
            do {
                System.out.println("Seçiminizi daxil edin: 1. Suala cavab vermək 2. Joker istifadə etmək 3. Geriçəkilmə");
                input = scan.nextLine().trim();
                if (input.equals("1") || input.equals("2") || input.equals("3")){
                    secim = Integer.parseInt(input); //STRING TO INT
                    break;
                }
                else {
                    System.out.println("Zəhmət olmasa yalnız 1, 2 və ya 3 daxil edin.");
                }}
            while (true);
            switch (secim){ //CAVAB VERMEK, JOKER ISTIFADE ETMEK VE GERICEKILME
                case 1:
                    break;
                case 2:
                    int secim2=0;
                    String input2;
                    do{
                        System.out.println("Zəhmət olmasa istifadə etmək istədiyiniz jokeri seçin (1/2/3): 1. '50/50' Jokeri 2. 'Skip' Jokeri 3. 'Hint' Jokeri");
                        input2=scan.nextLine().trim();
                        if (input2.equals("1") || input2.equals("2") || input2.equals("3")){
                            secim2= Integer.parseInt(input2); //STRING TO INT
                            break;
                        }
                        else {
                            System.out.println("Zəhmət olmasa yalnız 1, 2 və ya 3 daxil edin.");
                        }}
                    while (true);
                    switch (secim2){
//50/50 JOKERI
                        case 1:
                            if (yariyariJokeri==0){
                                System.out.println("'50/50' Jokeri artıq istifadə edilib.");
                                for (int i = 0; i < 5; i++) {
                                    System.out.println(finalSuali[0][i]);}
                            }
                            else {
                                System.out.println("Siz '50/50' Jokerini seçdiniz və sualdaki iki səhv cavab silinəcək.");
                                System.out.println(finalSuali[0][0]); //ISTIFADECI UCUN SUALI YENIDEN VERIREM
                                for (int j = 1; j < 5; j++) {
                                    String option = finalSuali[0][j].trim(); //Cavabi ekrana cixardir
                                    char optionLetter = Character.toUpperCase(option.charAt(0));
                                    char correctLetter = Character.toUpperCase(dogru.charAt(0));
                                    if (optionLetter == correctLetter) {
                                        System.out.println(option); //cavabin variantini ekrana cixardir
                                    }
                                }
                                switch (dogru) {
                                    case "B":
                                    case "D":
                                        System.out.println(finalSuali[0][1]);
                                        break;
                                    case "A":
                                    case "C":
                                        System.out.println(finalSuali[0][4]);
                                        break;
                                    default:
                                        System.out.println();
                                }

                                yariyariJokeri=0;}
                            break;
//SKIP JOKERI
                        case 2:
                            if (skipJoker==0){
                                System.out.println("'Skip' Jokeri artıq istifadə edilib.");
                                for (int i = 0; i < 5; i++) {
                                    System.out.println(finalSuali[0][i]);}
                            }
                            else {
                                System.out.println("Siz 'Skip' Jokerindən istifadə etdiniz. Sualınız dəyişir...");
                                for (int i = 0; i < 5; i++) {
                                    System.out.println(finalSuali[1][i]);}
                                dogru = finalSuali[1][5].trim().toUpperCase();
                                skipJoker=0;}
                            break;
//HİNT JOKERİ
                        case 3:
                            if (hintJoker==0){
                                System.out.println("'Hint' Jokeri artıq istifadə edilib.");
                                for (int i = 0; i < 5; i++) {
                                    System.out.println(finalSuali[0][i]);}
                            }
                            else {
                                System.out.println("Siz 'Hint' Jokerindən istifadə etdiniz. Sualınız üçün ipucu verilir...");
                                for (int i = 0; i < 5; i++) {
                                    System.out.println(finalSuali[0][i]);
                                }
                                System.out.println("Hint: " + finalSuali[0][6]);
                                hintJoker=0;}
                            break;
                        default:
                            System.out.println("Belə Joker yoxdur.");}
                    break;
                case 3:
                    System.out.println("Siz geriçəkildiniz. Sizin xalınız: "+xal);
                    scan.close();
                    return;
                default:
                    System.out.println("Belə bir seçiminiz yoxdur.");
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
                System.out.println("Doğrudur! Siz 50 xal qazandınız. ");
                xal = xal+50;
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
        System.out.println("Təbriklər!! Siz bu oyunu bitirdiniz!! Sizin xalınız: "+xal);
        System.out.println();

        scan.close();
    }
}