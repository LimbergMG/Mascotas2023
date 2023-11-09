package pe.edu.cibertec.veterinariasw2.controladores;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import pe.edu.cibertec.veterinariasw2.entidades.Mascota;
import pe.edu.cibertec.veterinariasw2.repositories.MascotaRepository;

@RestController

@AllArgsConstructor
public class MascotaController{

    MascotaRepository mascotaRepository;


    
    @GetMapping("obtenerMascotas")
    public List<Mascota> listarMascota(){
        return mascotaRepository.findAll();
    }

    @PostMapping("registrarMascota")
    public Long registrarMascota(Mascota mascota){
        Mascota mascotaGuardada = mascotaRepository.save(mascota);


        return mascotaGuardada.getId();
    }

}
