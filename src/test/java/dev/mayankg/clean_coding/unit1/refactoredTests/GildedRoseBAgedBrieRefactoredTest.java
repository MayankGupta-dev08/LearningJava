package dev.mayankg.clean_coding.unit1.refactoredTests;

import dev.mayankg.clean_coding.unit1.gildedrose.GildedRose;
import dev.mayankg.clean_coding.unit1.gildedrose.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static dev.mayankg.clean_coding.unit1.refactoredTests.TestUtil.assertItem;
import static dev.mayankg.clean_coding.unit1.refactoredTests.TestUtil.createGildedRoseWith1Item;

public class GildedRoseBAgedBrieRefactoredTest {
    private static final String AGED_BRIE_ITEM = "Aged Brie";
    private static final int UNEXPIRED_SELL_IN = 4;
    private static final int DEF_QUALITY = 3;
    private static final int MAX_QUALITY = 50;
    private static final int EXPIRED_SELL_IN = -1;

    @Test
    @DisplayName("Method to test the variation in quality of an unexpired Aged Brie")
    public void testQualityIncrementBy1ForUnexpiredAgedBrieItem() {
        GildedRose app = createGildedRoseWith1Item(AGED_BRIE_ITEM, UNEXPIRED_SELL_IN, DEF_QUALITY);
        app.updateQuality();
        Item actual = app.items[0];
        Item expected = new Item(AGED_BRIE_ITEM, UNEXPIRED_SELL_IN - 1, DEF_QUALITY + 1);
        assertItem(expected, actual);
    }

    @Test
    @DisplayName("Method to test the variation in quality of an expired Aged Brie")
    public void testQualityIncrementBy2ForExpiredAgedBrieItem() {
        GildedRose app = createGildedRoseWith1Item(AGED_BRIE_ITEM, EXPIRED_SELL_IN, DEF_QUALITY);
        app.updateQuality();
        Item actual = app.items[0];
        Item expected = new Item(AGED_BRIE_ITEM, EXPIRED_SELL_IN - 1, DEF_QUALITY + 2);
        assertItem(expected, actual);
    }

    @Test
    @DisplayName("Method to test the variation in quality of an unexpired but maxed quality Aged Brie")
    public void testQualityVariationForUnexpiredMaxedQAgedBrie() {
        GildedRose app = createGildedRoseWith1Item(AGED_BRIE_ITEM, UNEXPIRED_SELL_IN, MAX_QUALITY);
        app.updateQuality();
        Item actual = app.items[0];
        Item expected = new Item(AGED_BRIE_ITEM, UNEXPIRED_SELL_IN - 1, MAX_QUALITY);
        assertItem(expected, actual);
    }
}