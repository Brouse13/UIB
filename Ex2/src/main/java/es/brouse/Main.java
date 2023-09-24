package es.brouse;

import es.brouse.stack.DynamicStack;
import es.brouse.stack.Stack;
import es.brouse.stack.StaticStack;

public class Main {
    public static void main(String[] args) {
        //Create a static stack
        Stack<Integer> staticStack = new StaticStack<>(50);

        //Add 10 elements and pop 1
        for (int i = 0; i < 5; i++) staticStack.push(i);
        staticStack.pop();

        //Sout last element
        System.out.println(staticStack.last());



        //Create a dynamic stack
        Stack<Integer> dynamicStack = new DynamicStack<>();

        //Add 50 elements and pop 1
        int i = 0;
        while (true) {
            dynamicStack.push(i++);
            System.out.println(i);
        }

        //for (int i = 0; i < 50; i++) dynamicStack.push(i);

        /*
        dynamicStack.pop();
        dynamicStack.pop();
        dynamicStack.pop();

        //Sout last element
        System.out.println(dynamicStack.last());
         */
    }
}
