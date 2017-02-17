import java.util.*;

/**
 * Created by YSZ on 2017/2/16.
 */
public class InsertInterval {
    public class Interval {
        int start;
        int end;
        Interval() {start = 0; end = 0;}
        Interval(int s, int e) {start = s; end = e;}
    }

    public List<Interval> insertInterval1(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new ArrayList<Interval>();
        int idx = 0;
        while (idx< intervals.size() && intervals.get(idx).end < newInterval.start) {
            res.add(intervals.get(idx++));
        }
        while (idx < intervals.size() && intervals.get(idx).start <= newInterval.end) {
            newInterval = new Interval(
                    Math.min(newInterval.start, intervals.get(idx).start),
                    Math.max(newInterval.end, intervals.get(idx++).end)
            );
        }
        res.add(newInterval);
        while (idx < intervals.size()) {
            res.add(intervals.get(idx++));
        }
        return res;
    }

    public List<Interval> insertInterval2(List<Interval> intervals, Interval newInterval) {
        intervals.add(newInterval);
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        for (int i = 0; i < intervals.size() - 1; i++) {
            if (intervals.get(i).end < intervals.get(i + 1).start) continue;
            intervals.get(i).end = Math.max(intervals.get(i).end, intervals.get(i+1).end);
            intervals.remove(i+1);
            i--;
        }
        return intervals;
    }

    public static void main(String[] arg) {

    }
}

