/*******************************************************************************
 * Copyright (c) 2012 eBay Inc. and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     eBay Inc. - initial API and implementation
 *******************************************************************************/
vjo.ctype('engine.ShoppingItem') //< public
.protos({
    itemName:null, //< private String
    itemCategory:0, //< private int
    itemDescription:null, //< private String
    itemPrice:0, //< private int
    //> public constructs(String name,String desc,int price,int category)
    constructs:function(name,desc,price,category){
        this.itemName=name;
        this.itemDescription=desc;
        this.itemPrice=price;
        this.itemCategory=category;
    },
    //> public String getItemName()
    getItemName:function(){
        return this.itemName;
    },
    //> public void setItemName(String itemName)
    setItemName:function(itemName){
        this.itemName=itemName;
    },
    //> public int getItemCategory()
    getItemCategory:function(){
        return this.itemCategory;
    },
    //> public void setItemCategory(int itemCategory)
    setItemCategory:function(itemCategory){
        this.itemCategory=itemCategory;
    },
    //> public String getItemDescription()
    getItemDescription:function(){
        return this.itemDescription;
    },
    //> public void setItemDescription(String itemDescription)
    setItemDescription:function(itemDescription){
        this.itemDescription=itemDescription;
    },
    //> public int getItemPrice()
    getItemPrice:function(){
        return this.itemPrice;
    },
    //> public void setItemPrice(int itemPrice)
    setItemPrice:function(itemPrice){
        this.itemPrice=itemPrice;
    }
})
.endType();
