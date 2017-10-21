/*
Given two strings, you have to find the missing string.

Example
    Given a string str1 = This is an example
    Given another string str2 = is example
    Return ["This", "an"]
*/

// duplicates do not count towards missing string.
public class Solution {
    public List<String> missingString(String str1, String str2) {
        HashSet<String> set = new HashSet<String>();
        String[] arr1 = str1.split("\\s+");
        String[] arr2 = str2.split("\\s+");
        if(arr1.length < arr2.length) {
            String[] temp = arr1;
            arr1 = arr2;
            arr2 = temp;
        }
        for(String s : arr2) set.add(s);
        List<String> result = new ArrayList<String>();
        for(String s : arr1)
            if(!set.contains(s)) result.add(s);
        return result;
    }
}

// Duplicates count towards missing string, 
// e.g. str1 = "This is is an example", str2 = "is an example", return ["This", "is"].
public class Solution {
    public List<String> missingString(String str1, String str2) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        String[] arr1 = str1.split("\\s+");
        String[] arr2 = str2.split("\\s+");
        if(arr1.length < arr2.length) {
            String[] temp = arr1;
            arr1 = arr2;
            arr2 = temp;
        }
        for(String s : arr2) {
            if(map.containsKey(s))
                map.put(s, map.get(s)+1);
            else 
                map.put(s, 1);
        }
        List<String> result = new ArrayList<String>();
        for(String s : arr1) {
            if(map.containsKey(s)) {
                map.put(s, map.get(s)-1);
                if(map.get(s) < 0) result.add(s);
            } else {
                result.add(s);
            }
        }
        return result;
    }
}