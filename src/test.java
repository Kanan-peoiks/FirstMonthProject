import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int duzgunCavab=0;
        boolean sehvCavab=false;
        int xal=0;
        int sehvXal=0;
        int joker = 0; //EHTIYAC OLACAQMI BELKE BELE ETMEK OLAR KI, UMUMI OLAN JOKERINIZ BU QEDERDI KIMISINDEN
        int yariyariJokeri=0;
        int skipJoker=0;
        int hintJoker = 0;

        String[][] ortaSuallar = //HAZIRDI
                {//her seviyyede bir dene cox cetin sual qoy
                        {"Qız qalası hansı əsrdə tikilmişdir?", "A) XI əsr", "B) XII əsr", "C) IX əsr", "D) X əsr", "B"},
                        {"Şəki Xan Sarayı hansı hökmdarın dövründə inşa edilmişdir?", "A) Hüseyn xan Musəvi", "B) Fətəli xan", "C) Hacı Çələbi xan", "D) Məhəmmədhəsən xan", "C"},
                        {"Qobustan qayaüstü rəsmləri hansı dövrə aiddir?", "A) Eneolit dövrü", "B) Mezolit dövrü", "C) Tunc dövrü", "D) Orta əsrlər", "B"},
                        {"Xəzər dənizi tarix boyu “Kaspi dənizi” kimi də tanınıb. Bu ad haradan gəlir?", "A) Kaspi tayfaları bu ərazidə yaşamışdır", "B) Dəniz Kaspiya şəhərinin yaxınlığında yerləşirdi", "C) Kaspi qədim fars dilində “duzlu” deməkdir", "D) Məşhur Roma imperiyası sərkərdəsinin şərəfinə bu ad verilmişdir", "A"},
                        {"Səfəvilər dövlətinin paytaxtı əvvəlcə Təbriz idi. Lakin sonradan paytaxt İsfahana köçürüldü. Bunun əsas səbəbi nə idi?", "A) Təbrizdə zəlzələlərin baş verməsi", "B) Təbrizin Osmanlı hücumlarına açıq olması", "C) İsfahanın iqliminin daha əlverişli olması", "D) Təbrizin Tehrana uzaq olması", "B"}
                };
        System.out.println("Təbriklər!! Siz birinci mərhələni bitirdiniz. Sizin xalınız: "+xal);
        System.out.println("Yeni mərhələdə iki Jokeriniz olacaq, bir ədəd '50/50' Jokeri və bir ədəd 'Skip' Jokeri.\n" +
                "Jokerlər haqqında məlumat: '50/50' Jokeri sualdakı iki səhv cavabı silir, 'Skip' Jokeri isə yeni bir suala keçir.");



        boolean[] usedOrta = new boolean[ortaSuallar.length];
        boolean[] usedOrtaSual = new boolean[ortaSuallar.length];
        for (int k = 0;k < 3; k++) {
            int rand =(int)( Math.random() * ortaSuallar.length );
            System.out.println(rand);

            boolean answeredCorrected=false;

            while (true){
                if (usedOrta[rand]){
                    rand =(int)( Math.random() * ortaSuallar.length );
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
//JOKERLER
                    switch (secim2){
                        case 1:
                            if (yariyariJokeri==0){
                                System.out.println("50/50 Jokeri artıq istifadə edilib.");
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
                            System.out.println("Siz 'Skip' JokerinDEN ISTIFADE ETDINIZ. SUALINIZ DEYISIR...");
                            switch (rand){
                                case 0,1,2,3:
                                    System.out.println(ortaSuallar[rand+1][0]);
                                    for (int i = 1; i < 5; i++) {
                                        System.out.println(ortaSuallar[rand+1][i]);}
                                    dogru = ortaSuallar[rand+1][5].trim().toUpperCase();
                                    break;
                                case 4:
                                    System.out.println(ortaSuallar[rand-1][0]);
                                    for (int i = 1; i < 5; i++) {
                                        System.out.println(ortaSuallar[rand-1][i]);}
                                    dogru = ortaSuallar[rand-1][5].trim().toUpperCase();
                                    break;
                                default:
                                    System.out.println();
                            }
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
        System.out.println();
        System.out.println("Yeni mərhələdə əlavə bir Jokeriniz olacaq, bir ədəd 'Hint' Jokeri.\n" +
                "Joker haqqında məlumat: 'Hint' Jokeri sualdakı cavabı tapmağa ipucu verir. J-yə basaraq jokerdən istifadə edə bilərsiniz.");


    }
}
