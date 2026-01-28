package null_pointer_exception;

import java.util.Optional;

public class NullPointerExamples {
    private static final String FALLBACK_CITY = "n/a";

    public int triggerNpeWithNullCall() {
        String value = null;
        return value.length();
    }

    public int safeLength(String value) {
        return value == null ? 0 : value.length();
    }

    public String userCityUnsafe(User user) {
        return user.getProfile().getAddress().getCity();
    }

    public String userCityIfStatements(User user) {
        if (user == null) {
            return FALLBACK_CITY;
        }
        Profile profile = user.getProfile();
        if (profile == null) {
            return FALLBACK_CITY;
        }
        Address address = profile.getAddress();
        if (address == null) {
            return FALLBACK_CITY;
        }
        String city = address.getCity();
        if (city == null) {
            return FALLBACK_CITY;
        }
        return city;
    }

    public String userCityWithOptional(User user) {
        return Optional.ofNullable(user)
                .map(User::getProfile)
                .map(Profile::getAddress)
                .map(Address::getCity)
                .orElse(FALLBACK_CITY);
    }
}
