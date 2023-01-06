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

    @Test
    public void sumGenreGames() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Syberia", "Quest");
        Game game1 = store.publishGame("Syberia 2", "Quest");
        Game game3 = store.publishGame("Portal", "Adventure");

        Player player = new Player("Evgenia");
        player.installGame(game);
        player.installGame(game1);
        player.installGame(game3);
        player.play(game, 2);
        player.play(game1, 2);
        player.play(game3, 1);

        int expected = 4;
        int actual = player.sumGenre("Quest");
        assertEquals(expected, actual);
    }

    @Test
    public void playerByGenre() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Syberia", "Quest");
        Game game1 = store.publishGame("Syberia 2", "Quest");
        Game game3 = store.publishGame("Portal", "Adventure");

        Player player = new Player("Evgenia");
        player.installGame(game);
        player.installGame(game1);
        player.installGame(game3);
        player.play(game, 2);
        player.play(game1, 4);
        player.play(game3, 1);

        String expected = game.getTitle();
        Game actual = player.mostPlayerByGenre("Quest");
        assertEquals(expected, actual);
    }
}
