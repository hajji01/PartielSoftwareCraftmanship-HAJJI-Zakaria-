public class Survivant {
    private int x;
    private int y;
    private Orientation orientation;
    private int sante;
    private Inventaire inventaire;

    public Survivant(int x, int y, Orientation orientation, int sante) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.sante = sante;
        this.inventaire = new Inventaire();
    }

    public void ramasserRessource(Carte carte) {
        Ressource ressource = carte.getRessourceAtPosition(x, y);
        if (ressource != null) {
            inventaire.ajouterRessource(ressource);
            carte.retirerRessource(x, y);
        }
    }

    // Les Getters et les Setters
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    public int getSante() {
        return sante;
    }

    public void setSante(int sante) {
        this.sante = sante;
    }

    public Inventaire getInventaire() {
        return inventaire;
    }

    public void setInventaire(Inventaire inventaire) {
        this.inventaire = inventaire;
    }
}
