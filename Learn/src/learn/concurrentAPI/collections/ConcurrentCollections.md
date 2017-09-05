### Concurrrent Collections

* _[BlockingQueue](#blockingqueue)_
	* [ArrayBlockingQueue](#arrayblockingqueue)
	* [DelayQueue](#delayqueue)
	* [PriorityBLockingQueue](#priorityblockingqueue)
	* [SynchronousQueue](#synchronousqueue)
	* _[BlockingDeque](blocingdeque)_
		* [LinkedBlockingQueue](#linkedblockingqueue)
	* _[TrasferQueue](#trasferqueue)_
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


#### BlockingQueue
BlockingQueue is interface that represents a queue which is thread safe to put into, and take instances from.


#### ArrayBlockingQueue
**Implements** BlockingQueue
**Extends** AbstractQueue
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

