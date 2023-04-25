import java.util.*;

class Node {
    int id;
    int holderval;
    Node l;
    Node r;
    int[] require = new int[20];
}

public class EXP6T {
    public static void TraversalInorder(Node roonodeT) {
        if (roonodeT == null) {
            return;
        }
        TraversalInorder(roonodeT.l);
        System.out.println(roonodeT.id + " " + roonodeT.holderval);
        TraversalInorder(roonodeT.r);
    }

    public static void token(Node roonodeT, int NodeCS) {
        if (NodeCS == roonodeT.id) {
            System.out.println(roonodeT.id);
            roonodeT.holderval = roonodeT.id;
            return;
        } else if (NodeCS < roonodeT.id) {
            roonodeT.holderval = roonodeT.l.id;
            System.out.print(roonodeT.id + "->");
            roonodeT = roonodeT.l;
            token(roonodeT, NodeCS);
        } else if (NodeCS > roonodeT.id) {
            roonodeT.holderval = roonodeT.r.id;
            System.out.print(roonodeT.id + "->");
            roonodeT = roonodeT.r;
            token(roonodeT, NodeCS);
        }
    }

    public static void NodeTinsert(Node nodeNew, Node roonodeT) {
        if (nodeNew.id > roonodeT.id) {
            if (roonodeT.r == null) {
                roonodeT.r = nodeNew;
                nodeNew.holderval = roonodeT.id;
            } else {
                NodeTinsert(nodeNew, roonodeT.r);
            }
        }
        if (nodeNew.id < roonodeT.id) {
            if (roonodeT.l == null) {
                roonodeT.l = nodeNew;
                nodeNew.holderval = roonodeT.id;
            } else {
                NodeTinsert(nodeNew, roonodeT.l);
            }
        }
    }

    public static void main(String[] args) {
        Node r = new Node();
        r.id = 5;
        r.holderval = 5;
        Node n1 = new Node();
        n1.id = 3;
        Node n2 = new Node();
        n2.id = 7;
        Node n3 = new Node();
        n3.id = 1;
        Node n4 = new Node();
        n4.id = 4;
        Node n5 = new Node();
        n5.id = 6;
        Node n6 = new Node();
        n6.id = 8;
        Node n7 = new Node();
        n7.id = 2;
        Node n8 = new Node();
        n8.id = 9;
        Node n9 = new Node();
        n9.id = 10;
        Node n10 = new Node();
        n10.id = 11;

        NodeTinsert(n1, r);
        NodeTinsert(n2, r);
        NodeTinsert(n3, r);
        NodeTinsert(n4, r);
        NodeTinsert(n5, r);
        NodeTinsert(n6, r);
        NodeTinsert(n7, r);
        NodeTinsert(n8, r);
        NodeTinsert(n9, r);
        NodeTinsert(n10, r);

        TraversalInorder(r);
        token(r, 8);
    }
}
