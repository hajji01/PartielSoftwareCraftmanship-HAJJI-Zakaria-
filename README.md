# Projet de Gestion des Commandes


## Qu'est-ce que du code propre ?

Le code propre est un code qui est facile à lire, à comprendre et à modifier. Voici quelques caractéristiques du code propre :

1. **Lisibilité** : Le code doit être écrit de manière claire et compréhensible.

2. **Simplicité** : Le code doit être aussi simple que possible. Évitez les complexités inutiles. Chaque fonction ou méthode doit faire une seule chose et le faire bien.

3. **Organisation** : Le code doit être bien structuré et organisé. Utilisez des conventions de nommage cohérentes, indentez correctement et séparez les différentes parties du code de manière logique.

4. **Commentaire** : Les commentaires doivent être utilisés pour expliquer pourquoi quelque chose est fait, pas comment. 

5. **Testabilité** : Le code propre est facile à tester. 

6. **Évolutivité** : Le code propre est conçu pour être facilement modifiable . 

En résumé, le code propre rend la collaboration avec d'autres développeurs plus facile et rend le logiciel plus fiable et maintenable.

## Améliorations basées sur les piliers du manifeste Agile

### Valeurs du manifeste Agile

1. **Les individus et leurs interactions plutôt que les processus et les outils**
   - Encourager plus de communication directe et de collaboration entre les membres de l'équipe.

2. **Un logiciel qui fonctionne plutôt qu'une documentation exhaustive**
   - Se concentrer sur la livraison de logiciels fonctionnels à chaque changement.

3. **La collaboration avec le client plutôt que la négociation contractuelle**
   - Impliquer davantage nos clients dans le processus de développement.

4. **L'adaptation au changement**


### Exemple d'Amélioration

**Collaboration avec les clients** : En impliquant les clients régulièrement, nous pouvons mieux comprendre leurs besoins et nous adapter rapidement à leurs demandes. Cela nous permet de livrer un produit qui répond vraiment à leurs et nos attentes.


## Partie 4 : Correction du Code de Gestion des Achats

Le code original avait plusieurs problèmes :

1. La classe `OrderProcessor` faisait trop de choses à la fois.
2. Les dépendances étaient créées à l'intérieur du constructeur, ce qui rendait les tests unitaires difficiles.
3. Utilisation de `RuntimeException` pour signaler une indisponibilité d'articles, ce qui n'est pas précis.

Pour refactoriser le code, j'ai :

- Divisé les responsabilités dans des méthodes séparées (`checkInventory`, `saveOrder`, `sendConfirmationEmail`, `updateInventory`, `applyLoyalCustomerDiscount`).
- Utilisé l'injection de dépendances pour `Database`, `EmailService`, et `InventorySystem`, ce qui rend le code plus facile à tester.
- Créé une exception spécifique `ItemNotAvailableException` pour signaler une indisponibilité d'article.

J'ai ajouté les fonctionnalités suivantes :

- Vérification de la disponibilité des articles.
- Enregistrement de la commande.
- Envoi d'un email de confirmation.
- Mise à jour de l'inventaire.
- Application d'une remise pour les clients fidèles.

J'ai créé un fichier `OrderProcessor.java` qui contient le code refactorisé et correct.
