package k_2_05_interface_mokejimai;

public class VykdytiMokejimus {
/*
  +  Aprašykite interfeisą Mokėjimas (Payment) su šiais metodais:
  +      banko sąskaita (bank account) -  grąžina banko sąskaitos numerį
  +      sąskaitos turėtojas (account owner) - fizinio ar juridinio asmens pavadinimas
  +      suma (amount) - pervedama suma
  +  Sukurkite klases Darbuotojas (Employee) ir Klientas (Client), kurios implementuoja Mokėjimas interfeisą.
  +  Sukurkite masyvą iš keleto darbuotojų ir klientų objektų ir cikle išveskite jų mokėjimo informaciją

  +  Modifikuokite klasę Klientas (Client), kad joje galima būtų kaupti atliktų mokėjimų sumas (naudokite masyvą).
  +      Atspausdinkite klientus, su kuriais buvo atlikta daugiausia mokėjimų
  -  nedarytas    Atspausdinkite klientus kurių bent vienas mokėjimas viršija visų mokėjimų vidurkį bent 2 kartus
 */

    public static void main(String[] args) {

        Payment[] mokejimai = new Payment[5];

        mokejimai[0] = new Client("LT 123", "klientas_01", 5.0, new Double[]{5d, 2d, 6d, 8d});
        mokejimai[1] = new Client("LT 456", "klientas_02", 305.0, new Double[]{5d, 2d, 6d, 6d, 6d, 6d, 6d, 8d});
        mokejimai[2] = new Employee("LT 658", "klientas_03", 25.0);
        mokejimai[3] = new Employee("LT 257", "klientas_04", 5000.0);
        mokejimai[4] = new Client("LT 359", "klientas_05", 95.0, new Double[]{5d, 2d, 8d});

        spausdiinti(mokejimai);
    }

    public static void spausdiinti(Payment[] mokejimai) {

        for (int i = 0; i < mokejimai.length; i++) {
            System.out.println(mokejimai[i].accountOwner() + " sąskaita " +
                    mokejimai[i].bankAccount() + " mokėjimas " +
                    mokejimai[i].amount());
            if (mokejimai[i] instanceof Client) {

                // eikalingas kastinimas nes noriu iš interfeisinio masyvo išraukti konkrečios klasės objektą
                System.out.println("   mokėjimų skaičius: " + ((Client) mokejimai[i]).getMokejimai().length);
            }
        }
    }
}
