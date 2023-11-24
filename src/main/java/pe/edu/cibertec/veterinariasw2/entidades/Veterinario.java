package pe.edu.cibertec.veterinariasw2.entidades;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Entity
@Getter
public class Veterinario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;



    public   String nombre;
    String dni;
    String carnet;
    BigDecimal salario;

    @ManyToOne
  public   Especialidad especialidad;
}
