package search;

import org.junit.Test;

import static org.junit.Assert.*;

public class SearchParametersTest {

    private SearchParameters sp = new SearchParameters();

    // Each get method test also tests associated setter method

    @Test
    public void getLandUseType() {
        sp.setLandUseType("Residential");
        assertEquals("Residential", sp.getLandUseType());
    }

    @Test
    public void getParcelID() {
        sp.setParcelID("101");
        assertEquals("101", sp.getParcelID());
    }

    @Test
    public void getAddress() {
        sp.setAddress("925 Commonwealth Avenue");
        assertEquals("925 Commonwealth Avenue", sp.getAddress());
    }
}