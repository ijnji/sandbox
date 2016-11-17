package rlib;

public class RBTNode<T> {
    public T data = null;
    public RBTNode<T> parent = null;
    public RBTNode<T> left = null;
    public RBTNode<T> right = null;
    public RBTNode(T data) {
        this.data = data;
    }
    public void print() {
        print("");
    }
    private void print(String prefix) {
        System.out.println(prefix + "  = " + data);
        if (this.right == null && this.left == null) return;
        if (this.right != null) {
            this.right.print(prefix + "   ");
        } else {
            System.out.println(prefix + "     = ");
        }
        if (this.left != null) {
            this.left.print(prefix + "   ");
        } else {
            System.out.println(prefix + "     = ");
        }
    }
    public static void main(String[] args) {
        RBTNode<Integer> a = new RBTNode<Integer>(0);
        RBTNode<Integer> b = new RBTNode<Integer>(1);
        RBTNode<Integer> c = new RBTNode<Integer>(2);
        RBTNode<Integer> d = new RBTNode<Integer>(3);
        RBTNode<Integer> e = new RBTNode<Integer>(4);
        RBTNode<Integer> f = new RBTNode<Integer>(5);
        RBTNode<Integer> g = new RBTNode<Integer>(6);
        RBTNode<Integer> h = new RBTNode<Integer>(7);
        RBTNode<Integer> i = new RBTNode<Integer>(8);
        a.right = b;
        a.left = c;
        b.right = d;
        b.left = e;
        c.right = f;
        c.left = g;
        d.right = h;
        d.left = i;

        a.print();
    }
}