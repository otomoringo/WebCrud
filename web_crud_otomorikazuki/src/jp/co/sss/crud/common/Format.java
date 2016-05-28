package jp.co.sss.crud.common;

/**
 * @author otomorikazki 文字列を整形するクラス
 *
 */
public class Format {

    /** 年の最初の文字 */
    public static final int YEAH_FIRST = 0;
    /** 年の最初の文字 */
    public static final int YEAH_LAST = 4;
    /** 月の最初の文字 */
    public static final int MONTH_FIRST = 5;
    /** 月の最初の文字 */
    public static final int MONTH_LAST = 7;
    /** 日の最初の文字 */
    public static final int DAY_FIRST = 8;
    /** 日の最初の文字 */
    public static final int DAY_LAST = 10;

    /** Stringの1文字目 */
    public static final int STRING_FIRST_INDEX = 0;
    /** Stringの2文字目 */
    public static final int STRING_SECOND_INDEX = 1;
    /** Stringの3文字目 */
    public static final int STRING_THIRD_INDEX = 2;

    /** 文字列0 */
    public static final String ZERO = "0";

    /**
     * @param str
     *            日時を受け取って、年/月/日に整形する
     * @return 整形したものを返す
     */
    public static String modifyDate(String str) {
        String y = str.substring(YEAH_FIRST, YEAH_LAST);
        String m = str.substring(MONTH_FIRST, MONTH_LAST);
        String d = str.substring(DAY_FIRST, DAY_LAST);
        if (m.substring(STRING_FIRST_INDEX, STRING_SECOND_INDEX).equals(ZERO)) {
            m = m.substring(STRING_SECOND_INDEX, STRING_THIRD_INDEX);
        }
        if (d.substring(STRING_FIRST_INDEX, STRING_SECOND_INDEX).equals(ZERO)) {
            d = d.substring(STRING_SECOND_INDEX, STRING_THIRD_INDEX);
        }
        str = y + "/" + m + "/" + d;
        return str;
    }
}
