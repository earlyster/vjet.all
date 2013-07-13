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
vjo.ctype("org.eclipse.vjet.vsf.utils.jstrace.RemoteFormatter")
.needs("org.eclipse.vjet.vsf.utils.logging.Formatter")
.inherits("org.eclipse.vjet.vsf.utils.logging.Formatter")
.protos({
    //> private constructs()
	constructs: function(){
		this.base("org.eclipse.vjet.vsf.utils.jstrace.RemoteFormatter");
	},
	
	format: function(lr){
		var ctx = lr.params[0];
		if(!ctx){
			return;
		}
		var t = this,
			mgr = org.eclipse.vjet.vsf.utils.logging.LogManager.getLogManager(),
			cname = "org.eclipse.vjet.vsf.utils.jstrace.RemoteFormatter",
			guid = mgr.getStringProperty(cname + '.guid', 'default'),
			lifespan = mgr.getStringProperty(cname + '.lifespan', '90'),
			loc = document.location.href,
			jsrId = ctx.jsrId || '?',
			evtType = ctx.type || '?',
			evtTime = ctx.time || '?',
			expr = ctx.expr || '?',
			evtFunc = ctx.target || '?',
			evtParams = ctx.args ? t.getParamStr(ctx.args):'void',
			execTime = ctx.delta || 0,
			logSep = '@_@',
			logItem = 
				loc + logSep +
				guid + logSep +
				evtType + logSep +
				evtTime + logSep +
				expr + logSep +
				evtFunc + logSep +
				lifespan + logSep +
				jsrId + logSep +
				evtParams + logSep +
				execTime;
		return logItem;
	},
	
	getParamStr : function(args){
		var str = args[0];
		for(var i = 1;i<args.length;i++){
			str+=',';
			str+=args[i];
		}
		return str;
	}
})
.endType();
