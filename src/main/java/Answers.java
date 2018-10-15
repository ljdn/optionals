import java.util.List;
import java.util.Optional;

public class Answers {

    public String getValue(Optional<String> optionalString) {
//        return optionalString.orElse(getDefault());
        return optionalString.orElseGet(this::getDefault);
    }

    public Optional<String> isHello(Optional<String> string) {
        return string.filter(str -> str.equals("Hello"));
    }

    public Integer getSize(Optional<List<String>> optionalArray) {
        return optionalArray.map(List::size).orElse(0);
    }

    private String getDefault() {
        System.out.println("Getting default!");
        return "Default";
    }
}
