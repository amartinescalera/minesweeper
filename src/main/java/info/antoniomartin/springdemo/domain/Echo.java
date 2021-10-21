package info.antoniomartin.springdemo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class Echo {
    private final String msg;
    private final Long time;
}
