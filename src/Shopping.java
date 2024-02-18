import java.util.Scanner;

public class Shopping {
    public static void main(String[] args) {
        System.out.println("Вас приветствует список покупок!");

        int productCount = 0; // Переменная для подсчёта добавленных товаров
        String product; // Переменная для названий товаров
        boolean repeatValue = false;

        String[] shoppingList = new String[8]; // Массив для списка товаров

        // Массив для копирования элементов из массива shoppingList
        String[] shoppingListCopy = new String[(shoppingList.length + 8)];

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите одну из команд:");
            System.out.println("1. Добавить товар в список");
            System.out.println("2. Показать список");
            System.out.println("3. Очистить список");
            System.out.println("4. Завершить работу");

            int actionNumber = scanner.nextInt(); // Переменная для выбора пункта меню

            //Добавление товара в список покупок
            if (actionNumber == 1) {
                System.out.println("Введите товар :");
                product = scanner.next();

                // Проверка отсутствия повторения product в массиве shoppingList
                for(int k = 0; k < shoppingList.length; k++) {
                    if(product.equals(shoppingList[k])) {
                        repeatValue = false;
                        break;
                    } else {
                        repeatValue = true;
                    }
                }
                if(repeatValue) {
                    shoppingList[productCount] = product; //Запись в массив
                    productCount += 1; // Увеличение productCount на 1 на каждой итерации
                    System.out.println("Товар " + product + " добавлен в список под номером " + productCount);

                    if(productCount == shoppingList.length) {
                        for(int i = 0; i < shoppingList.length; i++) {
                            shoppingListCopy[i] = shoppingList[i];
                        }
                        shoppingList = new String[shoppingListCopy.length];
                        //shoppingList = shoppingListCopy;
                        for(int i = 0; i < productCount; i++) {
                            shoppingList[i] = shoppingListCopy[i];
                        }
                    }
                } else {
                    System.out.println("Такой товар уже есть в списке");
                }

            } else if(actionNumber == 2) { // Показ списка
                for (int j = 0; j < productCount; j++) {
                    System.out.println((j + 1) + ". " + shoppingList[j]);
                }

            } else if (actionNumber == 3) { // Очистка списка
                for (int k = 0; k < shoppingList.length; k++) {
                    shoppingList[k] = null;
                }
                productCount = 0; // Приведение productCount в исходное состояние
                System.out.println("Список пуст.");

            } else if (actionNumber == 4) { // Завершение работы
                break;

            } else { // Если команда отсутствует
                System.out.println("Неизвестная команда!");
            }
        }
    }
}
