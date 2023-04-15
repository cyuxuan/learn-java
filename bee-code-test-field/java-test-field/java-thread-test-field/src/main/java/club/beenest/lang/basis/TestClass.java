package club.beenest.lang.basis;


public class TestClass {
    public static void main(String[] args) {
        int a = 1;
        Object obj = (Object) a;
        System.out.println(obj);
        testM(a);
    }

    public static void testM(int a) {
        System.out.println("b");
        testM(a);
    }

    public static void testM(Object a) {
        System.out.println("a");
    }
}
