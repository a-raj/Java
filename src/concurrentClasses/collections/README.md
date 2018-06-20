# Concurrent Collections

* _[BlockingQueue](#blockingqueue)_
  * [ArrayBlockingQueue](#arrayblockingqueue)
  * [DelayQueue](#delayqueue)
  * [LinkedBlockingQueue](#linkedblockingqueue)
  * [PriorityBlockingQueue](#priorityblockingqueue)
  * [SynchronousQueue](#synchronousqueue)
  * _[BlockingDeque](#blocingdeque)_
    * [LinkedBlockingDeque](#linkedblockingdeque)
    * _[TransferQueue](#transferqueue)_
    * [LinkedTrasferQueue](#linkedtrasferqueue)
* _[ConcurrentMap](#concurrentmap)_
  * [ConcurrentHashMap](#concurrenthashmap)
  * _[ConcurrentNavigableMap](#concurrentnavigablemap)_
    * [ConcurrentSkipListMap](#concurrentskiplistmap)
* [ConcurrentSkipListSet](#concurrentskiplistset)
* [ConcurrentLinkedDeque](#concurrentlinkeddeque)
* [ConcurrentLinkedQueue](#concurrentlinkedqueue)
* [CopyOnWriteArrayList](#copyonwritearraylist)
* [CopyOnWriteArraySet](#copyonwritearrayset)

## _BlockingQueue_

BlockingQueue is interface that represents a queue which is thread safe to put into, and take instances from.  
> BlockingQueue methods come in four forms, with different ways of handling operations that cannot be satisfied immediately, but may be satisfied at some point in the future: one throws an exception, the second returns a special value (either null or false, depending on the operation), the third blocks the current thread indefinitely until the operation can succeed, and the fourth blocks for only a given maximum time limit before giving up. These methods are summarized in the following table:

  X | Throws exception | Special value | Blocks | Times out
--- | ---------------- | ------------- | ------ | ---------
**Insert** | add(e) | offer(e) | put(e) | offer(e, time, unit)
**Remove** | remove() | poll() | take() | poll(time, unit)
**Examine** | element() | peek() | not applicable | not applicable

## ArrayBlockingQueue

**Implements** BlockingQueue  
**Extends** AbstractQueue  
ArrayBlockingQueue is a bounded, blocking queue that stores the elements internally in an array. That it is bounded means that it cannot store unlimited amounts of elements. There is an upper bound on the number of elements it can store at the same time. You set the upper bound at instantiation time, and after that it cannot be changed.

It contains three constructors

```java
ArrayBlockingQueue(int capacity);
ArrayBlockingQueue(int capicaty, boolean fair);
ArrayBlockingQueue(int capicaty, boolean fair, Collection<? extends E> c);
```

1. Capacity is the fixed size
1. Fair if true then queue accesses for concurrentClasses.threads blocked on insertion or removal, are processed in FIFO order; if false the access order is unspecified.
1. C the collection of elements to initially contain

## DelayQueue

**Implements** BlockingQueue  
**Extends** AbstractQueue  
The DelayQueue (unbounded) blocks the elements internally until a certain delay has expired.  
As we can see from the class of DelayQueue it has upper limit of Delayed class for generic element E
The elements for the DelayQueue must implement the interface _java.util.concurrent.Delayed._

```java
public class DelayQueue<E extends Delayed> extends AbstractQueue<E>
    implements BlockingQueue<E> {...
```

The value returned by the getDelay() method should be the delay remaining before this element can be released. If 0 or a negative value is returned, the delay will be considered expired, and the element released at the next take() etc. call on the DelayQueue.  
Example

```java
class DelayElement implements Delayed{
	private String date;
	private long startTime;
	
	public DelayElement(String date, long startTime) {
		this.date = date;
		this.startTime = startTime;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		long diff = startTime - System.currentTimeMillis();
		return unit.convert(diff, TimeUnit.MILLISECONDS);
	}

	@Override
	public int compareTo(Delayed o) {
		if(this.startTime < ((DelayElement) o).startTime){
			return -1;
		}
		if(this.startTime > ((DelayElement) o).startTime){
			return 1;
		}
		return 0;
	}
}


DelayQueue<Delayed> delayQueue = new DelayQueue<>();
Delayed delayElement1 = new DelayElement(UUID.randomUUID().toString(), 1000L);
delayQueue.put(delayElement1);
Delayed element2 = delayQueue.take();
```

## LinkedBlockingQueue

**Implements** BlockingQueue  
**Extends** AbstractQueue  
The LinkedBlockingQueue keeps the elements internally in a linked structure (linked nodes). This linked structure can optionally have an upper bound if desired. If no upper bound is specified, Integer.MAX_VALUE is used as the upper bound.  

The LinkedBlockingQueue stores the elements internally in FIFO.

```java
BlockingQueue<String> unbounded = new LinkedBlockingQueue<String>();
BlockingQueue<String> bounded   = new LinkedBlockingQueue<String>(1024);

bounded.put("Value");

String value = bounded.take();
```

## PriorityBlockingQueue

**Implements** BlockingQueue  
**Extends** AbstractQueue  
The PriorityBlockingQueue is an unbounded concurrent queue. It uses the same ordering rules as the java.util.PriorityQueue class. You cannot insert null into this queue.

All elements inserted into the PriorityBlockingQueue must implement the java.lang.Comparable interface. The elements thus order themselves according to whatever priority you decide in your Comparable implementation.
Same as java.util.PriorityQueue

```java
BlockingQueue<String> priorityBlockingQueue = new PriorityBlockingQueue<>(10);
priorityBlockingQueue.put("TEST");
BlockingQueue<String> priorityBlockingQueue = new PriorityBlockingQueue<>(10, someComparator);
```

## SynchronousQueue

**Implements** BlockingQueue  
**Extends** AbstractQueue  
The SynchronousQueue is a queue that can only contain a single element internally. A thread inseting an element into the queue is blocked until another thread takes that element from the queue. Likewise, if a thread tries to take an element and no element is currently present, that thread is blocked until a thread insert an element into the queue.  
From JavaDoc : each insert operation must wait for a corresponding remove operation by another thread, and vice versa.

```java
SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();
synchronousQueue.put("Someone other Thread is waiting to remove me!");
```

## _BlockingDeque_

**Extends** BlockingQueue and Deque  
BlockingDeque is interface that represents a deuqe which is thread safe to put into, and take instances from both side (head and tail of queue).  
>BlockingDeque methods come in four forms, with different ways of handling operations that cannot be satisfied immediately, but may be satisfied at some point in the future: one throws an exception, the second returns a special value (either null or false, depending on the operation), the third blocks the current thread indefinitely until the operation can succeed, and the fourth blocks for only a given maximum time limit before giving up. These methods are summarized in the following table:

  X | Throws exception | Special value | Blocks | Times out
--- | ---------------- | ------------- | ------ | ---------
**Insert** | addFirst(e) | offerFirst(e) | putFirst(e) | offerFirst(e, time, unit)
**Remove** | removeFirst() | pollFirst() | takeFirst() | pollFirst(time, unit)
**Examine** | getFirst() | peekFirst() | not applicable| not applicable

  X | Throws exception | Special value | Blocks | Times out
--- | ---------------- | ------------- | ------ | ---------
**Insert** | addLast(e) |offerLast(e) | putLast(e) | offerLast(e, time, unit)
**Remove** | removeLast() | pollLast() | takeLast() | pollLast(time, unit)
**Examine** | getLast() | peekLast() | not applicable | not applicable

## LinkedBlockingDeque

**Implements** BlockingDeque  
**Extends** AbstractQueue  
An optionally-bounded blocking deque based on linked nodes.  
The capacity, if unspecified, is equal to Integer.MAX_VALUE. Linked nodes are dynamically created upon each insertion unless this would bring the deque above capacity.

```java
BlockingDeque<String> blockingDeque = new LinkedBlockingDeque<String>();
blockingDeque.add("first");
blockingDeque.addFirst("zero");
System.out.println(blockingDeque.takeLast());
```

## _TransferQueue_

**Extends** BlockingQueue  
TransferQueue is an interface.
> A BlockingQueue in which producers may wait for consumers to receive elements. A TransferQueue may be useful for example in message passing applications in which producers sometimes (using method transfer(E)) await receipt of elements by consumers invoking take or poll, while at other times enqueue elements (via method put) without waiting for receipt.

In other words, when you use BlockingQueue, you can only put element into queue (and block if queue is full). With TransferQueue, you can also block until other thread receives your element (you must use new transfer method for that). This is the difference. With BlockingQueue, you cannot wait until other thread removes your element (only when you use SynchronousQueue, but that isn't really a queue).

Default methods:

* **getWaitingConsumerCount​()** : Returns an estimate of the number of consumers waiting to receive elements via BlockingQueue.take() or timed poll.
* **hasWaitingConsumer​()** : Returns true if there is at least one consumer waiting to receive an element via BlockingQueue.take() or timed poll.
* **transfer​(E e)** : Transfers the element to a consumer, waiting if necessary to do so.
* **tryTransfer​(E e, long timeout, TimeUnit unit)** : Transfers the element to a consumer if it is possible to do so before the timeout elapses

## LinkedTrasferQueue

**Implements** TransferQueue  
**Extends** AbstractQueue  
LinkedTrasferQueue is the only implementation class of TrasferQueue
An unbounded TransferQueue based on linked nodes. This queue orders elements FIFO.
> The size method is NOT a constant-time operation. Because of the asynchronous nature of these queues, determining the current number of elements requires a traversal of the elements, and so may report inaccurate results if this collection is modified during traversal. Additionally, the bulk operations addAll, removeAll, retainAll, containsAll, equals, and toArray are not guaranteed to be performed atomically. For example, an iterator operating concurrently with an addAll operation might view only some of the added elements.

```java
String s1 = "Transfer 1";
TransferQueue<String> transferQueue = new LinkedTransferQueue<>();
transferQueue.add(s1);
transferQueue.transfer(s1);
```

## ConcurrentMap

> A Map providing thread safety and atomicity guarantees.  
ConcurrentMap cannot contain null values and get() returning null unambiguously means the key is absent.

Followings default methods are added in Java 8  

* **forEach(BiConsumer<? super K,? super V> action)** : Performs the given action for each entry in this map until all entries have been processed or the action throws an exception.

* **compute(K key, BiFunction<? super K,? super V,? extends V> remappingFunction)** : Attempts to compute a mapping for the specified key and its current mapped value (or null if there is no current mapping).

* **computeIfAbsent(K key, Function<? super K,? extends V> mappingFunction)** : If the specified key is not already associated with a value (or is mapped to null), attempts to compute its value using the given mapping function and enters it into this map unless null.

* **computeIfPresent(K key, BiFunction<? super K,? super V,? extends V> remappingFunction)** : If the value for the specified key is present and non-null, attempts to compute a new mapping given the key and its current mapped value.

* **getOrDefault(Object key, V defaultValue)** : Returns the value to which the specified key is mapped, or defaultValue if this map contains no mapping for the key.

* **merge(K key, V value, BiFunction<? super V,? super V,? extends V> remappingFunction)** : If the specified key is not already associated with a value or is associated with null, associates it with the given non-null value.

* **replaceAll(BiFunction<? super K,? super V,? extends V> function)** : 	Replaces each entry's value with the result of invoking the given function on that entry until all entries have been processed or the function throws an exception.

## ConcurrentHashMap

**Implements** ConcurrentMap  
**Extends** AbstractMap  
The ConcurrentHashMap is very similar to the java.util.HashTable class, except that ConcurrentHashMap offers better concurrency than HashTable does. ConcurrentHashMap does not lock the Map while you are reading from it. Additionally, ConcurrentHashMap does not lock the entire Map when writing to it. It only locks the part of the Map that is being written to, internally.  
Methods like size, isEmpty, and containsValue are typically useful only when a map is not undergoing concurrent updates in other concurrentClasses.threads. Otherwise the results of these methods reflect transient states.  

One Important contructor  
**ConcurrentHashMap(int initialCapacity, float loadFactor, int concurrencyLevel)**  
Creates a new, empty map with an initial table size based on the given number of elements (initialCapacity), table density (loadFactor), and number of concurrently updating concurrentClasses.threads (concurrencyLevel).  Initial capacity parameter and concurrency level parameters of ConcurrentHashMap constructor are set to 16 by default.  
  
Thus, instead of a map wide lock, ConcurrentHashMap maintains  a list of 16 locks by default (number of locks equal to the initial capacity , which is by default  16) each of which is used to lock on a single bucket of the Map. This indicates that 16 threads (number of threads equal to the concurrency level, which is by  default 16) can modify the collection at the same time, given, each thread works on different bucket. So unlike hashtable, we perform any sort of operation ( update, delete, read, create) without locking on entire map in ConcurrentHashMap.

```java
ConcurrentMap<String, Integer> concurrentHashMap = new ConcurrentHashMap<>();
concurrentHashMap.put("One", 1);
concurrentHashMap.putIfAbsent("Two", 2);
```

## _ConcurrentNavigableMap_

**Extends** ConcurrentMap, NavigableMap  
> The java.util.concurrent.ConcurrentNavigableMap class is a java.util.NavigableMap with support for concurrent access, and which has concurrent access enabled for its submaps. The "submaps" are the collections.maps returned by various methods like headMap(), subMap() and tailMap().  

## ConcurrentSkipListMap

**Implements** ConcurrentNavigableMap  
**Extends** AbstractMap  
> A scalable concurrent ConcurrentNavigableMap implementation. The map is sorted according to the natural ordering of its keys, or by a Comparator provided at map creation time, depending on which constructor is used.  
The size method is not a constant-time operation. Because of the asynchronous nature of these collections.maps, determining the current number of elements requires a traversal of the elements, and so may report inaccurate results if this collection is modified during traversal. Additionally, the bulk operations putAll, equals, toArray, containsValue, and clear are not guaranteed to be performed atomically.  

ConcurrencyLevel constructor is also available

```java
ConcurrentNavigableMap<String, Integer> concurrentNavigableMap = new ConcurrentSkipListMap<>();
concurrentNavigableMap.put("One", 1);
concurrentNavigableMap.put("Two", 2);
```

ConcurrentSkipListSet and ConcurrentSkipListMap are useful when you need a sorted container that will be accessed by multiple concurrentClasses.threads. These are essentially the equivalents of TreeMap and TreeSet for concurrent code.

The implementation for JDK 6 is based on High Performance Dynamic Lock-Free Hash Tables and List-Based Sets by Maged Michael at IBM, which shows that you can implement a lot of operations on skip lists atomically using compare and swap (CAS) operations. These are lock-free, so you don't have to worry about the overhead of synchronized (for most operations) when you use these classes.

## ConcurrentSkipListSet

It is implementd using ConncurrentSkipListMap. It contain a single instance varibale and that is ConncurrentSkipListMap.

## ConcurrentLinkedDeque  

**Implements** Dequqe  
> An unbounded concurrent deque based on linked nodes.  
Iterators and spliterators are weakly consistent.

## ConcurrentLinkedQueue  

## CopyOnWriteArrayList

> As name suggest CopyOnWriteArrayList creates copy of underlying
> ArrayList with every mutation operation e.g. add or set. Normally
> CopyOnWriteArrayList is very expensive because it involves costly
> Array copy with every write operation but **its very efficient if you
> have a List where Iteration outnumber mutation** e.g. you mostly need to
> iterate the ArrayList and don't modify it too often.  
>
> **Iterator of CopyOnWriteArrayList is fail-safe and doesn't throw
> ConcurrentModificationException** even if underlying
> CopyOnWriteArrayList is modified once Iteration begins because
> Iterator is operating on separate copy of ArrayList. Consequently all
> the updates made on CopyOnWriteArrayList is not available to Iterator.

To get the most updated version do a new read like `list.iterator();`

That being said, updating this collection alot will kill performance. If you tried to sort a CopyOnWriteArrayList you'll see the list throws an UsupportedOperationException (the sort invokes set on the collection N times). You should only use this read when you are doing upwards of 90+% reads.
StackOverFlow

## CopyOnWriteArraySet

A Set that uses an internal CopyOnWriteArrayList for all of its operations. Thus, it shares the same basic properties:

* It is best suited for applications in which set sizes generally stay small, read-only operations vastly outnumber mutative operations, and you need to prevent interference among concurrentClasses.threads during traversal.
* It is thread-safe.
* Mutative operations (add, set, remove, etc.) are expensive since they usually entail copying the entire underlying array.
* Iterators do not support the mutative remove operation.
* Traversal via iterators is fast and cannot encounter interference from other concurrentClasses.threads. Iterators rely on unchanging snapshots of the array at the time the iterators were constructed.
