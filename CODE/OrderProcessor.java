import java.util.List;

public class OrderProcessor {
    private Database database;
    private EmailService emailService;
    private InventorySystem inventorySystem;

    // Constructeur avec injection de dépendances
    public OrderProcessor(Database database, EmailService emailService, InventorySystem inventorySystem) {
        this.database = database;
        this.emailService = emailService;
        this.inventorySystem = inventorySystem;
    }

    // Méthode principale pour traiter une commande
    public void processOrder(Order order) {
        checkInventory(order.getItems());  // Vérifier la disponibilité des articles
        saveOrder(order);  // Enregistrer la commande dans la base de données
        sendConfirmationEmail(order);  // Envoyer un email de confirmation
        updateInventory(order.getItems());  // Mettre à jour l'inventaire
        applyLoyalCustomerDiscount(order);  // Appliquer une remise si c'est un client est fidèle
    }

    // Vérifie si les articles de la commande sont disponibles en stock
    private void checkInventory(List<Item> items) {
        for (Item item : items) {
            if (!inventorySystem.isItemAvailable(item)) {
                throw new ItemNotAvailableException("Item not available in inventory");
            }
        }
    }

    // Enregistre la commande dans la base de données
    private void saveOrder(Order order) {
        database.saveOrder(order);
    }

    // Envoie un email de confirmation de commande au client
    private void sendConfirmationEmail(Order order) {
        String message = "Your order has been received and is being processed.";
        emailService.sendEmail(order.getCustomerEmail(), "Order Confirmation", message);
    }

    // Mettre à jour l'inventaire en soustrayant les quantités commandées
    private void updateInventory(List<Item> items) {
        for (Item item : items) {
            inventorySystem.updateInventory(item, item.getQuantity() * -1);
        }
    }

    // Applique une remise pour les clients fidèles
    private void applyLoyalCustomerDiscount(Order order) {
        if (order instanceof LoyalCustomerOrder) {
            LoyalCustomerOrder loyalCustomerOrder = (LoyalCustomerOrder) order;
            loyalCustomerOrder.applyDiscount();
        }
    }

    // Exception spécifique pour les articles non disponibles
    public static class ItemNotAvailableException extends RuntimeException {
        public ItemNotAvailableException(String message) {
            super(message);
        }
    }

    // Classe pour les commandes des clients fidèles
    public static class LoyalCustomerOrder extends Order {
        @Override
        public void applyDiscount() {
            // Appliquer une remise de 10%
            setTotalPrice(getTotalPrice() * 0.9);
        }
    }
}
