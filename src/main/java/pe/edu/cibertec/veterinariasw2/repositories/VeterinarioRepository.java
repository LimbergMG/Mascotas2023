package pe.edu.cibertec.veterinariasw2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.edu.cibertec.veterinariasw2.Dtos.VeterinarioDto;
import pe.edu.cibertec.veterinariasw2.entidades.Veterinario;

public interface VeterinarioRepository  extends JpaRepository<Veterinario,Long> {
@Query("select new pe.edu.cibertec.veterinariasw2.Dtos.VeterinarioDto (v.nombre, e.nombre) from Veterinario v join v.especialidad e")
    List<VeterinarioDto> findbyResumido();
    
}
