import controller.JDBCController;

public class Main {

    public static void main(String[] args) {
        JDBCController control = new JDBCController(null, null, null, null);
        control.start();
    }
}