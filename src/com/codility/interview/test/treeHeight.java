package com.codility.interview.test;

public class treeHeight {

    public static void main(String[] args) {
        treeHeight.Tree test = new treeHeight.Tree();
        test.x=3;
        treeHeight.Tree testleft = new treeHeight.Tree();
        testleft.x=5;
        test.l = testleft;
        System.out.println("tree height "+solution(test));
    }

    public static class Tree {
        public int x;
        public Tree l;
        public Tree r;
    }

    public static int solution(Tree t){
        return path(t) - 1;
    }

    private static int path(Tree t){
        if(t==null) {
            return 0;
        }
        return Math.max(path(t.l), path(t.r)) + 1;
    }
}
