public class Person {
    private String familyName;
    private String firstName;
    private String address;
 
    public void setFamilyName(String fname)
    {
        this.familyName = fname;
    }
    public String getFamilyName()
    {
        return this.familyName;
    }
 
    public void setFirstName(String name)   
    { 
        this.firstName = name; 
    }
    public String getFirstName()            
    { 
        return this.firstName; 
    }
 
    public void setAddress(String addr)     
    { 
        this.address = addr; 
    }
    public String getAddress()              
    { 
        return this.address; 
    }
 
    public void print() 
    {
        System.out.println("Name: " + this.firstName + " " + this.familyName);
        System.out.println("Address: " + this.address);
    }
}