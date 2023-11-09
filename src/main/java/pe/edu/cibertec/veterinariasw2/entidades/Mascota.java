package pe.edu.cibertec.veterinariasw2.entidades;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class Mascota {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    public
    Long id;
    public String nombre;
    public String dueño;
}
