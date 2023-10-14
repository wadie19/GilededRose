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
    for (Item item : items) {
      switch (item.name) {

        //j'ai remarqué que Sulfuras est un objet qu'il n'interagit pas
        case sulfuras :           
            break;
        
        //Les tickets de backsatge ont de la valeur si la date approche et apres elle n'a pas de valeur
        case backstage :         
            addQuality(item);

            if (item.sellIn < 11) {
              addQuality(item);
            }

            if (item.sellIn < 6) {
              addQuality(item);
            }

            subSellIn(item);

            if (item.sellIn < 0) {
              item.quality = 0;
            }
            break;
            
        // pour aged brie la qualité augmente avec la jours de vente 
        case agedbrie :        
            addQuality(item);
            subSellIn(item);
            if (item.sellIn < 0) {
            addQuality(item);
            }
            break;

        //Comportement général pour tous les autres items 
        default :                   
            subQuality(item);
            subSellIn(item);
            if(item.sellIn < 0) {
                subQuality(item);
            }
            break;
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
