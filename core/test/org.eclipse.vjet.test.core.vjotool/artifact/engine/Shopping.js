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
vjo.ctype('engine.Shopping') //< public
.needs(['org.eclipse.vjet.vjo.java.lang.System','engine.ShoppingItem',
    'engine.ShoppingCategory'])
.inherits('engine.GenericShopping')
.satisfies('engine.IShopping')
.props({
    sellerName:"VJET", //< public String
    shop:null, //< private Shopping
    //> public Shopping getInstance()
    getInstance:function(){
        if(this.shop===null){
            this.shop=new this();
        }
        return this.shop;
    },
    //> public void main(String[] args)
    main:function(args){
        var sh=this.getInstance();
        this.vj$.System.out.println(this.sellerName);
        this.vj$.System.err.println(sh.getTotalItems());
    }
})
.protos({
    //> private constructs()
    constructs:function(){
        this.base();
        this.populateShoppingLists();
    },
    //> public boolean buy(ShoppingItem buyItem)
    buy:function(buyItem){
        this.buyOnEbay(buyItem);
        return true;
    },
    //> public boolean sell(ShoppingItem sellItem)
    sell:function(sellItem){
        this.sellOnEbay(sellItem);
        return true;
    },
    //> public int getTotalItems()
    getTotalItems:function(){
        var electronicsItems=this.getElectronicsList().size(); //<int
        var motorItems=this.getMotorList().size();//<int
        return (electronicsItems+motorItems);
    },
    //> private void populateShoppingLists()
    populateShoppingLists:function(){
        this.populateShoppingItem("iPhone","Stylish CellPhone",300,this.vj$.ShoppingCategory.ELECTRONICS);
        this.populateShoppingItem("PS3","Stylish Gaming Console",350,this.vj$.ShoppingCategory.ELECTRONICS);
        this.populateShoppingItem("BMW","Stylish Car",50000,this.vj$.ShoppingCategory.MOTORS);
        this.populateShoppingItem("Audi","Stylish Car",70000,this.vj$.ShoppingCategory.MOTORS);
    },
    //> private void populateShoppingItem(String name,String desc,int price,int category)
    populateShoppingItem:function(name,desc,price,category){
        var item=new this.vj$.ShoppingItem(name,desc,price,category);
        if(category===this.vj$.ShoppingCategory.ELECTRONICS){
            this.addElectronicsList(item);
        }
        if(category===this.vj$.ShoppingCategory.MOTORS){
            this.addMotorList(item);
        }
    }
})
.endType();
