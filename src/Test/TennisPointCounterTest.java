package Test;

import com.MartaPrzybyl.TennisPointCounter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class TennisPointCounterTest {
    private TennisPointCounter counter;

    public TennisPointCounterTest() {
        counter = new TennisPointCounter();
    }

    public void checkResult(String result) {
        String resultValue = counter.getPoints();
        assertEquals(result, resultValue);
    }

    @Test
    public void shouldReturnZeroOnInit() {
        checkResult("0:0");
    }

    @Test
    public void shouldAddFirstPointToPlayerOne() {
        counter.addPointsToPlayer(1);
        checkResult("15:0");
    }

    @Test
    public void shouldAddFirstPointToPlayerTwo() {
        counter.addPointsToPlayer(2);
        checkResult("0:15");
    }

    @Test
    public void shouldAddFirstPointToPlayerThree() {
        counter.addPointsToPlayer(3);
        checkResult("Error!");
    }

    @Test
    public void shouldAddPointsToBothPlayers() {
        counter.addPointsToPlayer(1);
        counter.addPointsToPlayer(2);
        checkResult("15:15");
    }

    @Test
    public void shouldAddSecondPointToBothPlayers() {
        counter.addPointsToPlayer(1);
        counter.addPointsToPlayer(1);
        counter.addPointsToPlayer(2);
        counter.addPointsToPlayer(2);
        checkResult("30:30");
    }

    @Test
    public void shouldAddThirdPointToPlayerOne() {
        counter.addPointsToPlayer(1);
        counter.addPointsToPlayer(1);
        counter.addPointsToPlayer(2);
        counter.addPointsToPlayer(2);
        counter.addPointsToPlayer(1);
        checkResult("40:30");
    }

    @Test
    public void shouldAddThirdPointToPlayerTwo() {
        counter.addPointsToPlayer(1);
        counter.addPointsToPlayer(1);
        counter.addPointsToPlayer(2);
        counter.addPointsToPlayer(2);
        counter.addPointsToPlayer(1);
        counter.addPointsToPlayer(2);
        checkResult("40:40");
    }

    @Test
    public void shouldShowPlayerOneWins() {
        counter.addPointsToPlayer(1);
        counter.addPointsToPlayer(1);
        counter.addPointsToPlayer(2);
        counter.addPointsToPlayer(2);
        counter.addPointsToPlayer(1);
        counter.addPointsToPlayer(2);
        counter.addPointsToPlayer(1);
        counter.addPointsToPlayer(1);
        checkResult("winner:40");
    }

    @Test
    public void shouldShowPlayerOneIsAd() {
        counter.addPointsToPlayer(1);
        counter.addPointsToPlayer(1);
        counter.addPointsToPlayer(2);
        counter.addPointsToPlayer(2);
        counter.addPointsToPlayer(1);
        counter.addPointsToPlayer(2);
        counter.addPointsToPlayer(1);
        checkResult("ad:40");
    }

    @Test
    public void shouldShowPlayerTwoIsAd() {
        counter.addPointsToPlayer(1);
        counter.addPointsToPlayer(1);
        counter.addPointsToPlayer(2);
        counter.addPointsToPlayer(2);
        counter.addPointsToPlayer(1);
        counter.addPointsToPlayer(2);
        counter.addPointsToPlayer(2);
//        counter.addPointsToPlayer(2);
        checkResult("40:ad");
    }

    @Test
    public void shouldShowPlayerTwoWins() {
        counter.addPointsToPlayer(1);
        counter.addPointsToPlayer(2);
        counter.addPointsToPlayer(1);
        counter.addPointsToPlayer(2);
        counter.addPointsToPlayer(1);
        counter.addPointsToPlayer(2);
        counter.addPointsToPlayer(2);
        counter.addPointsToPlayer(2);
        checkResult("40:winner");
    }

    @Test
    public void shouldShowPlayerTwoWinsWithTwoPointsMore() {
        counter.addPointsToPlayer(1);
        counter.addPointsToPlayer(2);
        counter.addPointsToPlayer(2);
        counter.addPointsToPlayer(2);
        checkResult("15:winner");
    }

    @Test
    public void shouldShowPlayerOneWinsWithTwoPointsMore() {
        counter.addPointsToPlayer(1);
        counter.addPointsToPlayer(2);
        counter.addPointsToPlayer(1);
        counter.addPointsToPlayer(1);
        checkResult("winner:15");
    }

    @Test
    public void shouldShowPlayerOneWinsTo30() {
        counter.addPointsToPlayer(1);
        counter.addPointsToPlayer(2);
        counter.addPointsToPlayer(1);
        counter.addPointsToPlayer(2);
        counter.addPointsToPlayer(1);
        counter.addPointsToPlayer(1);
        checkResult("winner:30");
    }

    @Test
    public void shouldShowPlayerTwoWinsTo30() {
        counter.addPointsToPlayer(1);
        counter.addPointsToPlayer(2);
        counter.addPointsToPlayer(1);
        counter.addPointsToPlayer(2);
        counter.addPointsToPlayer(2);
        counter.addPointsToPlayer(2);
        checkResult("30:winner");
    }
}