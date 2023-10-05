package com.gildedrose;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {

  @Test
  @DisplayName("Test that the name is unchanged")
  void testName() {
    Item element = new Item("foo", 1, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals("foo", element.name, "the name changed");
  }

  @Test
  @DisplayName("Test that the quality decrease by 1")
  void testqlty() {
    Item element = new Item("got", 10, 40);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(39, element.quality, "the namlte changed");
  }

  @Test
  @DisplayName("Test that the quality decrease by 1")
  void testqlty2() {
    Item element = new Item("Aged Brie", 10, 40);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(41, element.quality, "the namlte changed");
  }

  @Test
  @DisplayName("Test that the quality decrease by 1")
  void testqlty3() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 40);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(42, element.quality, "the namlte changed");
  }

  @Test
  @DisplayName("Test that the quality decrease by 1")
  void testqlty4() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 40);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(43, element.quality, "the namlte changed");
  }

  @Test
  @DisplayName("Test  the sellin ")
  void testSellIn() {
    Item element = new Item("foo", 8, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(7, element.sellIn, "the sellin changed");
  }

  @Test
  @DisplayName("Test  the sellin ")
  void testquality() {
    Item element = new Item("foo", 0, 8);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(6, element.quality, "the quality decrease by 1");
  }

  @Test
  @DisplayName("Test  the quality nul ")
  void testquality1() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 8);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(0, element.quality, "the quality decrease to 0");
  }

  @Test
  @DisplayName("Test  the quality ")
  void testquality2() {
    Item element = new Item("Aged Brie", 0, 8);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(10, element.quality, "the quality increase");
  }

  @Test
  @DisplayName("Test that the quality decrease by 1")
  void testbranche() {
    Item element = new Item("Sulfuras, Hand of Ragnaros", 10,39 );
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    //assertEquals(40, element.quality, "the namlte changed");
  }
  
  
  @Test
  @DisplayName("Test that the quality decrease by 1")
  void testqltybranch() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 50);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(50, element.quality, "the namlte changed");
  }

}