import controller.JDBCController;
import service.CreateService;
import service.DeleteService;
import service.ReadService;
import service.UpdateService;

public class Main {
    public static void main(String[] args) {
        CreateService createService = new CreateService();
        ReadService readService = new ReadService();
        UpdateService updateService = new UpdateService();
        DeleteService deleteService = new DeleteService();

        JDBCController controller = new JDBCController(
                createService,
                readService,
                deleteService,
                updateService);

        controller.start();
    }
}