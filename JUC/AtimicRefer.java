package JUC;


import java.util.concurrent.atomic.AtomicReference;

class User{
    String userName;
    int age;

    public User(String z3, int i) {
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUserName() {
        return userName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                '}';
    }
}
public class AtimicRefer {
    public static void main(String[] args) {
        User z3 = new User("z3",22);
        User l4 = new User("l4",25);

        AtomicReference<User> ar = new AtomicReference<>();
        ar.set(z3);
        System.out.println(ar.compareAndSet(z3, l4));
        System.out.println(ar.get().userName+" "+ar.get().age);


    }
}
