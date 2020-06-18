package pl.multithreading.datastucture;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class MyOwnBlockingQueue implements BlockingQueue<String> {

    private boolean blocked;//=false;
    private Queue<String> queue;
    private int size;


    public MyOwnBlockingQueue(int size){
        this.blocked=false;
        this.queue=new ArrayDeque<>(size);
        this.size=size;
    }

    @Override
    public  synchronized void put(String s) throws InterruptedException {
        while(blocked==true || queue.size()>=size){
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        boolean result=this.queue.add(s);
        notifyAll();
    }

    @Override
    public synchronized String take() throws InterruptedException {
        while(blocked==true || queue.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        notifyAll();
        return queue.poll();
    }

    @Override
    public synchronized int size() {
        if(queue==null){return 0;}
        else{
            return queue.size();
        }
    }

    @Override
    public boolean add(String s) {
       throw new UnsupportedOperationException();
    }



    @Override
    public boolean offer(String s) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String poll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String element() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String peek() {
        throw new UnsupportedOperationException();
    }



    @Override
    public boolean offer(String s, long timeout, TimeUnit unit) throws InterruptedException {
        throw new UnsupportedOperationException();
    }



    @Override
    public String poll(long timeout, TimeUnit unit) throws InterruptedException {
        throw new UnsupportedOperationException();
    }

    @Override
    public int remainingCapacity() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }



    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<String> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int drainTo(Collection<? super String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int drainTo(Collection<? super String> c, int maxElements) {
        throw new UnsupportedOperationException();
    }
}
