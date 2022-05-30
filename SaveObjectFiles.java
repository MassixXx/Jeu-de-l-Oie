package Kernel;

import java.io.*;

public class SaveObjectFiles {

    //Sauvegarde de l'objet c dans le fichier se trouvant dans filePath
    public static <T> void saveObject(T c, String filePath) {
        ObjectOutputStream out;
        try {
            out = new ObjectOutputStream(
                    new BufferedOutputStream(
                            new FileOutputStream(
                                    new File(filePath)
                            )
                    )
            );

            out.writeObject(c);
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Retourne l'objet
    public static <T> T getObject(String filePath) {
        T util;
        ObjectInputStream in;
        try {
            in = new ObjectInputStream(
                    new BufferedInputStream(
                            new FileInputStream(
                                    new File(filePath)
                            )
                    )
            );

            util = (T) in.readObject();
            util = (T) in.readObject();
            in.close();
            return util;


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
