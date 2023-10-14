package com.gildedrose;

class GildedRose {
  Item[] items;
  static final String sulfuras = "Sulfuras, Hand of Ragnaros";
  static final String backstage = "Backstage passes to a TAFKAL80ETC concert";
  static final String agedbrie = "Aged Brie";

  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
    for (int i = 0; i < items.length; i++) {
      if (!items[i].name.equals(agedbrie)
          && !items[i].name.equals(backstage)) {
        if (items[i].quality > 0) {
          if (!items[i].name.equals(sulfuras)) {
            items[i].quality = items[i].quality - 1;
          }
        }
      } else {
        if (items[i].quality < 50) {
          items[i].quality = items[i].quality + 1;

          if (items[i].name.equals(backstage)) {
            if (items[i].sellIn < 11) {
              if (items[i].quality < 50) {
                items[i].quality = items[i].quality + 1;
              }
            }

            if (items[i].sellIn < 6) {
              if (items[i].quality < 50) {
                items[i].quality = items[i].quality + 1;
              }
            }
          }
        }
      }

      if (!items[i].name.equals(sulfuras)) {
        items[i].sellIn = items[i].sellIn - 1;
      }

      if (items[i].sellIn < 0) {
        if (!items[i].name.equals(agedbrie)) {
          if (!items[i].name.equals(backstage)) {
            if (items[i].quality > 0) {
              if (!items[i].name.equals(sulfuras)) {
                items[i].quality = items[i].quality - 1;
              }
            }
          } else {
            items[i].quality = items[i].quality - items[i].quality;
          }
        } else {
          if (items[i].quality < 50) {
            items[i].quality = items[i].quality + 1;
          }
        }
      }
    }
  }
}
