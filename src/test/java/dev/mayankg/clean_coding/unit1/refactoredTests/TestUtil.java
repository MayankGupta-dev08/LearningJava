package dev.mayankg.clean_coding.unit1.refactoredTests;

import dev.mayankg.clean_coding.unit1.gildedrose.GildedRose;
import dev.mayankg.clean_coding.unit1.gildedrose.Item;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestUtil {
    static void assertItem(Item expected, Item actual) {
        assertEquals(expected.name, actual.name);
        assertEquals(expected.sellIn, actual.sellIn);
        assertEquals(expected.quality, actual.quality);
    }

    static GildedRose createGildedRoseWith1Item(String itemType, int sellIn, int quality) {
        Item item = new Item(itemType, sellIn, quality);
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);
        return app;
    }
}