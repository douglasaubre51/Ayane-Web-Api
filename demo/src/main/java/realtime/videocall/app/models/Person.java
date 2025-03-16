package realtime.videocall.app.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person {
    public String name;
    public String email;
    public String password;
}
