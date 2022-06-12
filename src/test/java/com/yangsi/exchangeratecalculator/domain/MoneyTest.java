package com.yangsi.exchangeratecalculator.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Java6Assertions.assertThat;

class MoneyTest {


    @ParameterizedTest
    @ValueSource(doubles = {1, 5, 10})
    void money_생성성공(double amount) {
        Money money = Money.of(amount, CountryEnum.미국);
        assertThat(money).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(doubles = {-10, 0})
    void money_생성실패(double amount) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> Money.of(amount, CountryEnum.미국)
        ).withMessageContaining("유효하지않은 돈입니다.");
    }

    @Test
    void 환전() {
        Money dollar = Money.of(1, CountryEnum.미국);

        String krw_exchange_rate = "1190.42";
        Money exchanged = dollar.exchange(krw_exchange_rate, CountryEnum.한국);

        assertThat(exchanged.getCountry()).isEqualTo(CountryEnum.한국);
        assertThat(exchanged.getValue().toString()).isEqualTo(krw_exchange_rate);

    }
}
