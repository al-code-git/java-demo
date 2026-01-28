package null_pointer_exception;

public final class User {
    private final String name;
    private final Profile profile;

    public User(String name, Profile profile) {
        this.name = name;
        this.profile = profile;
    }

    public static User withCity(String name, String city) {
        return new User(name, new Profile(new Address(city)));
    }

    public String getName() {
        return name;
    }

    public Profile getProfile() {
        return profile;
    }
}
