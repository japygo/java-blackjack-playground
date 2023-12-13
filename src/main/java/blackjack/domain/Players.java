package blackjack.domain;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class Players implements Iterable<Player> {
    private final List<Player> players;

    public Players(List<Player> players) {
        this.players = players;
    }

    public Stream<Player> stream() {
        return players.stream();
    }

    @Override
    public Iterator<Player> iterator() {
        return players.iterator();
    }
}
