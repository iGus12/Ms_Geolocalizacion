package Geolocalizacion.ms.geo.controller;

import Geolocalizacion.ms.geo.model.ubicacion;
import Geolocalizacion.ms.geo.service.IUbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/geo")
@CrossOrigin(origins = "*")
public class ubicacionController {

    @Autowired
    private IUbicacionService ubicacionService;

    @GetMapping("/listar")
    public ResponseEntity<List<ubicacion>> listarTodas() {
        return ResponseEntity.ok(ubicacionService.obtenerTodas());
    }

    @PostMapping("/registrar")
    public ResponseEntity<ubicacion> registrarUbicacion(@RequestBody ubicacion nuevaUbicacion) {
        return ResponseEntity.ok(ubicacionService.guardar(nuevaUbicacion));
    }

    @GetMapping("/mascota/{mascotaId}")
    public ResponseEntity<List<ubicacion>> obtenerPorMascota(@PathVariable Long mascotaId) {
        return ResponseEntity.ok(ubicacionService.obtenerPorMascota(mascotaId));
    }

    @GetMapping("/contar/{comuna}")
    public ResponseEntity<Long> contarPorComuna(@PathVariable String comuna) {
        return ResponseEntity.ok(ubicacionService.contarPorComuna(comuna));
    }
}