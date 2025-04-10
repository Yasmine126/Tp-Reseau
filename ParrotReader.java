import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ParrotReader {
    public static void main(String[] args) throws IOException {
        // Création d'un InputStreamReader pour lire les entrées depuis la console
        InputStreamReader inputStream = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStream);

        // Création d'un BufferedWriter pour écrire dans le fichier "output.log"
        BufferedWriter bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream("output.log")));

        System.out.println("Entrez du texte (tapez 'Done' pour terminer et lire le fichier) :");

        String line;
        // Boucle de lecture et d'écriture ligne par ligne jusqu'à ce que l'utilisateur
        // entre "Done"
        while (!(line = bufferedReader.readLine()).equals("Done")) {
            // Affiche la ligne saisie dans la console
            System.out.println("Vous avez entré : " + line);

            // Écrit la ligne dans le fichier "output.log"
            bufferedWriter.write(line);
            bufferedWriter.newLine(); // Ajoute une nouvelle ligne après chaque entrée
            bufferedWriter.flush(); // Assure que la ligne est immédiatement écrite
        }

        // Fermeture des flux de lecture depuis la console et d'écriture dans le fichier
        bufferedReader.close();
        bufferedWriter.close();

        // Lecture du fichier "output.log" et affichage de son contenu
        System.out.println("\nContenu du fichier 'output.log' :");

        // Création d'un FileInputStream pour ouvrir le fichier en mode lecture
        FileInputStream fileInputStream = new FileInputStream("output.log");

        // Création d'un BufferedReader pour lire le fichier ligne par ligne
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(fileInputStream));

        // Lecture et affichage de chaque ligne du fichier jusqu'à la fin
        while ((line = fileReader.readLine()) != null) {
            System.out.println(line);
        }

        // Fermeture du BufferedReader de lecture du fichier
        fileReader.close();
    }
}
