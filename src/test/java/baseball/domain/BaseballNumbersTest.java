package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BaseballNumbersTest {

    @DisplayName("숫자 3개로 숫자야구 세트를 만든다")
    @ParameterizedTest
    @MethodSource("generatedData")
    void 숫자_야구_세트_생성_test(List<Integer> numbers) {
        BaseballNumbers baseballNumbers = new BaseballNumbers(numbers);
        assertThat(baseballNumbers.size()).isEqualTo(3);
    }

    @DisplayName("숫자 야구 세트에 같은 숫자가 있다면 에러를 반환한다.")
    @Test
    void 숫자_야구_같은_숫자_exception_test() {
        assertThatThrownBy(() -> new BaseballNumbers(Arrays.asList(1, 1, 2)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자 야구 세트에 3개 이외의 갯수가 있다면 에러를 반환한다.")
    @Test
    void 숫자_야구_갯수_exception_test() {
        assertThatThrownBy(() -> new BaseballNumbers(Arrays.asList(1, 2)))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new BaseballNumbers(Arrays.asList(1, 2, 3, 4)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자 야구 세트 수가 1 - 9 이외의 수일 경우 에러를 반환한다")
    @Test
    void 숫자_야구_수_exception_test() {
        assertThatThrownBy(() -> new BaseballNumbers(Arrays.asList(0, 2, 3)))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new BaseballNumbers(Arrays.asList(10, 2, 3)))
            .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> generatedData() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 2, 3)),
            Arguments.of(Arrays.asList(7, 8, 9))
        );
    }
}