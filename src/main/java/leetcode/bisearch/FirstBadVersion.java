package leetcode.bisearch;

/**
 * @author lijt
 */
public class FirstBadVersion extends VersionControl {
    public int firstBadVersion(int n) {

        int left = 1;
        int right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (!isBadVersion(mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}

class VersionControl {
    boolean isBadVersion(int version) {
        return false;
    }
}
