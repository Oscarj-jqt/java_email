package emailapp;

import java.util.Scanner;

//La classe pour la gestion d'un email
public class Email {
    // les propriétés
    // On précise leur accès pour la confidentialité
   private String firstName;
   private String lastName;
   private String password;
   private String department;
   private String email;
   private int mailboxCapacity = 500;
   private int defaultPasswordLength = 10;
   private String alternateEmail;
   private String compagnySuffix = "gmail.com";

   // Avec ces instructions, on définit maintenant les méthodes

   // Le constructeur pour recevoir le prénom et le nom de famille
   // toujours : accès classe(type props)
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
//        System.out.println("Email créé : " + this.firstName + " " + this.lastName);

        // Appeler une méthode demandant le département et renvoie le département
        this.department = setDepartement();
//        System.out.println("Département : " + this.department);

        // Appeler une méthode qui renvoie un mot de passe aléatoire
        this.password = randomPassword(defaultPasswordLength);
        System.out.print("Votre mot de passe est :" + this.password);

        //Combiner les éléments pour générer l'email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + compagnySuffix;
//        System.out.println("\nTon email est: " + email);
    }

    // Requête pour le département
    private String setDepartement() {
        System.out.print("Nouveau salarié: " + firstName + ". \n code du département \n1 pour Ventes\n2 pour Développement\n3 pour la comptabilité\n0 pour aucun\nEntrez le code du département: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) { return "ventes"; }
        else if (depChoice == 2) { return "développement"; }
        else if (depChoice == 3) { return "comptabilité"; }
        else { return ""; }
    }

    //Générer un mot de passe aléatoire
    private String randomPassword(int length) {
        String passwordSet = "ABCEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for (int i=0 ; i<length; i++) {
            // On génère un nombre aléatoire entre 0 et la dimension max
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }
    // Méthode pour établir la capacité de la boîte mail
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    //Changer l'email alterné
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }
    // Changer le mot de passe
    public void changePassword(String password) {
        this.password = password;
    }
    // On utilise l'encapsulation des méthodes plutôt que les props directement
    public int getMailboxCapacity() { return mailboxCapacity; }
    public String getAlternateEmail() { return alternateEmail; }
    public String getPassword() { return password; }

    // Mérhode pour afficher nom, email et capacité

    public String showInfo() {
        return "\nNom d'affichage: " + firstName + " " + lastName +
                "\nEmail d'entreprise: " + email +
                "\nCapacité de la boîte mail: " + mailboxCapacity + " mb";
    }
}
