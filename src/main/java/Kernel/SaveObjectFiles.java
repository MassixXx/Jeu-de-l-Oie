package Kernel;

import java.io.*;
import java.util.Scanner;


public class SaveObjectFiles{

    //Sauvegarde de l'objet c dans le fichier se trouvant dans filePath
    public static <T>void  saveObject(T c, String filePath )
    {
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
    public static <T> T getObject(String filePath)

    {
        T util ;
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
           // util = (T) in.readObject();
            in.close();
            return  util;


        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
    public static void writeStringToTextFile(String filePath,String toBeWritten)
    {
        try(FileWriter fw = new FileWriter(filePath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(toBeWritten);
            out.close();
            bw.close();
            fw.close();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
    public static boolean isInTextFile(String filePath, String toBeResearched)
    {
        File file = new File(filePath);
        boolean trouv = false;
        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine() && !trouv) {
                String line = scanner.nextLine();
                if(line.equals(toBeResearched)) {
                    trouv = true;
                }
            }
            scanner.close();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }

        return  trouv;
    }

}
