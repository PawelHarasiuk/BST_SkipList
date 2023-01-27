package SkipList;

public class DataNode {

    //każdy węzeł ma nastepny element przed sobą i element pod sobą, wartość i poziom
    private DataNode next;
    private DataNode below;

    private int value;
    private int level;

    //gettery i settery
    public DataNode(int value) {
        this.value = value;
    }

    public DataNode getNext() {
        return next;
    }

    public void setNext(DataNode next) {
        this.next = next;
    }

    public DataNode getBelow() {
        return below;
    }

    public void setBelow(DataNode below) {
        this.below = below;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
