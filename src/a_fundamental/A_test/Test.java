package a_fundamental.A_test;

/**
 * M44061110 - I testas 2019-04-29
 * M44061110 - I testas 2019-04-29
 */
public class Test {
}

/*
    I.47 ką išves ši programa?
        A. a b
        B. d a b (mano klaida)
        C. d a c (teisingas atsakymas)

*/
class Test_I {
    public static void main(String[] args) {
        Base b = new Derived();
        b.f();
    }
}


class Base {
    void f() {
        System.out.print("a ");
        this.g();
    }

    void g() {
        System.out.print("b ");
    }
}

class Derived extends Base {
    void g() {
        System.out.print("c ");
    }

    void f() {
        System.out.print("d ");
        super.f();
    }
}

// todo kodėl abu true
class Test_I_77 {
    public static void main(String[] args) {

        String a = "value";
        String b = "value";
        System.out.println(a == b);      // true
        System.out.println(a.equals(b)); // true

        String c = new String("value");
        String d = new String("value");

        System.out.println(a == c);      // false
        System.out.println(a.equals(c)); // true

        System.out.println(c == d);      // false
        System.out.println(c.equals(d)); // true
    }
}

/*
    I.83 kas bus atspausdinta?
        A. 2
        B. 1 (testo atsakymas klaidingas)
        C. 0 (mano atsakymas teisingas)

*/
class Test_I_83 {

    private static void swap(int[] x, int i, int j) {

        int a = x[i];
        x[j] = x[i];
        x[i] = a;
    }

    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4};
        swap(a, 1, 2);
        System.out.println(a[2] - a[1]);
    }
}

/*
    I.86 kas bus atspausdinta?
        A. 4 (mano klaida)
        B. 12
        C. 6 (teisingas atsakymas)

*/
class Test_I_86 {

    public static void main(String[] args) {

        int x = new C().b(); // 2
        int y = new B().b();
        System.out.println(x + y);
    }
}

interface A {
    default int a() {
        return 1;
    }

    default int b() {
        return a() * 2;
    }
}

class B implements A {
    public int a() {
        return 2;
    }
}

class C implements A {
}

/*
    I.86 kas bus atspausdinta?
        A. 4 (mano klaida)
        B. 12
        C. 6 (teisingas atsakymas)

*/
class Test_I_191 {

    public static void main(String[] args) {
        int a = 1;
        int b = 0;
        int c = 0;

        try {

            c = a / b;
            System.out.println(c);

//        } catch (ArithmeticException e) {

        } finally {
            c = 1;
        }
        System.out.println(c);
    }
}

/*
    I.87 kas bus atspausdinta?
        A. false (teisingas atsakymas)
        B. true
        C. nieko, nes bus vykdymo klaida (mano klaida)
*/
class Test_I_87 {
    public static void main(String[] args) {
        Axy a = new Axy();
        System.out.println(a.x && a.y);
    }
}

class Axy {
    boolean x;
    Boolean y;
}

/*
    I.91 kas bus atspausdinta?
        A. nieko, nes klaida (mano atsakyms) (teisingas atsakymas)
        B. 111
        C. 110
*/
class Test_I_91 {
    public static void main(String[] args) {
        final int a = 100;
        final int b = a + 10;

        // užkomentuotas, nes braukia klaidą ties ++b
//        final int c = ++b;
//        System.out.println(c);
    }
}

// TODO Ugniui
/*
    II.73 Ką išves programa?
        A. kodas nesikompiliuos (mano atsakyms) Testo metu reikia spausti šitą atsakymą, net jei jis neteisingas
        B. equals (teisingas atsakymas)
        C. ==
*/
class Test_II_73 {
    public static void main(String[] args) {

        String a = "";
        a += 2;
        a += 'c';
        a += false;
        if (a == "2cfalse") {
            System.out.println("==");
        }
        if (a.equals("2cfalse")) {
            System.out.println("equals");
        }
    }
}

/*
    I.97 kas bus atspausdinta vykdant main metodą?
        A. 312 (teisingas atsakymas)
        B. 321 (mano atsakyms)
        C. 123
*/
class Test_I_97 {
    public static void main(String[] args) {

        class A extends Thread {
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
                System.out.println(1);
            }
        }

        A a = new A();
        class B extends Thread {
            public void run() {
                try {
                    a.join(); // tesia darba tik tada kai a tredas baigai darbą (po 2 sec.)
                } catch (InterruptedException e1) {
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                System.out.println(2);
            }
        }

        B b = new B();
        a.start();
        b.start();
        System.out.println(3);
    }
}

