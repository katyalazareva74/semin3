package hw3;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.*;

public class OutputInput {
    public static final String FILE_JSON = "task2.json";
    public static final String FILE_BIN = "task1.bin";
    public static final String FILE_XML = "task2.xml";
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static final XmlMapper xmlMapper = new XmlMapper();

    public static void saveObject(Object o, String filename) {
        try {
            if (filename.endsWith(".json")) {
                objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                objectMapper.writeValue(new File(filename), o);
                System.out.println("Объект Student сериализован в  файл .json.");
            } else if (filename.endsWith(".xml")) {
                xmlMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
                xmlMapper.writeValue(new File(filename), o);
                System.out.println("Объект Student сериализован в  файл .xml.");
            } else if (filename.endsWith(".bin")) {
                try (FileOutputStream fileOutputStream = new FileOutputStream(FILE_BIN); ObjectOutputStream output = new ObjectOutputStream(fileOutputStream)) {
                    output.writeObject(o);
                    System.out.println("Объект Student сериализован в  файл .bin. Значение GPA не было сохранено, так как поле GPA имеет модификатор transient.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Student loadObject(String fileName) {
        File file = new File(fileName);
        Student student = new Student();
        if (file.exists()) {
            try {
                if (fileName.endsWith(".json")) {
                    student = objectMapper.readValue(file, objectMapper.getTypeFactory().constructType(Student.class));
                    System.out.println("Объект Student десериализован из файла .json");
                } else if (fileName.endsWith(".xml")) {
                    student = xmlMapper.readValue(file, xmlMapper.getTypeFactory().constructType(Student.class));
                    System.out.println("Объект Student десериализован из файла .xml");
                } else if (fileName.endsWith(".bin")) {
                    try (FileInputStream fileInputStream = new FileInputStream(FILE_BIN); ObjectInputStream input = new ObjectInputStream(fileInputStream)) {
                        student = (Student) input.readObject();
                        System.out.println("Объект Student десериализован из файла .bin");
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return student;
    }
}
