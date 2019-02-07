package k_2_05_abstract_human;

import use.readWriteFiles.ReadWriteFile;

import java.io.IOException;

public class ZmoniuKonteineris {

    public Zmogus[] getZmones() {
        return zmones;
    }

    public void setZmones(Zmogus[] zmones) {
        this.zmones = zmones;
    }

    private Zmogus[] zmones;

    public void skaitytiDuomenisIsFailo(String filePath) throws IOException {

        ReadWriteFile readFile = new ReadWriteFile();
        readFile.readFile(filePath);
        String[][] matrix = readFile.getMatrix();

        zmones = new Zmogus[matrix.length];
        int sk = 0;
        for (String[] mtr : matrix) {

            Zmogus zmogus = null;
            if (mtr[0].equals("S")) {
                zmogus = new Studentas(mtr[1], mtr[2], Integer.parseInt(mtr[3]), mtr[4], Integer.parseInt(mtr[5]));
                // priskyrimas be konstruktoriaus būtų toks, bet būtų reikalinga kastingas(Studentas) zmogus:
                // zmogus.setVardas(mtr[1]);
                // zmogus.setPavardas(mtr[2]);
                // zmogus.setAmzius(Integer.parseInt(mtr[3]));
                // ((Studentas) zmogus).setPareigos(mtr[4]);
                // ((Studentas) zmogus).setStazas(Integer.parseInt(mtr[5]));
            }
            if (mtr[0].equals("D")) {
                zmogus = new Darbuotojas(mtr[1], mtr[2], Integer.parseInt(mtr[3]), mtr[4], Integer.parseInt(mtr[5]));
            }
            zmones[sk++] = zmogus;
        }
        System.out.println(sk);
//        System.out.println(zmones[2].getAmzius());
    }

    public void spausdintiZmones() {

        for (Zmogus zmogus : zmones) {

            if (zmogus instanceof Studentas) {

                System.out.println(" --- Studentas ---");
            }

            if (zmogus instanceof Darbuotojas) {
                System.out.println(" --- Darbuotojas ---");
            }
            zmogus.toString();
        }
    }

    public void spausdintiVienaZmogu(Integer index) {

            zmones[index].toString();
    }

    public Integer vyriausiasZmogus() {

        Integer max = 0;
        Integer index = 0;

        for (int i = 0; i < zmones.length; i++) {
            if (zmones[i].getAmzius() > max) {
                max = zmones[i].getAmzius();
                index = i;
            }
        }
        return index;
    }
}
