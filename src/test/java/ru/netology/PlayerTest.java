package ru.netology;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    @Test
    public void shouldSumGenreIfOneGame() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Petya");
        player.installGame(game);
        player.play(game, 3);

        int expected = 3;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }

    // другие ваши тесты
    @Test
    public void shouldRunTimeException() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Syberia", "Quest");
        Game game1 = store.publishGame("Syberia 2", "Quest");
        Game game3 = store.publishGame("Portal", "Adventure");

        Player player = new Player("Evgenia");
        player.installGame(game);


        assertThrows(RuntimeException.class, () -> {
            player.play(game1, 1);

        });
    }

    @Test
    public void addGameDouble() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Syberia", "Quest");
        Game game1 = store.publishGame("Syberia 2", "Quest");
        Game game3 = store.publishGame("Portal", "Adventure");

        Player player = new Player("Evgenia");
        player.installGame(game);
        player.play(game, 1);
        player.installGame(game);

        int expected = 1;
        int actual = player.sumGenre(game.getGenre());
        assertEquals(expected, actual);
    }
}
