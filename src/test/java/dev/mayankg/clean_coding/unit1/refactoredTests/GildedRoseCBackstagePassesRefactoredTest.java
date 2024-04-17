package dev.mayankg.clean_coding.unit1.refactoredTests;

import dev.mayankg.clean_coding.unit1Gildedrose.GildedRose;
import dev.mayankg.clean_coding.unit1Gildedrose.Item;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static dev.mayankg.clean_coding.unit1.refactoredTests.TestUtil.assertItem;
import static dev.mayankg.clean_coding.unit1.refactoredTests.TestUtil.createGildedRoseWith1Item;

class GildedRoseCBackstagePassesRefactoredTest {
    private static final String BACKSTAGE_PASSES_ITEM = "Backstage passes to a TAFKAL80ETC concert";
    private static final int SELL_IN_MORE_THAN_10 = 15;  // 11 or more
    private static final int SELL_IN_BW_10_AND_5 = 7;   // (5,10]
    private static final int SELL_IN_LESS_THAN_EQUAL_5 = 4;   // [0,5]
    private static final int EXPIRED_SELL_IN = -1;
    private static final int DEF_QUALITY = 3;
    private static final int MIN_QUALITY = 0;
    private static final int MAX_QUALITY = 50;

    @Test
    @DisplayName("Method to test the variation in quality of Backstage passes where sellIn > 10")
    void testQualityIncrementBy1ForBackstagePassesWithSellInMoreThan10() {
        GildedRose app = createGildedRoseWith1Item(BACKSTAGE_PASSES_ITEM, SELL_IN_MORE_THAN_10, DEF_QUALITY);
        app.updateQuality();
        Item actual = app.items[0];
        Item expected = new Item(BACKSTAGE_PASSES_ITEM, SELL_IN_MORE_THAN_10 - 1, DEF_QUALITY + 1);
        assertItem(expected, actual);
    }

    @Test
    @DisplayName("Method to test the variation in quality of Backstage passes where 5 < sellIn <= 10")
    void testQualityIncrementBy2ForBackstagePassesWithSellInBw10And5() {
        GildedRose app = createGildedRoseWith1Item(BACKSTAGE_PASSES_ITEM, SELL_IN_BW_10_AND_5, DEF_QUALITY);
        app.updateQuality();
        Item actual = app.items[0];
        Item expected = new Item(BACKSTAGE_PASSES_ITEM, SELL_IN_BW_10_AND_5 - 1, DEF_QUALITY + 2);
        assertItem(expected, actual);
    }

    @Test
    @DisplayName("Method to test the variation in quality of Backstage passes where sellIn <= 5")
    void testQualityIncrementBy1ForBackstagePassesWithSellInIsLessOrEqualTo5() {
        GildedRose app = createGildedRoseWith1Item(BACKSTAGE_PASSES_ITEM, SELL_IN_LESS_THAN_EQUAL_5, DEF_QUALITY);
        app.updateQuality();
        Item actual = app.items[0];
        Item expected = new Item(BACKSTAGE_PASSES_ITEM, SELL_IN_LESS_THAN_EQUAL_5 - 1, DEF_QUALITY + 3);
        assertItem(expected, actual);
    }

    @Test
    @DisplayName("Method to test the variation in quality of expired Backstage passes")
    void testQualityVariationForExpiredBackstagePasses() {
        GildedRose app = createGildedRoseWith1Item(BACKSTAGE_PASSES_ITEM, EXPIRED_SELL_IN, MIN_QUALITY);
        app.updateQuality();
        Item actual = app.items[0];
        Item expected = new Item(BACKSTAGE_PASSES_ITEM, EXPIRED_SELL_IN - 1, MIN_QUALITY);
        assertItem(expected, actual);
    }

    @Test
    @DisplayName("Method to test the variation in quality of maxed quality Backstage passes where sellIn <= 5")
    void testQualityVariationForUnexpiredMaxedQAgedBrie() {
        GildedRose app = createGildedRoseWith1Item(BACKSTAGE_PASSES_ITEM, SELL_IN_LESS_THAN_EQUAL_5, MAX_QUALITY);
        app.updateQuality();
        Item actual = app.items[0];
        Item expected = new Item(BACKSTAGE_PASSES_ITEM, SELL_IN_LESS_THAN_EQUAL_5 - 1, MAX_QUALITY);
        assertItem(expected, actual);
    }
}