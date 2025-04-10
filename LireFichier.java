import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class LireFichier {
    public static void main(String[] args) {
        // Crée une ArrayList pour stocker les lignes du fichier
        ArrayList<String> lignes = new ArrayList<>();

        // 1. Lecture du fichier texte et stockage de chaque ligne dans l'ArrayList
        try (BufferedReader br = new BufferedReader(new FileReader("fichier.txt"))) {
            String ligne;
            // Lit chaque ligne du fichier tant qu'il en reste
            while ((ligne = br.readLine()) != null) {
                lignes.add(ligne); // Ajoute la ligne à la liste
            }
        } catch (IOException e) {
            // Affiche un message d'erreur si la lecture du fichier échoue
            System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
            return; // Termine le programme en cas d'erreur
        }

        // 2. Création d'un Scanner pour lire la saisie de l'utilisateur
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // Invite l'utilisateur à entrer un numéro de ligne
            System.out.print("Entrez le numéro de ligne à lire (ou -1 pour quitter) : ");
            String input = scanner.nextLine();

            try {
                // Convertit l'entrée de l'utilisateur en entier
                int numLigne = Integer.parseInt(input);

                // Vérifie si l'utilisateur a saisi -1 pour quitter
                if (numLigne == -1) {
                    System.out.println("Programme terminé.");
                    break; // Quitte la boucle et termine le programme
                }
                // Vérifie si le numéro de ligne est dans les limites de la liste
                else if (numLigne >= 1 && numLigne <= lignes.size()) {
                    // Affiche la ligne correspondante (numLigne - 1 car les indices commencent à 0)
                    System.out.println("Ligne " + numLigne + " : " + lignes.get(numLigne - 1));
                } else {
                    // Affiche un message d'erreur si le numéro de ligne est incorrect
                    System.out.println("Numéro de ligne incorrect.");
                }
            } catch (NumberFormatException e) {
                // Capture les erreurs de format si l'entrée n'est pas un entier
                System.out.println("Input incorrect.");
                break; // Termine le programme en cas d'entrée non valide
            }
        }

        // Ferme le Scanner pour libérer les ressources
        scanner.close();
    }
}
