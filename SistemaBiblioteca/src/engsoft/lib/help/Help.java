package engsoft.lib.help;

import java.util.Calendar;
import java.util.Date;

public abstract class Help {
	public static Date criarData(int difDias) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeInMillis(cal.getTimeInMillis() + difDias*86400000);
		return cal.getTime();
	}
	
	public static Date getHoje() {
		return criarData(0);
	}
}
