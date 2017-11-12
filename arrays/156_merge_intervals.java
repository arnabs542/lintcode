/*
Given a collection of intervals, merge all overlapping intervals.

Example
    Given intervals => merged intervals:
    [                     [
      [1, 3],               [1, 6],
      [2, 6],      =>       [8, 10],
      [8, 10],              [15, 18]
      [15, 18]            ]
    ]

Challenge
    O(n log n) time and O(1) extra space.
*/

/*
Thought process
    Sort the interval list by interval start values.
    Two pointers: If current start value is smaller than the end value, compare the end value with the current end value, store the greater one.
                  If current start value is greater than the end value, add interval to the result list and update the start and end value.
    DO NOT forget to add the last interval to the result list.
*/

class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() <= 1) return intervals;
	intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
        /*
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        */
        List<Interval> result = new LinkedList<Interval>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (Interval i : intervals) {
            if (i.start <= end) {
                end = Math.max(end, i.end);
            } else {
                result.add(new Interval(start, end));
                start = i.start;
                end = i.end;
            }
        }
        //add the last interval!
        result.add(new Interval(start, end));
        return result;
    }
}
