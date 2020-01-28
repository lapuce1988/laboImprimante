package be.ifosup;

public class Main {
    public static void main(String[] args) {
        Imprimante imprimante = new Imprimante();
        Imprimante imprimante1 = new Imprimante(true);
        imprimante.allumerEteint(true);
        imprimante1.allumerEteint(false);

        imprimante.imprime(20);
    }
}
