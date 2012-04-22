package net.therap.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: parvez
 * Date: 4/22/12
 * Time: 3:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class Utils {

    public static final int USA_CODE = 1;
    public static final int CANADA_CODE = 2;

    public static int toInt(boolean  b){
        return b == true ? 1 : 0;
    }

    public static String convJS(String s) {
        // Convert problem characters to JavaScript Escaped values
        if (s == null) {
            return "";
        }

        String t = s;
        t = replace(t, "\\", "\\\\"); // replace backslash with \\
        t = replace(t, "'", "\\\'"); // replace an single quote with \'
        t = replace(t, "\"", "\\\""); // replace a double quote with \"
        t = replace(t, "\r", "\\r"); // replace CR with \r;
        t = replace(t, "\n", "\\n"); // replace LF with \n;

        return t;
    }


    private static String replace(String s, String one, String another) {
        // In a string replace one substring with another
        if (s.equals("")) {
            return "";
        }

        String res = "";
        int i = s.indexOf(one, 0);
        int lastpos = 0;

        while (i != -1) {
            res += (s.substring(lastpos, i) + another);
            lastpos = i + one.length();
            i = s.indexOf(one, lastpos);
        }

        res += s.substring(lastpos); // the rest

        return res;
    }


    public static boolean isEmpty(int[] array) {
        return array == null || array.length == 0;
    }

    public static boolean isEmptyList(List lst) {
        return lst == null || lst.size() == 0;
    }

    public static boolean isArrayEmpty(Object[] obj){
        return (obj == null || obj.length <= 0);
    }

    //returns true if any of the values is Empty, false if all the values are NonEmpty
    public static boolean isEmpty(String... values) {
        for (String value : values)
            if (isEmpty(value)) return true;
        return false;
    }

    public static boolean isEmpty(String str) {
        return ((str == null) || (str.trim().length() == 0));
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }
    //returns true if all the values are NonEmpty, false if any of the values is Empty
    public static boolean isNotEmpty(String... values) {
        return !isEmpty(values);
    }


/*

    public static boolean allHasText(String... values) {
        for (String value : values) {
            if(!StringUtils.hasText(value)) {
                return false;
            }
        }
        return true;
    }

    public static boolean anyHasText(String... values) {
        for (String value : values) {
            if(StringUtils.hasText(value)) {
                return true;
            }
        }
        return false;
    }
*/


    public static String getLanguage(Locale locale) {
        String loc = locale.getLanguage();

        if( loc == null || loc.equals("null")) {
            return "en";
        }

        if( loc.length() > 1) {
            return loc.substring(0, 2);
        }

        return loc;
    }

    public static String join(String... elements) {
        StringBuilder sb = new StringBuilder("");
        for (String element : elements) {
            if (isNotEmpty(element)) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append(element);
            }
        }
        return sb.toString();
    }

    public static String join(List<String> elements, String delemeter) {
        StringBuilder sb = new StringBuilder("");
        for (String element : elements) {
            if (isNotEmpty(element)) {
                if (sb.length() > 0) {
                    sb.append(delemeter);
                }
                sb.append(element);
            }
        }
        return sb.toString();
    }

    public static String join(List<String> elements) {
        return join(elements.toArray(new String[elements.size()]));
    }


    /**
     * Convenient equality checker, works even if first object is
     * null.
     */
    public static boolean nullEquals(Object o1, Object o2) {
        if (o1 == null) {
            return (o2 == null);
        }

        return o1.equals(o2);
    }

    public static boolean nullEqualsIgnoringCase(String s1, String s2, Locale locale) {
        if (locale == null) {
            locale = Locale.ENGLISH;
        }
        if (s1 == null) {
            return (s2 == null);
        } else if (s2 == null) {
            return false;
        }

        return s1.toLowerCase(locale).equals(s2.toLowerCase(locale));
    }

    public static boolean isObjectNull(Object ...objects) {
        if (objects == null) {
            return true;
        }

        for (Object object : objects) {
            if (object != null) {
                return false;
            }
        }

       return true;
    }


    public static boolean equalsSsnIdIgnoreFormat(String id1, String id2) {
        assert id1 != null;
        return id1.equals(id2) || id1.equals(changeSsnIdFormat(id2));
    }

    /**
     * Convert one SSN format to another
     */
    public static String changeSsnIdFormat(String num) {

        if (isEmpty(num)) {
            return "" ;
        }

        int len = num.length();
        String temp = "";
        if (len == 11) {
            temp += num.substring(0, 3) + num.substring(4, 6) + num.substring(7);
            return temp;
        } else if (len == 9) {
            for (int i = 0; i < 9; i++) {
                if (i == 3 || i == 5) {
                    temp += "-" + num.charAt(i);
                } else {
                    temp += num.charAt(i);
                }
            }
            return temp;
        }
//        log.debug("Old format: " + num);
//        log.debug("Changed Format: " + temp);

        return num;
    }

    public static boolean isEmpty(Collection collection) {
        return (collection == null || collection.isEmpty());
    }

    public static boolean isEmpty(Map map) {
        return (map == null || map.isEmpty());
    }

    public static Properties loadProperties(String path) throws Exception {

        Properties prop = new Properties();
        prop.load(new FileInputStream(path));
        return prop;
    }

    public static Properties loadProperties(InputStream inputStream) throws Exception {

        Properties prop = new Properties();
        prop.load(inputStream);
        return prop;
    }

    public static Properties loadPropertiesFromClassPath(String path) throws Exception {

        return loadProperties(Utils.class.getClass().getResourceAsStream(path));
    }
}
