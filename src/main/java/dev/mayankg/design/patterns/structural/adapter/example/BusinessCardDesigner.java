package dev.mayankg.design.patterns.structural.adapter.example;

/**
 * Client code
 * It accepts Customer interface.
 */
class BusinessCardDesigner {
    public String designCard(Customer customer) {
        String card = "";
        card += customer.getName();
        card += "\n" + customer.getDesignation();
        card += "\n" + customer.getAddress();
        return card;
    }
}