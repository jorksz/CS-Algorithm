package leetcode.character;

public class LongPressedName {

    /**
     * 双指针，定义nameIndex, typedIndex, 遍历两个字符串，判断index位置的字符是否相等
     * 分3种情况， 第一种，字符相同，两个指针+1
     * 第二种，字符不相同，导致的原因可能是出现“长按”情况，这时候需要判断typed前后的字符是否相同，相同typed index + 1
     * 第三种，也就是不包括的情况了，这时候直接返回false即可。
     */
    public boolean isLongPressedName(String name, String typed) {
        if (name == null || name.length() == 0) {
            return true;
        }
        int nameIndex = 0;
        int typedIndex = 0;
        while (typedIndex < typed.length()) {
            if ( nameIndex < name.length() && name.charAt(nameIndex) == typed.charAt(typedIndex)) {
                nameIndex++;
                typedIndex++;
            } else if (typedIndex > 0 && typed.charAt(typedIndex) == typed.charAt(typedIndex - 1)) {
                typedIndex++;
            }
            else return false;
        }
        return nameIndex == name.length();
    }

    public static void main(String[] args) {
        LongPressedName longPressedName = new LongPressedName();
        System.out.println(longPressedName.isLongPressedName("alex", "aaleex"));
    }
}
