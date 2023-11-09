package niukeTop101.search;

public class BM22ComparativeVersionNumber {


    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 比较版本号
     * @param version1 string字符串
     * @param version2 string字符串
     * @return int整型
     */
    public int compare (String version1, String version2) {
        // write code here
        int version1Index = 0;
        int version2Index = 0;
        while (version1Index < version1.length() || version2Index < version2.length()) {

            long num1 = 0;
            while (version1Index < version1.length() && version1.charAt(version1Index) != '.') {
                num1 = num1 * 10 + (version1.charAt(version1Index) - '0');
                version1Index++;
            }
            version1Index++;
            long num2 = 0;
            while (version2Index < version2.length() && version2.charAt(version2Index) != '.') {
                num2 = num2 * 10 + (version2.charAt(version2Index) - '0');
                version2Index++;
            }
            version2Index++;

            if (num1 < num2) {
                return -1;
            } else if (num1 > num2) {
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        BM22ComparativeVersionNumber versionNumber = new BM22ComparativeVersionNumber();
        String version1 = "1.1";
        String version2 = "2.1";
        System.out.println(versionNumber.compare(version1, version2));

        version2 = "1.01";
        System.out.println(versionNumber.compare(version1, version2));

        version2 = "1.1.1";
        System.out.println(versionNumber.compare(version1, version2));

        version1 = "2.0.1";
        version2 = "2";
        System.out.println(versionNumber.compare(version1, version2));

        version1 = "0.226";
        version2 = "0.36";
        System.out.println(versionNumber.compare(version1, version2));
    }
}
