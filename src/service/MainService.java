package service;

import datastr.MyHeap;

public class MainService {
    public static void main(String[] args) throws Exception {
        MyHeap intHeap = new MyHeap<>();
        intHeap.enqueue(3); //3
        intHeap.enqueue(6); // 6 3
        intHeap.enqueue(4); // 6(root) 3(L) 4(R)
        intHeap.enqueue(100); //100(root) 6(L) 4(R) 3(6 - L)
        intHeap.print(); // 100 6 4 3

        System.out.println(intHeap.dequeue());//100
        intHeap.enqueue(1000);
        System.out.println(intHeap.dequeue()); //1000

    }
//    public static void recursiveEx1(int N){
//        if(N>0) {
//            System.out.println(N);
//            recursiveEx1(N-1);
//        }
//    }
//
//    public static int recursiveEx2(int N){
//        if(N > 0) {
//            System.out.println(N);
//            return N + recursiveEx2(N-1);
//        }
//        else return 0;
//    }
}
