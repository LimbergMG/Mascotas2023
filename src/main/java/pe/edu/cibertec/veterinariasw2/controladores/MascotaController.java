package pe.edu.cibertec.veterinariasw2.controladores;


import java.util.List;

import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import pe.edu.cibertec.veterinariasw2.MascotaRequest;
import pe.edu.cibertec.veterinariasw2.entidades.Mascota;
import pe.edu.cibertec.veterinariasw2.repositories.MascotaRepository;

@RestController

@AllArgsConstructor

@RequestMapping("mascotas")
public class MascotaController{

    MascotaRepository mascotaRepository;


    
    @GetMapping
    public List<Mascota> listarMascota(String nombre){
        if(nombre != null){

            return mascotaRepository.searchByNombreContains(nombre);
        }
        return mascotaRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Mascota> findById(@PathVariable Long id){
        
        return ResponseEntity.of(mascotaRepository.findById(id));
    }
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Long register(@RequestBody @Valid MascotaRequest mascotaRequest){
        Mascota mascota = new Mascota();
       mascota.nombre = mascotaRequest.nombre;
       mascota.dueño = mascotaRequest.dueño;
       Mascota mascotaGuardada =  mascotaRepository.save(mascota);  
       return mascotaGuardada.id;
    }
    @DeleteMapping("{id}")
    public  void deleteById(@PathVariable Long id){

        mascotaRepository.deleteById(id);;
    }
    @PutMapping("{id}")
    public ResponseEntity<Mascota> update(@PathVariable Long id,@RequestBody @Valid MascotaRequest mascotaRequest){

       Optional<Mascota> mascotaOptional= mascotaRepository.findById(id);
       if(mascotaOptional.isPresent()){
        Mascota mascota = mascotaOptional.get();
        mascota.nombre= mascotaRequest.nombre;
        mascota.dueño = mascotaRequest.dueño;
        mascotaRepository.save(mascota);

        return ResponseEntity.ok(mascota);
       }
       return ResponseEntity.notFound().build();
    }


    @PatchMapping("{id}")
    public ResponseEntity<Mascota> updatePartial(@PathVariable Long id,@RequestBody  MascotaRequest mascotaRequest){

        return mascotaRepository.findById(id).map(mascota ->{
            if(mascotaRequest.dueño != null){
                mascota.dueño = mascotaRequest.dueño;
            }

              if(mascotaRequest.nombre != null){
                mascota.nombre = mascotaRequest.nombre;
            }


            mascotaRepository.save(mascota);

            return ResponseEntity.ok(mascota);
        }).orElseGet(()-> ResponseEntity.notFound().build());
       
    }
}

