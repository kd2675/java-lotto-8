package lotto.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {
    @DisplayName("6개 일치 1등")
    @Test
    void firstRank() {
        // given
        int matchCount = 6;
        boolean matchBonus = false;

        // when
        Rank rank = Rank.valueOf(matchCount, matchBonus);

        // then
        assertThat(rank).isEqualTo(Rank.FIRST);
        assertThat(rank.isWinning()).isTrue();
    }

    @DisplayName("5개, 보너스 일치 2등")
    @Test
    void secondRank() {
        // given
        int matchCount = 5;
        boolean matchBonus = true;

        // when
        Rank rank = Rank.valueOf(matchCount, matchBonus);

        // then
        assertThat(rank).isEqualTo(Rank.SECOND);
        assertThat(rank.isWinning()).isTrue();
    }

    @DisplayName("5개 일치 3등")
    @Test
    void thirdRank() {
        // given
        int matchCount = 5;
        boolean matchBonus = false;

        // when
        Rank rank = Rank.valueOf(matchCount, matchBonus);

        // then
        assertThat(rank).isEqualTo(Rank.THIRD);
        assertThat(rank.isWinning()).isTrue();
    }

    @DisplayName("4개 일치 4등")
    @Test
    void fourthRank() {
        // given
        int matchCount = 4;
        boolean matchBonus = false;

        // when
        Rank rank = Rank.valueOf(matchCount, matchBonus);

        // then
        assertThat(rank).isEqualTo(Rank.FOURTH);
        assertThat(rank.isWinning()).isTrue();
    }

    @DisplayName("3개 일치 5등")
    @Test
    void fifthRank() {
        // given
        int matchCount = 3;
        boolean matchBonus = false;

        // when
        Rank rank = Rank.valueOf(matchCount, matchBonus);

        // then
        assertThat(rank).isEqualTo(Rank.FIFTH);
        assertThat(rank.isWinning()).isTrue();
    }

    @DisplayName("2개 이하 일치하면 당첨되지 않는다")
    @Test
    void noRank() {
        // given
        int matchCount = 2;
        boolean matchBonus = false;

        // when
        Rank rank = Rank.valueOf(matchCount, matchBonus);

        // then
        assertThat(rank).isEqualTo(Rank.NONE);
        assertThat(rank.isWinning()).isFalse();
    }
}