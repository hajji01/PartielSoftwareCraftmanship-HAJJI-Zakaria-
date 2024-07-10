public class Ressource {
    private TypeRessource type;

    public enum TypeRessource {
        NOURRITURE,
        EAU,
        ARME
    }

    public Ressource(TypeRessource type) {
        this.type = type;
    }

    public TypeRessource getType() {
        return type;
    }

    public void setType(TypeRessource type) {
        this.type = type;
    }
}
