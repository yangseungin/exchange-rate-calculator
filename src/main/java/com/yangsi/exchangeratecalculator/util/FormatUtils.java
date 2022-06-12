package com.yangsi.exchangeratecalculator.util;

import java.text.DecimalFormat;

public class FormatUtils {
    private static final String EXCHANGE_RATE_FORMAT = "#,###.00";


    public static String removeComma(String str) {
        return str.replace(",", "");
    }

    public static String exchangeRateFormat(Object val) {

        return new DecimalFormat(EXCHANGE_RATE_FORMAT).format(val);
    }
}
