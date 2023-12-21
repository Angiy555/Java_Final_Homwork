import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class HardwareStore {
    
    public static void main(String[] args) {
        DrawInterface drawInterface = new DrawInterface();
        Set<Laptop> laptops = new HashSet<>();
        boolean shouldExit = false;        
        
        Laptop laptop1 = new Laptop("Asus", "A02-45", 8, 250, "Windows", 1300);
        Laptop laptop2 = new Laptop("Asus", "A06-60", 8, 250, "Windows", 1500);
        Laptop laptop3 = new Laptop("Asus", "A03-55", 12, 500, "Windows", 1700);
        Laptop laptop4 = new Laptop("Samsung", "G05-35H", 8, 250, "Windows", 1500);
        Laptop laptop5 = new Laptop("Samsung", "G02-45G", 12, 500, "Windows", 1800);
        Laptop laptop6 = new Laptop("Huawei", "H02-45", 8, 250, "Windows", 1500);
        Laptop laptop7 = new Laptop("Huawei", "H02-45", 32, 128, "Windows", 1500);

        laptops.add(laptop1);
        laptops.add(laptop2);
        laptops.add(laptop3);
        laptops.add(laptop4);
        laptops.add(laptop5);
        laptops.add(laptop6);
        laptops.add(laptop7);

        while (!shouldExit) {            
            //вывод меню
            drawInterface.outputMenu();            
            System.out.print("Введите операцию от 1 до 3 или 0 для выхода: ");
            String answer = readConsole();
            if(answer.equals("0")){
                shouldExit = true;
            }
            if(answer.equals("1")){                
                printAllLaptop(laptops, drawInterface);                
            }
            if(answer.equals("2")){
                addLaptop(laptops, drawInterface);
            }
            if(answer.equals("3")){
                findLaptop(laptops, drawInterface);
            }
            if(!answer.equals("0") && !answer.equals("1") 
                && !answer.equals("2") && !answer.equals("3")){
                System.out.println("");
                System.out.println("Введен неверный пункт.");
                System.out.println("");
                System.out.print("Нажмите ENTER для продолжения ");
                readConsole();
            }
        } 
    }

    //Методы ------------------
    //Вывод в консоль множества
    static void printSet(Set<Laptop> laptops){       
        for (Laptop laptop: laptops){
            System.out.println(laptop);
        }        
    }

    //Чтение из консоли
    static String readConsole(){
        Scanner scanner = new Scanner(System.in);
        String readedLine = scanner.nextLine();
        return readedLine;
    }

    //Вывод множества всех ноутбуков
    static void printAllLaptop(Set<Laptop> laptops, DrawInterface drawInterface){
        drawInterface.outputLaptopsHeader();
        printSet(laptops);
        System.out.println("");
        System.out.print("Нажмите ENTER для продолжения ");
        readConsole();
    }

    //Добавление ноутбука
    static void addLaptop(Set<Laptop> laptops, DrawInterface drawInterface){
        drawInterface.outpuAddtLaptopsHeader();

        System.out.print("Введите название производителя: ");        
        String manufacturer = readConsole();

        System.out.print("Введите марку: ");
        String title = readConsole();

        System.out.print("Введите объем РАМ: ");
        String rawRamValue = readConsole();        
        int parsedRamValue = Integer.parseInt(rawRamValue);

        System.out.print("Введите объем жесткого диска: ");
        String rawHardDiskSpace = readConsole();
        int parsedHardDiskSpace = Integer.parseInt(rawHardDiskSpace);

        System.out.print("Введите название операционной системы: ");
        String operatingSystem = readConsole();

        System.out.print("Введите стоимость: ");
        String rawCost = readConsole();
        int parseCost = Integer.parseInt(rawCost);

        Laptop newLaptop = new Laptop(manufacturer, title, parsedRamValue, parsedHardDiskSpace, operatingSystem, parseCost);
        laptops.add(newLaptop);
    }

     //Поиск ноутбуков по параметрам
     static void findLaptop(Set<Laptop> laptops, DrawInterface drawInterface){
        //Множество искомых ноутбуков
        Set<Laptop> foundLaptops = new HashSet<>(laptops);
        //Критерии
        Map<String, List<String>> selectedCriteria = selectingSearchCriteria(drawInterface);
        //Поиск по критерию, удаляем не подходящие
        for(Laptop laptop: laptops){
            for(Object selectedCriteriaNumber: selectedCriteria.keySet()){   
                List<String> selectedValuesList = selectedCriteria.get(selectedCriteriaNumber);             
                if(selectedCriteriaNumber.equals("1") && !laptop.manufacturer.equals(selectedValuesList.get(0))){
                    foundLaptops.remove(laptop);
                }
                if(selectedCriteriaNumber.equals("2") && !laptop.title.equals(selectedValuesList.get(0))){
                    foundLaptops.remove(laptop);
                }
                if(selectedCriteriaNumber.equals("3") ){                    
                    int parsedRamMinValue = Integer.parseInt(selectedValuesList.get(0));
                    int parsedRamMaxValue = Integer.parseInt(selectedValuesList.get(1)); 

                    if(laptop.ram < parsedRamMinValue || laptop.ram > parsedRamMaxValue){
                        foundLaptops.remove(laptop);
                    }                                      
                }
                if(selectedCriteriaNumber.equals("4")){
                    int parsedHardDiskSpaceMinValue = Integer.parseInt(selectedValuesList.get(0));
                    int parsedHardDiskSpaceMaxValue = Integer.parseInt(selectedValuesList.get(1));

                    if(laptop.hardDiskSpace < parsedHardDiskSpaceMinValue || laptop.hardDiskSpace > parsedHardDiskSpaceMaxValue){
                            foundLaptops.remove(laptop);
                    }                    
                }
                if(selectedCriteriaNumber.equals("5") && !laptop.operatingSystem.equals((selectedCriteria.get(selectedCriteriaNumber)).get(0))){
                    foundLaptops.remove(laptop);
                }
                if(selectedCriteriaNumber.equals("6")){
                    int parsedCostMinValue = Integer.parseInt(selectedValuesList.get(0));
                    int parsedCostMaxValue = Integer.parseInt(selectedValuesList.get(1));

                    if(laptop.cost < parsedCostMinValue || laptop.cost > parsedCostMaxValue){
                            foundLaptops.remove(laptop);
                    }                    
                }                
            }
        }
        //Если множество пустое сообщаем
        if(foundLaptops.isEmpty()){
            System.out.println("По введенным критериям ничего не найдено!");
            System.out.println("");
            System.out.print("Нажмите ENTER для продолжения ");
            readConsole();
        }
        //Если во множестве есть данные выводим
        else{
            drawInterface.outputLaptopSearchResulTHeader();
            printSet(foundLaptops);
            System.out.println("");
            System.out.print("Нажмите ENTER для продолжения ");
            readConsole();
        }        
    }

    //Выбор критериев поиска
    static Map<String, List<String>> selectingSearchCriteria(DrawInterface drawInterface){
        Map<String, List<String>> criteriaResult = new HashMap<>();        
        boolean shouldStopCriteriaAddition = false;

        while (!shouldStopCriteriaAddition) {
            System.out.print("Вы хотите выбрать критерий? (y/n): ");
            String question = readConsole();

            if(question.equals("n")){
                shouldStopCriteriaAddition = true;
            }
            else{                
                drawInterface.outputMenuCriteria();
                System.out.print("Введите цифру критерия: ");
                String criteriaNumber = readConsole();
                List<String> paramList = new ArrayList<>();

                switch (criteriaNumber) {
                    case "1":
                        System.out.print("Введите название производителя: "); 
                        paramList.add(readConsole());                      
                        criteriaResult.put(criteriaNumber, paramList);
                        break;
                    case "2":
                        System.out.print("Введите марку: "); 
                        paramList.add(readConsole());                        
                        criteriaResult.put(criteriaNumber, paramList);
                        break;
                    case "3":
                        System.out.print("Введите минимальный объем РАМ: ");  
                        paramList.add(readConsole());
                        System.out.print("Введите максимальный объем РАМ: ");  
                        paramList.add(readConsole());                      
                        criteriaResult.put(criteriaNumber, paramList);
                        break;
                    case "4":
                        System.out.print("Введите минимальный объем жесткого диска: ");  
                        paramList.add(readConsole());
                        System.out.print("Введите максимальный объем жесткого диска: ");  
                        paramList.add(readConsole());                      
                        criteriaResult.put(criteriaNumber, paramList);
                        break;
                    case "5":
                        System.out.print("Введите название операционной системы: "); 
                        paramList.add(readConsole());                        
                        criteriaResult.put(criteriaNumber, paramList);
                        break;
                    case "6":
                        System.out.print("Введите минимальную стоимость: ");  
                        paramList.add(readConsole());
                        System.out.print("Введите максимальную стоимость: ");  
                        paramList.add(readConsole());                      
                        criteriaResult.put(criteriaNumber, paramList);
                        break;
                    default:
                        System.out.println("");
                        System.out.println("Введен неверный пункт.");
                        System.out.println("");
                        System.out.print("Нажмите ENTER для продолжения ");
                        readConsole();
                        break;
                }                          
            }
        }

        return criteriaResult;
    }
}