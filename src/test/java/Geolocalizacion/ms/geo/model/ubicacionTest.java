package Geolocalizacion.ms.geo.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class ubicacionTest {

    @Test
    void deberiaAsignarYObtenerDatosDeUbicacion() {
        // Arrange
        ubicacion ubi = new ubicacion();

        // Act
        ubi.setId(1L);
        ubi.setMascotaId(37L); // Rocco
        ubi.setLatitud(-33.4489);
        ubi.setLongitud(-70.6693);
        ubi.setComuna("Santiago Centro");
        ubi.setSectorReferencia("Cerca de la plaza");

        // Assert
        assertAll("Verificando datos de la ubicación",
            () -> assertEquals(1L, ubi.getId()),
            () -> assertEquals(37L, ubi.getMascotaId()),
            () -> assertEquals(-33.4489, ubi.getLatitud()),
            () -> assertEquals(-70.6693, ubi.getLongitud()),
            () -> assertEquals("Santiago Centro", ubi.getComuna()),
            () -> assertEquals("Cerca de la plaza", ubi.getSectorReferencia())
        );
    }


    @Test
    void deberiaAsignarFechaHoraAntesDePersistir() {
        // Arrange
        ubicacion ubi = new ubicacion();
        // Assert: 
        assertNull(ubi.getFechaHora(), "La fecha debería ser nula antes de crearse");
        // Act:
        ubi.onCreate();
        // Assert: 
        assertNotNull(ubi.getFechaHora(), "La fecha no debería ser nula después del onCreate");
    }
}