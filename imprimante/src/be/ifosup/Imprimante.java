package be.ifosup;

import static java.lang.StrictMath.ceil;

public class Imprimante {
    private boolean allumer;
    private boolean rectoVerso;
    private Toner toner;
    private BacPapier bacPapier;

    //Constructeur
    public Imprimante() {
    }

    public Imprimante(boolean allumer) {
        this.allumer = allumer;
        this.rectoVerso = false;
        this.toner = new Toner(100);
        this.bacPapier = new BacPapier(0);
    }

    public Imprimante(boolean allumer, boolean rectoVerso, Toner toner, BacPapier bacPapier){
        this.allumer = allumer;
        this.rectoVerso = rectoVerso;
        this.toner = toner;
        this.bacPapier = bacPapier;
    }

    //Etat de l'imprimante
    public boolean allumerEteint(boolean allumer){
        if(allumer){
            System.out.println("L'imprimante est allumée");
            return true;
        } else{
            System.out.println("L'imprimante est éteinte");
            return false;
        }
    }

    public void setRectoVerso(boolean rectoVerso){
        this.rectoVerso = rectoVerso;
    }

    private boolean assezDeToner (int nbPagesImp) {
        if (rectoVerso)
            return ((this.toner.getNiveauToner()-(nbPagesImp*2))>=0);
        return ((this.toner.getNiveauToner()-nbPagesImp)>=0);
    }
    //true=assez de papier pour imprimer
    private boolean verifnbPagesBac(int nbPagesImp) {
        if ((this.bacPapier.getNbFeuilles()-nbPagesImp)>=0)
            return true;
        return false;
    }

    public void nouveauToner() {
        this.toner.remplacerToner();
    }

    public void chargerFeuille(int nbrFeuilles) {
        if (nbrFeuilles>=0)
            this.bacPapier.chargerFeuille(nbrFeuilles);
        else
            System.out.println("le nombre entré n'est pas correct");
    }

    public void imprime (int nbpages) {
        int pagesAImprimer;
        if (rectoVerso) {
            pagesAImprimer = (int) ceil (nbpages/2); //ceil arrondi supérieur
        } else {
            pagesAImprimer=nbpages;
        }

        if (assezDeToner(pagesAImprimer)) {
            if (verifnbPagesBac(pagesAImprimer)) {
                this.bacPapier.setNbFeuilles(this.bacPapier.getNbFeuilles() - pagesAImprimer);
                // impression réussie
                if (rectoVerso)
                    System.out.println("vous avez imprimé " + pagesAImprimer + " page(s) Recto-Verso.\n toner restant : " + this.toner.getNiveauToner());
                else
                    System.out.println("vous avez imprimé " + pagesAImprimer + " page(s).\n toner restant : " + this.toner.getNiveauToner());
            }
            else {
                //pas assez de pages
                System.out.println("Il n'y a plus de papier, Veuillez charger du papier");
                System.out.print("vous avez imprimé " + pagesAImprimer + " page(s) ");
                if (rectoVerso)
                    System.out.println(" Recto-Verso");
            }
        } else {
            //pas assez de toner
            System.out.println("Le toner est vide, Veuillez le remplacer");
            System.out.print("vous avez imprimé " + pagesAImprimer + " page(s) ");
            if (rectoVerso)
                System.out.println(" Recto-Verso");
        }
    }
}
