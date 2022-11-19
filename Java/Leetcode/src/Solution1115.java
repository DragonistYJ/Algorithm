import java.util.concurrent.Semaphore;

/**
 * @author yujian
 * @since 2022/9/6 10:57
 * 两个不同的线程将会共用一个 FooBar实例：
 * 线程 A 将会调用foo()方法，而
 * 线程 B 将会调用bar()方法
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 */
class FooBar {
    private int n;
    private Semaphore fooSema = new Semaphore(1);
    private Semaphore barSema = new Semaphore(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            fooSema.acquire();
            printFoo.run();
            barSema.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            barSema.acquire();
            printBar.run();
            fooSema.release();
        }
    }
}

public class Solution1115 {
    public static void main(String[] args) {
        FooBar fooBar = new FooBar(5);
        Thread thread1 = new Thread(() -> {
            try {
                fooBar.foo(() -> System.out.println("foo"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                fooBar.bar(() -> System.out.println("bar"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread2.start();
        thread1.start();
    }
}
