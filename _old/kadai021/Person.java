class Person {
    private String lastName;
    private String firstName;
    private String address;

    // Rule of 3/5/0? Constructor?

    public void setLastName(String name) {
        this.lastName = name;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getAddress() {
        return this.address;
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public void print() {
        // Problem: class person has a view responsibility, when it should be a POD
        System.out.printf("Name: %s\n", getName());
        System.out.printf("Address: %s\n", getAddress());
    }
}