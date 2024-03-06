public class Lexeme {
	
    LexemType type;
    int value;
	
    public Lexeme(int value) {
        this.type = LexemType.NUMBER;
        this.value = value;
    }

    public Lexeme(LexemType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Lexem{" +
                "type=" + type +
                ", value=" + value +
                '}';
    }
}
