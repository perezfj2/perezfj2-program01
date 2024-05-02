// Fernando Perez
// January 18, 2023
// CSCI 3302 Section 001
// 
// Files:   
// 
// Description:

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.*;
import java.util.*;

public class OrderedIntegers {

    public static void main(String[] args) throws IOException {

        OrderedIntegers test = new OrderedIntegers();

        test.loadFileData("/workspaces/program01-perezfj2/numbers.bin");

        

    }

    public ArrayList<Integer> numbers;

    public OrderedIntegers() {
        numbers = new ArrayList<Integer>();
    } // end constructor

    public int getSize() {
        return numbers.size();
    } // end getSize method

    public int getValue(int index) throws OrderedIntegersException {
        if (index <= numbers.size())
            return numbers.get(index);
        else
            throw new OrderedIntegersException("Out of index size.");
    } // end getValue method

    public void addValue(int newNumber) {

        numbers.add(newNumber);

        Collections.sort(numbers);
    }

    public void removeValue(int index) {
        if (index <= numbers.size())
            numbers.remove(numbers.get(index));
        else
            throw new OrderedIntegersException("Out of index size.");
    } // end removeValue method

    public void loadFileData(String filename) throws OrderedIntegersException, IOException {

        try {
            FileInputStream inputFile = new FileInputStream(filename);
            DataInputStream dataFile = new DataInputStream(inputFile);

            while (dataFile.available() > 1) {
                numbers.add(dataFile.readInt());
            }
            dataFile.close();

        } catch (OrderedIntegersException e) {
            // TODO: handle exception
        }

    }

} // end class