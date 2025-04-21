package Ergin.demo.model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class TDL {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @OneToMany(mappedBy = "TDL", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Event> events;

    public TDL(String name) {
        this.name = name;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
        for (Event event : events) {
            event.setTDL(this);
            break;
        }
    }
}
