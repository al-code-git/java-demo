package null_pointer_exception;

public final class Profile {
    private final Address address;

    public Profile(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
}
