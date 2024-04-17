package dev.mayankg.clean_coding.unit1.originalTests;

import dev.mayankg.clean_coding.unit1Gildedrose.GildedRose;
import dev.mayankg.clean_coding.unit1Gildedrose.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseCBackstagePassesTest {
	
	@Test
	void testUpdateQualityBackstagePasses1() {
		Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 3);
		Item[] items = new Item[] { item };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("Backstage passes to a TAFKAL80ETC concert",
				app.items[0].name);
		assertEquals(14, app.items[0].sellIn);
		assertEquals(4, app.items[0].quality);
	}

	@Test
	void testUpdateQualityBackstagePasses2() {
		Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 7, 3);
		Item[] items = new Item[] { item };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("Backstage passes to a TAFKAL80ETC concert",
				app.items[0].name);
		assertEquals(6, app.items[0].sellIn);
		assertEquals(5, app.items[0].quality);
	}

	@Test
	void testUpdateQualityBackstagePasses3() {
		Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 4, 3);
		Item[] items = new Item[] { item };
		GildedRose app = new GildedRose(items);
		app.updateQuality();
		assertEquals("Backstage passes to a TAFKAL80ETC concert",
				app.items[0].name);
		assertEquals(3, app.items[0].sellIn);
		assertEquals(6, app.items[0].quality);
	}

}