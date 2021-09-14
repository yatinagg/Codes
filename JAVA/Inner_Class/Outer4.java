public class Outer4 {
    void outMethod() {
        class Inner {
            public void show() {
                System.out.println("In a nested class method of Outer 4");
            }
        }
        Inner obj1 = new Inner();
        obj1.show();
    }
}