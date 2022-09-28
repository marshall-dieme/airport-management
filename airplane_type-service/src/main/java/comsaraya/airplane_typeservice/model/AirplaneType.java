package comsaraya.airplane_typeservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirplaneType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long airplane_type_id;
    private String airplane_type_identifier;



}
