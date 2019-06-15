package search;

import parcels.Parcel;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParcelFilter {

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
     * Filters Parcels in parcelMap to find Parcels with
     * propertyValue less than parameter upperPropertyValue and
     * greater than lowerPropertyValue
     * @param param: SearchParameters object
     * @param parcelMap: LinkedHashMap with PID,Parcel pairs
     * @return outputMap: LinkedHashMap with filtered output values
     */
    protected LinkedHashMap<String, Parcel> propertyValueFilter(SearchParameters param,
                                                                LinkedHashMap<String, Parcel> parcelMap){
        parcelList.addAll(parcelMap.values());

        Predicate<Parcel> highValue = p -> (p.getPropertyValue() < param.getUpperPropertyValue());
        Predicate<Parcel> lowValue = p -> (p.getPropertyValue() > param.getLowerPropertyValue());

        LinkedList<Parcel> intermediateList = parcelList.stream()
                .filter(highValue)
                .filter(lowValue)
                .collect(Collectors.toCollection(LinkedList::new));

        for (Parcel p : intermediateList){
            outputMap.put(p.getParcelID(), p);
        }

        return outputMap;
    }



}
