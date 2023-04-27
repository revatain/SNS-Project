package main;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class User {
    private int idx;
    private String name;

}
