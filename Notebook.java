import java.util.Map;
import java.util.Random;

public class Notebook implements Comparable<Notebook> {

    public static Random r;
    private int id;
    private static int counter = 1;
    private String model;
    private String os;
    private String color;
    private int screen;
    private String cpu;
    private String gpu;
    private int ram;
    private int ssd;
    private int price;

    public static final String[] listModel = { "Asus", "Lenovo", "MSI", "Irbis", "Digma" };
    public static final String[] listOs = { "Win10", "Win10 Pro", "Win11", "Win11 Pro", "Без OS" };
    public static final String[] listColor = { "Black", "Silver", "White", "Green", "Yellow" };
    public static final int[] listScreen = { 13, 14, 15, 16, 17 };
    public static final String[] listCpu = { "i3", "i5", "i7", "Ryzen5", "Ryzen7" };
    public static final String[] listGpu = { "GTX3050", "GTX3060", "GTX3070", "GTX3080", "Встроенная" };
    public static final int[] listRam = { 4, 8, 16 };
    public static final int[] listSsd = { 120, 240, 500, 1000 };

    static {
        Notebook.r = new Random();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getScreen() {
        return screen;
    }

    public void setScreen(int screen) {
        this.screen = screen;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getSsd() {
        return ssd;
    }

    public void setSsd(int ssd) {
        this.ssd = ssd;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * @param model  - Модель
     * @param os     - Операционная система
     * @param color  - Цвет
     * @param screen - Диагональ экрана
     * @param cpu    - Процессор
     * @param gpu    - Видеокарта
     * @param ram    - Оперативная память
     * @param ssd    - Объем ССД диска
     * @param price  - Стоимость
     */
    public Notebook(String model, String os,
            String color, int screen, String cpu,
            String gpu, int ram, int ssd, int price) {
        this.id = counter++;
        this.model = model;
        this.os = os;
        this.color = color;
        this.screen = screen;
        this.cpu = cpu;
        this.gpu = gpu;
        this.ram = ram;
        this.ssd = ssd;
        this.price = price;
    }

    public Notebook() {
        this(randomString("model"), randomString("os"),
                randomString("color"), randomInt("screen"),
                randomString("cpu"), randomString("gpu"),
                randomInt("ram"), randomInt("ssd"),
                randomInt("price"));
    }

    private static String randomString(String field) {
        return switch (field) {
            case "model" -> listModel[r.nextInt(listModel.length)];
            case "os" -> listOs[r.nextInt(listOs.length)];
            case "color" -> listColor[r.nextInt(listColor.length)];
            case "cpu" -> listCpu[r.nextInt(listCpu.length)];
            default -> listGpu[r.nextInt(listGpu.length)];
        };
    }

    private static int randomInt(String field) {
        return switch (field) {
            case "screen" -> listScreen[r.nextInt(listScreen.length)];
            case "ram" -> listRam[r.nextInt(listRam.length)];
            case "ssd" -> listSsd[r.nextInt(listSsd.length)];
            default -> r.nextInt(43254, 186532);
        };
    }

    public Boolean isSorted(Map<Integer, Object> mapForSort) {
        int stopFlag = 1;
        for (Integer integer : mapForSort.keySet()) {
            switch (integer) {
                case 1:
                    if (!this.model.equals(mapForSort.get(integer))) {
                        stopFlag = 0;
                    }
                    break;
                case 2:
                    if (!this.os.equals(mapForSort.get(integer))) {
                        stopFlag = 0;
                    }
                    break;
                case 3:
                    if (!this.color.equals(mapForSort.get(integer))) {
                        stopFlag = 0;
                    }
                    break;
                case 4:
                    if (this.screen < (Integer) mapForSort.get(integer)) {
                        stopFlag = 0;
                    }
                    break;
                case 5:
                    if (!this.cpu.equals(mapForSort.get(integer))) {
                        stopFlag = 0;
                    }
                    break;
                case 6:
                    if (!this.gpu.equals(mapForSort.get(integer))) {
                        stopFlag = 0;
                    }
                    break;
                case 7:
                    if (this.ram < (Integer) mapForSort.get(integer)) {
                        stopFlag = 0;
                    }
                    break;
                case 8:
                    if (this.ssd < (Integer) mapForSort.get(integer)) {
                        stopFlag = 0;
                    }
                    break;
                case 9:
                    if (this.price < (Integer) mapForSort.get(integer)) {
                        stopFlag = 0;
                    }
                    break;
            }
            if (stopFlag == 0)
                return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format(
                "ID: %d, Model: %s, OS: %s, Color: %s, Screen: %d\", CPU: %s, GPU: %s, RAM: %dgb, SSD: %dgb, Price: %d руб.",
                this.id, this.model, this.os, this.color, this.screen, this.cpu, this.gpu, this.ram, this.ssd,
                this.price);
    }

    @Override
    public int compareTo(Notebook o) {
        return Integer.compare(this.id, o.id);
    }
}