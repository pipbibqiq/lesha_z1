import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexProcessor {
    private Pattern pattern;
    private String text;

    public RegexProcessor(String pattern, String text) {
        this.pattern = Pattern.compile(pattern);
        this.text = text;
    }

    public RegexProcessor() {
        this("", "");
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPattern() {
        return pattern.pattern();
    }

    public void setPattern(String pattern) {
        this.pattern = Pattern.compile(pattern);
    }

    public void displayText() {
        System.out.println("Текст: " + text);
    }

    public boolean containsPattern() {
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }

    public void displayMatchingFragments() {
        Matcher matcher = pattern.matcher(text);

        System.out.println("Фрагменты текста, соответствующие шаблону:");
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    public void removeMatchingFragments() {
        text = text.replaceAll(pattern.pattern(), "");
    }
}