package singlton;

class SingletonEger {
    private static SingletonEger instance = new SingletonEger();

    private SingletonEger() {
    }

    public static SingletonEger getIntance() {
        return instance;
    }
}

class SingletonLazy {
    private static SingletonLazy instance;

    private SingletonLazy() {
    }

    public static SingletonLazy getIntance() {
        if (instance == null) {
            instance = new SingletonLazy();
        }
        return instance;
    }
}

class SingletonSynchronized {
    private static SingletonSynchronized instance;

    private SingletonSynchronized() {
    }

    public static synchronized SingletonSynchronized getIntance() {
        if (instance == null) {
            instance = new SingletonSynchronized();
        }
        return instance;
    }
}

class SingletonSynchronizedBlock {
    private static SingletonSynchronizedBlock instance;

    private SingletonSynchronizedBlock() {
    }

    public static SingletonSynchronizedBlock getIntance() {
        if (instance == null)
            synchronized (Singleton.class) {
                instance = new SingletonSynchronizedBlock();
            }
        return instance;
    }
}

public class Singleton {
    public static void main(String[] args) {
        SingletonEger instance = SingletonEger.getIntance();
        System.out.println(instance);
        SingletonEger instance1 = SingletonEger.getIntance();
        System.out.println(instance1);

        SingletonLazy instance2 = SingletonLazy.getIntance();
        System.out.println(instance2);
        SingletonLazy instance3 = SingletonLazy.getIntance();
        System.out.println(instance3);
    }

}
