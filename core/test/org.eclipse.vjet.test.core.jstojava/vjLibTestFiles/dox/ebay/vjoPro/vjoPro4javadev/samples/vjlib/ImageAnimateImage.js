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
vjo.ctype("dox.ebay.vjoPro.vjoPro4javadev.samples.vjlib.ImageAnimateImage")
.needs("vjoPro.dsf.utils.Object")
.needs('vjoPro.dsf.document.Image','A')
.needs('vjoPro.samples.images.Image','B')
.protos({

//> public void constructs(String psId, String [] paImageUrls)
constructs : function (psId, paImageUrls) {
if (document.images){// object detection
this.sId = psId;
// add image
this.aImageUrls = paImageUrls;
// preload image
for(var i = 0; i < this.aImageUrls.length; ++i) {
this.vj$.B.preload(this.aImageUrls[i]);
}
}
},

//> public void animate()
animate:function(){
if (document.images){// object detection
if (this.iCurrentIndex > this.aImageUrls.length - 1) {
this.iCurrentIndex = 0;
}
this.vj$.A.load(this.sId, this.aImageUrls[this.iCurrentIndex++]);
setTimeout(vjoPro.dsf.utils.Object.hitch(this,"animate"),  500);
}
},
iCurrentIndex : 0 //<Number
})
.endType();
