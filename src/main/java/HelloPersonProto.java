public class HelloPersonProto {
    public static void main(String[] args) {
        PersonOuterClass.Person person = PersonOuterClass.Person.newBuilder()
                .setName("Mohit")
                .setAge(100)
                .build();
        System.out.println(person.toString());
    }
}
