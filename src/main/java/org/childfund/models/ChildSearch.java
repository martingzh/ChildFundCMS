package org.childfund.models;

public class ChildSearch {
    private final String id;
    private final String firstName;
    private final String otherName;

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getOtherName() {
        return otherName;
    }

    public ChildSearch(String id, String firstName, String otherName) {
        this.id = id;
        this.firstName = firstName;
        this.otherName = otherName;
    }
}
