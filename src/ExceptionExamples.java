
import java.io.*;
import java.sql.*;

public class ExceptionExamples {
    public static void main(String[] args) {

        handleIOException();
        handleFileNotFoundException();
        handleEOFException();
        handleSQLException();
        handleClassNotFoundException();


        handleArithmeticException();
        handleNullPointerException();
        handleArrayIndexOutOfBoundsException();
        handleClassCastException();
        handleIllegalArgumentException();
        handleNumberFormatException();
    }


    public static void handleIOException() {
        try {
            FileReader reader = new FileReader("nonexistent_file.txt");
            reader.close();
        } catch (IOException e) {
            System.out.println("IOException caught: " + e.getMessage());
        }
    }


    public static void handleFileNotFoundException() {
        try {
            FileInputStream file = new FileInputStream("nonexistent_file.txt");
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException caught: " + e.getMessage());
        }
    }


    public static void handleEOFException() {
        try (ByteArrayInputStream input = new ByteArrayInputStream(new byte[0]);
             ObjectInputStream objectInput = new ObjectInputStream(input)) {
            objectInput.readObject();
        } catch (EOFException e) {
            System.out.println("EOFException caught: " + e.getMessage());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Other exception caught: " + e.getMessage());
        }
    }


    public static void handleSQLException() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://invalid_url", "user", "password");
        } catch (SQLException e) {
            System.out.println("SQLException caught: " + e.getMessage());
        }
    }


    public static void handleClassNotFoundException() {
        try {
            Class.forName("com.nonexistent.Class");
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException caught: " + e.getMessage());
        }
    }


    public static void handleArithmeticException() {
        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught: " + e.getMessage());
        }
    }


    public static void handleNullPointerException() {
        try {
            String str = null;
            str.length();
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught: " + e.getMessage());
        }
    }


    public static void handleArrayIndexOutOfBoundsException() {
        try {
            int[] array = new int[5];
            int value = array[10];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught: " + e.getMessage());
        }
    }


    public static void handleClassCastException() {
        try {
            Object obj = "This is a string";
            Integer num = (Integer) obj;
        } catch (ClassCastException e) {
            System.out.println("ClassCastException caught: " + e.getMessage());
        }
    }


    public static void handleIllegalArgumentException() {
        try {
            Thread.sleep(-1);
        } catch (IllegalArgumentException | InterruptedException e) {
            System.out.println("IllegalArgumentException caught: " + e.getMessage());
        }
    }


    public static void handleNumberFormatException() {
        try {
            int num = Integer.parseInt("InvalidNumber");
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught: " + e.getMessage());
        }
    }
}
