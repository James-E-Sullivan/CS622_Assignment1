package search;

import parcels.Parcel;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class ParcelSorter {

    private LinkedList<Parcel> parcelList = new LinkedList<>();
    private LinkedHashMap<String, Parcel> outputMap = new LinkedHashMap<>();

    /**
     * Filters parcels in parcelMap to find Parcels with PID, address,
     * and/or propertyValue that matches parameter values.
     * @param param: SearchParameter object
     * @param parcelMap: LinkedHashMap with PID,Parcel pairs
     * @return outputMap: LinkedHashMap with filtered output values
     */
    protected LinkedHashMap<String, Parcel> parameterFilter(SearchParameters param,
                                                            LinkedHashMap<String, Parcel> parcelMap){

        // extract Parcels from parcelMap, add to parcelList
        parcelList.addAll(parcelMap.values());

        Predicate<Parcel> matchingPID = p -> (p.getParcelID().equals(param.getParcelID()));

        Predicate<Parcel> matchingAddress = p -> (p.getAddress()
                .toLowerCase().contains(param.getAddress().toLowerCase()));

        Predicate<Parcel> matchingPropertyValue = p -> (p.getPropertyValue() > param.getLowerPropertyValue() &&
                        p.getPropertyValue() < param.getUpperPropertyValue());

        parcelList.stream()
                .filter(matchingPID)
                .filter(matchingAddress)
                .filter(matchingPropertyValue)
                .sorted(Comparator.comparing(Parcel::getAddress))
                .forEach(p -> outputMap.put(p.getParcelID(), p));
        return outputMap;
    }

    /**
     * Filters Parcels in parcelMap to find Parcels with PID that matches
     * parameter PID value
     * @param param: SearchParameter object
     * @param parcelMap: LinkedHashMap with PID,Parcel pairs
     * @return outputMap: LinkedHashMap with filtered output values
     */
    protected LinkedHashMap<String, Parcel> parcelIDFilter(SearchParameters param,
                                                           LinkedHashMap<String, Parcel> parcelMap){
        parcelList.addAll(parcelMap.values());
        Predicate<Parcel> matchingPID = p -> (p.getParcelID().equals(param.getParcelID()));
        parcelList.stream()
                .filter(matchingPID)
                .forEach(p -> outputMap.put(p.getParcelID(), p));
        return outputMap;
    }

    /**
     * Sorts input parcelMap Parcels by address
     * @param parcelMap: LinkedHashMap with PID,Parcel pairs
     * @return outputMap: LinkedHashMap with sorted output values
     */
    protected LinkedHashMap<String, Parcel> sortAddress(LinkedHashMap<String, Parcel> parcelMap){
        parcelList.addAll(parcelMap.values());
        parcelList.stream()
                .sorted(Comparator.comparing(Parcel::getAddress))
                .forEach(p -> outputMap.put(p.getParcelID(), p));
        return outputMap;
    }

    /**
     * Sorts input parcelMap Parcels by propertyValue
     * @param parcelMap: LinkedHashMap with PID,Parcel pairs
     * @return outputMap: LinkedHashMap with sorted output values
     */
    protected LinkedHashMap<String, Parcel> sortPropertyValue(LinkedHashMap<String, Parcel> parcelMap){
        parcelList.addAll(parcelMap.values());
        parcelList.stream()
                .sorted(Comparator.comparing(Parcel::getPropertyValue))
                .forEach(p -> outputMap.put(p.getParcelID(), p));
        return outputMap;
    }

    /**
     * Sorts input parcelMap Parcels by landArea
     * @param parcelMap: LinkedHashMap with PID,Parcel pairs
     * @return outputMap: LinkedHashMap with sorted output values
     */
    protected LinkedHashMap<String, Parcel> sortLandArea(LinkedHashMap<String, Parcel> parcelMap){
        parcelList.addAll(parcelMap.values());
        parcelList.stream()
                .sorted(Comparator.comparing(Parcel::getLandArea))
                .forEach(p -> outputMap.put(p.getParcelID(), p));
        return outputMap;
    }


}
