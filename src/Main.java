import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RegexProcessor regexProcessor = new RegexProcessor();

        System.out.println("Введите текст:");
        String textStr = scanner.nextLine();
        regexProcessor.setText(textStr);

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Вывести текст");
            System.out.println("2. Проверить наличие фрагментов, соответствующих шаблону");
            System.out.println("3. Вывести фрагменты текста, соответствующие шаблону");
            System.out.println("4. Удалить фрагменты текста, соответствующие шаблону");
            System.out.println("5. Установить новый шаблон поиска");
            System.out.println("0. Выйти");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера после ввода числа

            switch (choice) {
                case 1:
                    regexProcessor.displayText();
                    break;
                case 2:
                    boolean containsPattern = regexProcessor.containsPattern();
                    System.out.println("Содержит фрагменты, соответствующие шаблону: " + containsPattern);
                    break;
                case 3:
                    regexProcessor.displayMatchingFragments();
                    break;
                case 4:
                    regexProcessor.removeMatchingFragments();
                    System.out.println("Фрагменты текста, соответствующие шаблону, удалены.");
                    break;
                case 5:
                    System.out.println("Введите новый шаблон поиска:");
                    String newPattern = scanner.nextLine();
                    regexProcessor.setPattern(newPattern);
                    break;
                case 0:
                    System.out.println("Программа завершена.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Неверный выбор. Повторите попытку.");
            }
        }
    }
}