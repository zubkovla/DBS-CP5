package jpa.modelEntities;

public enum FacilityType {
    HOTEL("Hotel"),
    SPA("Spa"),
    GUEST_HOUSE("Guest house");

    private final String toString;

    private FacilityType(String toString) {
        this.toString = toString;
    }

    public String toString() {
        return toString;
    }
}
