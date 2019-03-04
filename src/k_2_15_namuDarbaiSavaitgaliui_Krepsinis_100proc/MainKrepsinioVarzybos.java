package k_2_15_namuDarbaiSavaitgaliui_Krepsinis_100proc;

import java.io.*;
import java.util.*;

public class MainKrepsinioVarzybos {

    public static void main(String[] args) throws IOException {

        MainKrepsinioVarzybos krepsinioVarzybos = new MainKrepsinioVarzybos();

        Map<Integer, Zaidejas> zaidejai = skaitytiZaidejus(new File("").getAbsolutePath() + "\\src\\k_2_15_namuDarbaiSavaitgaliui_Krepsinis_100proc\\zaidejai.txt");

//        List<Integer[]> taskai = skaitytiTaskus(new File("").getAbsolutePath() + "\\src\\k_2_15_namuDarbaiSavaitgaliui_Krepsinis_100proc\\taskai.txt");
//        krepsinioVarzybos.varzybosNuskaitantIsFailo(zaidejai, taskai);
        List<Integer[]> taskai = skaitytiTaskus2(new File("").getAbsolutePath() + "\\src\\k_2_15_namuDarbaiSavaitgaliui_Krepsinis_100proc\\taskai2.txt");
        krepsinioVarzybos.varzybosNuskaitantIsFailo2(zaidejai, taskai);

//        krepsinioVarzybos.varzybosTesiasi(zaidejai, taskai);
    }

    private void varzybosTesiasi(Map<Integer, Zaidejas> zaidejai, List<Integer[]> taskai) throws IOException {

        if (zaidejai != null && taskai != null) {

            Scanner sc = new Scanner(System.in);
            String line;

            // PAGRINDINIS ŽAIDIMO EIGĄ IMITUOJANTIS CIKLAS
            do {
                System.out.println("Įveskite žaidėją ir taškus: (0 = exit)");
                line = sc.nextLine();

                String[] metimas = line.split(" ");
                Integer zaidejoNumeris;
                Integer pelnytaTasku;

                if (metimas.length == 2) {

                    zaidejoNumeris = Integer.parseInt(metimas[0]);
                    pelnytaTasku = Integer.parseInt(metimas[1]);
                } else {

                    System.out.println("Neteisingai įvesta.");
                    continue;
                }

                if (tikrintiArYraZaidejasKomandoje(zaidejai, zaidejoNumeris)) {

                    priskirtiTaskusZaidejui(zaidejai, zaidejoNumeris, pelnytaTasku);
                }
            } while (!line.equals("0"));

            StringBuilder statistika = gautiStatistika(zaidejai);
            System.out.println(statistika);
            irasytiDuomenisFailan(new File("").getAbsolutePath() + "\\src\\k_2_15_namuDarbaiSavaitgaliui_Krepsinis_100proc\\suvestine.txt", statistika);
        }

    }

    private void varzybosNuskaitantIsFailo(Map<Integer, Zaidejas> zaidejai, List<Integer[]> taskai) throws IOException {

        if (zaidejai != null && taskai != null) {

            // PAGRINDINIS ŽAIDIMO EIGĄ IMITUOJANTIS CIKLAS
            for (Integer[] metimas : taskai) {

                Integer zaidejoNumeris = metimas[0];
                Integer pelnytaTasku = metimas[1];

                if (tikrintiArYraZaidejasKomandoje(zaidejai, zaidejoNumeris)) {

                    priskirtiTaskusZaidejui(zaidejai, zaidejoNumeris, pelnytaTasku);
                }
            }

            StringBuilder statistika = gautiStatistika(zaidejai);
            System.out.println(statistika);
            irasytiDuomenisFailan(new File("").getAbsolutePath() + "\\src\\k_2_15_namuDarbaiSavaitgaliui_Krepsinis_100proc\\suvestine.txt", statistika);
        }
    }

    private StringBuilder gautiStatistika(Map<Integer, Zaidejas> zaidejaiPirminis) {

        // sortinimas pagal Key su Lambda išraiška, sort: Z-A


        Map<Integer, Zaidejas> zaidejai = new TreeMap<>((o1, o2) -> o2.compareTo(o1));

        zaidejai.putAll(zaidejaiPirminis);

        StringBuilder txt = new StringBuilder();
        String entr = System.lineSeparator();

        txt.append("**************************************************************************************").append(entr);
        txt.append("| Nr. | Vardas, Pavardė       | Baudos | Dvit. | Trit. | Nepat. | Taskai | Tikslumas |").append(entr);
        txt.append("**************************************************************************************").append(entr);

        for (Zaidejas zaidejas : zaidejai.values()) {

            txt.append(zaidejas.toStringAll()).append(entr);
        }
        txt.append("**************************************************************************************").append(entr);

        Zaidejas rez = rastiRezultatyviausia(zaidejai);
        Zaidejas trit = rastiTritaskiuCempiona(zaidejai);
        Zaidejas taikl = rastiTaikliausia(zaidejai);

        txt.append("     Daugiausia taškų pelnė: ").append(rez.toString()).append(rez.getTaskai()).append(entr);
        txt.append(" Daugiausia įmetė tritaškių: ").append(trit.toString()).append(trit.getTritaskiai()).append(entr);
        txt.append("               Taikliausias: ").append(taikl.toString()).append(taikl.getTaiklumas()).append(" %").append(entr);

        return txt;
    }

    private Zaidejas rastiRezultatyviausia(Map<Integer, Zaidejas> zaidejai) {

        int max = 0;
        int n = 0;
        for (Zaidejas zaidejas : zaidejai.values()) {

            if (zaidejas.getTaskai() > max) {

                max = zaidejas.getTaskai();
                n = zaidejas.getNumeris();
            }
        }
        return zaidejai.get(n);
    }

    private Zaidejas rastiTritaskiuCempiona(Map<Integer, Zaidejas> zaidejai) {

        int max = 0;
        int n = 0;
        for (Zaidejas zaidejas : zaidejai.values()) {

            if (zaidejas.getTritaskiai() > max) {

                max = zaidejas.getTritaskiai();
                n = zaidejas.getNumeris();
            }
        }
        return zaidejai.get(n);
    }

    private Zaidejas rastiTaikliausia(Map<Integer, Zaidejas> zaidejai) {

        double max = 0;
        int n = 0;
        for (Zaidejas zaidejas : zaidejai.values()) {

            if (zaidejas.getTaiklumas() > max) {

                max = zaidejas.getTaiklumas();
                n = zaidejas.getNumeris();
            }
        }
        return zaidejai.get(n);
    }

    private boolean tikrintiArYraZaidejasKomandoje(Map<Integer, Zaidejas> zaidejai, Integer zaidejoNumeris) {

        if (zaidejai.containsKey(zaidejoNumeris)) {
            return true;
        }

        System.out.println("Žaidėjo Nr." + zaidejoNumeris + " nėra komandoje, todėl taškas neužskaitomas");
        return false;
    }

    private void priskirtiTaskusZaidejui(Map<Integer, Zaidejas> zaidejai, Integer zaidejoNumeris, Integer pelnytaTasku) {

        switch (pelnytaTasku) {
            case 0:
                zaidejai.get(zaidejoNumeris).setNepataikyta();
                break;
            case 1:
                zaidejai.get(zaidejoNumeris).setBaudos();
                break;
            case 2:
                zaidejai.get(zaidejoNumeris).setDvitaskiai();
                break;
            case 3:
                zaidejai.get(zaidejoNumeris).setTritaskiai();
                break;
            default:
                System.out.println("tokių taškų negali būti");
        }
    }

    private static List<Integer[]> skaitytiTaskus(String failas) throws IOException {

        List<Integer[]> taskai = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(failas))) {

            String line = br.readLine();
            int sk = 0;
            while (line != null) {

                if (sk++ > 100) {
                    System.out.println("Faile yra daugiau nei 100 įrašų, visi įršai (nuo 101 eil.) liko nenuskaityti.");
                    return taskai;
                }

                String[] metimas = line.split(" ");

                if (metimas.length == 2) {

                    taskai.add(new Integer[]{Integer.parseInt(metimas[0]), Integer.parseInt(metimas[1])});
                }
                line = br.readLine();
            }
            return taskai;

        } catch (FileNotFoundException ex) {

            System.out.println("Failas nerastas " + failas);
        }
        return null;
    }

    private static Map<Integer, Zaidejas> skaitytiZaidejus(String failas) throws IOException {

        Map<Integer, Zaidejas> taskai = new LinkedHashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(failas))) {

            String line = br.readLine();

            while (line != null) {

                String[] zd = line.split(" ");

                if (zd.length == 3) {

                    if (Integer.parseInt(zd[0]) > 100) {
                        System.out.println("Rastas žaidėjas kurio numeris " + zd[0] + ", kadangi jis didesnis už 100, šis žaiėjas nebuvo užregstruotas komandoje.");
                        line = br.readLine();
                        continue;
                    }

                    Zaidejas zaidejas = new Zaidejas(Integer.parseInt(zd[0]), zd[1], zd[2]);
                    taskai.put(zaidejas.getNumeris(), zaidejas);
                }
                line = br.readLine();
            }
            return taskai;

        } catch (FileNotFoundException ex) {

            System.out.println("Failas nerastas " + failas);
        }
        return null;
    }

    private static void irasytiDuomenisFailan(String failas, StringBuilder zaidejaiToFile) throws IOException {

        try (BufferedWriter  output = new BufferedWriter(new FileWriter(failas))){

            output.write(zaidejaiToFile.toString());

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    private void varzybosNuskaitantIsFailo2(Map<Integer, Zaidejas> zaidejai, List<Integer[]> taskai) throws IOException {

        if (zaidejai != null && taskai != null) {

            // PAGRINDINIS ŽAIDIMO EIGĄ IMITUOJANTIS CIKLAS
            for (Integer[] metimas : taskai) {

                Integer zaidejoNumeris = metimas[0];
                Integer pelnytaTasku = metimas[1];

                if (tikrintiArYraZaidejasKomandoje(zaidejai, zaidejoNumeris)) {

                    priskirtiTaskusZaidejui(zaidejai, zaidejoNumeris, pelnytaTasku);
                }
            }

            StringBuilder statistika = gautiStatistika2(zaidejai);
            System.out.println(statistika);
//            irasytiDuomenisFailan(new File("").getAbsolutePath() + "\\src\\k_2_15_namuDarbaiSavaitgaliui_Krepsinis_100proc\\suvestine2.txt", statistika);
        }
    }

    private StringBuilder gautiStatistika2(Map<Integer, Zaidejas> zaidejaiPirminis) {

        // sortinimas pagal Key su Lambda išraiška, sort: Z-A
        Map<Integer, Zaidejas> zaidejai = new TreeMap<>((o1, o2) -> o2.compareTo(o1));


        // stream: todo

//        Map<Integer, Zaidejas> zaidejai = new LinkedHashMap<>();
        zaidejai.putAll(zaidejaiPirminis);

        System.out.println(zaidejai.get(88).compareTo(zaidejai.get(33)));

        StringBuilder txt = new StringBuilder();
        String entr = System.lineSeparator();

        txt.append("**************************************************************************************").append(entr);
        txt.append("| Nr. | Vardas, Pavardė       | Baudos | Dvit. | Trit. | Nepat. | Taskai | Tikslumas |").append(entr);
        txt.append("**************************************************************************************").append(entr);

        for (Zaidejas zaidejas : zaidejai.values()) {

            txt.append(zaidejas.toStringAll()).append(entr);
        }
        txt.append("**************************************************************************************").append(entr);

        Zaidejas rez = rastiRezultatyviausia(zaidejai);
        Zaidejas trit = rastiTritaskiuCempiona(zaidejai);
        Zaidejas taikl = rastiTaikliausia(zaidejai);

        txt.append("     Daugiausia taškų pelnė: ").append(rez.toString()).append(rez.getTaskai()).append(entr);
        txt.append(" Daugiausia įmetė tritaškių: ").append(trit.toString()).append(trit.getTritaskiai()).append(entr);
        txt.append("               Taikliausias: ").append(taikl.toString()).append(taikl.getTaiklumas()).append(" %").append(entr);

        return txt;
    }

    private static List<Integer[]> skaitytiTaskus2(String failas) throws IOException {

        List<Integer[]> taskai = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(failas))) {

            String line = br.readLine();
            int sk = 0;
            while (line != null) {

//                if (sk++ > 100) {
//                    System.out.println("Faile yra daugiau nei 100 įrašų, visi įršai (nuo 101 eil.) liko nenuskaityti.");
//                    return taskai;
//                }

                String[] metimas = line.split(" ");

                if (metimas.length == 2) {

                    taskai.add(new Integer[]{Integer.parseInt(metimas[0]), Integer.parseInt(metimas[1])});
                }
                line = br.readLine();
            }
            return taskai;

        } catch (FileNotFoundException ex) {

            System.out.println("Failas nerastas " + failas);
        }
        return null;
    }

}


