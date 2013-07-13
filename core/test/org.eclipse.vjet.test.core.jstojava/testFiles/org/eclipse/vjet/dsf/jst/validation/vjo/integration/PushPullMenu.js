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
vjo.ctype("org.eclipse.vjet.dsf.jst.validation.vjo.integration.PushPullMenu")
.needs("org.eclipse.vjet.dsf.jst.validation.vjo.integration.PushPullMenuJsModel")
.protos({

	//> public void constructs(org.eclipse.vjet.dsf.jst.validation.vjo.integration.PushPullMenuJsModel pModel)
	constructs : function(pModel){
		var c = pModel;
		this.sAvailMap = c.availMap;		
		this.sSelMap = c.selMap;
		this.sPushPullId =c.pushPullId;
	},
	
	//> public void changeService(String ddId)
	changeService : function(ddId){
	   dropDown =  ddId.toString();
	   if(listSel == null || listSel === undefined){listSel = [];}
	   this.optionsAvailable(listAvail, listSel);
	   this.optionsSelected(listSel);
	 },
	 
	//> public void optionsAvailable(String pAvailList,String pSelList)
	 optionsAvailable : function(pAvailList, pSelList){
			check = true;
			var val = 0;  //<Number
			var j = 0;//<Number
			var i = 0;//<Number
			for (i=0 ; i<pAvailList.length; i++) {
				for (j=0;  j<pSelList.length; j++) {
					if (pAvailList[i].id == pSelList[j].id) {
						check = false;
						break;
					} else{
						check = true;
					}
				}
				if (check) {
					val++;
				}
			}
	 },
	
	//> private void replaceStr(String pSource,String pToReplace,String pReplaceBy)
	replaceStr : function(pSource, pToReplace, pReplaceBy){
		while(pSource.has(pToReplace)){
			pSource = pSource.replace(pToReplace, pReplaceBy);
		}
		return pSource;
	},
	
  //> public String selectedValue(String pDropDownId)
	selectedValue : function(pDropDownId){
	  	return pDropDownId + "test".toString();
	}
	
})
.props({

   //> public void showHide(String pDropDownId,String pValue,org.eclipse.vjet.dsf.jst.validation.vjo.integration.PushPullMenuJsModel pModel)
	 showHide : function(pDropDownId,pValue,pModel){
	 	this.replaceStr();
	 	new org.eclipse.vjet.dsf.jst.validation.vjo.integration.PushPullMenu(pModel).
	 }
})
.endType();