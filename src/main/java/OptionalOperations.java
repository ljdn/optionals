import java.util.List;
import java.util.Optional;

public class OptionalOperations {

    // Answers are in Answers.java

    public String getValue(Optional<String> optionalString) {
        return null;
    }

    public Optional<String> isHello(Optional<String> string) {
        return null;
    }

    public Integer getSize(Optional<List<String>> optionalArray) {
        return null;
    }

    // The print statement is here for a reason ;)
    private String getDefault() {
        System.out.println("Getting default!");
        return "Default";
    }
}
