package ua.dp.gurskaya.datastuctures.list;

public class ArrayListTest extends AbstractListTest{
    @Override
    List<String> getList() {
        return new ArrayList<>(5);
    }
}