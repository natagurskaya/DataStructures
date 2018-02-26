package ua.dp.gurskaya.datastuctures.map;

public class Test {
    public static void main(String[] args) {
        HashMap<String,Object> hashMap = new HashMap<>();

        hashMap.put("one", "111");
        hashMap.put(null, "222");

        System.out.println(hashMap);

        System.out.println(hashMap.get(null));

    }
}
