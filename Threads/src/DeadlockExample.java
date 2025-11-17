class A {
    synchronized void methodA(B b) {
        System.out.println("Thread 1: Entered A.methodA");
        b.last();
    }

    synchronized void last() {
        System.out.println("Inside A.last");
    }
}

class B {
    synchronized void methodB(A a) {
        System.out.println("Thread 2: Entered B.methodB");
        a.last();
    }

    synchronized void last() {
        System.out.println("Inside B.last");
    }
}

public class DeadlockExample {
    public static void main(String[] args) {
        A a = new A();
        B b = new B();

        Thread t1 = new Thread(() -> a.methodA(b));
        Thread t2 = new Thread(() -> b.methodB(a));

        t1.start();
        t2.start();
    }
}
