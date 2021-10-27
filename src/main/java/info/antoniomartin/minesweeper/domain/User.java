package info.antoniomartin.minesweeper.domain;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class User {
    private final String id;
    private final String password;
    private final String name;
    private final String email;
}
