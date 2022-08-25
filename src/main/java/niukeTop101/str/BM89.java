package niukeTop101.str;

import java.util.ArrayList;

public class BM89 {

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return new ArrayList<>();
        }

        intervals.sort((o1, o2) -> {
            if (o1.start == o2.start) {
                return o1.end - o2.end;
            } else {
                return o1.start - o2.start;
            }
        });
        ArrayList<Interval> mergeRes = new ArrayList<>();
        mergeRes.add(intervals.get(0));
        int count = 0;
        for (int i = 1; i < intervals.size(); i++) {
            Interval interval = mergeRes.get(count);
            Interval tempInterval = intervals.get(i);
            // 前的起始节点大于后的结束节点，那么必定是不会又重叠的
            if (interval.end < tempInterval.start) {
                count ++;
                mergeRes.add(tempInterval);
            } else {
                if (interval.end < tempInterval.end) {
                    interval.end = tempInterval.end;
                }
            }
        }

        return mergeRes;
    }

    public static void main(String[] args) {
        BM89 bm89 = new BM89();
        ArrayList<Interval> arrayList = new ArrayList<>();
        Interval interval = new Interval(0, 2);
        arrayList.add(interval);
        Interval interval1 = new Interval(1, 4);
        arrayList.add(interval1);
        ArrayList<Interval> res = bm89.merge(arrayList);

    }
}


class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
