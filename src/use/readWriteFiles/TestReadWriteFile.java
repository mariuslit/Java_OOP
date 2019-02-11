package use.readWriteFiles;

import java.io.File;
import java.io.IOException;

public class TestReadWriteFile {

    public static void main(String[] args) throws IOException {

        ReadWriteFile data = new ReadWriteFile();

        data.readFile(new File("").getAbsolutePath() + "\\src\\use\\readWriteFiles\\files\\read.txt");


        for (int i = 0; i < data.getMatrix().length; i++) {
            for (int j = 0; j < data.getMatrix()[i].length; j++) {

                System.out.print(data.getMatrix()[i][j] + "   ");
            }
            System.out.println();
        }
    }
}
