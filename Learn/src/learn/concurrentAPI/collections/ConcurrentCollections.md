### Concurrrent Collections

* _[BlockingQueue](#blockingqueue)_
	* [ArrayBlockingQueue](#arrayblockingqueue)
	* [DelayQueue](#delayqueue)
	* [LinkedBlockingQueue](#linkedblockingqueue)
	* [PriorityBLockingQueue](#priorityblockingqueue)
	* [SynchronousQueue](#synchronousqueue)
	* _[BlockingDeque](#blocingdeque)_
		* [LinkedBlockingDeque](#linkedblockingdeque)
	* _[TransferQueue](#trasferqueue)_
		* [LinkedTrasferQueue](#linkedtrasferqueue)
* _[ConcurrentMap](#concurrentmap)_
	* [ConcurrentHashMap](#concurrenthashmap)
	* _[ConcurrentNavigableMap](#concurrentnavigablemap)_
		* [ConcurrentSkipListMap](#concurrentskiplistmap)
* [ConcurrentLinkedDeque](#concurrentlinkeddeque)
* [ConcurrentLinkedQueue](#concurrentlinkedqueue)
* [ConcurrentSkipListSet](#concurrentskiplistset)
* [CopyOnWriteArrayList](#copyonwritearraylist)
* [CopyOnWriteArraySet](#copyonwritearrayset)


#### _BlockingQueue_
BlockingQueue is interface that represents a queue which is thread safe to put into, and take instances from.
<br>
java doc : BlockingQueue methods come in four forms, with different ways of handling operations that cannot be satisfied immediately, but may be satisfied at some point in the future: one throws an exception, the second returns a special value (either null or false, depending on the operation), the third blocks the current thread indefinitely until the operation can succeed, and the fourth blocks for only a given maximum time limit before giving up. These methods are summarized in the following table:

  X | Throws exception | Special value | Blocks | Times out
--- | ---------------- | ------------- | ------ | ---------
**Insert** | add(e) | 	offer(e) | put(e) | offer(e, time, unit)
**Remove** | remove()	| poll() | take() | poll(time, unit)
**Examine** | element() | peek() | not applicable	| not applicable

#### ArrayBlockingQueue
**Implements** BlockingQueue <br>
**Extends** AbstractQueue <br>
ArrayBlockingQueue is a bounded, blocking queue that stores the elements internally in an array. That it is bounded means that it cannot store unlimited amounts of elements. There is an upper bound on the number of elements it can store at the same time. You set the upper bound at instantiation time, and after that it cannot be changed.

###### It contains three constructors
```java
ArrayBlockingQueue(int capacity);
ArrayBlockingQueue(int capicaty, boolean fair);
ArrayBlockingQueue(int capicaty, boolean fair, Collection<? extends E> c);
```
1. capacity is the fixed size
2. fair if true then queue accesses for threads blocked on insertion or removal, are processed in FIFO order; if false the access order is unspecified.
3. c the collection of elements to initially contain


#### DelayQueue
**Implements** BlockingQueue
**Extends** AbstractQueue
The DelayQueue blocks the elements internally until a certain delay has expired. 
As we can see from the class of DelayQueue it has upper limit of Delayed class for generic element E
The elements for the DelayQueue must implement the interface _java.util.concurrent.Delayed._
```java
public class DelayQueue<E extends Delayed> extends AbstractQueue<E>
    implements BlockingQueue<E> {...
```

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

#### LinkedBlockingQueue
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

#### PriorityBLockingQueue
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

#### SynchronousQueue
**Implements** BlockingQueue
**Extends** AbstractQueue
The SynchronousQueue is a queue that can only contain a single element internally. A thread inseting an element into the queue is blocked until another thread takes that element from the queue. Likewise, if a thread tries to take an element and no element is currently present, that thread is blocked until a thread insert an element into the queue.
From JavaDoc : each insert operation must wait for a corresponding remove operation by another thread, and vice versa.
```java
SynchronousQueue<String> synchronousQueue = new SynchronousQueue<>();
synchronousQueue.put("Someone other Thread is waiting to remove me!");
```

#### _BlockingDeque_
**Extends** BlockingQueue and Deque
BlockingDeque is interface that represents a deuqe which is thread safe to put into, and take instances from both side (head and tail of queue).
<br/>
Java Doc: BlockingDeque methods come in four forms, with different ways of handling operations that cannot be satisfied immediately, but may be satisfied at some point in the future: one throws an exception, the second returns a special value (either null or false, depending on the operation), the third blocks the current thread indefinitely until the operation can succeed, and the fourth blocks for only a given maximum time limit before giving up. These methods are summarized in the following table:


  X | Throws exception | Special value | Blocks | Times out
--- | ---------------- | ------------- | ------ | ---------
**Insert** | addFirst(e) | offerFirst(e) | putFirst(e) | offerFirst(e, time, unit)
**Remove** | removeFirst()	| pollFirst()	| takeFirst()	| pollFirst(time, unit)
**Examine** | getFirst() | peekFirst() | not applicable	| not applicable

  X | Throws exception | Special value | Blocks | Times out
--- | ---------------- | ------------- | ------ | ---------
**Insert** | addLast(e) | 	offerLast(e) | putLast(e) | offerLast(e, time, unit)
**Remove** | removeLast()	| pollLast() | takeLast() | pollLast(time, unit)
**Examine** | getLast() | peekLast() | not applicable	| not applicable

#### LinkedBlockingDeque
**Implements** BlockingDeque
**Extends** AbstractQueue
An optionally-bounded blocking deque based on linked nodes. <br>
The capacity, if unspecified, is equal to Integer.MAX_VALUE. Linked nodes are dynamically created upon each insertion unless this would bring the deque above capacity.

```java
BlockingDeque<String> blockingDeque = new LinkedBlockingDeque<String>();
blockingDeque.add("first");
blockingDeque.addFirst("zero");
System.out.println(blockingDeque.takeLast());
```

#### _TransferQueue_
TransferQueue is interface
> A BlockingQueue in which producers may wait for consumers to receive elements. A TransferQueue may be useful for example in message passing applications in which producers sometimes (using method transfer(E)) await receipt of elements by consumers invoking take or poll, while at other times enqueue elements (via method put) without waiting for receipt.
> - JavaDocs

In other words, when you use BlockingQueue, you can only put element into queue (and block if queue is full). With TransferQueue, you can also block until other thread receives your element (you must use new transfer method for that). This is the difference. With BlockingQueue, you cannot wait until other thread removes your element (only when you use SynchronousQueue, but that isn't really a queue).