package k_2_12_collections;

import java.util.*;

public class Test {

    public static void main(String[] args) {

/*
    +   Sukurkite žodyno tipo kolekciją saugoti žmonių klasės objektus
            (su tokiais laukais: vardas, pavardė, asmens kodas), o kaip raktą naudokite asmens kodą.
    +   Įdėkite keletą žmonių į kolekciją ir atspausdinkite žmones asmens kodo didėjimo tvarka.
    -   Pabandykite įdėti į kolekciją du skirtingus žmones bet su tuo pačiu asmens kodu. Patikrinkite kas atsitiks?
    -   Pagalvokite kaip saugoti žmones jei norime turėti kelis su tuo pačiu asmens kodu.
*/
        List<Zmogus> zodynas = new ArrayList<>();
        zodynas.add(new Zmogus("Marius", "Litvinas", "123456789", "pardavimai", 900.55));
        zodynas.add(new Zmogus("Darius", "Andraitis", "123456789", "pirkimai", 900.55));
        zodynas.add(new Zmogus("Rytis", "Briedaitis", "123456789", "pardavimai", 900.55));
        zodynas.add(new Zmogus("Andrius", "Petraitis", "987654321", "pirkimai", 1000.64));
        zodynas.add(new Zmogus("Jonas", "Jonaitis", "456789123", "pardavimai", 2000.14));
        zodynas.add(new Zmogus("Giedrius", "Matusa", "654987321", "pirkimai", 2500.14));
        zodynas.add(new Zmogus("Saulius", "Briedauskas", "123456123", "pardavimai", 1500.14));

        for (Zmogus zm : zodynas) {

            System.out.println(zm.toString());
        }
        System.out.println();

        // Collection išsaugo rikšmę
        Collections.sort(zodynas,Zmogus::compareTo);
        for (Zmogus zm : zodynas) {

            System.out.println(zm.toString());
        }

    }
}
