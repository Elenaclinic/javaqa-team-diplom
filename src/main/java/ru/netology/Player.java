package ru.netology;

import java.util.HashMap;
import java.util.Map;

public class Player {
    private String name;


    /** 1+информация о том, в какую игру сколько часов было сыграно
    ключ - игра
    значение - суммарное количество часов игры в эту игру */

    private Map<Game, Integer> playedTime = new HashMap<>();

    public Player(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }


    /** 2+ добавление игры игроку
    если игра уже была, никаких изменений происходить не должно */

    public void installGame(Game game) {
        if (!playedTime.containsKey(game)) {
            playedTime.put(game, 0);
        }
    }


    /** 3 игрок играет в игру game на протяжении hours часов
    об этом нужно сообщить объекту-каталогу игр, откуда была установлена игра
    также надо обновить значения в мапе игрока, добавив проигранное количество часов
    возвращает суммарное количество часов, проигранное в эту игру.
    если игра не была установлена, то надо выкидывать RuntimeException */

    public int play(Game game, int hours) {
        game.getStore().addPlayTime(name, hours);
        if (playedTime.containsKey(game)) {
            playedTime.put(game, playedTime.get(game) + hours);
        } else {
            throw new NotInstalledException(game);
        }
        return playedTime.get(game);
    }

    /** +4 Метод принимает жанр игры (одно из полей объекта игры) и
     суммирует время, проигранное во все игры этого жанра этим игроком */

    public int sumGenre(String genre) {
        int sum = 0;
        for (Game game : playedTime.keySet()) {
            if (game.getGenre().equals(genre)) {
                sum += playedTime.get(game);
            }
        }
        return sum;
    }


    /** 5 Метод принимает жанр и возвращает игру этого жанра, в которую играли больше всего
     Если в игры этого жанра не играли, возвращается null */

    public Game mostPlayerByGenre(String genre) {
        Game game = null;
        int time = 0;
        for (Map.Entry<Game, Integer> entry : playedTime.entrySet()) {
            Game key = entry.getKey();
            Integer value = entry.getValue();

            if (key.getGenre().equals(genre) && value > time) {
                time = value;
                game = key;
            }
        }
        return game;
    }
}

