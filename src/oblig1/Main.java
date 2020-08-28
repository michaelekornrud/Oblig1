package oblig1;

public class Main {

    public static void main(String[] args) {
        System.out.print("Hello World! ");

        int [] a = {1,2,7,4,5,6};


        int index = Oblig1.maks(a);
        int m = a[index];
        System.out.print("Største verdi er : " + m + " på index : " + index);
        System.out.println(" Det er "+ Oblig1.antallUlikeUsortert(a) + " forskjellige verdier.");
    }
}
