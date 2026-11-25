public class Student extends Person {
    private String school;
    private int grade;
    private String number;
 
    public void setSchool(String sname) { this.school = sname; }
    public String getSchool()           { return this.school; }
 
    public void setGrade(int gd)        { this.grade = gd; }
    public int getGrade()               { return this.grade; }
 
    public void setNumber(String no)    { this.number = no; }
    public String getNumber()           { return this.number; }
 
    @Override
    public void print()
    {
        super.print();
        System.out.println("School: " + this.school);
        System.out.println("Grade: " + this.grade);
        System.out.println("Student Number: " + this.number);
    }
 
    public static void main(String[] args) {
        Student student = new Student();
        {
            student.setFamilyName("Yamada");
            student.setFirstName("Taro");
            student.setAddress("Goshokaidocho, Matsugasaki, Sakyoku, Kyoto");
            student.setSchool("Kyoto Institute of Technology");
            student.setGrade(2);
            student.setNumber("0123456789");
        }
 
        System.out.println("-=-=: getters :=-=-");
        System.out.println("Name: " + student.getFirstName() + " " + student.getFamilyName());
        System.out.println("Address: " + student.getAddress());
        System.out.println("School: " + student.getSchool());
        System.out.println("Grade: " + student.getGrade());
        System.out.println("Student Number: " + student.getNumber());
 
        System.out.println("-=-=: print() :=-=-");
        student.print();
    }
}
