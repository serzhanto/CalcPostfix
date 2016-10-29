/**
 * Created by Oleg Serzhant on 15.10.2016.
 */
public class Stack<T> {
    private int maxSize;
    private T[] stackArray;
    private int top;

    public Stack(int s) {
        maxSize = s;
        top = -1;
        stackArray = (T[])(new Object[maxSize]);
    }

    public void push(T j) {
        stackArray[++top] = j;
    }

    public T pop() {
        return stackArray[top--];
    }

    public T peek() {
        return stackArray[top];
    }

    public boolean isEmpty()  // true, если стек пуст
    {
        return (top == -1);
    }

    public int size()         // Текущий размер стека
    {
        return top + 1;
    }

    public T peekN(int n)  // Чтение элемента с индексом n
    {
        return stackArray[n];
    }

    public void displayStack(String s) {
        System.out.print(s);
        System.out.print("Stack (bottom-->top): ");
        for (int j = 0; j < size(); j++) {
            System.out.print(peekN(j));
            System.out.print(' ');
        }
        System.out.println("");
    }
}
