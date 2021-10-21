package org.r3.db.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.r3.system.util.StringUtils;

public class SQLStringUtils
{
	public enum LikeMode {
		None, FullLike, LeftLike, RightLike
	};
		
	public    static DateFormat        DBDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	public static String escapeSingleQuotes(String targetString)
    {
         if (targetString == null || targetString.length() == 0 || targetString.indexOf('\'') < 0)
             return targetString;

         return StringUtils.replace(targetString, "'", "''");
    }
	
	public static String getDateAsSQLString(java.sql.Date aDate)
	{
	     if (aDate == null)
	    	 return null;
	     
	     return DBDateFormat.format(aDate);
	}
	
	public static String getStringForLikeMode(String s, LikeMode aLikeMode)
	{
		if (s == null || aLikeMode == LikeMode.None)
			return s;

		StringBuilder stb = new StringBuilder();
		switch (aLikeMode)
		{
		case FullLike:
			stb.append('%');
			break;

		case LeftLike:
			break;

		case RightLike:
			stb.append('%');
			break;

		}

		stb.append(s);

		switch (aLikeMode)
		{
		case FullLike:
			stb.append('%');
			break;

		case LeftLike:
			stb.append('%');
			break;

		case RightLike:
			break;

		}

		return stb.toString();
	}
}
