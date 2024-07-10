public class Carte {
    private final int tailleX;
    private final int tailleY;
    private Ressource[][] grille;

    public Carte(int tailleX, int tailleY) {
        this.tailleX = tailleX;
        this.tailleY = tailleY;
        this.grille = new Ressource[tailleX][tailleY];
    }

    public void placerRessource(Ressource ressource, int x, int y) {
        grille[x][y] = ressource;
    }

    public Ressource getRessourceAtPosition(int x, int y) {
        return grille[x][y];
    }

    public void retirerRessource(int x, int y) {
        grille[x][y] = null;
    }

    // Getters
    public int getTailleX() {
        return tailleX;
    }

    public int getTailleY() {
        return tailleY;
    }
}
