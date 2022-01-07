package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballNumberTest {

    @DisplayName("포지션 정보와 숫자를 가진 숫자 야구 한 개를 생성한다")
    @ParameterizedTest
    @CsvSource(value = {"1,9", "2,3"}, delimiter = ',')
    void 숫자_야구_생성_test(int position, int number) {
        BaseballNumber baseballNumber = new BaseballNumber(position, number);
        assertThat(baseballNumber.position()).isEqualTo(position);
        assertThat(baseballNumber.number()).isEqualTo(number);
    }

    @DisplayName("숫자는 1 - 9 이외의 경우 에러를 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"1,10", "2,0"}, delimiter = ',')
    void 숫자_야구_생성_number_exception_test(int position, int number) {
        assertThatThrownBy(() -> new BaseballNumber(position, number))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("위치는 1 - 3 이외의 경우 에러를 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"0,3", "4,1"}, delimiter = ',')
    void 숫자_야구_생성_position_exception_test(int position, int number) {
        assertThatThrownBy(() -> new BaseballNumber(position, number))
            .isInstanceOf(IllegalArgumentException.class);
    }
}