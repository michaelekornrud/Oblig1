package oblig1;
import java.lang.UnsupportedOperationException;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Oblig1 {

////// Løsningsforslag Oblig 1 ////////////////////////

        private Oblig1() {}

        ///// Oppgave 1 //////////////////////////////////////

    public static class Bytt {  //Klasse for å forenkle byttene
        public void bytt(int[] a, int i, int j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

        public static int maks(int[] a) {
            if (a == null || a.length == 0 ) {
                throw new NoSuchElementException();
            }

            for (int i = 1; i < a.length; i++) {

                    if (a[i-1] > a[i]) {  //Sjekker om tallet til venstre er større enn tallet til høyre
                        int temp = a[i - 1];  //bytter plass på verdiene
                        a[i - 1] = a[i];
                        a[i] = temp; //oppdaterer tallet
                    }
                }
            return a[a.length - 1]; //Returnerer størtste tall/tall som er helt til høyre i arrayet
        }

        public static int ombyttinger(int[] a) {
            if (a == null) {
                throw new NoSuchElementException();
            }

            int antallOmbyttinger = 0;  //initialiserer antallOmbytter som skal telles opp


            for (int i = 1; i < a.length; i++) { //looper gjennom arrayet
                if (a[i - 1] > a[i]) {  //Sjekker om tallet til venstre er større enn tallet til høyre i arrayet

                    //stokker om tallene, Kan også bruke bytt-metoden som er laget lengre opp i filen. Endre på dette senere
                    int temp = a[i - 1];
                    a[i - 1] = a[i];
                    a[i] = temp;
                    antallOmbyttinger++;
                }
            }
            return antallOmbyttinger;
        }

        ///// Oppgave 2 //////////////////////////////////////
        public static int antallUlikeSortert(int[] a) {
            int antallUlike = 1;

            if (a.length == 0) {
                return 0;
            }

            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i+1]) { //Sjekker om tallet til venstre er større enn tallet til høyre i arrayet
                    throw new IllegalStateException("Feil rekkefølge i array");
                }
                else if (a[i+1] != a[i]){  //Sjekker om tallet til høre ikke er ulik tallet til venstre
                    antallUlike++;
                }
            }

            return antallUlike;
        }



        ///// Oppgave 3 //////////////////////////////////////
        public static int antallUlikeUsortert(int[] a) {
            /*int count = 0;

            ArrayList<Integer> diffNum = new ArrayList<>();

            for(int i = 0; i < a.length; i++) {
                if(!diffNum.contains(a[i])) {
                    diffNum.add(a[i]);
                }
            }
            if(diffNum.size() == 1) {
                count = 0;
            }
            else {
                count = diffNum.size();
            }
            return count;*/

            int count = 0; //initialiserer en hjelpevariabel som skal telle antall ulike tall i array

            for (int i = 0; i < a.length; i++){  //Looper gjennom arrayet
                boolean uLik = false;
                for (int j = 0; j < i; j++){  //Looper gjennom a[i] og a[j]
                    if (a [i] == a[j]){   //Sjekker om tallene er like
                        uLik = true;
                        break; //Hopper ut av interasjon og tester videre om det er flere tall som er like
                    }
                }
                if (!uLik){  //Test som teller opp hvor mange ulike som er false.
                    count++; //Teller opp
                }
            }

return count;  //returnerer antall ulike

        }

        ///// Oppgave 4 //////////////////////////////////////
        public static void delsortering(int[] a) {
            //throw new UnsupportedOperationException();
            int n = a.length;
            int left = 0;
            int right = n-1;

            if (n == 0){ return;}

            while (left <= right){
                if (((a[left] % 2) == 0) && !(((a[right] %2)==0))){
                   // bytt(a, left++, right--); //lage en metode bytt

                }
            }


        }

        ///// Oppgave 5 //////////////////////////////////////
        public static void rotasjon(char[] a) {
            throw new UnsupportedOperationException();
        }

        ///// Oppgave 6 //////////////////////////////////////
        public static void rotasjon(char[] a, int k) {
            throw new UnsupportedOperationException();
        }

        ///// Oppgave 7 //////////////////////////////////////
        /// 7a)
        public static String flett(String s, String t) {
            throw new UnsupportedOperationException();
        }

        /// 7b)
        public static String flett(String... s) {
            throw new UnsupportedOperationException();
        }

        ///// Oppgave 8 //////////////////////////////////////
        public static int[] indekssortering(int[] a) {
            throw new UnsupportedOperationException();
        }

        ///// Oppgave 9 //////////////////////////////////////
        public static int[] tredjeMin(int[] a) {
            if (a.length <0){
                throw new UnsupportedOperationException();
            }
            int index = a.length;
            int min = 0;
            int secondSmallest = 0;
            int thirdSmallest = 0;
            for(int i=1;i<index;i++){
                if(a[i] < a[min]){
                    min = i;
                }else if(a[i] < a[secondSmallest]){
                    secondSmallest = i;
                }else if(a[i]< a[thirdSmallest]){
                    thirdSmallest = i;
                }
            }

            return new int[]{a[thirdSmallest]};
        }

        ///// Oppgave 10 //////////////////////////////////////
        public static int bokstavNr(char bokstav) {
            throw new UnsupportedOperationException();
        }

        public static boolean inneholdt(String a, String b) {
            throw new UnsupportedOperationException();
        }

}  // Oblig1


