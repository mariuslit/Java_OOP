package k_2_05_abstract_human;

import java.io.IOException;

public class Vykdyti {
    /*  Java 9, 13ps.
        +    Sukurti abstrakčią klasę Zmogus, kurioje būtų saugomas vardas, pavardė, amžius.
        -    Sukurti vaikines klases Studentas, Darbuotojas.
          +      Studentas klasėje saugomas kursas, studijų kryptis.
          -      Darbuotojo klasėje saugoma kiek metų dirba toje srityje, specialybė.
        +    Sukurti abstraktų metodą toString(), kur atspausdinami visi objekto duomenys.
        +    Sukurti klasę ZmoniuKonteineris, kurioje būtų saugomas Zmogaus klasės masyvas.
        +    Nuskaityti iš duomenų failo duomenis. Pvz:
        +           Studentas Andrius Jonaitis 2 Informatika
        +           Darbuotojas Jonas Jonaitis 6 Vadybininkas
        -       Rasti vyriausią žmogų.
    */

    public static void main(String[] args) throws IOException {
        Studentas studentas = new Studentas();
        studentas.setVardas("Marius");
        studentas.setPavardas("Litvinas");
        studentas.setAmzius(44);
        studentas.setStudijuKryptis("Programavimas");
        studentas.setKursas(2);
        System.out.println(studentas.toString());

        ZmoniuKonteineris zk = new ZmoniuKonteineris();
        zk.skaitytiDuomenisIsFailo("C:\\Coding\\Java_OOP\\src\\k_2_05_abstract_human\\dataStudentai.txt");
    }
}
