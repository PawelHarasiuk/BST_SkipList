package SkipList;

public class SkipList {
    private final int NEG_INFINITE = Integer.MIN_VALUE;
    private final int POS_INFINITE = Integer.MAX_VALUE;
    private DataNode topNode;

    private int[] values;
    private int counter;


    public SkipList() {
        this.topNode = new DataNode(NEG_INFINITE);
        this.topNode.setNext(new DataNode(POS_INFINITE));
        this.topNode.setLevel(0);
    }

    public DataNode getBaseNodeAtLevel(int level){
        DataNode tmp = topNode;

        while (true){
            if (tmp.getLevel() == level){
                return tmp;
            }
            tmp = tmp.getBelow();
        }
    }

    private void insertAtLevel(int value, int level){
        DataNode newDataNode;
        DataNode tmp = getBaseNodeAtLevel(level);

        while (true){
            if (value < tmp.getNext().getValue()){
                newDataNode = new DataNode(value);
                if (level > 0){
                    newDataNode.setNext(tmp.getNext());
                    newDataNode.setBelow(findElementToBond(value,level-1));
                } else if (level == 0){
                    newDataNode.setNext(tmp.getNext());
                }
                tmp.setNext(newDataNode);
                return;
            }
            if (value > tmp.getNext().getValue()){
                tmp = tmp.getNext();
            }

            if (tmp.getNext()==null){
                tmp.setNext(new DataNode(value));
                return;
            }
        }

    }

    private void newLayer(){
        DataNode newTopNode = new DataNode(NEG_INFINITE);
        newTopNode.setBelow(topNode);
        newTopNode.setNext(new DataNode(POS_INFINITE));
        newTopNode.setLevel(topNode.getLevel() + 1);

        topNode = newTopNode;
    }

    private DataNode findElementToBond(int value, int level){
        DataNode tmp = getBaseNodeAtLevel(level);
        while (tmp!=null){
            if (tmp.getValue() == value){
                return tmp;
            }
            tmp = tmp.getNext();
        }
        return null;
    }

    public void add(int value){
        int level=0;
        insertAtLevel(value, level);
        boolean flag = true;

        while (flag){
            flag = Math.random() > 0.5;
            if (flag) {
                return;
            }
            level++;
            if (level > topNode.getLevel()) {
                newLayer();
            }
            insertAtLevel(value, level);
        }
    }

    public DataNode get(int value){
        DataNode tmp = topNode;

        while (tmp.getBelow()!=null && value!=tmp.getValue()){
            counter++;
            tmp = tmp.getBelow();

            while (value >= tmp.getNext().getValue()){
                counter++;
                tmp=tmp.getNext();
            }
        }
        return tmp;
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
