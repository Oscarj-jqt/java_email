package emailapp;

//Création de la classe de notre app (dépendant de Email.java)
public class EmailApp {

    public static void main(String[] args) {
        //On crée un objet à partir du constructeur créé dans Email.
        Email em1 = new Email("Oscar","Jacquet");
        System.out.println(em1.showInfo());
        // On peut changer le mot de passe, altérer l'email avec les méthodes créées
//        em1.setAlternateEmail("oj@gmail.com");
//        System.out.println(em1.getAlternateEmail());
    }
}
