package thinkingInJavaChapter7Q5;

public class Solution {

    class A {
        public A(){
            System.out.println("A");
        }
    }

    class B {
        B(){
            System.out.println("B");
        }
    }

    class C extends A{
        B b = new B();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.test();
    }

    private void test(){
        C c = new C();
    }
}
