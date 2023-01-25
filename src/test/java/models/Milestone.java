package models;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
//@Data - заменяет все вышеописанное
// но конструктор должен быть с обязательным параметром
public class Milestone {
    @EqualsAndHashCode.Exclude
    private int id;
    @NonNull
    private String name;
    private String references;
    private String description;
    @ToString.Exclude
    private boolean completed;
}
