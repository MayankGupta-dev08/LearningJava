package dev.mayankg.clean_coding.unit1.refactoredTests;

import dev.mayankg.clean_coding.unit1.gildedrose.GildedRose;
import dev.mayankg.clean_coding.unit1.gildedrose.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GildedRoseADefaultItemRefactoredTest {
    private static final String DEFAULT_ITEM = "DEFAULT_ITEM";
    private static final int UNEXPIRED_SELL_IN = 15;
    private static final int DEF_QUALITY = 3;
    private static final int EXPIRED_SELL_IN = -1;

    @Test
    @DisplayName("Method to test the variation in quality of an unexpired item")
    public void testQualityDecrementBy1ForUnexpiredDefaultItem() {
        //setup
        GildedRose app = createGildedRoseWith1Item(DEFAULT_ITEM, UNEXPIRED_SELL_IN, DEF_QUALITY);

        //update method invocation
        app.updateQuality();

        //verification
        Item actual = app.items[0];
        Item expected = new Item(DEFAULT_ITEM, UNEXPIRED_SELL_IN - 1, DEF_QUALITY - 1);
        assertItem(expected, actual);
    }

    @Test
    @DisplayName("Method to test the variation in quality of an expired item")
    public void testQualityDecrementBy2ForExpiredDefaultItem() {
        GildedRose app = createGildedRoseWith1Item(DEFAULT_ITEM, EXPIRED_SELL_IN, DEF_QUALITY);

        app.updateQuality();

        Item actual = app.items[0];
        Item expected = new Item(DEFAULT_ITEM, EXPIRED_SELL_IN - 1, DEF_QUALITY - 2);
        assertItem(expected, actual);
    }

    private void assertItem(Item expected, Item actual) {
        assertEquals(expected.name, actual.name);
        assertEquals(expected.sellIn, actual.sellIn);
        assertEquals(expected.quality, actual.quality);
    }

    private GildedRose createGildedRoseWith1Item(String itemType, int sellIn, int quality) {
        Item item = new Item(itemType, sellIn, quality);
        Item[] items = new Item[]{item};
        GildedRose app = new GildedRose(items);
        return app;
    }
}