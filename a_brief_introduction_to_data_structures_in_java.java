/*
Arrays
An array is a container object that holds a fixed number of values of a single type. After an array is created, its length is fixed and cannot be changed.
*/

// declare an array of various data types
int[] arrInt;
byte[] arrByte;
short[] arrShort;
long[] arrLong;
float[] arrFloat;
double[] arrDouble;
boolean[] arrBool;
char[] arrChar;
String[] arrString;

// instantiate an array of integers with the new operator
arrInt = new int[100];

// initialize an array
arrInt[0] = 1;        // initialize the first element
arrInt[1] = 2;        // initialize the second element

// declare, create and initialize an array all together
int[] arrInt = new int[5];
int[] arrInt = new int[]{1,2,3,4,5};
int[] arrInt = {1,2,3,4,5};

// access to a value by its index in the array
arrInt[0];        // get the first element
arrInt[1];        // get the second element

// methods in java.util.Arrays class

// sort arrInt in ascending order 
Arrays.sort(arrInt);
// sort arrInt by a index range: [0,5)
Arrays.sort(arrInt, 0, 5);

// find the index of 10 in arrInt using binary search algorithm
// notice the input array must be sorted in ascending order
// if the array contains multiple elements with the specified value, there is no guarantee which one will be found
// if the specified value is not found, return a negative number
Arrays.binarySearch(arrInt, 10);

// convert an array to string
// suppose arrInt is [1,2,3], the following line will convert arrInt to "[1, 2, 3]"
Arrays.toString(arrInt);

// copy the specified array and length
// truncate if given length is smaller than array length
// pad with 0s if given length is larger than array length
Arrays.copyOf(arrInt, 3); 
// copy subarray given start and end indices: [1,5)
Arrays.copyOfRange(arrInt, 1, 5);

// fill an array with specified value
Arrays.fill(arrInt, 10);
// fill subarray with specified value, provided the start and end indices: [1,5)
Arrays.fill(arrInt, 1, 5, 10);

// convert an array to a list
// the list points to the original array
List<Integer> list = Arrays.asList(arrInt);

// check equality of two arrays, return true if a and b have the same number of elements and each pair of elements are equal
Arrays.equals(a, b);



/*
Strings
A string is an object that represents a sequence of char values.
String is immutable.
*/

// create a string by converting a char array
char[] c = {'a', 'b', 'c', 'd'};
String s = new String(c);
// create a string by new keyword
String s = new String("abc");
// create a string by string literal
String s = "abc";

// String methods
str.length()                              // length of the string str
str.concat(str1)                          // concatenate two strings
str + str1                                // equivalent to .concat() method but even simple
str.charAt(i)                             // character at index i
str.toCharArray()                         // convert a string to char array
str.equals(str1)                          // compare two strings
str.equalsIgnoreCase                      // compare two strings, case insensitive
str.indexOf('a')                          // returns the index within this string of the first occurrence of the specified character 
str.indexOf('a', i)                       // same but search from index i
str.indexOf("abc")                        // returns the index within this string of the first occurrence of the specified substring
str.indexOf("abc", i)                     // same but search from index i
str.lastIndexOf('a') 
str.lastIndexOf('a', i)
str.lastIndexOf("abc")
str.lastIndexOf("abc", i)
str.replace(oldChar, newChar)             // replace the old char with new char
str.replaceAll(oldStr, newStr)            // replace the old substring with new substring
str.replaceFirst(oldStr, newStr)          // replace the first substring with new substring
str.split(",")                            // split string to an array of strings with a certain delimiter
str.substring(1,5)                        // return substring from index [1,5)
str.toLowerCase()
str.toUpperCase()
str.trim()                                // remove leading and trailing spaces
// java.lang.String method
String.valueOf(123)                       // convert a primitive data type to string


/*
StringBuffer: a thread-safe mutable sequence of characters
StringBuilder: same to StringBuffer but not thread-safe
*/

sb.append(e)                              // append e at the end
sb.charAt(i)                              // return character at position i
sb.deleteCharAt(i)                        // remove character at position i
sb.setCharAt(i, c)                        // set character at position i to c 
sb.delete(i, j)                           // remove sub string with index range [i,j)
sb.length()                                 // return the number of elements
sb.indexOf(e)                             // return the index of the first occurence of e
sb.indexOf(e, i)                          // return the index of the first occurence of e, starting from position i
sb.lastIndexOf(e)                         // return the index of the last occurence of e
sb.lastIndexOf(e, i)                      // ?
sb.insert(i, e)                           // insert e at position i
sb.reverse()                              // reverse the string buffer
sb.replace(i, j, str)                     // replace a substring [i,j) in sb with str
sb.toString()                             // convert sb to string
sb.substring(i)                           // return a new string that contains a substring starting from position i
sb.substring(i, j)                        // return a new string that contains a substring with range [i, j)




/*
ArrayList
Resizable array
*/

// methods
aList.add(e)                              // append e to the end of the list
aList.add(i, e)                           // insert e at position i
aList.addAll(Collection)                  // append all of the elements in the specified collection to the end of the list
aList.addAll(i, Collection)               // append all of the elements at position i
aList.clear()                             // remove all of the elements
aList.contains(e)                         // return true if the list contains e
aList.get(i)                              // return the element at position i
aList.indexOf(e)                          // return the index of the first occurence of e
aList.isEmpty()                           // return true if the list is empty
aList.lastIndexOf(e)                      // return the index of the last occurence of e
aList.remove(i)                           // remove the element at position i
aList.remove(obj e)                       // remove the first occurence of obj e, e.g. aList.remove(new Integer(1))
aList.removeAll(Collection)               // remove from the list all of its elements that are contained in the specified collection
aList.set(i, e)                           // replace element at position i with e
aList.size()                              // return the number of elements in the list
aList.subList(i, j)                       // return a sub list with index range [i, j)
aList.toArray()                           // convert the array list to array




/*
Stack
LIFO linked list
*/

// create a new stack
Stack<Integer> s = new Stack<Integer>();

// methods
s.push(e)                                 // push an item e onto the top of stack s
s.pop()                                   // remove the object at the top and return the object
s.peek()                                  // retrieve the object at the top without removing it
s.isEmpty()                               // return true if s is empty
s.size()                                  // return the number of elements in s
s.search(e)                               // return 1-based position from the top of s where e is located




/*
Queue
FIFO linked list
*/

// create a new queue
Queue<Integer> q = new LinkedList<Integer>();

// methods
q.add(e)                                   // insert e into the queue, return true upon success, otherwise throw an exception
q.offer(e)                                 // insert e into the queue, otherwise return false
q.remove()                                 // remove the head of q and return the object, throw an exception when q is empty
q.poll()                                   // remove the head of q and return the object, return null when q is empty
q.element()                                // retrieve the head of q wihtout removing it, otherwise throw an exception
q.peek()                                   // retrieve the head of q without removing it, otherwise return null




/*
Deque
Double ended queue
*/

deq.addFirst(e)                            // insert e at the front of deq, throw an exception upon error
deq.offerFirst(e)                          // insert e at the front of deq, return false upon error
deq.removeFirst()                          // q.remove()
deq.pollFirst()                            // q.poll()
deq.getFirst()                             // q.element()
deq.peekFirst()                            // q.peek()
deq.addLast(e)                             // q.add(e)
deq.offerLast(e)                           // q.offer(e)
deq.removeLast()                           // remove the last element in deq, throw an exception upon error
deq.pollLast()                             // remove the last element in deq, return null upon error
deq.getLast()                              // retrieve the last element of deq, throw an exception upon error
deq.peekLast()                             // retrieve the last element of deq, return null upon error





/*
HashMap
Hash table with key - value pair
*/

// create a new HashMap
HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

// methods
map.put(key, value)                        // associate the specified value with the specified key in this map
map.get(key)                               // returns the value to which the specified key is mapped
map.remove(key)                            // remove the mapping for the specified key from map
map.size()                                 // return the number of key-value mappings in map
map.values()                               // return a Collection of the values contained in map
map.keySet()                               // return a Set of the keys contained in map
map.isEmpty()                              // return true if map contains no key-value mappings
map.containsKey(key)                       // return true if map contains a mapping for the specified key
map.containsValue(value)                   // return true if map maps one or more keys to the specified value
map.clear()                                // remove all of the mappings from map





/*
Binary Tree
A tree data structure in which each node has at most two children, which are referred to as the left and the right child.

Types of binary trees:
    1) A full binary tree: a binary tree in which every node in the tree has either 0 or 2 children.
    2) A perfect binary tree: a binary tree in which all interior nodes have two children and all leaves have the same depth or same level.
    3) A complete binary tree: a binary tree in which every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible.
*/
