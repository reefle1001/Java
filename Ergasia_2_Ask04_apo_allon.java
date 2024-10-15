class MySort {
    public static int partition(MyArray array, int low, int high, int pivot) {

        array.swap(pivot ,high);
        int pivot_index=high;
        int i=(low-1);
        for (int j=low; j<high; j++)
        {
            if (array.comp(j , pivot_index ) <0 )
            {
                i++;
                array.swap(i,j);
            }
        }

        array.swap(i+1,high);
        return i+1;
    }

}