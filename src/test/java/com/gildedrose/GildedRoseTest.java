package com.gildedrose;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {

  @Test
  @DisplayName("Test that the name is unchanged")
  void testName() {
    Item element = new Item("FIXME", 0, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals("FIXME", element.name, "the name changed");
  }

  @Test
  @DisplayName("Test that the quantity is unchanged")
  void testQty() {
    Item element = new Item("foo", 0, 5);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(3, element.quality, "the quality chanesged");
  }

  @Test
  @DisplayName("Test that the sellin is unchanged")
  void testSellIn() {
    Item element = new Item("foo", 8, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(7, element.sellIn, "the sellin chanesged");
  }

  @Test
  public void testUpdateQualityForBackstagePasses() {
    Item backstagePasses = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20);
    GildedRose gildedRose = new GildedRose(new Item[]{backstagePasses});

    gildedRose.updateQuality();

    assertEquals(22, backstagePasses.quality);

    // Test for sellIn < 11
    backstagePasses.sellIn =9;
    gildedRose.updateQuality();

    assertEquals(24, backstagePasses.quality);

    // Test for sellIn < 6
    backstagePasses.sellIn = 5;
    gildedRose.updateQuality();

    assertEquals(27, backstagePasses.quality);
  }

  @Test
  public void testUpdateQualityForSulfuras() {
    Item sulfuras = new Item("Sulfuras, Hand of Ragnaros", 0, 80);
    GildedRose gildedRose = new GildedRose(new Item[]{sulfuras});

    gildedRose.updateQuality();

    assertEquals(80, sulfuras.quality);
  }
}
