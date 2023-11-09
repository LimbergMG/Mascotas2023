package pe.edu.cibertec.veterinariasw2.repositories;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.edu.cibertec.veterinariasw2.entidades.Mascota;

public interface MascotaRepository  extends JpaRepository <Mascota,Long>{

    @Query("select ma from Mascota as ma where nombre like CONCAT('%',:nombre,'%')")
    List<Mascota> buscarMascotaPorNombre(String nombre);


    //select * from where nombre = ?
     List<Mascota> findByNombre(String nombre);

     List<Mascota> readByNombre(String nombre);

     List<Mascota> queryByNombre(String nombre);

     List<Mascota> searchByNombre(String nombre);

      List<Mascota> searchByNombreContains(String nombre);
}
