package BST;

public class BST {
    private DataNode root;

    //dane do pomiaru
    private int[] values;
    private int counter;

    public DataNode get(int value) {
        DataNode flag = getRoot();
        while (flag != null){
            counter++;
            if (flag.getValue() == value){
                return flag;
            }
            counter++;
            if (flag.getValue()<value){
                flag = flag.getRight();
            }
            counter++;
            if(flag.getValue()>value){
                flag = flag.getLeft();
            }
            counter++;
        }

        return null;
    }

    public void add(int value){
        DataNode flag = getRoot();
        DataNode parent = getRoot();
        DataNode newNode = new DataNode(value);

        while (flag != null){
            if (value == flag.getValue()){
                return;
            }
            parent=flag;
            if (value > flag.getValue()){
                flag=flag.getRight();
            }else if (value < flag.getValue()){
                flag=flag.getLeft();
            }
        }

        if (parent == null){
            setRoot(newNode);
        }
        else if (value > parent.getValue()){
            parent.setRight(newNode);
            newNode.setParent(parent);
        }else {
            parent.setLeft(newNode);
            newNode.setParent(parent);
        }
    }

    public DataNode getRoot() {
        return root;
    }

    public void setRoot(DataNode root) {
        this.root = root;
    }

    public int[] getValues() {
        return values;
    }

    public void setValues(int[] values) {
        this.values = values;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
