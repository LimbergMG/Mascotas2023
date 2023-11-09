package pe.edu.cibertec.veterinariasw2;


import jakarta.validation.constraints.NotBlank;

import lombok.Setter;



@Setter
public class MascotaRequest {
   @NotBlank
   public String nombre;
   @NotBlank
   public String dueño;


   // @PositiveOrZero
   //@Min(1)
   //@Max(25)
   //int edad;
}
