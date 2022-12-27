import java.util.*;

public class Program {
    public static void main(String[] args) {
        TreeSet<Notebook> notebookList = new TreeSet<>();
        for (int i = 0; i < 100; i++) {
            notebookList.add(new Notebook());
        }
        Map<Integer, Object> priorities = getPriority();
        int count = 0;
        for (Notebook notebook : notebookList) {
            if (notebook.isSorted(priorities)) {
                System.out.println(notebook);
                count++;
            }
        }
        if (count == 0) {
            System.err.println("Совпадения не найдены!");
        }
    }

    public static Map<Integer, Object> getPriority() {
        Scanner scn = new Scanner(System.in);
        Map<Integer, Object> resultMap = new TreeMap<>();
        Map<Integer, String> mapCriterion = new TreeMap<>(Map.of(1, "Модель ноутбука",
                2, "Операционная система",
                3, "Цвет",
                4, "Размер экрана",
                5, "Процессор",
                6, "Видеокарта",
                7, "Оперативная память",
                8, "Объем жесткого диска",
                9, "Цена",
                10, "Закончить выбор"));

        int choice;
        boolean flag = true;
        while (flag) {
            for (Map.Entry<Integer, String> menu : mapCriterion.entrySet()) {
                if (menu.getKey() == 10) {
                    System.out.println("Что бы закончить выбор введите 0 (ноль)");
                } else {
                    System.out.printf("%d. %s\n", menu.getKey(), menu.getValue());
                }
            }
            System.out.print("Выберете критерий: ");
            choice = scn.nextInt();
            switch (choice) {
                case 1:
                    getFieldString(Notebook.listModel, mapCriterion, resultMap, scn, choice);
                    break;
                case 2:
                    getFieldString(Notebook.listOs, mapCriterion, resultMap, scn, choice);
                    break;
                case 3:
                    getFieldString(Notebook.listColor, mapCriterion, resultMap, scn, choice);
                    break;
                case 4:
                    getFieldInt(Notebook.listScreen, mapCriterion, resultMap, scn, choice);
                    break;
                case 5:
                    getFieldString(Notebook.listCpu, mapCriterion, resultMap, scn, choice);
                    break;
                case 6:
                    getFieldString(Notebook.listGpu, mapCriterion, resultMap, scn, choice);
                    break;
                case 7:
                    getFieldInt(Notebook.listRam, mapCriterion, resultMap, scn, choice);
                    break;
                case 8:
                    getFieldInt(Notebook.listSsd, mapCriterion, resultMap, scn, choice);
                    break;
                case 9:
                    System.out.print("Введите минимальную цену в рублях: ");
                    int price = scn.nextInt();
                    resultMap.put(choice, price);
                    mapCriterion.remove(choice);
                    break;
                case 0:
                    flag = false;
                    break;
            }
        }
        return resultMap;
    }

    public static void getFieldString(String[] array,
            Map<Integer, String> menu,
            Map<Integer, Object> mapFields,
            Scanner scn,
            int move) {
        int count = 0;
        int choiceField;
        for (String s : array) {
            System.out.printf("%d: %s%n", ++count, s);
        }
        System.out.print("Выбор: ");
        choiceField = scn.nextInt();
        mapFields.put(move, array[choiceField - 1]);
        menu.remove(move);
    }

    public static void getFieldInt(int[] array,
            Map<Integer, String> menu,
            Map<Integer, Object> mapFields,
            Scanner scn,
            int move) {
        int count = 0;
        int choiceField;
        for (int d : array) {
            if (menu.get(move).equals("Размер экрана")) {
                System.out.printf("%d: %d\"%n", ++count, d);
            } else {
                System.out.printf("%d: %dgb%n", ++count, d);
            }
        }
        System.out.print("Выберете минимальное требование: ");
        choiceField = scn.nextInt();
        mapFields.put(move, array[choiceField - 1]);
        menu.remove(move);
    }
}
