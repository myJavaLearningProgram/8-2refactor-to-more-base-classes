package com.github.hcsp.inheritance;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("ABC");
        cat.meow();
        cat.sayMyName();

        Dog dog = new Dog("BCD");
        dog.wang();
        dog.sayMyName();

        Boy boy = new Boy("123", 2);
        boy.sayMyName();
        boy.sayMyAge();
        boy.sayBoy();

        Girl girl = new Girl("234", 3);
        girl.sayMyName();
        girl.sayMyAge();
        girl.sayGirl();
    }
}
