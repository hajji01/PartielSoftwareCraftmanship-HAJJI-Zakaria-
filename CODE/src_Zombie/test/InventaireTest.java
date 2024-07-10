import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InventaireTest {

    @Test
    public void testAjouterRessource() {
        // Création d'une ressource
        Ressource ressource = new Ressource(Ressource.TypeRessource.NOURRITURE);

        // Création d'un inventaire
        Inventaire inventaire = new Inventaire();

        // Vérification que l'inventaire est vide initialement
        assertTrue(inventaire.getRessources().isEmpty());

        // Ajout de la ressource à l'inventaire
        inventaire.ajouterRessource(ressource);

        // Vérification que la ressource a bien été ajoutée à l'inventaire
        assertFalse(inventaire.getRessources().isEmpty());
        assertTrue(inventaire.getRessources().contains(ressource));
    }
}

