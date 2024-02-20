package dev.mayankg.design.patterns.structural.adapter.example;

/**
 * Target interface
 * required by new client code
 */
interface Customer {
    String getName();

    String getDesignation();

    String getAddress();
}