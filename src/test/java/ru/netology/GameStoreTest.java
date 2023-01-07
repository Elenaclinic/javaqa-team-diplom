package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameStoreTest {

    @Test
    public void shouldAddGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        assertTrue(store.containsGame(game));
    }

    @Test
    public void testIfNotContainsGame() {

        GameStore store = new GameStore();
        Game game = null;

        Boolean expected = false;
        Boolean actual = store.containsGame(game);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldContainsGame() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Boolean expected = true;
        Boolean actual = store.containsGame(game);

        assertEquals(expected, actual);
    }

    @Test
    public void playTimeCheck() {

        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player = new Player("Elena");
        player.installGame(game);
        player.play(game, 3);
        store.addPlayTime("Elena", 4);


        int expected = 7;
        int actual = store.getSumPlayedTime();

        assertEquals(expected, actual);

    }

    @Test
    public void shouldMostPlayedPlayer() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player1 = new Player("Elena");
        player1.installGame(game);
        player1.play(game, 3);

        Player player2 = new Player("Alex");
        player2.installGame(game);
        player2.play(game, 4);


        String expected = "Alex";
        String actual = store.getMostPlayer();
        assertEquals(expected, actual);
    }

    @Test
    public void testIfNotMostPlayer() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        String expected = null;
        String actual = store.getMostPlayer();
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSumPlayedTime() {
        GameStore store = new GameStore();
        Game game = store.publishGame("Нетология Баттл Онлайн", "Аркады");

        Player player1 = new Player("Elena");
        player1.installGame(game);
        player1.play(game, 3);

        Player player2 = new Player("Alex");
        player2.installGame(game);
        player2.play(game, 4);


        int expected = 7;
        int actual = store.getSumPlayedTime();
        assertEquals(expected, actual);
    }
}
