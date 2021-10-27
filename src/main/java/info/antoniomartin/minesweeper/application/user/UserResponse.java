package info.antoniomartin.minesweeper.application.user;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserResponse {
    private final String id;
    private final String name;
    private final String email;
}
