public class DrawInterface {
    
    //Методы
    //Очистка консоли
    private void ClearConsole(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    //Вывод страницы меню
    public void outputMenu(){        
        ClearConsole();
        System.out.println("============================================================");
        System.out.println("######################      MENU      ######################");
        System.out.println("============================================================");
        System.out.println("    1. Показать список всех ноутбуков.");
        System.out.println("    2. Добавить данные по ноутбуку.");
        System.out.println("    3. Поиск ноутбука по параметрам.");
        System.out.println("    0. ВЫХОД.");
        System.out.println("============================================================");
    }

    //Вывод заголовка Ноутбуки
    public void outputLaptopsHeader(){
        ClearConsole();
        System.out.println("============================================================");
        System.out.println("####################      НОУТБУКИ      ####################");
        System.out.println("============================================================");
    }

    //Вывод заголовка ДОБАВЛЕНИЕ ДАННЫХ ПО НОУТБУКУ
    public void outpuAddtLaptopsHeader(){
        ClearConsole();
        System.out.println("============================================================");
        System.out.println("##########      ДОБАВЛЕНИЕ ДАННЫХ ПО НОУТБУКУ      #########");
        System.out.println("============================================================");
    }

    //Вывод заголовка РЕЗУЛЬТАТЫ ПОИСКА НОУТБУКОВ
    public void outputLaptopSearchResulTHeader(){
        ClearConsole();
        System.out.println("============================================================");
        System.out.println("###########      РЕЗУЛЬТАТЫ ПОИСКА НОУТБУКОВ      ##########");
        System.out.println("============================================================");
    }

    //Вывод страницы меню критериев
    public void outputMenuCriteria(){
        ClearConsole();
        System.out.println("============================================================");
        System.out.println("####################      КРИТЕРИИ      ####################");
        System.out.println("============================================================");
        System.out.println("    1. Название производителя.");
        System.out.println("    2. Марка.");
        System.out.println("    3. Объем РАМ.");
        System.out.println("    4. Объем жесткого диска.");
        System.out.println("    5. Название операционной системы.");
        System.out.println("    6. Стоимость.");
        System.out.println("============================================================");
    }
}
