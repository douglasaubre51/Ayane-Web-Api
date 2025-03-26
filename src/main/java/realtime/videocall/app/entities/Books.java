package realtime.videocall.app.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name="books")
public class Books {
    @Id
    public Long Id;
    public String name;
    public String author;
    public String price;
}
