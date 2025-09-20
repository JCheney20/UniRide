
package com.uniride.model;

import java.util.List;

public class Administrator extends User {
    private String adminId;
    private List<String> permissions;

    public void banDriver() {}
    public void updateSystemConfig() {}
    public void provideTechSupport() {}
    public void trackDriver() {}
    public void viewDriverDetails() {}

    // Getters and Setters

    public String getAdminId() {
        return adminId;
    }

    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    @Override
    public void register() {

    }

    @Override
    public void login() {

    }

    @Override
    public void updateProfile() {

    }

    @Override
    public void verifyAccount() {

    }

    @Override
    public void setPreferences() {

    }
}
