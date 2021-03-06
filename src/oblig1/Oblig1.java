package oblig1;
import java.lang.UnsupportedOperationException;
import java.util.*;
import java.util.stream.IntStream;

public class Oblig1 {

    // Johannes Eerdahl Andresen, s341876, s341876@oslomet.no
    //Aina Turum Wangsmo, s341826, s341826@oslomet.no
    //Ole-Michael Ekornrud, s341866, s341866@oslomet.no

////// Løsningsforslag Oblig 1 ////////////////////////

        private Oblig1() {}



     //metode for å forenkle byttene, hentet fra https://www.cs.hioa.no/~ulfu/appolonius/kap1/3/kap13.html#kode.1.3.9.a
        public static void bytt(int[] a, int i, int j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

        //hentet fra https://www.cs.hioa.no/~ulfu/appolonius/kap1/3/kap13.html#kode.1.3.9.a
        public static void fraTilKontroll(int tablengde, int fra, int til){
            if (fra < 0){
                throw new ArrayIndexOutOfBoundsException("fra("+fra+") er negativ");
            }
            if (til > tablengde){
                throw new ArrayIndexOutOfBoundsException( "til("+til+")tablengde "+ tablengde+")");
            }
            if (fra > til){
                throw new IllegalArgumentException("fra("+fra+")>til "+ til+") -illegalt intervall ");
            }
        }

        //hentet fra https://www.cs.hioa.no/~ulfu/appolonius/kap1/3/kap13.html#kode.1.3.9.a
        private static int parter0(int []a, int v, int h, int skilleverdi){
            while (true){ //Stopper når v > h
                while (v <= h && a[v] < skilleverdi) v++; //h er stoppverdi for v
                while (v<=h && a[h] >=skilleverdi)h--; //v er stoppverdi for h

                if (v < h) bytt(a, v++, h--);  //bytter om a[v] og a[h]
                else return v; //a[v] er nåden første som ikke er mindre enn skilleverdi
            }
        }

        //hentet fra https://www.cs.hioa.no/~ulfu/appolonius/kap1/3/kap13.html#kode.1.3.9.a
        public static int sParter0(int [] a, int v, int h, int index){
            bytt(a, index, h);  //Skilleverdi a[index] flyttes bakerst
            int pos = parter0(a, v, h-1, a[h]); //partisjonerer a[a:h-1]
            bytt(a, pos, h); //Bytter for å få skilleverdien på rett plass
            return pos; //returnerer posisjonen til skilleverdien
        }


        //hentet fra https://www.cs.hioa.no/~ulfu/appolonius/kap1/3/kap13.html#kode.1.3.9.a
   private static void kvikkSortering0(int [] a, int v, int h){
            if ( v>= h) return; //a[v:h] er tomt eller har max ett element
            int k = sParter0(a, v, h,(v+h)/2); //bruker midtverdien
            kvikkSortering0(a, v, k-1); //sorterer intervallet a[v:k-1]
            kvikkSortering0(a, k+1, h);//sorterer intervallet a[h:k+1]
    }

    //Hentet fra https://www.cs.hioa.no/~ulfu/appolonius/kap1/3/kap13.html#kode.1.3.9.a
    public static void kvikkSortering(int[]a, int fra, int til){  //a[frta:til]>
            fraTilKontroll(a.length, fra, til);  //Sjekker når metoden er offentlig
            kvikkSortering0(a, fra, til-1); //v = fra, h = til.1
    }

    //Hentet fra https://www.cs.hioa.no/~ulfu/appolonius/kap1/3/kap13.html#kode.1.3.9.a
    public static int gcd(int a, int b){ //Euklids algoritme  //Høyeste felles divisor
        return b ==0 ? a:gcd(b, a%b);
    }


    //Boblesortering er en sorteringsalgoritme som gjentatte ganger går gjennom listen,
    // sammenligner tilstørende elementer og bytter dem hvis de er i feil rekkefølge.
    // Loopen gjennom listen gjentas til listen er sortert
    public static void bobleSortering(int [] a){  //forelesning
        for (int n = a.length; n > 1; n--){
            for (int i = 1; i < n; i++){
                if (a[i-1] > a[i]){
                    bytt(a, i-1, i);
                }
            }
        }
    }


    ///// Oppgave 1 //////////////////////////////////////
    //permutasjoner og inversjoner - kompendiet
        public static int maks(int[] a) {

            if (a == null || a.length == 0 ) {
                throw new NoSuchElementException();
            }

            for (int i = 1; i < a.length; i++) {

                    if (a[i-1] > a[i]) {  //Sjekker om tallet til venstre er større enn tallet til høyre
                        int temp = a[i - 1];
                        a[i - 1] = a[i]; //bytter plass på verdiene
                        a[i] = temp; //oppdaterer tallet
                    }
                }
            return a[a.length - 1]; //Returnerer størtste tall/tall som er helt til høyre i arrayet
        }

       /* 1) Når blir det flest ombyttinger?
    - Det blir flest ombyttinger når den største verdien er på indeks '0' (helt til venstre i arrayet)
          2)Når blir det færrest ombyttinger?
    - Det blir færrest ombyttinger når tallene allerede står i sortert stigende rekkefølge.
          3) Hvor mange blir det i gjennomsnitt?
    - Det blir ca antall tall / 2 (n/2) ombyttinger i gjennomsnitt */

    public static int ombyttinger(int[] a) {
            if (a == null) {
                throw new NoSuchElementException();
            }

            int antallOmbyttinger = 0;  //Hjelpeverdi

            for (int i = 1; i < a.length; i++) { //looper gjennom arrayet
                if (a[i - 1] > a[i]) {  //Sjekker om tallet til venstre er større enn tallet til høyre i arrayet

                    //stokker om tallene, Kan også bruke bytt-metoden som er laget lengre opp i filen. Endre på dette senere
                    int temp = a[i - 1];
                    a[i - 1] = a[i];
                    a[i] = temp;
                    antallOmbyttinger++;   //Øker ombyttinger med 1 gang pr loop (hvis det er ombyttinger)
                }
            }
            return antallOmbyttinger;
        }


        ///// Oppgave 2 //////////////////////////////////////
        public static int antallUlikeSortert(int[] a) {
            int array_length = a.length;

            if (array_length == 0) {
                return 0;
            }
            int antallUlike = 1;

            for (int i = 0; i < array_length- 1; i++) {
                if (a[i] > a[i+1]) { //Sjekker om tallet til venstre er større enn tallet til høyre i arrayet
                    throw new IllegalStateException("Feil rekkefølge i array");  //kaster avvik
                }
                else if (a[i+1] != a[i]){  //Sjekker om tallet til høre ikke er ulik tallet til venstre
                    antallUlike++;
                }
            }

            return antallUlike; //Returnerer antall ulike verdier i et sortert array
        }



        ///// Oppgave 3 //////////////////////////////////////
        public static int antallUlikeUsortert(int[] a) {

        // hjelpevariabel for å telle antall variabler
            int count;

            // Initialiserer en arraylist for å legge elementet inn der, for å lettere skille de ut
            ArrayList<Integer> diffNum = new ArrayList<>();

            // Går gjennom heltallstabellen og sjekker om elementet ligger i arraylisten diffNum, hvis ikke,
            // legger vi den til
            for (int j : a) {
                if (!diffNum.contains(j)) {
                    diffNum.add(j);
                }
            }
            if(diffNum.size() == 1) {
                count = 1;
            }
            else {
                count = diffNum.size();
            }
            return count; // returnerer her hvor mange av elementene fra a som er lagt inn i diffNum

        }

        ///// Oppgave 4 //////////////////////////////////////
        public static void delsortering(int[] a) {
            //throw new UnsupportedOperationException();
           int array_length = a.length;
            int left = 0;  //Starter på venstre side med verdu 0
            int right = array_length-1;  //Starter på høyre side med verdi (array sin lenge -1)

            if (array_length == 0){ return;}

            while (left <= right){
                if (((a[left] % 2) == 0) && !(((a[right] %2)==0))){ //Sjekk av partall og oddetall
                   bytt(a, left++, right--); //Bruker metoden bytt for å sortere verdiene i arrayet
                }
                else if ((a[left] %2 )==0){ //Sjekker om tallene på venstre er partall/oddetall
                    right--;
                }
                else {  //Sjekker om tallene på høyre er partall/oddetall
                    left++;
                }
            }
            kvikkSortering(a, 0, left);
            kvikkSortering(a, left, array_length);
        }

    ///// Oppgave 5 //////////////////////////////////////
        public static void rotasjon(char[] a) {

            int arr_length = a.length;

            if (arr_length == 0){
                return;
            }

            char last = a[arr_length-1];
            System.arraycopy(a, 0, a, 1, arr_length - 2 + 1);
            a[0] = last;
        }

        ///// Oppgave 6 //////////////////////////////////////
    //https://www.techiedelight.com/right-rotate-an-array-k-times/ - Kilde til flere metoder som gjør det samme
        public static void rotasjon(char[] a, int k) {

         int array_length = a.length;
          if (array_length <2) { return;}

          if ((k %= array_length) <0 ) {
              k += array_length;
          }

          int largest_common_divisor = gcd(array_length, k);  //Største felles divisor

            for (int d = 0; d < largest_common_divisor; d++) { //Antall loops
                char value = a[d];

                for (int i = d-k, j = d; i!=d; i -= k){
                    if (i < 0) i+=array_length;
                    a[j] = a[i]; //Sjekker fortegnert til i
                    j=i; //oppdaterter j
                }
                a[d+k] = value;  //legger tilbake verdiene
            }
        }


        ///// Oppgave 7 //////////////////////////////////////
        /// 7a)
        public static String flett(String s, String t) {

            // For å lage den "nye" stringen
            StringBuilder flettet = new StringBuilder();

            // Går gjennom alle indeksene i stringene
            for (int i = 0; i < s.length() || i < t.length(); i++) {

                // Finner elementet for hver indeks hvis det eksisterer
                if (i < s.length())
                    flettet.append(s.charAt(i));

                // Gjør det samme for den andre stringen
                if (i < t.length())
                    flettet.append(t.charAt(i));
            }
            return flettet.toString();

        }

        /// 7b)
        public static String flett(String... s) {

        //Loop over alle strenger, fjern første bokstav dersom strenglengde > 0
        //Teller for hvert eneste ord som sier hvor langt man har kommet
        //En bostav for hver ord, så lenge lengden forstatt er der


            //initialiserer hjelpevariabler
           StringBuilder inputStringsCombined = new StringBuilder();
           int index = 0;
           int array_length = s.length;

            //looper igjennom strigene og oppdaterer indexen
           for (String t : s){
               index += t.length();
           }

            //Initialiserer ny hjelpeveri ved å lage et nytt array a som er lik lengden til s.length
           int [] a = new int[array_length];

           //Looper igjennom den oppdaterte indeksen og oppdaterer inpusStringsCombined
           for (int i = 0; i < index; i++){
               for (int j = 0; j < array_length; j++){
                   if (a[j] < s[j].length()){
                       inputStringsCombined.append(s[j].toCharArray()[a[j]]);
                       a[j] ++;
                   }
               }
           }
           //Returnerer den nye stringen som er kombinert med først til n-te bokstav i hver inputstirng
           return inputStringsCombined.toString();
        }


        ///// Oppgave 8 //////////////////////////////////////
        public static int[] indekssortering(int[] a) {

            int[] b = IntStream.range(0, a.length).toArray();

            for (int i = a.length; i > 1; --i) {
                for (int j = 1; j < i; ++j) {
                    if (a[b[j - 1]] > a[b[j]]) bytt(b, j - 1, j);
                }
            }
            return b;
        }


        ///// Oppgave 9 //////////////////////////////////////
        public static int[] tredjeMin(int[] a) {
      //lager en hjelpevariabel a.length, og kaster et avvik hvis lengden til input-arrayet er mindre enn 3
            int array_length = a.length;
            if (array_length < 3){
                throw new NoSuchElementException("Arrayet sin lengde er mindre enn 3! Dette går ikke");
            }

           if (array_length <= 3){ //input-arrayet må ha en lengde på minimum 3
               //Her skal programmet finne indekxen til det tredj minste tallet i input-arrayet
               int [] indexToNumber1 = new int[3];
               int [] temporaryNumber1 = new int[array_length];

               System.arraycopy(a, 0, temporaryNumber1, 0, array_length); //Enklere kode enn  for (int i = 0; i < array_length; i++){
                                                                                            //temporaryNumber1[i] = a[i];
               bobleSortering(temporaryNumber1);

               //Looper igjennom arrayet og oppdaterer indeksen til laveste tall
               for (int i = 0; i < 3; i++){
                   for (int j = 0; j < array_length; j++){
                       if (temporaryNumber1[i] == a[j]){
                           indexToNumber1[i] = j;
                       }
                   }
               }
               return indexToNumber1;
           }
           else if (array_length <= 6){
               int [] indexToNumber2 = new int[6];
               int [] temporaryNumber2 = new int[6]; //Kan også bruke a.lenght

               System.arraycopy(a, 0, temporaryNumber2, 0, 6); //Enklere kode enn   for (int i = 0; i < 6; i++){
                                                                                    //temporaryNumber2[i] = a[i];
               bobleSortering(temporaryNumber2); //fra forelesning


               //Looper igjennom arrayet og oppdaterer indeksen til nest laveste tall
               for (int i = 0; i < 6; i++){
                   for (int j = 0; j < array_length; j++){
                       if (temporaryNumber2[i] == a[j]){
                           indexToNumber2[i] = j;
                       }
                   }
               }
               return indexToNumber2;
           }

           else {
               int [] indexToNumber3 = new int[10];
               int [] temporaryNumber3 = new int[10];

               System.arraycopy(a, 0, temporaryNumber3, 0, 10);
               bobleSortering(temporaryNumber3); //fra forelesning

               //Looper igjennom arrayet og oppdaterer indeksen til tredj laveste tall
               for (int i = 0; i < 10; i++){
                   for (int j = 0; j < array_length; j++){
                       if (temporaryNumber3[i] == a[j]){
                           indexToNumber3[i] = j;
                       }
                   }
               }
               return indexToNumber3;
           }
        }

    ///// Oppgave 10 //////////////////////////////////////
    public static int bokstavNr(char bokstav) {
        throw new UnsupportedOperationException();
    }

    public static boolean inneholdt(String a, String b) {
        int [] bokstavA = new int[256];
        int [] bokstavB = new int[256];


        //Gjør om heltallstabellene til char
        char [] A = a.toCharArray();
        char [] B = b.toCharArray();


        //Øker verdien for hver loop
        for (char c : A) {
            bokstavA[c]++;
        }

        for (char c : B) {
            bokstavB[c]++;
        }


        //Sjekker om de inneholder samme
        for (int i = 0; i < 256; ++i) {
            if(bokstavB[i] < bokstavA[i]) {
                return false;
            }
        }
        return true;
    }




}  // Oblig1


