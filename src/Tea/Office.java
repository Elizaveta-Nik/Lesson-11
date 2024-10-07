package Tea;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Office {
    public static void main(String[] args) {

        TeaCan teaCan = new TeaCan();
        Queue<String> drinkLog = new LinkedList<>();
        Queue<Employee> employeesPool = new LinkedList<>();

        for (int i = 1; i <= 5; i++) {
            employeesPool.add(new Employee(i));
        }

        for (int day = 1; day <= 2; day++) {
            System.out.println("День " + day);
            teaCan.refill();
            Queue<Employee> employees = prepareEmployees(employeesPool);

            while (!employees.isEmpty()) {
                Employee employee = employees.poll();
                employee.drinkTea(teaCan, drinkLog);

                if (employee.getDesiredTeaBags() > 0 && !teaCan.isEmpty()) {
                    employees.add(employee);
                }
            }

            for (String log : drinkLog){
                System.out.println(log);
            }

            drinkLog.clear();
        }
    }

    private static Queue<Employee> prepareEmployees(Queue<Employee> employeesPool) {
        Random random = new Random();
        Queue<Employee> employees = new LinkedList<>(employeesPool);
        for (Employee employee : employees) {
            employee.setDesiredTeaBags(random.nextInt(1,6));
            employee.printEmployeeInfo();
        }
        return employees;
    }
}