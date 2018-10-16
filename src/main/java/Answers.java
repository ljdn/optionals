import java.util.List;
import java.util.Optional;

public class Answers {

    // Note: the different params, as well as what gets printed when you use orElse vs orElseGet
    public String getValue(Optional<String> optionalString) {
        // return optionalString.orElse(getDefault());
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
