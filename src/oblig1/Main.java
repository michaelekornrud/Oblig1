package oblig1;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        ///////// Oppgave 8 ////////////////////////////
        /*
        int [] a = {5, 2, 8, 3, 5, 10, 7, 5, 2, 10, 6}; //{6,10,16,11,7,12,3,9,8,5};{1, 2, 3, 4, 5, 6};

        int [] index = Oblig1.indekssortering(a);

        for (int i = 0; i < a.length; i++){
            System.out.print(a[index[i]] + "\t");


        }*/


        //////// myTernaryTest ////////////////////////
        /*for (int i  = 0; i <10; ++i){
            int numb = i;
            int b = myTernaryTest(numb);
            System.out.println(b);

        }*/



        //////// Oppgave 10 //////////////////////////


        System.out.println(Oblig1.bokstavNr('A'));
        String a = "AHABAB";
        String b = "ABBA";

        char [] arr = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','Æ','Ø','Å'};
        int [] values = new int[arr.length];
        int temp = 0;
        for(int i = 0; i < arr.length; ++i){
            temp = arr[i];
            values[i] = temp;
        }
        //System.out.print("Values: " + Arrays.toString(values));
        if (Oblig1.inneholdt(a, b)){
            System.out.println("a er inneholdt i b!");

        }

    }

    public static int myTernaryTest (int value){
        return (value < 5 ) ? 0 : 98;
        //Her står det at hvis value er mindre enn 5, så skal den returnere 0, hvis ikke skal den returnere 98.
    }
}
