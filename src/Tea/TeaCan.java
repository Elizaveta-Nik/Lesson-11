package Tea;
import java.util.Random;
import java.util.Stack;

public class TeaCan {
    private final Stack<String> teaCan;
    String[] teaTypes = new String[]{"Зеленый", "Черный", "Фруктовый"};
    private final Random random = new Random();


    public TeaCan() {
        teaCan = new Stack<>();
    }

    public boolean isEmpty(){
        return teaCan.isEmpty();
    }

    public void refill() {
        teaCan.clear();//пустая в начале дня
        int randomTeaBags = 10 + random.nextInt(11);//рандомное наполнение
        for (int i = 0; i < randomTeaBags; i++) {
            teaCan.add(teaTypes[random.nextInt(teaTypes.length)]);
        }
        System.out.println("Количество пакетиков чая на начало дня: " + randomTeaBags);
        System.out.println("Типы пакетиков чая: " + teaCan);
    }

    public String takeTeaBag() {
        if (teaCan.isEmpty()) {
            return null;
        }
        return teaCan.pop();//возвращает элемент на верхушке стека, однако помимо возвращения ещё и удаляет.
    }
}