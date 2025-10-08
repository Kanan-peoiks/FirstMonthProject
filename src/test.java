import java.util.Scanner;

public class test {
    public static void main(String[] args) {
//        int rand =(int)( Math.random() * 5 );
//        //burda 10 veririk fəqət 0-9 aralığında qaytarır səbəb isə random methodu [0,1) kimi işləyir
//        // məsələn 3 sual verəcəmsə bura 4 yazacam
//        System.out.println(rand);




//        int max = 10;
//        int min = 0;
//        int range = max - min + 1; //+1 onu bildirir ki, maks ededimizde daxil olsun
//
//        int rand = (int)(Math.random() * range) + min; //min ona görə var ki, neçənci ədəddən başlayacaq onu bildirir
//        System.out.println(rand);
        Scanner scan = new Scanner(System.in);
        String [][] asanSuallar =
                {
                        {"Azərbaycanın paytaxtı hansıdır?", "C", "A) Bakı B) Gəncə C) Sumqayıt"},
                        {"Azərbaycanın ən böyük gölü hansıdır?", "C", "A) Sərsəng B) Xəzər C) Göygöl"},
                        {"Azərbaycanın milli musiqi aləti hansıdır?", "A", "A) Tar B) Piano C) Nərə"},
                        {"Azərbaycanın ən yüksək dağ zirvəsi hansıdır?", "B", "A) Tufandağ B) Bazardüzü C) Şahdağ"},
                        {"Azərbaycanda ən uzun müddətli hökm sürmüş Türk dövləti hansıdır?", "C", "A) Səfəvilər B) Əfşarlar C) Şirvanşahlar"}
                };
        int duzgunSay=0;
        int sehvSay = 0;


//        for (int i =0; i<suallar.length; i++)
//
//        {
//            //int sualIndeksi = 0;
//            boolean answeredCorrected = false;
//            String dogru = suallar[i][1].trim().toUpperCase();
//            do {
//                System.out.println((i + 1) + ". Sual: " + suallar[i][0]);
//                for (int j = 2; j < suallar[i].length; j++) {
//                    System.out.println(suallar[i][j]);
//                }
//                System.out.print("Cavab (A/B/C): ");
//                String cavab = scan.nextLine().trim().toUpperCase();
//
//                if (!(cavab.equals("A") || cavab.equals("B") || cavab.equals("C"))) {
//                    System.out.println("Zəhmət olmasa yalnız A, B və ya C daxil edin.");
//                    continue; // do-while davam etsin
//                }
//
//
//                if (cavab.equals(dogru)) {
//                    System.out.println("Doğru!");
//                    duzgunSay++;
//                    answeredCorrected = true; // sualdan çıx
//                } else {
//                    System.out.println("Səhv! Yenidən cəhd edin.");
//                    sehvSay++;
//                }
//            } while (!answeredCorrected);
//        }
        int rand =(int)( Math.random() * asanSuallar.length ); //burda xeta var, array 0-1-2 men ise 0-1-2-3
        System.out.println(rand);
        boolean answeredCorrected=false;
        boolean[] used = new boolean[asanSuallar.length];
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

    }
}
