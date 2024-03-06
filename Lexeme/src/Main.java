import java.io.IOException;
import java.nio.file.Path;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Path path = Path.of("src", "text.txt");
        Scanner scanner = new Scanner(path);
        String expr = scanner.nextLine();
        var lexemes = lexemAnalyse(expr);
        ListIterator<Lexeme> iterator = lexemes.listIterator();
        int result = expr(iterator);
        System.out.println(result);
    }

    private static List<Lexeme> lexemAnalyse (String expression) {
        List <Lexeme> lexemesList = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            switch (expression.charAt(i)) {
                case ' ' -> { }
                case '-' -> lexemesList.add(new Lexeme(LexemType.MINUS));
                case '+' -> lexemesList.add(new Lexeme(LexemType.PLUS));
                case '*' -> lexemesList.add(new Lexeme(LexemType.MULTI));
                case '/' -> lexemesList.add(new Lexeme(LexemType.DIV));
                case '1', '2', '3', '4', '5', '6', '7', '8', '9' -> {
                    StringBuilder sb = new StringBuilder();
                    while (i < expression.length() && expression.charAt(i) >= '0' && expression.charAt(i) <= '9')
                        sb.append(expression.charAt(i++));
                    lexemesList.add(new Lexeme(Integer.parseInt(sb.toString())));
                    i--;
                }
                case '(' -> lexemesList.add(new Lexeme(LexemType.LEFT_BRACKET));
                case ')' -> lexemesList.add(new Lexeme(LexemType.RIGHT_BRACKET));
                default -> throw new RuntimeException("Unexpected character");
            }
        }
        return lexemesList;
    }

    private static int factor(ListIterator<Lexeme> pos) {
        Lexeme currentLexeme = pos.next();
        return switch (currentLexeme.type) {
            case NUMBER -> currentLexeme.value;
            case LEFT_BRACKET -> {
                int val = expr(pos);
                if (pos.next().type != LexemType.RIGHT_BRACKET)
                    throw new RuntimeException("Missing closing bracket");
                yield val;
            }
            default -> throw new RuntimeException("Unexpected character");
        };
    }

    private static int multDiv (ListIterator<Lexeme> pos) {
        int value = factor(pos);
        while (pos.hasNext()) {
            Lexeme currentLexeme = pos.next();
            switch (currentLexeme.type) {
                case MULTI -> value *= factor(pos);
                case DIV -> value /= factor(pos);
                default -> {
                    pos.previous();
                    return value;
                }
            }
        }
        return value;
    }

    private static int plusMinus (ListIterator<Lexeme> pos) {
        int value = multDiv(pos);
        while (pos.hasNext()) {
            Lexeme currentLexeme = pos.next();
            switch (currentLexeme.type) {
                case PLUS -> value += multDiv(pos);
                case MINUS -> value -= multDiv(pos);
                default -> {
                    pos.previous();
                    return value;
                }
            }
        }
        return value;
    }

    private static int expr (ListIterator<Lexeme> pos) {
        if (!pos.hasNext())
            return 0;
        else
            return plusMinus(pos);
    }

}
