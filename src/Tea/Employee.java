package Tea;
import java.util.Queue;

public class Employee {

    private final long id;
    private int desiredTeaBags;

    public long getId() {
        return id;
    }

    public int getDesiredTeaBags() {
        return desiredTeaBags;
    }

    public void setDesiredTeaBags(int value) {
        this.desiredTeaBags = value;
    }

    public Employee(long id) {
        this.id = id;
    }

    public void drinkTea(TeaCan teaCan, Queue<String> drinkLog) {
        if (desiredTeaBags > 0) {
            String teaBag = teaCan.takeTeaBag();
            if (teaBag != null) {
                desiredTeaBags--;
                drinkLog.add("Сотрудник #" + id + " выпил " + teaBag + " чай.");
            } else {
                drinkLog.add("Сотрудник #" + id + " хотел выпить чай, но его не хватило. (Еще хочет " + getDesiredTeaBags() + ")");
            }
        }
    }

    public void printEmployeeInfo() {
        System.out.println("Сотрудник #" + getId() + ", " + "хочет выпить пакетиков: " + getDesiredTeaBags());
    }
}