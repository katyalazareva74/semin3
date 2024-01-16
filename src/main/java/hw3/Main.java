package hw3;

import static hw3.OutputInput.*;

public class Main {
    /**
     * 1. Разработайте класс Student с полями String name, int age, transient double GPA (средний балл).
     * Обеспечьте поддержку сериализации для этого класса.
     * Создайте объект класса Student и инициализируйте его данными.
     * Сериализуйте этот объект в файл.
     * Десериализуйте объект обратно в программу из файла.
     * Выведите все поля объекта, включая GPA, и ответьте на вопрос,
     * почему значение GPA не было сохранено/восстановлено.
     * 2. * Выполнить задачу 1 используя другие типы сериализаторов (в xml и json документы).
     *
     * @param args
     */
    public static void main(String[] args) {
        Student student1 = new Student("Denis", 20, new double[]{5.00, 4.00, 5.00});
        Student student2 = new Student("Elena", 19, new double[]{5.00, 4.00, 4.00});
        Student student3 = new Student("Oleg", 21, new double[]{5.00, 5.00, 5.00});
        System.out.println(student1.toString());
        System.out.println(student2.toString());
        System.out.println(student3.toString());
        OutputInput.saveObject(student1, FILE_BIN);
        OutputInput.saveObject(student2, FILE_JSON);
        OutputInput.saveObject(student3, FILE_XML);
        student1 = OutputInput.loadObject(FILE_BIN);
        System.out.println(student1.toString());
        student2 = OutputInput.loadObject(FILE_JSON);
        System.out.println(student2.toString());
        student3 = OutputInput.loadObject(FILE_XML);
        System.out.println(student3.toString());
    }
}
