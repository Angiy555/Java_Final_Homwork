public class Laptop {
    String manufacturer;
    String title;
    int ram;
    int hardDiskSpace;
    String operatingSystem;
    int cost;

    //Конструктор -------------------
    public Laptop(String manufacturer, String title, int ram, 
            int hardDiskSpace, String operatingSystem, int cost){
        this.manufacturer = manufacturer;
        this.title = title;
        this.ram = ram;
        this.hardDiskSpace = hardDiskSpace;
        this.operatingSystem = operatingSystem;
        this.cost = cost;
    }

    //Методы -------------------------
    @Override
    public String toString() {
        return "Ноутбук: " + manufacturer + ", марка: " + title 
                + ", РАМ: " + ram + ", жесткий диск: " + hardDiskSpace
                + ", операционная система: " + operatingSystem
                + ", стоимость: " + cost;
    }
}
