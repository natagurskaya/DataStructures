package ua.dp.gurskaya.list;

public class ArrayListTest extends AbstractListTest{
    @Override
    List getList() {
        return new ArrayList(5);
    }
}