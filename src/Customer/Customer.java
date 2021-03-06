package Customer;

public class Customer {
    private String name;
    private char gender;
    private int age;
    private String tel;
    private String email;

    public Customer() {

    }
    public Customer(String name, char gender,int age,String tel,String email)
    {
        this.name=name;
        this.age=age;
        this.tel=tel;
        this.email=email;
        this.gender=gender;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
