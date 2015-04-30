package angus.tools.date;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DateUtil
{
	//返回最详细的时候
	public static String getFormalTime()
	{
		return getFormat("yyyy-MM-dd HH-mm-ss");
	}
	
	//返回字符串作为文件名
	public static String getStringTime()
	{
		return getFormat("yyyyMMddHHmmss");
	}
	//工具方法
	private static String getFormat(String format)
	{
		Date d = new Date();
		DateFormat df = new SimpleDateFormat(format);
		return df.format(d);
	}
}
