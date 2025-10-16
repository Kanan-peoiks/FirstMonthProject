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

            System.out.println("Təbriklər!! Siz üçüncü mərhələni bitirdiniz. Sizin xalınız: "+xal);

            System.out.println();

            for (int k = 0;k < 1; k++) {

                String dogru = finalSuali[0][5].trim().toUpperCase();
                for (int i = 0; i < 5; i++) {
                    System.out.println(finalSuali[0][i]);} //VARIANTLAR +Suallar

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
                                        System.out.println(finalSuali[0][i]);}
                                }
                                else {
                                    System.out.println("Siz '50/50' Jokerini secdiniz ve sualdaki iki sehv cavab silinecek.");
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
                                    System.out.println("Skip Jokeri artıq istifadə edilib.");
                                    for (int i = 0; i < 5; i++) {
                                        System.out.println(finalSuali[0][i]);}
                                }
                                else {
                                    System.out.println("Siz 'Skip' JokerinDEN ISTIFADE ETDINIZ. SUALINIZ DEYISIR...");
                                    for (int i = 0; i < 5; i++) {
                                        System.out.println(finalSuali[1][i]);}
                                    dogru = finalSuali[1][5].trim().toUpperCase();
                                    skipJoker=0;}
                                break;
//HİNT JOKERİ
                            case 3:
                                if (hintJoker==0){
                                    System.out.println("Hint Jokeri artıq istifadə edilib.");
                                    for (int i = 0; i < 5; i++) {
                                        System.out.println(finalSuali[0][i]);}
                                }
                                else {
                                    System.out.println("Siz 'Hint' JokerinDEN ISTIFADE ETDINIZ. SUALINIZ ucun ipucu verilir...");
                                    for (int i = 0; i < 5; i++) {
                                        System.out.println(finalSuali[0][i]);
                                        }
                                    System.out.println(finalSuali[0][6]);
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


        }
    }
