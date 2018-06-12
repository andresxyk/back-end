package mx.com.web2lab.backend.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

public class DateDiff {
	
	private static final double MINUTE_MILLIS = 1000 * 60;
	private static final double HOUR_MILLIS = MINUTE_MILLIS * 60;
	private static final double DAY_MILLIS = HOUR_MILLIS * 24.0015;
	private static final double WEEK_MILLIS = DAY_MILLIS * 7;
	private static final double MONTH_MILLIS = DAY_MILLIS * 30.43675;
	private static final double YEAR_MILLIS = WEEK_MILLIS * 52.2;
	
	/**
	 * Metodo utilizado para obtener la diferencias entre dos fechas. 
	 * Esta diferencia puede ser obtenida en minutos, horas, dias, 
	 * semanas, meses y años. 
	 * @param calUnit. Este parametro puede tener los siguientes Valores: 
	 * <li>Calendar.MINUTE
	 * <li>Calendar.HOUR 
	 * <li>Calendar.DAY_OF_MONTH ó Calendar.DATE
	 * <li>Calendar.WEEK_OF_YEAR
	 * <li>Calendar.MONTH
	 * <li>Calendar.YEAR 
	 * 
	 * @param baseDate. Fecha base para calcular la diferencia, esta es la fecha mas reciente.   
	 * @param olderDate. Fecha final, esta es la fecha mas vieja.  
	 * @return entero con el resultado de la diferencia 
	 */
	public int getDateDiff( int calUnit, Date baseDate, Date olderDate ) {
//		swap if baseDate later than olderDate
		boolean neg = false;
		if( baseDate.after(olderDate) ) {
			Date temp = baseDate;
			baseDate = olderDate;
			olderDate = temp;
			neg = true;
		}
//		estimate the diff. baseDate is now guaranteed <= olderDate
		int estimate = (int)getEstDiff( calUnit, baseDate, olderDate );
//		convert the Dates to GregorianCalendars
		GregorianCalendar c1 = new GregorianCalendar();
		c1.setTime(baseDate);
		GregorianCalendar c2 = new GregorianCalendar();
		c2.setTime(olderDate);
//		add 2 units less than the estimate to 1st date,
//		then serially add units till we exceed 2nd date
		c1.add( calUnit, (int)estimate - 2);
		for( int i = estimate-1; ; i++ ) { 
			c1.add( calUnit, 1 );
			if( c1.after(c2) )
				return neg ? 1-i : i-1;
		}
	}
	
	/**
	 * 
	 * @param calUnit
	 * @param baseDate
	 * @param olderDate
	 * @return
	 */
	private int getEstDiff( int calUnit, Date baseDate, Date olderDate ) {
		long diff = olderDate.getTime() - baseDate.getTime();
		switch (calUnit) {
		case Calendar.MINUTE:
			return (int) (diff / MINUTE_MILLIS + .5);
		case Calendar.HOUR: 
			return (int) (diff / HOUR_MILLIS + .5);
		case Calendar.DAY_OF_WEEK_IN_MONTH :
			
		case Calendar.DAY_OF_MONTH :
//			case Calendar.DATE : // codes to same int as DAY_OF_MONTH
			return (int) (diff / DAY_MILLIS + .5);
		case Calendar.WEEK_OF_YEAR :
			return (int) (diff / WEEK_MILLIS + .5);
		case Calendar.MONTH :
			return (int) (diff / MONTH_MILLIS + .5);
		case Calendar.YEAR :
			return (int) (diff / YEAR_MILLIS + .5);
		default:
			return 0;
		} /* endswitch */
	}
	
	/**
	 * Metodo para probar la funcionalidad de la clase. 
	 * @param args
	 */
	public static void main(String[] args) {
		DateDiff dd = new DateDiff();
		Date then = null, now = null;
		DateFormat df = DateFormat.getInstance();
//		Use this instead of DecimalFormat if you have it...
//		If not, you can get it at:
//		http://pws.prserv.net/ad/programs/Programs.html#PaddedDecimalFormat
		Calendar cal1 = new GregorianCalendar(2005,1,1,0,0,0);
		Calendar cal2 = new GregorianCalendar(2005,1,1,1,23,0);
		NumberFormat ddf =
			DecimalFormat.getNumberInstance(Locale.getDefault());
		
		df.setTimeZone( TimeZone.getDefault() );
		then = cal1.getTime();
		now = cal2.getTime();
//		now we have two Date objects. get real & estimated diff
		
		int diff = dd.getDateDiff( Calendar.MINUTE, then, now );
		System.out.println("Interval in minutes: " + ddf.format(diff));
		diff = dd.getDateDiff( Calendar.HOUR, then, now );
		System.out.println("Interval in hours: " + ddf.format(diff));
		diff = dd.getDateDiff( Calendar.DATE, then, now ); 
		System.out.println("Interval in days: " + ddf.format(diff));
		diff = dd.getDateDiff( Calendar.WEEK_OF_YEAR, then, now );
		System.out.println("Interval in weeks: " + ddf.format(diff));
		diff = dd.getDateDiff( Calendar.MONTH, then, now );
		System.out.println("Interval in months: " + ddf.format(diff));
		diff = dd.getDateDiff( Calendar.YEAR, then, now );
		System.out.println("Interval in years: " + ddf.format(diff));
	}
	
}
