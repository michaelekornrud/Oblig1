package oblig1;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        ///////// Oppgave 8 ////////////////////////////

        int [] a = {5, 2, 8, 3, 5, 10, 7, 5, 2, 10, 6}; //{6,10,16,11,7,12,3,9,8,5};{1, 2, 3, 4, 5, 6};

        int [] index = Oblig1.indekssortering(a);

        for (int i = 0; i < a.length; i++){
            System.out.print(a[index[i]] + "\t");


        }
        /*for (int i  = 0; i <10; ++i){
            int numb = i;
            int b = myTernaryTest(numb);
            System.out.println(b);

        }*/


        char [] c = "ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ".toCharArray();

        //Oblig1.bokstavNr(Oblig1.inneholdt("A", "B"));


       /* System.out.print("Største verdi er : " + m + " på index : " + index);
        System.out.println(" Det er "+ Oblig1.antallUlikeUsortert(a) + " forskjellige verdier.");*/
    }

    public static int myTernaryTest (int value){
        return (value < 5 ) ? 0 : 98;
        //Her står det at hvis value er mindre enn 5, så skal den returnere 0, hvis ikke skal den returnere 98.
    }
}
