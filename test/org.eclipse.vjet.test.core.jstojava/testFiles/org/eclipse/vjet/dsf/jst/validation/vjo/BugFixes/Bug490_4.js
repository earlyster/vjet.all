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
vjo.etype('org.eclipse.vjet.dsf.jst.validation.vjo.BugFixes.Bug490_4') //< public
.values({
	MON:[true, 'Monday'],
	TUE:[true, 'Tuesday'],
	WED:[true, 'Wednesday'],
	THU:[true, 'Thursday'],
	FRI:[true, 'Friday'],
	SAT:[false, 'Saturday'],
	SUN:[false, 'Sunday']
})
.protos({
	weekday : undefined, //< private boolean
	displayName : undefined, //< private String

	//> private void contructs(boolean, String)
	constructs : function (wkday, dispName) {
		this.weekday = wkday;
		this.displayName = dispName;
	},
	
	//>  public boolean isWeekday()
	isWeekday : function () {
		return this.weekday;
	},

	//> public String getDisplayName()
	getDisplayName : function () {
		return this.displayName;
	},

	//> public String getDisplayName(String str)
	getDisplayName : function (str) {
		return this.displayName + str;
	}
	
})
.endType();//End the Type Definition