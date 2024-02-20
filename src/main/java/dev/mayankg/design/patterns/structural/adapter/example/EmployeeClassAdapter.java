package dev.mayankg.design.patterns.structural.adapter.example;

/**
 * A class adapter works as a Two-way adapter
 * Using inheritance to translate interface
 */
class EmployeeClassAdapter extends Employee implements Customer {
    @Override
    public String getName() {
        return this.getFullName();
    }

    @Override
    public String getDesignation() {
        return this.getJobTitle();
    }

    @Override
    public String getAddress() {
        return this.getOfficeLocation();
    }
}