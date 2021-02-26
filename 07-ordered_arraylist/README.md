# OrderedArrayList
Assignment 26 for APCS with Mr. K

__Discussion__
* Each part will be written in it's own class file

* __NoNullArrayList<T>__
  * Should call `super()` frequently
  * Before calling `super()`, check whether or not the passed element is `null`
* __OrderedArrayList<T>__
  * Will also call `super()` frequently
  * After adding or setting a value, the ArrayList must be sorted
  * Should use the `.compareTo()` function to determine if two elements are in order or not
  * I will implement bubble sort here because it is the easiest one to implement even though it's runtime is `O(N^2)`