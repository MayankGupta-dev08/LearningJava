package dev.mayankg.clean_coding.unit1.originalTests;

import dev.mayankg.clean_coding.unit1Gildedrose.GildedRose;
import dev.mayankg.clean_coding.unit1Gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseBAgedBrieTest {

	@Test
	void testUpdateQualityAgedBrie1() {
		Item item = new Item("Aged Brie", 4, 3);
		Item[] items = new Item[] { item };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("Aged Brie", app.items[0].name);
		assertEquals(3, app.items[0].sellIn);
		assertEquals(4, app.items[0].quality);
	}

	@Test
	void testUpdateQualityAgedBrie2() {
		Item item = new Item("Aged Brie", -1, 3);
		Item[] items = new Item[] { item };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("Aged Brie", app.items[0].name);
		assertEquals(-2, app.items[0].sellIn);
		assertEquals(5, app.items[0].quality);
	}

	@Test
	void testUpdateQualityAgedBrie3() {
		Item item = new Item("Aged Brie", 4, 50);
		Item[] items = new Item[] { item };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("Aged Brie", app.items[0].name);
		assertEquals(3, app.items[0].sellIn);
		assertEquals(50, app.items[0].quality);
	}
}