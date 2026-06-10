package Geolocalizacion.ms.geo.repository;

import Geolocalizacion.ms.geo.model.ubicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UbicacionRepository extends JpaRepository<ubicacion, Long> {


    List<ubicacion> findByMascotaId(Long mascotaId);
    long countByComuna(String comuna);
}