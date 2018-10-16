import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class OptionalOperationsTest {
    private OptionalOperations ops;

    @Before
    public void setUp() {
        ops = new OptionalOperations();
    }
    
    // The first two tests can pass with either orElse or orElseGet, but pay attention to any differences in behavior...
    // I was lazy so not all of these tests will pass (if the first is passing the third won't)

    @Test
    public void orElse_shouldGetDefaultIfOptionalIsNull() {
        Optional<String> empty = Optional.empty();
        assertThat(ops.getValue(empty), is("Default"));
    }

    @Test
    public void orElse_shouldReturnValueIfPresent() {
        Optional<String> string = Optional.of("Hello");
        assertThat(ops.getValue(string), is("Hello"));
    }

    @Test(expected = NullPointerException.class)
    public void orElseThrow_shouldThrowException() {
        Optional<String> empty = Optional.empty();
        ops.getValue(empty);
    }

    @Test
    public void filter_shouldReturnOptionalWithStringIfMatchesHello() {
        Optional<String> string = Optional.of("Hello");
        assertThat(ops.isHello(string).isPresent(), is(true));
    }

    @Test
    public void filter_shouldReturnEmptyIfStringDoesNotMatchHello() {
        Optional<String> string = Optional.of("Pie");
        assertThat(ops.isHello(string).isPresent(), is(false));
    }


    @Test
    public void map_shouldReturnSizeOfArray() {
        List<String> array = Arrays.asList("1", "2", "3");
        Optional<List<String>> optionalArray = Optional.of(array);

        assertThat(ops.getSize(optionalArray), is(3));
    }

    @Test
    public void map_shouldReturn0IfArrayIsNull() {
        Optional<List<String>> empty = Optional.empty();
        assertThat(ops.getSize(empty), is(0));
    }
}