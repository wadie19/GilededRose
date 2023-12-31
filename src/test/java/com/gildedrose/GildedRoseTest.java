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
    Item element = new Item("Aged Brie", 0, 8); /////////
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


  /*********************** test pour la partie mutation **************************/


  // test sur la branche (if (items[i].sellIn < 6) { )
  @Test
  @DisplayName("test on the sellIn")
  void testSellInMutation1() {
      Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 6, 45); 
      GildedRose app = new GildedRose(new Item[]{element});
      app.updateQuality();
      assertEquals(47, element.quality, "the quality should not change when sellin = 6 ");
    // qualité augmenté une fois quand la qualité < 50 et une fois quand c'est backstage passes et sellin < 11 
    // et apres elle atteint la condition sellin =6 elle ne change pas
  }

  // test sur la branche (if (items[i].sellIn < 0) { )
  @Test
  @DisplayName("test the sellIn")
  void testSellInMutation2() {
      Item element = new Item("item", 1, 40); 
      GildedRose app = new GildedRose(new Item[]{element});
      app.updateQuality();
      assertEquals(39, element.quality, "Quality should not change ");
      // la qualité est decrementé une fois au premier if 
      // sellin est decrementé et atteint 0 
  }  

  // test sur "items[i].quality = items[i].quality + 1;" quand sellin < 6 
  @Test
  @DisplayName("test the quality")
  void TestQualitymutation3() {
      Item element = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 46); 
      GildedRose app = new GildedRose(new Item[]{element});
      app.updateQuality();
      assertEquals(49, element.quality, "Quality increase");
      // qualité augmente au début else de premier if quand quality < 50 et quand c'est backstage passes 
      // et une fois quand sellin < 11 et autre fois quand sellin < 6 
  } 


  /******************************** tests sur conjured *****************************/
  
  @Test
  public void testQualityConjured() {
      // une qualité de 10 et un délai de vente de 5
      Item elementConjured = new Item("Conjured Mana Cake", 5, 10);
      GildedRose app = new GildedRose(new Item[] {elementConjured});
      app.updateQuality();

      assertEquals(8, elementConjured.quality, "the quality decrease by 2"); 
      // Vérifions la qualité a été réduite de 2
  }

  @Test
  public void testQualityConjured2() {
      // une qualité de 0 et un délai de vente de 5
      Item elementConjured = new Item("Conjured Mana Cake", 5, 0);
      GildedRose app = new GildedRose(new Item[] {elementConjured});
      app.updateQuality();

      assertEquals(0, elementConjured.quality, "the quality remain 0");
      // la qualité reste à 0

  }

  @Test
  @DisplayName("test the quality for conjured with negative sellin")
  public void testQualityConjured3() {
      // une qualité de 10 et un délai de vente de -1
      Item elementConjured = new Item("Conjured Mana Cake", -1, 10);
      GildedRose app = new GildedRose(new Item[] {elementConjured});
      app.updateQuality();

      assertEquals(6, elementConjured.quality, "the quality decreased by 4");
      // Vérifions la qualité a été réduite de 4 (2 fois plus rapide en raison du délai de vente négatif)

  }

  
}