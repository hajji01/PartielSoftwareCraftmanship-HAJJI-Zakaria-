public class Explorateur {
    private Survivant survivant;
    private Carte carte;

    public Explorateur(Survivant survivant, Carte carte) {
        this.survivant = survivant;
        this.carte = carte;
    }

    // Méthode pour explorer en fonction de la direction spécifiée
    public void explorer(Direction direction) {
        switch (direction) {
            case AVANCER:
                avancer();
                break;
            case TOURNER_GAUCHE:
                tournerGauche();
                break;
            case TOURNER_DROITE:
                tournerDroite();
                break;
            default:
                System.out.println("Direction non reconnue");
        }
    }

    // Méthode pour rencontrer des zombies et ajuster la santé du survivant
    public void rencontrerZombie(int nombreZombies) {
        int degats = nombreZombies * 10; 
        survivant.setSante(survivant.getSante() - degats);
        System.out.println("Vous avez rencontré " + nombreZombies + " zombie(s). Vous perdez " + degats + " points de santé.");
    }

    // Méthode privée pour avancer le survivant sur la carte
    private void avancer() {
        switch (survivant.getOrientation()) {
            case NORD:
                if (survivant.getY() < carte.getTailleY() - 1) {
                    survivant.setY(survivant.getY() + 1);
                } else {
                    System.out.println("Vous êtes au bord nord de la carte.");
                }
                break;
            case SUD:
                if (survivant.getY() > 0) {
                    survivant.setY(survivant.getY() - 1);
                } else {
                    System.out.println("Vous êtes au bord sud de la carte.");
                }
                break;
            case EST:
                if (survivant.getX() < carte.getTailleX() - 1) {
                    survivant.setX(survivant.getX() + 1);
                } else {
                    System.out.println("Vous êtes au bord est de la carte.");
                }
                break;
            case OUEST:
                if (survivant.getX() > 0) {
                    survivant.setX(survivant.getX() - 1);
                } else {
                    System.out.println("Vous êtes au bord ouest de la carte.");
                }
                break;
        }
    }

    // Méthode privée pour tourner à gauche
    private void tournerGauche() {
        switch (survivant.getOrientation()) {
            case NORD:
                survivant.setOrientation(Orientation.OUEST);
                break;
            case SUD:
                survivant.setOrientation(Orientation.EST);
                break;
            case EST:
                survivant.setOrientation(Orientation.NORD);
                break;
            case OUEST:
                survivant.setOrientation(Orientation.SUD);
                break;
        }
    }

    // Méthode privée pour tourner à droite
    private void tournerDroite() {
        switch (survivant.getOrientation()) {
            case NORD:
                survivant.setOrientation(Orientation.EST);
                break;
            case SUD:
                survivant.setOrientation(Orientation.OUEST);
                break;
            case EST:
                survivant.setOrientation(Orientation.SUD);
                break;
            case OUEST:
                survivant.setOrientation(Orientation.NORD);
                break;
        }
    }
}
