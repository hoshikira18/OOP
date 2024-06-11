/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class QueueArray<T> {

    T[] data;
    int front = -1;
    int back = -1;
    int size = 0;
    int cap;

    public QueueArray(int cap) {
        this.cap = cap;
        this.data = (T[]) new Object[cap];
    }

    public boolean isFull() {
        return this.size == this.cap;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void enQueue(T data) {
        if (this.isFull()) {
            System.out.println("Queue is full!");
            return;
        }

        if (this.front == -1) {
            this.front = 0;
            this.back = 0;
            this.data[0] = data;
            this.size++;
            return;
        }
        if (this.size == 0) {
            this.front = (this.front + 1) % this.cap;

        }
        this.back = (this.back + 1) % this.cap;
        this.data[this.back] = data;
        this.size++;

    }

    public void clear() {
        T data[];
        this.front = -1;
        this.back = -1;
        this.size = 0;
    }

    public T deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        if (this.size == 1) {
            T value = this.data[this.front];
            this.clear();
            return value;
        }

        T value = this.data[this.front];
        this.data[this.front] = null;
        this.front = (this.front + 1) % this.cap;
        this.size--;
        return value;
    }

    public T pick() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        return this.data[this.front];
    }

    public void traverse() {
        for (int i = 0; i < this.size; i++) {
            System.out.print(this.data[(this.front + i) % this.cap] + " ");
        }
        System.out.println("");
    }


}
