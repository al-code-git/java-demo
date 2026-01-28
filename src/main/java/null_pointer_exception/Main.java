package null_pointer_exception;

public class Main {
    public static void main(String[] args) {
        NullPointerExamples examples = new NullPointerExamples();
        System.out.println("=== NullPointerException demo ===");


        User withCity = User.withCity("João", "Fortaleza");
        User missingProfile = new User("Jerônimo", null);
        User missingAddress = new User("Joaquim", new Profile(null));
        User missingCity = new User("José ", new Profile(new Address(null)));
        User completeUser = new User("Ben", new Profile(new Address("Itapipoca")));
        User missingName = new User(null, new Profile(new Address("Itapipoca")));


//        System.out.println("If-statements based lookup");
//        System.out.println("If-statements based lookup [With City] -> " + examples.userCityUnsafe(withCity));
////        System.out.println("If-statements based lookup [Missing Profile] -> " + examples.userCityUnsafe(missingProfile));
//        System.out.println("If-statements based lookup [Missing Profile] -> " + examples.userCityIfStatements(missingProfile));


//        System.out.println("Optional-based lookup");
//        System.out.println("Optional-based lookup [Missing Profile] -> " + examples.userCityWithOptional(missingProfile));
//        System.out.println("Optional-based lookup [Missing Address] -> " + examples.userCityWithOptional(missingAddress));
//        System.out.println("Optional-based lookup [Missing City] -> " + examples.userCityWithOptional(missingCity));
//        System.out.println("Optional-based lookup [Complete User] -> " + examples.userCityWithOptional(completeUser));
        String USER_NAME = "Ben";
        System.out.println("Testing constants -> " + USER_NAME.equals(missingName.getName()));

    }

}
