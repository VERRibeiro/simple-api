package com.verribeiro.tournamentapi.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.regex.Pattern;

public class FormatUtil {

	public String formatBigDecimal(String number) {		
		return number.replaceAll(Pattern.quote("."), "").replaceAll(",", ".");
	}
	
	public String setBigDecimalPattern(String number) {
		String pattern = "###,###.###";		
		Locale locale  = new Locale("da", "DK");
		DecimalFormat decimalFormat = (DecimalFormat)
		        NumberFormat.getNumberInstance(locale);	
		decimalFormat.applyPattern(pattern);
		
		return decimalFormat.format(new BigDecimal(number));		
	}
}
