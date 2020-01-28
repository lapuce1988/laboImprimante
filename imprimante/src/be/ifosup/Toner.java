package be.ifosup;

public class Toner {
    private int niveauToner=100;

    //Constructeur
    public Toner(int niveauToner) {
        this.niveauToner = niveauToner;
    }

    //Get Set
    public int getNiveauToner() {
        return niveauToner;
    }

    public void setNiveauToner(int niveauToner) {
        this.niveauToner = niveauToner;
    }

    @Override
    public String toString() {
        return "Toner{" +
                "niveauToner=" + niveauToner +
                '}';
    }

    //Remplacement du toner
    public void remplacerToner(){
        System.out.println("Nouveau toner insérré");
        this.setNiveauToner(100);
    }
}
