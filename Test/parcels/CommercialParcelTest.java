package parcels;

import org.junit.Test;

import static org.junit.Assert.*;

public class CommercialParcelTest {

    // Each get method test also tests associated setter method

    CommercialParcel cp = new CommercialParcel();

    @Test
    public void getParcelID() {
        cp.setParcelID("101");
        assertEquals("101", cp.getParcelID());
    }

    @Test
    public void getAddress() {
        cp.setAddress("925 Commonwealth Avenue");
        assertEquals("925 Commonwealth Avenue", cp.getAddress());
    }

    @Test
    public void getType() {
        cp.setType("Commercial");
        assertEquals("Commercial", cp.getType());
    }

    @Test
    public void getPropertyValue() {
        cp.setPropertyValue("100000");
        assertEquals("100000", cp.getPropertyValue());
    }

    @Test
    public void getLandArea() {
        cp.setLandArea("1000");
        assertEquals("1000", cp.getLandArea());
    }
}