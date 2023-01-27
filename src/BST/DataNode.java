package BST;

public class DataNode {

    private DataNode right;
    private DataNode left;
    private DataNode parent;
    private int value;

    public DataNode(int value) {
        this.value = value;
    }

    public DataNode getRight() {
        return right;
    }

    public void setRight(DataNode right) {
        this.right = right;
    }

    public DataNode getLeft() {
        return left;
    }

    public void setLeft(DataNode left) {
        this.left = left;
    }

    public DataNode getParent() {
        return parent;
    }

    public void setParent(DataNode parent) {
        this.parent = parent;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
