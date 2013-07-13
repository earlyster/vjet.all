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
vjo.ctype('access.returnStatement.AccessReturnCorrect1Tester')
.protos({

//> public int getIsle(int val1, String val2)
getIsle : function (val1, val2)
{
if (val1 == 0)
{
	return 0;
}
else if (val1 == 1)
{
return 0;
}
else if (val1 == 2)
{
return 0;
}
else if(val2 == "String"){return 0;}
else if(val2 === "string"){return 0;}
else if(val1 > 0){return 0;}
else if(val1 < 30){return 0;}
else if(val1 >= 0){return 0;}
else if(val1 <= 30){return 0;}
else if(val1 == 0){return 0;}
else if(val1 != 0){return 0;}
else return 0;
}
})
.endType();