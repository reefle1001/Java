public class MySearch {
    public static int search(MyArray array, int value) {
        int left = 0;
        int right = array.length - 1;
        int comparisons = 0;

        while (left <= right && comparisons <= 10){
            int mid = left + (right -left)/2;

            //Κάνουμε σύγκριση της τιμής με το μέσο στοιχείο
            int cmp = array.compToValue(mid, value);
            comparisons++;

            if(cmp == 0){
                return  mid; //Βρέθηκε η τιμή, επιστρέφουμε τη θέση
            }
            else if (cmp<0) {
                left = mid + 1; // Η τιμή είναι στο δεξί μισό
            }
            else {
                right = mid - 1; // Η τιμή είναι στο αριστερό μισό
            }
        }
        return  -1; // Η τιμή δεν βρέθηκε ή υπέρβαση του ορίου συγκρίσεων
    }
}
