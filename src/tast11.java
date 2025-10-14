import java.util.Scanner;

public class tast11 {
    public static void main(String[] args) {
        String[][] ortaSuallar = //HAZIRDI
                {//her seviyyede bir dene cox cetin sual qoy
                        {"Qız qalası hansı əsrdə tikilmişdir?", "A) XI əsr", "B) XII əsr", "C) IX əsr", "D) X əsr", "B"},
                        {"Şəki Xan Sarayı hansı hökmdarın dövründə inşa edilmişdir?", "A) Hüseyn xan Musəvi", "B) Fətəli xan", "C) Hacı Çələbi xan", "D) Məhəmmədhəsən xan", "C"},
                        {"Qobustan qayaüstü rəsmləri hansı dövrə aiddir?", "A) Eneolit dövrü", "B) Mezolit dövrü", "C) Tunc dövrü", "D) Orta əsrlər", "B"},
                        {"Xəzər dənizi tarix boyu “Kaspi dənizi” kimi də tanınıb. Bu ad haradan gəlir?", "A) Kaspi tayfaları bu ərazidə yaşamışdır", "B) Dəniz Kaspiya şəhərinin yaxınlığında yerləşirdi", "C) Kaspi qədim fars dilində “duzlu” deməkdir", "D) Məşhur Roma imperiyası sərkərdəsinin şərəfinə bu ad verilmişdir", "A"},
                        {"Səfəvilər dövlətinin paytaxtı əvvəlcə Təbriz idi. Lakin sonradan paytaxt İsfahana köçürüldü. Bunun əsas səbəbi nə idi?", "A) Təbrizdə zəlzələlərin baş verməsi", "B) Təbrizin Osmanlı hücumlarına açıq olması", "C) İsfahanın iqliminin daha əlverişli olması", "D) Təbrizin Tehrana uzaq olması", "B"}
                };

       Scanner scan = new Scanner(System.in);
        System.out.println("Zehmet olmasa istifade etmek istediyiniz jokeri secin (1/2/3): 1. '50/50' Jokeri 2. 'Skip' Jokeri 3. 'Hint' Jokeri");
        int secim2 = scan.nextInt();
         switch (secim2){
         case 1:
             System.out.println("Siz '50/50' Jokerini secdiniz ve sualdaki iki sehv cavab silinecek.");
             System.out.println(ortaSuallar[rand][0]);
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
                        else {
            System.out.println("Siz bu Jokeri istifade etmisiniz...");
        }

    }
             break;
         case 2:
             System.out.println("'Skip' Jokeri");
             break;
         case 3:
             System.out.println("'Hint' Jokeri");
             break;
             default:
                 System.out.println("BELE JOKER YOXDUR DEYECEM");
         }














    }
}
