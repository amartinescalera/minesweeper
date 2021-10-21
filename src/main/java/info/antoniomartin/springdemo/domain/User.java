package info.antoniomartin.springdemo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class User {
    private final String id;
    private final String name;
    private final String email;
}
