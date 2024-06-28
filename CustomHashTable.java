import java.util.ArrayList;
import java.util.LinkedList;

public class CustomHashTable {
    private ArrayList<LinkedList<Node>> multiplicationTable;
    private ArrayList<LinkedList<Node>> divisionTable;
    private int size;

    public CustomHashTable() {
        this.size = 1000; // Elegir un tamaño adecuado para la tabla hash
        this.multiplicationTable = new ArrayList<>(size);
        this.divisionTable = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            multiplicationTable.add(new LinkedList<>());
            divisionTable.add(new LinkedList<>());
        }
    }

    private int hashMultiplication(String key) {
        int hash = Math.abs(key.hashCode());
        double A = (Math.sqrt(5) - 1) / 2;
        return (int) (size * (hash * A % 1));
    }

    private int hashDivision(String key) {
        int hash = Math.abs(key.hashCode());
        return hash % size;
    }

    public void insertUsingMultiplication(String key, String[] data) {
        int index = hashMultiplication(key);
        multiplicationTable.get(index).add(new Node(key, data));
    }

    public void insertUsingDivision(String key, String[] data) {
        int index = hashDivision(key);
        divisionTable.get(index).add(new Node(key, data));
    }

    public String[] searchUsingMultiplication(String key) {
        int index = hashMultiplication(key);
        for (Node node : multiplicationTable.get(index)) {
            if (node.key.equals(key)) {
                return node.data;
            }
        }
        return null;
    }

    public String[] searchUsingDivision(String key) {
        int index = hashDivision(key);
        for (Node node : divisionTable.get(index)) {
            if (node.key.equals(key)) {
                return node.data;
            }
        }
        return null;
    }
}

