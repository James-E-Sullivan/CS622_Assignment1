package mail_packages;

public class MailPackage {

    // Class variables
    protected String shipper;
    protected String origination;
    protected String address;
    protected Double weight;
    
    // default constructor
    public MailPackage(){}

    public void display(){
        System.out.println("\nShipper: " + shipper +
                "\nOrigination: " + origination +
                "\nAddress: " + address +
                "\nWeight: " + weight);
    }

    // setter methods
    public void setShipper(String ship){shipper = ship;}
    public void setOrigination(String orig){origination = orig;}
    public void setAddress(String add){address = add;}
    public void setWeight(Double w){weight = w;}

    // accessor methods
    public String getShipper(){return shipper;}
    public String getOrigination(){return origination;}
    public String getAddress(){return address;}
    public Double getWeight(){return weight;}
}
