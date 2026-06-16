package Geolocalizacion.ms.geo.service;

import Geolocalizacion.ms.geo.model.ubicacion;
import java.util.List;

public interface IUbicacionService {
    
    ubicacion guardar(ubicacion ubicacion);
    
    List<ubicacion> obtenerTodas();

    List<ubicacion> obtenerPorMascota(Long mascotaId);
  
    long contarPorComuna(String comuna);
}