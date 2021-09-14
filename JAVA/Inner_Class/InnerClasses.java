public class InnerClasses {

    public static void main(String[] args) {

        // simple outer and inner class
        Outer.Inner in = new Outer().new Inner();
        in.show();

        // static function show of inner class
        Outer1.Inner.show();

        // static inner class
        Outer3.Inner in3 = new Outer3.Inner();
        in3.show();

        // method local inner class
        Outer4 out4 = new Outer4();
        out4.outMethod();
    }

}
