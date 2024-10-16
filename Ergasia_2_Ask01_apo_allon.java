public class MySearch {

    public static int search(MyArray array, int value) {

        // array.comp(i,  j): compares two items of the array
        // array.compToValue(i, value): compares an item of the array with a given value.
        // returns:
        // 1, if array[i] > array[j]
        // 0, if array[i] == array[j]
        // -1, if array[i] < array[j]

        // array.getNumberOfComparisons();

        // array.get(i);
        // returns the contents of position i
        //
        // The number of get operations:
        // array.getNumberOfReads();

        int length = array.length;

        int lo = 0, hi = ( length-1);

        int low = array.get(lo);
        int high = array.get(hi);


        if(low<= value && high>= value) {
            while (lo<= hi)
            {
                low = array.get(lo);
                high = array.get(hi);
                if (lo == hi)
                {
                    if (low == value)return lo;
                    return -1;
                }
                int pos = lo + (((hi-lo)*(value-low))/(high-low));
                int c=array.compToValue(pos,value);
                if (c== 0)
                    return pos;
                if (c== -1)
                    lo=pos+1;
                else
                    hi=pos-1;

            }
        }




        // complete the code

        return -1; // -1 means that the value has not been found

    }
}