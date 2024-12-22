package data;


import java.io.*;


public class ReaderWriter {
    public static boolean serialize(Object o, String filePath) {
        try {
            File file= new File(filePath);
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(o);

            oos.close();
            fos.close();

            return true;
        } catch (IOException exp) {
            exp.printStackTrace();
            return false;
        }
    }

    public static Object deserialize(String filePath) {
        try {
            File file= new File(filePath);
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            Object o = ois.readObject();

            ois.close();
            fis.close();
            return o;
        } catch (IOException | ClassNotFoundException io) {
            io.printStackTrace();
            return null;
        }
    }
}
