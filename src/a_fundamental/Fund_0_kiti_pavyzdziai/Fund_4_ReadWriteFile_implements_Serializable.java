package a_fundamental.Fund_0_kiti_pavyzdziai;

import java.io.*;

// įrašymas į failą siunčiant Objektą
// skaitymas iš į failo gaunant Objektą

class Krepsininkas implements Serializable {
    int id;
    String name;

    public Krepsininkas(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class WriteObjToFile {

    public static void main(String args[]) throws Exception {

        Krepsininkas krepsininkas = new Krepsininkas(11, "Arvydas Sabonis");

        String path = new File("").getAbsolutePath() + "\\src\\a_fundamental\\Fund_0_kiti_pavyzdziai\\Fund_4_ReadWriteFile_implements_Serializable.txt";
        FileOutputStream fout = new FileOutputStream(path);
        ObjectOutputStream out = new ObjectOutputStream(fout);
        out.writeObject(krepsininkas);
        out.flush();
        System.out.println("success2");
    }
}

class ReadObjFromFile {

    public static void main(String args[]) throws Exception {

        String path = new File("").getAbsolutePath() + "\\src\\a_fundamental\\Fund_0_kiti_pavyzdziai\\Fund_4_ReadWriteFile_implements_Serializable.txt";
        FileInputStream fin = new FileInputStream(path);
        ObjectInputStream in = new ObjectInputStream(fin);
        Krepsininkas krepsininkas = (Krepsininkas) in.readObject();
        in.close();
        System.out.println(krepsininkas.name + " Nr." + krepsininkas.id);
    }
}