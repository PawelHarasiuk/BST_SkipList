import BST.BST;
import SkipList.SkipList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] dataDir = {
                "data/1000a.txt",
                "data/1000b.txt",
                "data/5000a.txt",
                "data/5000b.txt",
                "data/10000a.txt",
                "data/10000b.txt"
        };

        for (String s : dataDir) {
            BST bst = new BST();
            readFileForBST(s, bst);
            find_n_element(bst);
        }

        System.out.println();
        for (String s : dataDir) {
            SkipList skipList = new SkipList();
            addElementsToSkipList(s,skipList);
            find_n_element(skipList);
        }
    }

    public static void readFileForBST(String fName, BST bst){
        int count=0;
        try {
            File file = new File(fName);
            Scanner scanner = new Scanner(file);
            bst.setValues(new int[Integer.parseInt(scanner.nextLine())]);

            while (scanner.hasNextLine()){
                String value = scanner.nextLine();
                bst.add(Integer.parseInt(value));
                bst.getValues()[count] = Integer.parseInt(value);
                count++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void find_n_element(BST bst){
        for (int i = 0; i<bst.getValues().length; i+=10) {
            bst.get(bst.getValues()[i]);
        }
        System.out.println("Bst suma przeskokow i porownan "  + bst.getCounter());
    }

    public static void addElementsToSkipList(String fName, SkipList skipList){
        int count=0;
        try {
            File file = new File(fName);
            Scanner scanner = new Scanner(file);
            skipList.setValues(new int[Integer.parseInt(scanner.nextLine())]);
            while (scanner.hasNextLine()){
                String value = scanner.nextLine();
                skipList.add(Integer.parseInt(value));
                skipList.getValues()[count] = Integer.parseInt(value);
                count++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void find_n_element(SkipList skipList){
        for (int i = 0; i<skipList.getValues().length; i+=10) {
            skipList.get(skipList.getValues()[i]);
        }
        System.out.println("SkipList suma przeskokow i porownan "  + skipList.getCounter());
    }
}
