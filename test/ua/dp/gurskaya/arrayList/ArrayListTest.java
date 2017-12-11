package ua.dp.gurskaya.arrayList;

import static org.junit.Assert.*;

public class ArrayListTest extends AbstractListTest{
    @Override
    List getList() {
        return new ArrayList(5);
    }
}