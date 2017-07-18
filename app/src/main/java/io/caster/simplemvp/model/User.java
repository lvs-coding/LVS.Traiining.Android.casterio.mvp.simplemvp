package io.caster.simplemvp.model;

import hugo.weaving.DebugLog;

public class User {
    private int id;
    private String firstName;
    private String lastName;


    @DebugLog
    public int getId() {
        return id;
    }

    @DebugLog
    public void setId(int id) {
        this.id = id;
    }

    @DebugLog
    public String getFirstName() {
        return firstName;
    }

    @DebugLog
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @DebugLog
    public String getLastName() {
        return lastName;
    }

    @DebugLog
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
