package Geolocalizacion.ms.geo.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "geolocalizaciones")
@Data 
public class ubicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long mascotaId; 

    private Double latitud;
    private Double longitud;

    private String comuna;
    private String sectorReferencia;

    private LocalDateTime fechaHora;

    @PrePersist
    protected void onCreate() {
        this.fechaHora = LocalDateTime.now();
    }
}