package main;

public class Main {
    public static void main(String[] args) {
        User myUser = new User();
        myUser.setName("홍길동");
        System.out.println(myUser);
        User user1 = new User(1,"임꺽정");
        User user2 = User.builder().idx(1).name("임꺽정").build();
    }
}
