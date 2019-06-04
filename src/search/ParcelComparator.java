package search;

import parcels.Parcel;

public class ParcelComparator<T extends Comparable<T>> {

    /**
     * Generic comparator for parcel variables
     * @param v1: 1st parcel variable
     * @param v2: 2nd parcel variable
     * @return answer: Returns "greater" value
     */
    public T highValue(T v1, T v2){
        return v1.compareTo(v2) > 0 ? v1 : v2;
    }

    public T lowValue(T v1, T v2){
        return v1.compareTo(v2) <= 0 ? v1 : v2;
    }

}
