import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SurvivantTest {

    @Test
    public void testRamasserRessource() {
        // Création d'une carte avec une ressource à une position spécifique
        Carte carte = new Carte();
        Ressource ressource = new Ressource("Nourriture");
        carte.placerRessource(ressource, 3, 4);

        // Création d'un survivant à une position donnée sur la carte
        Survivant survivant = new Survivant(3, 4, Orientation.NORD, 100);

        // Vérification que l'inventaire du survivant est vide initialement
        assertTrue(survivant.getInventaire().getRessources().isEmpty());

        // Ramasser la ressource sur la carte à la position du survivant
        survivant.ramasserRessource(carte);

        // Vérification que la ressource a été ajoutée à l'inventaire du survivant
        assertTrue(survivant.getInventaire().possedeRessource(ressource));
    }
}
