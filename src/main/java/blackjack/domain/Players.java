package blackjack.domain;

import java.util.Iterator;
import java.util.List;

public class Players implements Iterable<Player> {
    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public List<Player> getPlayers() {
        return players;
    }

    @Override
    public Iterator<Player> iterator() {
        return players.iterator();
    }
}
