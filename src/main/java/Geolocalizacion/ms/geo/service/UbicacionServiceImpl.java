package Geolocalizacion.ms.geo.service;

import Geolocalizacion.ms.geo.model.ubicacion;
import Geolocalizacion.ms.geo.repository.UbicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UbicacionServiceImpl implements IUbicacionService {

    @Autowired
    private UbicacionRepository ubicacionRepository;

    @Override
    public ubicacion guardar(ubicacion ubicacion) {
        return ubicacionRepository.save(ubicacion);
    }

    @Override
    public List<ubicacion> obtenerTodas() {
        return ubicacionRepository.findAll();
    }

    @Override
    public List<ubicacion> obtenerPorMascota(Long mascotaId) {
        return ubicacionRepository.findByMascotaId(mascotaId);
    }

    @Override
    public long contarPorComuna(String comuna) {
        return ubicacionRepository.countByComuna(comuna);
    }
}
