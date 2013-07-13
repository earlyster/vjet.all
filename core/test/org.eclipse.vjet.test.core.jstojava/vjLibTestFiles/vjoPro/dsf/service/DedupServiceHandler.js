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
vjo.ctype("vjoPro.dsf.service.DedupServiceHandler")
.needs(["vjoPro.dsf.Message",
"vjoPro.dsf.ServiceEngine",
"vjoPro.dsf.common.IJsRespHandler",
"vjoPro.dsf.common.IJsReqHandler",
"vjoPro.dsf.common.IDedupComparable"])
.satisfies("vjoPro.dsf.common.IJsRespHandler")
.satisfies("vjoPro.dsf.common.IJsReqHandler")
.protos({

messages:null,//<Object[]
oComparable:null,//<IDedupComparable
//> public void constructs(vjoPro.dsf.common.IDedupComparable);
constructs : function (comparable) {
this.messages = [];
this.oComparable = comparable;
},

//> public void handleRequest(Object);
handleRequest : function(message) {
if(!this.oComparable.shouldTrack(message)) {
return;
}
var msgs = this.messages;
for (var i = 0; i < msgs.length; i++) {
var msg = msgs[i];
if (this.oComparable.isDedup(msg,message)) {
//alert("Message is duplicate");
return;
}
}
this.messages[this.messages.length] = message;
},

//> public void handleResponse(Object);
handleResponse : function( message) {
var temp = [], len = this.messages.length;
for (var i=0; i<len; i++) {
if (message != this.messages[i]) {
temp[temp.length] = this.messages[i];
}
}
this.messages = temp;
}
})
.endType();
