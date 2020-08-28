package oblig1;
import java.lang.UnsupportedOperationException;
import java.util.ArrayList;

public class Oblig1 {

////// Løsningsforslag Oblig 1 ////////////////////////

        private Oblig1() {}

        ///// Oppgave 1 //////////////////////////////////////
        public static int maksimum (int [] a, int venstre, int høyre){
            if (venstre < 0 || høyre > a.length || venstre >= høyre) {
                throw new UnsupportedOperationException("En av disse er nå feil");
            }

            int index = venstre;
            int maksverdi = a[index];



            for (int i = venstre; i <høyre; ++i) {
                if (a[i] > maksverdi) {
                    maksverdi = a[i];
                    index = i;
                }
                //System.out.print("\nStørste tallet er: " + maksverdi + " på index: " + index);
            }
            return index;

        }
        public static int maks(int[] a) {
            return maksimum(a, 0, a.length);

        }

        public static int ombyttinger(int[] a) {
            throw new UnsupportedOperationException();
        }

        ///// Oppgave 2 //////////////////////////////////////
        public static int antallUlikeSortert(int[] a) {
            throw new UnsupportedOperationException();
        }

        ///// Oppgave 3 //////////////////////////////////////
        public static int antallUlikeUsortert(int[] a) {
            int count = 0;

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
            return count;

        }

        ///// Oppgave 4 //////////////////////////////////////
        public static void delsortering(int[] a) {
            throw new UnsupportedOperationException();
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


