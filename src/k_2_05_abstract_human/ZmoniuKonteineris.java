package k_2_05_abstract_human;

import use.readWriteFiles.ReadWriteFile;

import java.io.IOException;

public class ZmoniuKonteineris {

    private Zmogus[] zmones;

    public void skaitytiDuomenisIsFailo(String filePath) throws IOException {

        ReadWriteFile readFile = new ReadWriteFile();
        readFile.readFile(filePath);
        String[][] matrix = readFile.getMatrix();

        zmones = new Zmogus[matrix.length];
        int sk = 0;
        for (String[] mtr : matrix) {

            Zmogus zmogus = new Studentas();
            zmogus.setVardas(mtr[1]);
            zmogus.setPavardas(mtr[2]);
            zmogus.setAmzius(Integer.parseInt(mtr[3]));
            ((Studentas) zmogus).setStudijuKryptis(mtr[4]);
            ((Studentas) zmogus).setKursas(Integer.parseInt(mtr[5]));
            zmones[sk++] = zmogus;

        }
        System.out.println(zmones[2].getAmzius());
    }
}
