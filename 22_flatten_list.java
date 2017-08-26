/*
Given a list, each element in the list can be a list or integer. flatten it into a simply list with integers.

Notice
If the element in the given list is a list, it can contain list too.

Example
Given [1,2,[1,2]], return [1,2,1,2].
Given [4,[3,[2,[1]]]], return [4,3,2,1].
*/

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

public class Solution {
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        if(nestedList == null) return null;
        if(nestedList.size() == 0) return [];
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(NestedInteger i : nestedList) {
            if(i.isInteger()) {
                result.add(i.getInteger());
            } else {
                result.addAll(flatten(i.getList()));
            }
        }
        return result;
    }
}
