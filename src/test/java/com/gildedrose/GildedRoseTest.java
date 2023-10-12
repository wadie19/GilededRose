package com.gildedrose;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {

  @Test
  @DisplayName("Test that the name is unchanged")
  void testNameUnchanged() {
    Item element = new Item("foo", 1, 0);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals("foo", element.name, "the name shoul not change");
  }

  // la qualité diminue par 1 
  @Test
  @DisplayName("Test that the quality decrease by 1")
  void testQltyDecrease() {
    Item element = new Item("goat", 10, 40);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(39, element.quality, "the quality decrease by 1");
  } 

  // quand c'est Aged Brie la qualité augmente par 1 
  @Test
  @DisplayName("Test that the quality should increase by 1 for Aged Brie")
  void testQltyIncreaseAgedBrie() {
    Item element = new Item("Aged Brie", 10, 40);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(41, element.quality, "the quality increase by 1 for Aged Brie");
  } 

  // quand c'est Backstage passes to a TAFKAL80ETC concert la qualité augmente
  @Test
  @DisplayName("Test that the quality increase by 1 for Backstage passes")
  void testQltyBackstagePasses() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 40);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(42, element.quality, "the quality increase by 2");
  } 

  /*@Test
  @DisplayName("Test that the quality decrease by 1")
  void testqlty4() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 40);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(43, element.quality, "the namlte changed");
  } */

  // sellIn diminue par 1 
  @Test
  @DisplayName("Test  the sellin decrease by 1")
  void testSellIn() {
    Item element = new Item("foo", 8, 40);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(7, element.sellIn, "the sellin decrease by 1");
  } 

  // quand sellIn est négative la qualité diminue par 1 et le name différent de sulfuras et aged brie et backstage
  @Test
  @DisplayName("Test  the quality should decrease")
  void testquality() {
    Item element = new Item("foo", -1, 8);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(6, element.quality, "the quality decrease by 1"); // ici la qualité diminue par 2 car elle est diminué 
                                                                                    // en premier lieu dans le premier if et apres dans le deuxieme condition 
  } 

  // la qualité diminue à 0 quand : sellin = 0 et Backstage passes to a TAFKAL80ETC concert
  @Test
  @DisplayName("Test  that the quality should decrease to 0 when SellIn is 0 for Backstage passes ")
  void testQualityZeroBackStage() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 8);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(0, element.quality, "the quality decrease to 0");
  } 

  //la qualité augmente par 1 quand c'est Aged Brie et qualité < 50 sellin < 0
  @Test
  @DisplayName("Test that the quality should increase")
  void testQualityWhenNegativeSellInForAgedBrie() {
    Item element = new Item("Aged Brie", -1, 8);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(10, element.quality, "the quality increase"); // augmente de 1 dans le else de premier if 
                                                                                // et après dans le else de dernier if 
  } 
  
  // test pour la fonction toString de Item.java
  @Test
  @DisplayName("Test Item toString method")
  void testFctToString() {
    Item item = new Item("Sulfuras, Hand of Ragnaros", 8, 39);
    String expectedString = "Sulfuras, Hand of Ragnaros, 8, 39";
    assertEquals(expectedString, item.toString(), "expectedString doit etre égal à la sortie de de cette fonction");
  } 


  /******************************* test sur les branches if ***************************************/

  // test la branche quand la qualité atteint 50 et sellin < 11
  @Test
  @DisplayName("Test that the quality < 50")
  void testQltybranche() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49);
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(50, element.quality, "quality not changed "); // quality augmente au début de if et après elle atteint 50 et n'entre pas dans le if 
  } 

  // test quand sellin est 11 et c'est Backstage passes
  @Test
  @DisplayName("Test la branche de if (items[i].sellIn < 11)")
  void testBranche2() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 11,39 );
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(40, element.quality, "the sellin not changed"); // ici la qualité est augmenté juste dans le traitement de if précedente
      // elle n'entre pas dans le traitement de if de sellin car sellin = 11
  } 

  // test la branche quand la qualité atteint 50 et sellin < 6
  @Test
  @DisplayName("Test la branche de if (items[i].quality < 50)")
  void testBranche4() {
    Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 5,49 );
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(50, element.quality, "the quality not changed");
  } 

  // test la branche quand la qualité est 0
  @Test
  @DisplayName("Test la branche de if (items[i].quality > 0)")
  void testBranche5() {
    Item element = new Item("foo", 0,0 );
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(0, element.quality, "the quality nul");
  } 

  // test la branche quand le nom égal à Sulfuras, Hand of Ragnaros et sellin < 0 et quality >0 
  @Test
  @DisplayName("Test la branche de if (!items[i].name.equals(\"Sulfuras, Hand of Ragnaros\"))")
  void testBranche6() {
    Item element = new Item("Sulfuras, Hand of Ragnaros", -1, 5 );
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(5, element.quality, "the quality not changed");
  } 

  // test la branche quand la qualité atteitn 50 et quand sellin < 0 et c'est Aged Brie
  @Test
  @DisplayName("Test la branche de if (items[i].quality < 50)")
  void testBranche7() {
    Item element = new Item("Aged Brie", -1,50 );
    GildedRose app = new GildedRose(new Item[] {element});
    app.updateQuality();
    assertEquals(50, element.quality, "the quality not changed");
  } 

}