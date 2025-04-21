package Ergin.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String eventText;

    @ManyToOne
    @JoinColumn(name = "TDL_id")
    @JsonBackReference
    private TDL TDL;

    public Event(String text) {
        this.eventText = text;
    }


    @Override
    public String toString() {
        return "Event{" +
                "eventText='" + eventText + '\'' +
                ", id=" + id +
                '}';
    }
}
