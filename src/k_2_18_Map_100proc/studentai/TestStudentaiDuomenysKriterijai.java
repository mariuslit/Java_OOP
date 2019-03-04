package k_2_18_Map_100proc.studentai;

import java.io.*;
import java.util.*;

public class TestStudentaiDuomenysKriterijai {


/*
    Nuskaityti failą ir sudėti į Map<String, List<Studentas>> kolekciją.
    Atspausdinti nuskaitytus duomenis
*/

    public static void main(String[] args) throws IOException {

        Set<String> grupes = new TreeSet<>();
        Map<String, List<Studentas>> studentai = gautiStudentus(grupes, new File("").getAbsolutePath() + "\\src\\k_2_18_Map_100proc\\studentai\\Studentai.txt");

//        System.out.println();
        for (String grupe : grupes) {

                System.out.println(studentai.get(grupe));

        }
    }

    private static Map<String, List<Studentas>> gautiStudentus(Set<String> grupes, String failas) throws IOException {

        Map<String, List<Studentas>> studentai = new LinkedHashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(failas))) {

            String line = br.readLine();

            while (line != null) {

                String[] zd = line.split(" ");

                String vardas = zd[0];
                String pavarde = zd[1];
                String grupe = zd[2];

                if (studentai.containsKey(grupe)) {

                    studentai.get(grupe).add(new Studentas(vardas, pavarde, grupe));
                } else {

                    List list = new ArrayList<>();
                    list.add(new Studentas(vardas, pavarde, grupe));
                    studentai.put(grupe, list);

                }

                grupes.add(grupe);
                line = br.readLine();
            }
            return studentai;

        } catch (FileNotFoundException ex) {

            System.out.println("Failas nerastas " + failas);
        }
        return null;
    }


}
