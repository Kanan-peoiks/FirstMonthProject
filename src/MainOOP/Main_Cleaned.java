package MainOOP;

import java.util.Scanner;

public class Main_Cleaned {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Adınızı daxil edin: ");
        String name = scan.nextLine();
        System.out.println("Salam, " + name + "! \uD83D\uDC4B\n" +
                "“Azərbaycanın Tarixi Abidələri” viktorinasına xoş gəlmisiniz. Oyun 10 sualdan ibarətdir. Qaydaları oxumaq istəyirsiniz? (Hə / Yox)");
        String heYoxCavabi = scan.nextLine();
        String he = "Hə";
        heYoxCavabi = heYoxCavabi.trim();

        if (he.equalsIgnoreCase(heYoxCavabi)) {
            System.out.println("Qaydalar:\n" +
                    "Sual 1–3: Bu mərhələdə asan suallar soruşulacaq, bu sualları cavablandırmaq olduqca asandır.\n" +
                    "Sual 4–6: Bu mərhələdə orta suallar soruşulacaq, burada tarixi və coğrafi bilikləriniz lazım olacaq. Həmçinin bu mərhələyə keçdikdən sonra iki Joker qazanacaqsınız.\n" +
                    "Sual 7–9: Bu mərhələdə çətin suallar soruşulacaq, burada tarix və coğrafi biliklərini zorlamalı olacaqsan və bu mərhələyə keçdikdən sonra bir Joker qazanacaqsınız.\n" +
                    "Sual 10: Final sualı olacaq.\n" +
                    "Hər sual A/B/C/D variantlıdır. Səhv cavab verəndə yarışma bitir və yığdığınız xalların (böyük) bir qismini itirirsiniz. İstəsəniz geri çəkilə bilərsiniz və yığdığınız xalları götürə bilərsiniz.");
        } else {
            System.out.println("Cavabınız yox olaraq qeyd edildi, oyuna keçə bilərik...");
        }
        System.out.println();
        System.out.println("Başlayırıq! Uğurlar! \uD83C\uDF40");

        // --- ASAN SUALLAR ---
        Question[] asanSuallar = new Question[]{
                new Question("Səfəvilərin ilk paytaxtı hansıdır?", "A) Təbriz", "B) Qəzvin", "C) İsfahan", "D) Tehran", "A"),
                new Question("Şuşa şəhərinin banisi kim olub?", "A) Fətəli xan", "B) Nadir şah", "C) Pənahəli xan", "D) Cavad xan", "C"),
                new Question("Gəncə şəhərinin tarixi “Gəncə qalası” hansı dövrdə salınıb?", "A) Monqolların dövründə", "B) Qafqaz Albaniyası dövründə", "C) Səfəvilər dövründə", "D) Şəddadilər dövründə", "D"),
                new Question("Azərbaycan Respublikasının ilk paytaxtı hansı şəhər olub?", "A) Bakı", "B) Şəki", "C) Naxçıvan", "D) Gəncə", "D"),
                new Question("Azərbaycanda ən uzun müddətli hökm sürmüş Türk dövləti hansıdır?", "A) Səfəvilər", "B) Əfşarlar", "C) Şirvanşahlar", "D) Salarilər", "C")
        };

        int duzgunCavab = 0;
        boolean sehvCavab = false;
        int xal = 0;
        int sehvXal = 0;

        GameState gs = new GameState();
        // initial joker counts will be updated later according to game logic
        gs.yariyariJokeri = 0;
        gs.skipJoker = 0;
        gs.hintJoker = 0;

        FiftyFiftyJoker fifty = new FiftyFiftyJoker("asan");
        SkipJoker skip = new SkipJoker();
        HintJoker hint = new HintJoker();

        boolean[] usedAsan = new boolean[asanSuallar.length];

        for (int k = 0; k < 3; k++) {
            int rand = (int) (Math.random() * asanSuallar.length);

            while (usedAsan[rand]) {
                rand = (int) (Math.random() * asanSuallar.length);
            }
            usedAsan[rand] = true;

            String dogru = asanSuallar[rand].answer.trim().toUpperCase();
            System.out.println("Sual: " + (k + 1));
            asanSuallar[rand].printFull();
            System.out.print("Cavab (A/B/C/D): ");
            String cavab = scan.nextLine().trim().toUpperCase();

            while (!(cavab.equals("A") || cavab.equals("B") || cavab.equals("C") || cavab.equals("D"))) {
                System.out.println("Zəhmət olmasa yalnız A, B, C və ya D daxil edin.");
                cavab = scan.nextLine().trim().toUpperCase();
            }

            if (cavab.equals(dogru)) {
                System.out.println("Doğrudur! Siz 10 xal qazandınız. ");
                if (k == 0) {
                    System.out.println("Sıradakı suallar üçün geriçəkilmə haqqına sahib oldunuz.");
                }
                xal += 10;
                duzgunCavab++;
            } else {
                System.out.println("Səhv!");
                System.out.println("Doğru cavab: " + dogru);
                sehvCavab = true;
                sehvXal = xal / (2 + duzgunCavab);
                break;
            }

            int secim = 0;
            String input;
            do {
                System.out.println("Seçiminizi daxil edin: 1. Suala cavab vermək 2. Geriçəkilmə");
                input = scan.nextLine().trim();
                if (input.equals("1") || input.equals("2")) {
                    secim = Integer.parseInt(input);
                    break;
                } else {
                    System.out.println("Zəhmət olmasa yalnız 1 və ya 2 daxil edin.");
                }
            } while (true);

            if (secim == 2) {
                System.out.println("Siz geri çəkildiniz. Sizin xalınız: " + xal);
                scan.close();
                return;
            }
        }

        if (sehvCavab) {
            System.out.println("Təəssüf ki, yarışmamız sona çatdı. Sizin xalınız: " + sehvXal);
            scan.close();
            return;
        }

        // ---------- ORTA MERHELE ----------
        gs.yariyariJokeri = 1;
        gs.skipJoker = 1;

        Question[] ortaSuallar = new Question[]{
                new Question("Qız qalası hansı əsrdə tikilmişdir?", "A) XI əsr", "B) XII əsr", "C) IX əsr", "D) X əsr", "B"),
                new Question("Şəki Xan Sarayı hansı hökmdarın dövründə inşa edilmişdir?", "A) Hüseyn xan Musəvi", "B) Fətəli xan", "C) Hacı Çələbi xan", "D) Məhəmmədhəsən xan", "C"),
                new Question("Qobustan qayaüstü rəsmləri hansı dövrə aiddir?", "A) Eneolit dövrü", "B) Mezolit dövrü", "C) Tunc dövrü", "D) Orta əsrlər", "B"),
                new Question("Xəzər dənizi tarix boyu “Kaspi dənizi” kimi də tanınıb. Bu ad haradan gəlir?", "A) Kaspi tayfaları bu ərazidə yaşamışdır", "B) Dəniz Kaspiya şəhərinin yaxınlığında yerləşirdi", "C) Kaspi qədim fars dilində “duzlu” deməkdir", "D) Məşhur Roma imperiyası sərkərdəsinin şərəfinə bu ad verilmişdir", "A"),
                new Question("Səfəvilər dövlətinin paytaxtı əvvəlcə Təbriz idi. Lakin sonradan paytaxt İsfahana köçürüldü. Bunun əsas səbəbi nə idi?", "A) Təbrizdə zəlzələlərin baş verməsi", "B) Təbrizin Osmanlı hücumlarına açıq olması", "C) İsfahanın iqliminin daha əlverişli olması", "D) Təbrizin Tehrana uzaq olması", "B"),
                new Question("Nadir şah Əfşarın Dehli yürüşü nəticəsində hansı məşhur tarixi əşyalar İran torpaqlarına gətirilmişdi?", "A) Tavus taxtı və Köhlən Nur almazı", "B) Qızıl Orda bayrağı və Şahnamə əlyazması", "C) Babur ordusunun silahları", "D) Hindistan qızılı və baharatı", "A")
        };

        boolean[] usedOrta = new boolean[ortaSuallar.length];
        for (int k = 0; k < 3; k++) {
            int rand = (int) (Math.random() * ortaSuallar.length);
            while (usedOrta[rand]) rand = (int) (Math.random() * ortaSuallar.length);
            usedOrta[rand] = true;

            String dogru = ortaSuallar[rand].answer.trim().toUpperCase();
            System.out.println("Sual: " + (k + 4));
            ortaSuallar[rand].printFull();

            int secim = 0;
            String input;
            do {
                System.out.println("Seçiminizi daxil edin: 1. Suala cavab vermək 2. Joker istifadə etmək 3. Geriçəkilmə");
                input = scan.nextLine().trim();
                if (input.equals("1") || input.equals("2") || input.equals("3")) {
                    secim = Integer.parseInt(input);
                    break;
                } else {
                    System.out.println("Zəhmət olmasa yalnız 1, 2 və ya 3 daxil edin.");
                }
            } while (true);

            if (secim == 2) {
                int secim2 = 0;
                String input2;
                do {
                    System.out.println("Zəhmət olmasa istifadə etmək istədiyiniz jokeri seçin (1/2): 1. '50/50' Jokeri 2. 'Skip' Jokeri");
                    input2 = scan.nextLine().trim();
                    if (input2.equals("1") || input2.equals("2")) {
                        secim2 = Integer.parseInt(input2);
                        break;
                    } else {
                        System.out.println("Zəhmət olmasa yalnız 1 və ya 2 daxil edin.");
                    }
                } while (true);

                switch (secim2) {
                    case 1:
                        rand = fifty.use(ortaSuallar, rand, gs);
                        break;
                    case 2:
                        rand = skip.use(ortaSuallar, rand, gs);
                        break;
                    default:
                        System.out.println("Belə Joker yoxdur");
                }
            } else if (secim == 3) {
                System.out.println("Siz geriçəkildiniz. Sizin xalınız: " + xal);
                scan.close();
                return;
            }

            System.out.print("Cavab (A/B/C/D): ");
            String cavab = scan.nextLine().trim().toUpperCase();
            while (!(cavab.equals("A") || cavab.equals("B") || cavab.equals("C") || cavab.equals("D"))) {
                System.out.println("Zəhmət olmasa yalnız A, B, C və ya D daxil edin.");
                cavab = scan.nextLine().trim().toUpperCase();
            }

            if (cavab.equals(dogru)) {
                System.out.println("Doğrudur! Siz 20 xal qazandınız. ");
                xal += 20;
                duzgunCavab++;
            } else {
                System.out.println("Səhv!");
                System.out.println("Doğru cavab: " + dogru);
                sehvCavab = true;
                sehvXal = xal / (2 + duzgunCavab);
                break;
            }
            System.out.println();
        }

        if (sehvCavab) {
            System.out.println("Təəssüf ki, yarışmamız sona çatdı. Sizin xalınız: " + sehvXal);
            scan.close();
            return;
        }

        // --------- CETIN MERHELE ----------
        gs.hintJoker = 1;
        Question[] cetinSuallar = new Question[]{
                new Question("Səfəvilər dövründə Azərbaycan ərazisinin inzibati bölgüsü necə adlanırdı?", "A) Vilayətlər", "B) Bəylərbəyliklər", "C) Xanlıqlar", "D) Qəzalar", "B",
                        "Bəzi bölgələr böyük idarəetmə vahidlərinə bölünürdü və hər birinin rəhbəri mərkəzlə müəyyən qədər bağlı idi."),
                new Question("Gülüstan sülh müqaviləsindən sonra Azərbaycanın hansı tarixi bölgələri Rusiya imperiyasına birləşdirildi?", "A) Qarabağ, Şəki, Gəncə", "B) Naxçıvan, Ordubad, Lənkəran", "C) Gəncə, Şamaxı, Bakı", "D) Qarabağ, Gəncə, Şirvan", "D", "Qərb və şimal-qərb bölgələrinə diqqət yetirin."),
                new Question("Qaraqoyunlu və Ağqoyunlu dövlətlərinin Azərbaycan tarixində rolu hansı aspektdə fərqlənir?", "A) Qaraqoyunlular ticarətə üstünlük verirdi, Ağqoyunlular isə yalnız kənd təsərrüfatı ilə məşğul idi", "B) Qaraqoyunlular mərkəzləşmiş inzibati sistem qurmuşdular, Ağqoyunlular isə daha çox yerli hökmdarlara səlahiyyət vermişdilər",
                        "C) Hər iki dövlət eyni inzibati struktura malik idi, yalnız adları fərqli idi", "D) Qaraqoyunlular dini məsələlərdə sərt siyasət yürüdürdü, Ağqoyunlular isə tamamilə tolerant idi", "B", "Bir dövlət mərkəzləşmiş idarəetməyə üstünlük verirdi, digəri isə bəzi yerləri daha sərbəstdi."),
                new Question("XIV əsrdə Azərbaycan ərazisində yaranan Qaraqoyunlu dövlətinin inzibati və siyasi strukturu haqqında hansı ifadə doğrudur?", "A) Qaraqoyunlular ərazini vilayətlərə bölməmiş, mərkəzi hakimiyyət yalnız şahın sarayına bağlı idi", "B) Dövlət quruluşu mərkəzləşmişdi, amma hər bölgədə ayrı bir bəy və ya hakimi vardı",
                        "C) Qaraqoyunlular demokratik prinsiplərlə şəhər şurasını idarə edirdilər", "D) Dövlət yalnız kənd təsərrüfatı ilə məşğul olan kənd icmaları tərəfindən idarə olunurdu", "B", "Bəzi bölgələr özünü idarə etməkdə azad idi, amma mərkəzi hakimiyyət hələ də əsas rolu oynayırdı."),
                new Question("Ərəblərin Qafqaza yürüşləri zamanı Azərbaycan torpaqlarında ən güclü müqavimət hansı bölgədə göstərilmişdi?", "A) Şirvan", "B) Qarabağ", "C) Gülüstan qalası", "D) Cavanşir qalası", "D", "Ən güclü müqavimət dağlıq və strateji əhəmiyyətli bölgələrdə meydana gəldi."),
                new Question("Şirvanşahlar dövlətinin mövcud olduğu dövr hansı əsrləri əhatə edir?", "A) XI–XV əsrlər", "B) XII–XVIII əsrlər", "C) X–XIII əsrlər", "D) XIII–XVI əsrlər", "B", "Mövcudluq orta əsrlərin bir hissəsini əhatə edir, lakin daha erkən və daha gec dövrlərdən fərqlidir.")
        };

        boolean[] usedCetin = new boolean[cetinSuallar.length];
        for (int k = 0; k < 3; k++) {
            int rand = (int) (Math.random() * cetinSuallar.length);
            while (usedCetin[rand]) rand = (int) (Math.random() * cetinSuallar.length);
            usedCetin[rand] = true;

            String dogru = cetinSuallar[rand].answer.trim().toUpperCase();
            System.out.println("Sual: " + (k + 7));
            cetinSuallar[rand].printFull();

            int secim = 0;
            String input;
            do {
                System.out.println("Seçiminizi daxil edin: 1. Suala cavab vermək 2. Joker istifadə etmək 3. Geriçəkilmə");
                input = scan.nextLine().trim();
                if (input.equals("1") || input.equals("2") || input.equals("3")) {
                    secim = Integer.parseInt(input);
                    break;
                } else {
                    System.out.println("Zəhmət olmasa yalnız 1, 2 və ya 3 daxil edin.");
                }
            } while (true);

            if (secim == 2) {
                int secim2 = 0;
                String input2;
                do {
                    System.out.println("Zehmet olmasa istifadə etmək istədiyiniz jokeri seçin (1/2/3): 1. '50/50' Jokeri 2. 'Skip' Jokeri 3. 'Hint' Jokeri");
                    input2 = scan.nextLine().trim();
                    if (input2.equals("1") || input2.equals("2") || input2.equals("3")) {
                        secim2 = Integer.parseInt(input2);
                        break;
                    } else {
                        System.out.println("Zəhmət olmasa yalnız 1, 2 və ya 3 daxil edin.");
                    }
                } while (true);

                switch (secim2) {
                    case 1:
                        rand = fifty.use(cetinSuallar, rand, gs);
                        break;
                    case 2:
                        rand = skip.use(cetinSuallar, rand, gs);
                        break;
                    case 3:
                        rand = hint.use(cetinSuallar, rand, gs);
                        break;
                    default:
                        System.out.println("Belə Joker yoxdur.");
                }
            } else if (secim == 3) {
                System.out.println("Siz geriçəkildiniz. Sizin xalınız: " + xal);
                scan.close();
                return;
            }

            System.out.print("Cavab (A/B/C/D): ");
            String cavab = scan.nextLine().trim().toUpperCase();
            while (!(cavab.equals("A") || cavab.equals("B") || cavab.equals("C") || cavab.equals("D"))) {
                System.out.println("Zəhmət olmasa yalnız A, B, C və ya D daxil edin.");
                cavab = scan.nextLine().trim().toUpperCase();
            }

            if (cavab.equals(dogru)) {
                System.out.println("Doğrudur! Siz 30 xal qazandınız. ");
                xal += 30;
                duzgunCavab++;
            } else {
                System.out.println("Səhv!");
                System.out.println("Doğru cavab: " + dogru);
                sehvCavab = true;
                sehvXal = xal / (2 + duzgunCavab);
                break;
            }
            System.out.println();
        }

        if (sehvCavab) {
            System.out.println("Təəssüf ki, yarışmamız sona çatdı. Sizin xalınız: " + sehvXal);
            scan.close();
            return;
        }

        // -------- FINAL ----------
        Question[] finalSuali = new Question[]{
                new Question("“Ey gənclər! Siz gələcəyin sahibisiniz. Vətən sizdən ümidlidir. Torpağımızın azadlığı, xalqımızın tərəqqisi sizin əlinizdədir. " +
                        "Hər biriniz elmə, mədəniyyətə, milli ruhun qorunmasına sadiq olmalısınız. Dövlət qurmaq, xalqı birləşdirmək və milli azadlığı qorumaq sizin vəzifənizdir. " +
                        "Hər zaman dürüst, cəsarətli və vətənpərvər olun. Sizi gözləyən məsuliyyət böyükdür, amma sizin gücünüz də ona uyğun olmalıdır. Vətən üçün çalışın, onun adını yüksəldin və heç vaxt təslim olmayın!”" +
                        "'Gəncliyə Xitabə' kimi adlanan bu səsləniş kimə məxsusdur?", "A) Məmməd Əmin Rəsulzadə", "B) Heydər Əliyev", "C) Şah İsmayıl Xətai", "D) Elçibəy", "A",
                        "Bu şəxs Azərbaycanın yaranmasında mühim rol oynamışdır, Azərbaycanın qurucu lideri və ulu Öndəridir."),
                new Question("Əgər Rəsulzadə bu gün yaşasaydı, müasir Azərbaycana bir tövsiyə verə bilsəydi, hansı məsləhəti ən vacib sayardı?",
                        "A) Müstəqilliyi hər zaman qoruyun — suverenlikdən vazkeçməyin.", "B) Təhsilə və maarifçiliyə sərmayə qoyun — millətin gələcəyi üçün ən vacib investisiya.",
                        "C) Siyasi və ictimai dialoqu gücləndirin; qütbləri yumşaldın və birlik yaradın.", "D) İqtisadi rifah və praktiki islahatlara üstünlük verin — xalqın gündəlik həyatını yaxşılaşdırın.",
                        "B", "Rəsulzadə maarifçilik və maariflənməyə böyük önəm verirdi.")
        };

        for (int k = 0; k < 1; k++) {
            String dogru = finalSuali[0].answer.trim().toUpperCase();
            System.out.println("Sual: 10");
            finalSuali[0].printFull();

            int secim = 0;
            String input;
            do {
                System.out.println("Seçiminizi daxil edin: 1. Suala cavab vermək 2. Joker istifadə etmək 3. Geriçəkilmə");
                input = scan.nextLine().trim();
                if (input.equals("1") || input.equals("2") || input.equals("3")) {
                    secim = Integer.parseInt(input);
                    break;
                } else {
                    System.out.println("Zəhmət olmasa yalnız 1, 2 və ya 3 daxil edin.");
                }
            } while (true);

            if (secim == 2) {
                int secim2 = 0;
                String input2;
                do {
                    System.out.println("Zəhmət olmasa istifadə etmək istədiyiniz jokeri seçin (1/2/3): 1. '50/50' Jokeri 2. 'Skip' Jokeri 3. 'Hint' Jokeri");
                    input2 = scan.nextLine().trim();
                    if (input2.equals("1") || input2.equals("2") || input2.equals("3")) {
                        secim2 = Integer.parseInt(input2);
                        break;
                    } else {
                        System.out.println("Zəhmət olmasa yalnız 1, 2 və ya 3 daxil edin.");
                    }
                } while (true);

                switch (secim2) {
                    case 1:
                        fifty.use(finalSuali, 0, gs);
                        break;
                    case 2:
                        skip.use(finalSuali, 0, gs);
                        break;
                    case 3:
                        hint.use(finalSuali, 0, gs);
                        break;
                    default:
                        System.out.println("Belə Joker yoxdur.");
                }
            } else if (secim == 3) {
                System.out.println("Siz geriçəkildiniz. Sizin xalınız: " + xal);
                scan.close();
                return;
            }

            System.out.print("Cavab (A/B/C/D): ");
            String cavab = scan.nextLine().trim().toUpperCase();
            while (!(cavab.equals("A") || cavab.equals("B") || cavab.equals("C") || cavab.equals("D"))) {
                System.out.println("Zəhmət olmasa yalnız A, B, C və ya D daxil edin.");
                cavab = scan.nextLine().trim().toUpperCase();
            }

            if (cavab.equals(dogru)) {
                System.out.println("Doğrudur! Siz 50 xal qazandınız. ");
                xal += 50;
                duzgunCavab++;
            } else {
                System.out.println("Səhv!");
                System.out.println("Doğru cavab: " + dogru);
                sehvCavab = true;
                sehvXal = xal / (2 + duzgunCavab);
                break;
            }
            System.out.println();
        }

        if (sehvCavab) {
            System.out.println("Təəssüf ki, yarışmamız sona çatdı. Sizin xalınız: " + sehvXal);
            scan.close();
            return;
        }

        System.out.println("Təbriklər!! Siz bu oyunu bitirdiniz!! Sizin xalınız: " + xal);
        System.out.println();

        scan.close();
    }
}
