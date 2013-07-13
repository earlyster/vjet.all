/*******************************************************************************
 * Copyright (c) 2005, 2012 eBay Inc.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.vjet.dsf.jsnative.global;

import org.eclipse.vjet.dsf.jsnative.anno.BrowserSupport;
import org.eclipse.vjet.dsf.jsnative.anno.BrowserType;
import org.eclipse.vjet.dsf.jsnative.anno.Constructor;
import org.eclipse.vjet.dsf.jsnative.anno.Function;
import org.eclipse.vjet.dsf.jsnative.anno.JsSupport;
import org.eclipse.vjet.dsf.jsnative.anno.JsVersion;
import org.eclipse.vjet.dsf.jsnative.anno.OverLoadFunc;
import org.eclipse.vjet.dsf.jsnative.anno.Static;


/**
 * 
 * Represents JavaScript native Date object
 *
 */
@JsSupport( {JsVersion.MOZILLA_ONE_DOT_ZERO, JsVersion.JSCRIPT_ONE_DOT_ZERO})
public interface Date extends Object {
	
	@Constructor void Date();
	
	@Constructor void Date(Number millisecond);
	
	@Constructor void Date(String datestring);
	
	@Constructor void Date(Number year, Number month, Number date);
	
	@Constructor void Date(Number year, Number month, Number date, Number hour, 
			Number minute, Number second, Number millisecond);
	
	
	/**
	 * Returns the day of the month for the specified date according to local time. 
	 */
	@Function Number getDate();
	
	/**
	 * Returns a number representing the day of the week for the specified date 
	 * (according to local time).
	 */
	@Function Number getDay();
	
	/**
	 * Returns the year of the specified date according to local time. 
	 */
	@JsSupport( JsVersion.MOZILLA_ONE_DOT_THREE)
	@Function Number getFullYear();
	
	/**
	 * Returns the hour for the specified date according to local time. 
	 */
	@Function Number getHours();
	
	/**
	 * Returns the number of milliseconds in the specified date according to local time. 
	 */
	@JsSupport( JsVersion.MOZILLA_ONE_DOT_THREE)
	@Function Number getMilliseconds();
	
	/**
	 * Returns the minutes in the specified date according to local time. 
	 */
	@Function Number getMinutes();
	
	/**
	 * Returns the month (from 0-11) in the specified date according to local time. 
	 */
	@Function Number getMonth();
	
	/**
	 * Returns the seconds in the specified date according to local time. 
	 */
	@Function Number getSeconds();
	
	/**
	 * Returns the numeric value corresponding to the time for the specified 
	 * date according to universal time. 
	 */
	@Function Number getTime();
	
	/**
	 * Returns the time-zone offset in minutes for the current locale. 
	 */
	@Function Number getTimezoneOffset();
	
	/**
	 * Returns the day (date) of the month in the specified date 
	 * according to universal time. 
	 */
	@JsSupport( JsVersion.MOZILLA_ONE_DOT_THREE)
	@Function Number getUTCDate();
	
	/**
	 * Returns the day of the week in the specified date according to universal time. 
	 */
	@JsSupport( JsVersion.MOZILLA_ONE_DOT_THREE)
	@Function Number getUTCDay();
	
	/**
	 * Returns the year in the specified date according to universal time. 
	 */
	@JsSupport( JsVersion.MOZILLA_ONE_DOT_THREE)
	@Function Number getUTCFullYear();
	
	/**
	 * Returns the hours in the specified date according to universal time. 
	 */
	@JsSupport( JsVersion.MOZILLA_ONE_DOT_THREE)
	@Function Number getUTCHours();
	
	/**
	 * Returns the milliseconds in the specified date according to universal time. 
	 */
	@JsSupport( JsVersion.MOZILLA_ONE_DOT_THREE)
	@Function Number getUTCMilliseconds();
	
	/**
	 * Returns the minutes in the specified date according to universal time. 
	 */
	@JsSupport( JsVersion.MOZILLA_ONE_DOT_THREE)
	@Function Number getUTCMinutes();
	
	/**
	 * Returns the month of the specified date according to universal time. 
	 */
	@JsSupport( JsVersion.MOZILLA_ONE_DOT_THREE)
	@Function Number getUTCMonth();
	
	/**
	 * Returns the seconds in the specified date according to universal time. 
	 */
	@JsSupport( JsVersion.MOZILLA_ONE_DOT_THREE)
	@Function Number getUTCSeconds();
	
	/**
	 * Returns the year in the specified date according to local time. 
	 */
	@Function Number getYear();
	
	/**
	 * Returns the number of milliseconds passed since 1970-01-01 00:00:00 UTC.
	 */
	@BrowserSupport({BrowserType.FIREFOX_1P})
	@Function @Static Number now();
	
	/**
	 * Parses a string representation of a date, and returns the number of 
	 * milliseconds since January 1, 1970, 00:00:00, local time. 
	 */
	@Function @Static Number parse(Object dateString);
	
	/**
	 * Sets the day of the month for a specified date according to local time. 
	 */
	@Function Number setDate(Number day);
	
	/**
	 * Sets the full year for a specified date according to local time. 
	 */
	@JsSupport( JsVersion.MOZILLA_ONE_DOT_THREE)
	@OverLoadFunc Number setFullYear(Number year);
	
	/**
	 * Sets the full year for a specified date according to local time. 
	 */
	@JsSupport( JsVersion.MOZILLA_ONE_DOT_THREE)
	@OverLoadFunc Number setFullYear(Number year,Number month);
	
	/**
	 * Sets the full year for a specified date according to local time. 
	 */
	@JsSupport( JsVersion.MOZILLA_ONE_DOT_THREE)
	@OverLoadFunc Number setFullYear(Number year,Number month,Number day);
	
	/**
	 * Sets the hours for a specified date according to local time. 
	 */
	@OverLoadFunc Number setHours(Number hour);
	
	/**
	 * Sets the hours for a specified date according to local time. 
	 */
	@OverLoadFunc Number setHours(Number hour,Number min);
	
	/**
	 * Sets the hours for a specified date according to local time. 
	 */
	@OverLoadFunc Number setHours(Number hour,Number min,Number sec);
	
	/**
	 * Sets the hours for a specified date according to local time. 
	 */
	@OverLoadFunc Number setHours(Number hour,Number min,Number sec,Number millisec);
	
	/**
	 * Sets the milliseconds for a specified date according to local time. 
	 */
	@Function Number setMilliseconds(Number millisec);
	
	/**
	 * Sets the minutes for a specified date according to local time. 
	 */
	@OverLoadFunc Number setMinutes(Number min);
	
	/**
	 * Sets the minutes for a specified date according to local time. 
	 */
	@OverLoadFunc Number setMinutes(Number min,Number sec);
	
	/**
	 * Sets the minutes for a specified date according to local time. 
	 */
	@OverLoadFunc Number setMinutes(Number min,Number sec,Number millisec);
	
	/**
	 * Set the month for a specified date according to local time. 
	 */
	@OverLoadFunc Number setMonth(Number month);
	
	/**
	 * Set the month for a specified date according to local time. 
	 */
	@OverLoadFunc Number setMonth(Number month,Number day);
	
	/**
	 * Sets the seconds for a specified date according to local time. 
	 */
	@OverLoadFunc Number setSeconds(Number sec);
	
	/**
	 * Sets the seconds for a specified date according to local time. 
	 */
	@OverLoadFunc Number setSeconds(Number sec,Number millisec);
	
	/**
	 * Sets the value of a Date object according to local time. 
	 */
	@Function Number setTime(Number millisec);
	
	/**
	 * Sets the day of the month for a specified date according to universal time. 
	 */
	@Function Number setUTCDate(Number day);
	
	/**
	 * Sets the full year for a specified date according to universal time. 
	 */
	@OverLoadFunc Number setUTCFullYear(Number year);
	
	/**
	 * Sets the full year for a specified date according to universal time. 
	 */
	@OverLoadFunc Number setUTCFullYear(Number year,Number month);
	
	/**
	 * Sets the full year for a specified date according to universal time. 
	 */
	@OverLoadFunc Number setUTCFullYear(Number year,Number month,Number day);
	
	/**
	 * Sets the hour for a specified date according to universal time. 
	 */
	@OverLoadFunc Number setUTCHours(Number hour);
	
	/**
	 * Sets the hour for a specified date according to universal time. 
	 */
	@OverLoadFunc Number setUTCHours(Number hour,Number min);
	
	/**
	 * Sets the hour for a specified date according to universal time. 
	 */
	@OverLoadFunc Number setUTCHours(Number hour,Number min,Number sec);
	
	/**
	 * Sets the hour for a specified date according to universal time. 
	 */
	@OverLoadFunc Number setUTCHours(Number hour,Number min,Number sec,Number millisec);
	
	/**
	 * Sets the minutes for a specified date according to universal time. 
	 */
	@OverLoadFunc Number setUTCMinutes(Number min);
	
	/**
	 * Sets the minutes for a specified date according to universal time. 
	 */
	@OverLoadFunc Number setUTCMinutes(Number min,Number sec);
	
	/**
	 * Sets the minutes for a specified date according to universal time. 
	 */
	@OverLoadFunc Number setUTCMinutes(Number min,Number sec,Number millisec);
	
	/**
	 * Sets the seconds for a specified date according to universal time. 
	 */
	@OverLoadFunc Number setUTCSeconds(Number sec);
	
	/**
	 * Sets the seconds for a specified date according to universal time. 
	 */
	@OverLoadFunc Number setUTCSeconds(Number sec,Number millisec);
	
	/**
	 * Sets the milliseconds for a specified date according to universal time. 
	 */
	@Function Number setUTCMilliseconds(Number millisec);
	
	/**
	 * Sets the month for a specified date according to universal time. 
	 */
	@OverLoadFunc Number setUTCMonth(Number month);
	
	/**
	 * Sets the month for a specified date according to universal time. 
	 */
	@OverLoadFunc Number setUTCMonth(Number month,Number day);
	
	/**
	 * Sets the year for a specified date according to local time. 
	 */
	@Function Number setYear(Number year);
	
	/**
	 * Returns a string version of the Date object expressed in local time.
	 */
	@Function String toDateString();
	
	/**
	 * Converts a date to a string, using Internet GMT conventions. 
	 */
	@Function String toGMTString();
	
	/**
	 * Converts a date to a string, returning the "date" portion using 
	 * the current locale's conventions. 
	 */
	@Function String toLocaleDateString();
	
	/**
	 * Converts a date to a string, returning the "date" portion using
	 * the current locale's conventions. 
	 */
	@Function String toLocaleTimeString();
	
	/**
	 * Converts a date to a string, using the current locale's conventions. 
	 */
	@Function String toLocaleString();
	
	/**
	 * Returns a string representation of the time portion of a Date object, 
	 * expressed in local time. 
	 */
	@Function String toTimeString();
	
	/**
	 * Converts a date to a string, using the universal time convention. 
	 */
	@Function String toUTCString();
	
	/**
	 * Accepts the same parameters as the longest form of the constructor, 
	 * and returns the number of milliseconds in a Date object since January 1, 1970, 00:00:00, universal time. 
	 */
	@OverLoadFunc @Static Number UTC(Number year,Number month,Number day);
	/**
	 * Accepts the same parameters as the longest form of the constructor, 
	 * and returns the number of milliseconds in a Date object since January 1, 1970, 00:00:00, universal time. 
	 */
	@OverLoadFunc @Static Number UTC(Number year,Number month,Number day,
			Number hours);
	/**
	 * Accepts the same parameters as the longest form of the constructor, 
	 * and returns the number of milliseconds in a Date object since January 1, 1970, 00:00:00, universal time. 
	 */
	@OverLoadFunc @Static Number UTC(Number year,Number month,Number day,
			Number hours,Number minutes);
	/**
	 * Accepts the same parameters as the longest form of the constructor, 
	 * and returns the number of milliseconds in a Date object since January 1, 1970, 00:00:00, universal time. 
	 */
	@OverLoadFunc @Static Number UTC(Number year,Number month,Number day,
			Number hours,Number minutes,Number seconds);
	
	/**
	 * Accepts the same parameters as the longest form of the constructor, 
	 * and returns the number of milliseconds in a Date object since January 1, 1970, 00:00:00, universal time. 
	 */
	@OverLoadFunc @Static Number UTC(Number year,Number month,Number day,
			Number hours,Number minutes,Number seconds,Number ms);
	
	/**
	 * Returns the primitive value of a Date object.
	 */
	@Function Number valueOf();
}
