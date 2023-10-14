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
      switch (items[i].name) {
        //j'ai remarqué que Sulfuras est un objet qu'il n'interagit pas
        case sulfuras :           
            break;
        
        //Les tickets de backsatge ont de la valeur si la date approche et apres elle n'a pas de valeur
        case backstage :         
            addQuality(items[i]);

            if (items[i].sellIn < 11) {
              addQuality(items[i]);
            }

            if (items[i].sellIn < 6) {
              addQuality(items[i]);
            }

            subSellIn(items[i]);

            if (items[i].sellIn < 0) {
              items[i].quality = items[i].quality - items[i].quality;
            }
            break;

        //Comportement général pour tous les autres items 
        default :                   
            subQuality(items[i]);
            subSellIn(items[i]);
            if(items[i].sellIn < 0) {
                subQuality(items[i]);
            }
            break;

        

      }
      if (!items[i].name.equals(agedbrie)) {
        
      } else {
        if (items[i].quality < 50) {
          items[i].quality++;
        }
      }

      if (items[i].sellIn < 0) {
        if (!items[i].name.equals(agedbrie)) {
          
        } else {
          addQuality(items[i]);
        }
      }
    }
  }

  // Une fonction qui ajoute 1 à la qualité à un item en question
  protected void addQuality(Item item) {      
    if (item.quality < 50) {
        item.quality++;
    }
  }

  // Une fonction qui enlève 1 à la qualité à un item en question
  protected void subQuality(Item item) {      
    if (item.quality > 0) {
        item.quality--;
    }
  }

  // Une fonction qui enlève 1 jour de vente
  protected void subSellIn(Item item) {
    item.sellIn--;
  } 
}
