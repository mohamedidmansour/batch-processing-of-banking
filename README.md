un batch de traitement des transactions bancaires avec les fonctionnalités suivantes :

1. **Objectif Principal** : Traiter un fichier de transactions bancaires quotidiennes et générer des rapports d'analyse
2. **Fonctionnalités Complexes** :
    - Traitement parallèle des transactions domestiques et internationales
    - Validation des données avec gestion des erreurs
    - Détection de fraudes
    - Conversion de devises pour les transactions internationales
    - Génération de rapports d'analyse
3. **Structure du Job** :
    - Step 1 : Validation des données
    - Steps 2 & 3 (en parallèle) :
        - Traitement des transactions domestiques
        - Traitement des transactions internationales
    - Step 4 : Génération des rapports
4. **Aspects Techniques à Implémenter** :
    - Parallel Processing avec Flow
    - Skip Logic pour les transactions frauduleuses
    - Custom Listeners pour le monitoring
    - Gestion des erreurs avec retry
    - Transactions database
    - Chunk processing
5. **Règles Métier à Implémenter** :
    - Validation du solde suffisant pour les débits
    - Détection des transactions suspectes (montant élevé, localisation inhabituelle)
    - Conversion des devises avec taux de change en temps réel
    - Calcul des frais de transaction
    - Génération de rapports d'analyse des risques
