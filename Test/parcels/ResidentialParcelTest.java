package parcels;

import org.junit.Test;

import static org.junit.Assert.*;

public class ResidentialParcelTest {

    ResidentialParcel rp = new ResidentialParcel();

    // Each get method test also tests associated setter method

    @Test
    public void getParcelID() {
        rp.setParcelID("101");
        assertEquals("101", rp.getParcelID());
    }

    @Test
    public void getAddress() {
        rp.setAddress("925 Commonwealth Avenue");
        assertEquals("925 Commonwealth Avenue", rp.getAddress());
    }

    @Test
    public void getType() {
        rp.setType("Residential");
        assertEquals("Residential", rp.getType());
    }

    @Test
    public void getPropertyValue() {
        rp.setPropertyValue("100000");
        assertEquals("100000", rp.getPropertyValue());
    }

    @Test
    public void getLandArea() {
        rp.setLandArea("1000");
        assertEquals("1000", rp.getLandArea());
    }

    @Test
    public void getLivingArea() {
        rp.setLivingArea("1000");
        assertEquals("1000", rp.getLivingArea());
    }

    @Test
    public void getBedrooms() {
        rp.setBedrooms("3");
        assertEquals("3", rp.getBedrooms());
    }
}