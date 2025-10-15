import java.util.Scanner;

public class test12 {
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);
            int duzgunCavab=0;
            boolean sehvCavab=false;
            int xal=0;
            int sehvXal=0;
            int joker = 0; //EHTIYAC OLACAQMI BELKE BELE ETMEK OLAR KI, UMUMI OLAN JOKERINIZ BU QEDERDI KIMISINDEN
            int yariyariJokeri=1; //ikinci merheleye kecende + olacaq
            int skipJoker=1; //ikinci merheleye kecende + olacaq
            int hintJoker = 1; //ucuncu merheleye kecende + olacaq

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



            System.out.println("Təbriklər!! Siz birinci mərhələni bitirdiniz. Sizin xalınız: "+xal);
            System.out.println("Yeni mərhələdə iki Jokeriniz olacaq, bir ədəd '50/50' Jokeri və bir ədəd 'Skip' Jokeri.\n" +
                    "Jokerlər haqqında məlumat: '50/50' Jokeri sualdakı iki səhv cavabı silir, 'Skip' Jokeri isə yeni bir suala keçir.");
            System.out.println();
            boolean[] usedOrta = new boolean[cetinSuallar.length];
            for (int k = 0;k < 3; k++) {

                int rand =(int)( Math.random() * 5 ); //RANDOM SUAL VERMESI UCUN

                while (true){
                    if (usedOrta[rand]){
                        rand =(int)( Math.random() * 5 );}
                    else {
                        usedOrta[rand]=true;
                        break;}}

                String dogru = cetinSuallar[rand][5].trim().toUpperCase();
                for (int i = 0; i < 5; i++) {
                    System.out.println(cetinSuallar[rand][i]);} //VARIANTLAR +Suallar

//------------------------------------------------------------------------------------------------------
//JOKERLER UCUN HISSE BURADA OLACAQ
                //------------------------------------------------------------------------------------------------------
                int secim=0;
                String input;
                do {
                    System.out.println("Seciminiz daxil edin: 1. Suala cavab vermek 2. Joker istifade etmek 3. Gericekilme");
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
                            System.out.println("Zehmet olmasa istifade etmek istediyiniz jokeri secin (1/2/3): 1. '50/50' Jokeri 2. 'Skip' Jokeri 3. 'Hint' Jokeri");
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
                                    System.out.println("50/50 Jokeri artıq istifadə edilib.");
                                    for (int i = 0; i < 5; i++) {
                                        System.out.println(cetinSuallar[rand][i]);}
                                }
                                else {
                                    System.out.println("Siz '50/50' Jokerini secdiniz ve sualdaki iki sehv cavab silinecek.");
                                    System.out.println(cetinSuallar[rand][0]); //ISTIFADECI UCUN SUALI YENIDEN VERIREM
                                    switch (dogru) {
                                        case "B", "D":
                                            System.out.println(cetinSuallar[rand][1]);
                                            break;
                                        case "A", "C":
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
                                    System.out.println("Skip Jokeri artıq istifadə edilib.");
                                    for (int i = 0; i < 5; i++) {
                                        System.out.println(cetinSuallar[rand][i]);}
                                }
                                else {
                                    System.out.println("Siz 'Skip' JokerinDEN ISTIFADE ETDINIZ. SUALINIZ DEYISIR...");
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
                                    System.out.println("Siz 'Hint' JokerinDEN ISTIFADE ETDINIZ. SUALINIZ ucun ipucu verilir...");
                                    for (int i = 0; i < 5; i++) {
                                        System.out.println(cetinSuallar[rand][i]);
                                        }
                                    System.out.println(cetinSuallar[rand][6]);
                                    hintJoker=0;}
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
            System.out.println("Təbriklər!! Siz ikinci mərhələni bitirdiniz. Sizin xalınız: "+xal);
            System.out.println();
            System.out.println("Yeni mərhələdə əlavə bir Jokeriniz olacaq, bir ədəd 'Hint' Jokeri.\n" +
                    "Joker haqqında məlumat: 'Hint' Jokeri sualdakı cavabı tapmağa ipucu verir. J-yə basaraq jokerdən istifadə edə bilərsiniz.");


        }
    }
