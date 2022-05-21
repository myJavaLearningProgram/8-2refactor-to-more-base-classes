package com.github.hcsp.inheritance;

import com.github.hcsp.test.helper.ClassInspector;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {
    @Test
    public void behaveCorrectly() {
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

    @Test
    public void inspectFields() {
        ClassInspector.assertNoPublicFields(Cat.class, Dog.class, Boy.class, Girl.class);
        ClassInspector.assertNoDeclaredFields(Cat.class, Dog.class, Boy.class, Girl.class);
    }

    @Test
    public void inspectMethods() {
        Assertions.assertEquals(1, Cat.class.getDeclaredMethods().length);
        Assertions.assertEquals(1, Dog.class.getDeclaredMethods().length);
        Assertions.assertEquals(1, Boy.class.getDeclaredMethods().length);
        Assertions.assertEquals(1, Girl.class.getDeclaredMethods().length);
    }

    @Test
    public void hasCommonAncestor() {
        Set<Class> catAncestors = ClassInspector.getAncestors(Cat.class);
        Set<Class> dogAncestors = ClassInspector.getAncestors(Dog.class);
        Set<Class> boyAncestors = ClassInspector.getAncestors(Boy.class);
        Set<Class> girlAncestors = ClassInspector.getAncestors(Girl.class);
        catAncestors.retainAll(dogAncestors);
        catAncestors.retainAll(boyAncestors);
        catAncestors.retainAll(girlAncestors);
        Assertions.assertTrue(catAncestors.size() > 0);
    }
}
