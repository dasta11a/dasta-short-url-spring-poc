/**
 * 
 */
package com.dasta.shorturl.util;

/**
 * @author dasta
 *
 */
public class ShortURLUtil {
	
	private static char[] code = new char[62];
	
    static {
        for (char c='0'; c<='9'; ++c) {
            code[c-'0'] = c;
        }

        for (char C='A', c='a'; C<='Z'; ++C,++c) {
            code[c-'a'+36] = c;
            code[C-'A'+10] = C;
        }
    }

    public static String getShortURL(long l) {
        return decTo62(l);
    }

    private static String decTo62(long l) {
        StringBuffer result = new StringBuffer();
        while (l > 0) {
            long m = l / 62;
            long n = l - m * 62;
            result.append(code[(int)n]);
            l = m;
        }
        return result.toString();
    }
}
