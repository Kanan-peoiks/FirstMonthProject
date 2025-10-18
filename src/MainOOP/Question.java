// FILE: Question.java
package MainOOP;
public class Question {
    String text;
    String[] options; // A,B,C,D
    String answer; // "A"/"B"/"C"/"D"
    String hint; // optional

    public Question(String text, String a, String b, String c, String d, String answer) {
        this(text, new String[]{a, b, c, d}, answer, null);
    }

    public Question(String text, String a, String b, String c, String d, String answer, String hint) {
        this(text, new String[]{a, b, c, d}, answer, hint);
    }

    public Question(String text, String[] options, String answer, String hint) {
        this.text = text;
        this.options = options;
        this.answer = answer.trim().toUpperCase();
        this.hint = hint;
    }

    public void printQuestion() {
        System.out.println(text);
    }

    public void printOptions() {
        for (String opt : options) System.out.println(opt);
    }

    public void printFull() {
        printQuestion();
        printOptions();
    }
}


// FILE: SkipJoker.java




// FILE: .java


// -----------------------------------------------------------------------------
// FILE: .java
// Variant 1 — Level sinifi əlavə edilmiş versiya. Məntiq eyni, suallar ayrı Level obyektində.
// -----------------------------------------------------------------------------


// -----------------------------------------------------------------------------
// FILE: .java
// Variant 2 — sualları CSV fayldan oxuyan versiya. (Kod strukturunu qarışdırmamaq üçün eyni axar saxlanılıb.)
// Qeyd: çalışdırmaq üçün ROOT-da "questions.csv" adlı fayl tələb olunur — amma məntiq dəyişməyib.
// -----------------------------------------------------------------------------

// -----------------------------------------------------------------------------
// FILE: .java
// Variant 3 — Jokerləri ayrıca fayllarda saxlayan və istifadə edən versiya. JokerFactory nümunəsi.
// -----------------------------------------------------------------------------

// -----------------------------------------------------------------------------
// FILE: .java
// Variant 4 — Level + Loader birləşdirilmiş versiya. Suallar fayldan yüklənir və Level obyektinə verilir.
// -----------------------------------------------------------------------------



// -----------------------------------------------------------------------------
// FILE: .java
// Variant 5 — Kod təmizliyi və şərhlərlə sənədləşdirmə versiyası. Məntiq eyni saxlanıldı.
// -----------------------------------------------------------------------------
