package use.readWriteFiles;

import java.io.*;
import java.util.Arrays;

public class ReadWriteFile {

    private final String UTF8 = "UTF-8";

    private String spliter = " ";
    private String[][] matrix = new String[][]{};


    // ------------------------------------- F >>
    public void readFile(String file) throws IOException {

        try (BufferedReader fileRead = new BufferedReader(new FileReader(file))) { // BT Džiugas
//        try (BufferedReader fileRead = new BufferedReader(new InputStreamReader(new FileInputStream(file), UTF8))) { // KCS Andrius

            String[][] dataMatrix = new String[][]{};
            String line;

            // ciklas vykdomas kol nusiskaito sekanti eiluutė
            while ((line = fileRead.readLine()) != null) {

                // išskaidyti sring eilutę su split ir priskirt string masyvui
                String[] arr = line.split(spliter);

                // matricą praplėsti viena eilute(+1 elementas) ir jai priskirti masyvą
                dataMatrix = Arrays.copyOf(dataMatrix, dataMatrix.length + 1);
                dataMatrix[dataMatrix.length - 1] = arr;
            }
            this.matrix = dataMatrix;

        } catch (FileNotFoundException ex) {

            System.out.println("Failas nerastas");
        }
    }

    // ------------------------------------- F <<
    private void rasytiMatrica(String failas, Integer[][] arr) throws IOException {

        BufferedWriter output = null;

        //         try (BufferedWriter file = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path + fileName), UTF8))) { // KCS Andrius
        try {
            output = new BufferedWriter(new FileWriter(failas));

            for (int i = 0; i < arr.length; i++) {

                StringBuilder text = new StringBuilder();

                for (int j = 0; j < arr[i].length; j++) {

                    text.append(arr[i][j]).append(" ");
                }

                text.append(System.lineSeparator());
                output.write(text.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (output != null) {
                output.close();
            }
        }
    }

    public String getSpliter() {
        return spliter;
    }

    public void setSpliter(String spliter) {
        this.spliter = spliter;
    }

    public String[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(String[][] matrix) {
        this.matrix = matrix;
    }
}
