package info.antoniomartin.minesweeper.application.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class UserResponse {
    private String id;
    private String name;
    private String email;
}
