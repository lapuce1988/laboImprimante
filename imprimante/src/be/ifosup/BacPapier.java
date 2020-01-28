package be.ifosup;

public class BacPapier {
    private int nbFeuilles;

    //Constructeur
    public BacPapier(int nbFeuilles){
        this.nbFeuilles = nbFeuilles;
    }

    //Get Set
    public int getNbFeuilles(){
        return nbFeuilles;
    }

    public void setNbFeuilles(int nbFeuilles){
        this.nbFeuilles = nbFeuilles;
    }

    //Chargement papier
    public void chargerFeuille(int nbFeuilles){
        System.out.println("Charger " + nbFeuilles + " feuilles dans le bas d'impression");
        this.setNbFeuilles(nbFeuilles);
    }

}
