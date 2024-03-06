public class Main {
    public static void main(String[] args) {
        // Создание экземпляра CustomContainer
        CustomContainer<String> container = new CustomContainer<>();

        // Добавление элементов в контейнер
        container.add("Элемент 1");
        container.add("Элемент 2");
        container.add("Элемент 3");

        // Получение элемента по индексу
        String element = container.get(1);
        System.out.println("Элемент по индексу 1: " + element);

        // Удаление элемента по индексу
        container.remove(0);

        // Проверка размера контейнера
        int size = container.size();
        System.out.println("Размер контейнера: " + size);

        // Проверка на пустоту
        boolean isEmpty = container.isEmpty();
        System.out.println("Контейнер пустой? " + isEmpty);

        // Итерация по элементам контейнера с помощью цикла for-each
        for (String item : container) {
            System.out.println(item);
        }
    }
}
