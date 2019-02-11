package k_2_06_vidines_lokalios_anonimines;

import java.util.Arrays;

public class Main2 {

     public static void main(String[] args) {
            Employee2 e1 = new Employee2("Jonas", 600d,
                    "Kaunas", "Savanoriu", "9a");
            Employee2 e2 = new Employee2("Jonas", 600d,
                    "Vilnius", "Savanoriu", "9a");
            Employee2 e3 = new Employee2("Jonas", 600d,
                    "Siauliai", "Savanoriu", "9a");
            Employee2[] arr = new Employee2[]{
                    e1, e2, e3, e1, e2, e3
            };
            System.out.println(rastiUnikaliuMiestuSkaiciu(arr));
//        Employee2.Address add = e1.new Address("Kaunas", "Savanoriu", "9a");
//        add.Test();
//        Employee2.Address1 adress = new Employee2.Address1("Kaunas", "Savanoriu", "9a");

            Abstrakti ab = new Abstrakti() {
                @Override
                void Spausdinti() {
                    Spausdinti2();
                }

                void Spausdinti2() {
                    System.out.println("tratata");
                }

                Double paskaiciuotiAtlyginima(Double atlyginimas) {
                    return atlyginimas * 1.1;
                }
            };

            Abstrakti ab2 = new Abstrakti() {
                @Override
                void Spausdinti() {

                }

                @Override
                Double paskaiciuotiAtlyginima(Double atlyginimas) {
                    return atlyginimas + 50;
                }
            };

            e1.setAtlyginimas(ab.paskaiciuotiAtlyginima(e1.getAtlyginimas()));
            System.out.println(e1);
//        Abstrakti ab = new Abstrakti() {
//            @Override
//            void Spausdinti() {
//                Spausdinti2();
//                System.out.println("Spausdinti");
//            }
//            void Spausdinti2() {
//                System.out.println("tratata");
//            }
//        };
//        ab.Spausdinti();
//        ab.Spausdinti2();
        }

        public static Integer rastiUnikaliuMiestuSkaiciu(Employee2[] arr) {
            String[] unikalusMiestai = new String[]{arr[0].getAddress().getCity()};
            for(int i = 0; i < arr.length; i++) {
                for(int j = 0; j < unikalusMiestai.length; j++) {
                    if(!arr[i].getAddress().getCity().equals(unikalusMiestai[j]))  {
                        unikalusMiestai = pridetiElementaInteger(unikalusMiestai, arr[i].getAddress().getCity());
                        break;
                    }
                }

            }
            return unikalusMiestai.length;
        }

        public static String[] pridetiElementaInteger(String[] masyvas, String skaicius) {
            if(arTuriReiksme(masyvas, skaicius)) {
                return masyvas;
            } else {
                masyvas = Arrays.copyOf(masyvas, masyvas.length + 1);
                masyvas[masyvas.length - 1] = skaicius;
                return masyvas;
            }
        }

        public static Boolean arTuriReiksme(String[] masyvas, String reiksme) {
            for(int i = 0; i < masyvas.length; i++) {
                if(masyvas[i].equals(reiksme)) {
                    return true;
                }
            }
            return false;
        }
    }