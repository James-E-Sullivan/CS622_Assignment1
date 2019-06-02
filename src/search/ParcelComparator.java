package search;

import parcels.Parcel;

public class ParcelComparator {

    /**
     * Generic comparator for parcel variables
     * @param v1: 1st parcel variable
     * @param v2: 2nd parcel variable
     * @param <T>: Generic variable type
     * @return answer: Returns "greater" value
     */
    public <T extends Comparable<T>> T compareParcel(T v1, T v2){

        T answer = v1.compareTo(v2) > 0 ? v1 : v2;
        return answer;

    }


}
