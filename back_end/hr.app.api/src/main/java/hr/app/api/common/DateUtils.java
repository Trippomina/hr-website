package hr.app.api.common;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateUtils {
	public static int daysBetween(Date startDate, Date endDate) {
		long diffInMilliseconds = endDate.getTime() - startDate.getTime();
		return (int) TimeUnit.DAYS.convert(diffInMilliseconds, TimeUnit.MILLISECONDS);
	}
}
