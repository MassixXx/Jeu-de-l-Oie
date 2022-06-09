package Kernel;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class User implements Serializable, Comparable<User>{
    private static final String USERS_NAME_FILE = "UsersFiles/UsersNames.txt";
    private static final long serialversionUID = 3L;
            //129348938L;
    //Attributs
    private String nom;
    private int meilleurScore;
    private ArrayList<Partie> listeParties;
    //Méthodes
    public User(String nom) {
        this.nom = nom;
        this.meilleurScore = 0;
    }
    public  User(){}
    public User(String nom,ArrayList<Partie> liste) {
        this.nom = nom;
        this.meilleurScore = 0;
        this.listeParties = liste;
    }
    public void setMeilleurScore(int meilleurScore) {
        this.meilleurScore = meilleurScore;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getMeilleurScore() {
        return meilleurScore;
    }

    public void setListeParties(ArrayList<Partie> listeParties) {
        this.listeParties = listeParties;
    }

    public ArrayList<Partie> getListeParties() {
        return listeParties;
    }

    public String getNom() {
        return nom;
    }
    public  void afficher(){
        System.out.println(this.nom);
        System.out.println(this.meilleurScore);
        System.out.println(this.listeParties);

    }
    public static Map<String,Integer> getUsersClassified()
    {
        File file = new File("UsersFiles/UsersNames.txt");
        Map<String,Integer> usersMap = new TreeMap<>();
        //ArrayList<User> liste = new ArrayList<User>();
        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                User util = (User) SaveObjectFiles.getObject("UsersFiles/"+line+".dat");
               usersMap.put(util.getNom(), util.getMeilleurScore());
                //liste.add(util);
            }
            scanner.close();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            return usersMap;
        }
    }
    public int compareTo(User user)
    {
        if(this.meilleurScore >= user.getMeilleurScore()) return 1;
        else return -1;
    }
    public void saveToFile(){
        //Sérialise l'utilisateur

        SaveObjectFiles.saveObject(this,"UsersFiles/"+this.nom+".dat");
        if (!SaveObjectFiles.isInTextFile(USERS_NAME_FILE,this.nom))
            SaveObjectFiles.writeStringToTextFile(USERS_NAME_FILE,this.nom);
    }
    public void getFromFile(Jeu jeu){
        //Déserilalise l'utilisateur
        if (SaveObjectFiles.isInTextFile(USERS_NAME_FILE,this.nom))
        {
            User util = (User) SaveObjectFiles.getObject("UsersFiles/"+this.nom+".dat");
            this.nom = util.getNom();
            this.meilleurScore = util.getMeilleurScore();
            this.listeParties = util.getListeParties();
            //Réinitialisation des champs non sérialisés
            for (Partie part: listeParties
                 ) {
                        part.setUser(this);
                        part.setDe(new De(part));
                        part.setJeu(jeu);
                        part.getPlateau().setPartie(part);
            }
        }



    }


}
