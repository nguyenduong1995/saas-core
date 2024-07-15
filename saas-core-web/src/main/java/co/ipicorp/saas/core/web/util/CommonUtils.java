package co.ipicorp.saas.core.web.util;

import java.text.DecimalFormat;
import java.util.Random;

public class CommonUtils {

    public static String generateCode(String prefix, int id, String middle, int number) {
        Random r = new Random( System.currentTimeMillis() );
        DecimalFormat df = new DecimalFormat("00000000");
        String numFormat = "" + number + r.nextInt(1000000);
        return prefix + id + middle + df.format(Integer.valueOf(numFormat));
    }
}
