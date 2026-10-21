public class PersonTest {
    public static void main(String[] args) {
        Person person = new Person();

        person.setFirstName("Paulo Vinícius");
        person.setLastName("Castro Galvão");
        person.setAddress("松ヶ崎学生館");

        System.out.printf("Name: %s\n", person.getName());
        System.out.printf("Address: %s\n", person.getAddress());

        person.print();
    }
}