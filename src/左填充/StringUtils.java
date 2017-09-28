package 左填充;

public class StringUtils {
    /**
     * @param originalStr: the string we want to append to with spaces
     * @param size:        the target length of the string
     * @return: A string
     */
    static public String leftPad(String originalStr, int size) {
        return leftPad(originalStr, size, ' ');
    }

    /*
     * @param originalStr: the string we want to append to
     * @param size: the target length of the string
     * @param padChar: the character to pad to the left side of the string
     * @return: A string
     */
    static public String leftPad(String originalStr, int size, char padChar) {
        int over = size - originalStr.length();
        StringBuilder stringBuilder = new StringBuilder();
        if (size <= 0) {
            return "";
        }
        if (over > 0) {
            for (int i = 0; i < over; i++) {
                stringBuilder.append(padChar);
            }
            stringBuilder.append(originalStr);
            return stringBuilder.toString();
        }
        return originalStr;
    }
}
