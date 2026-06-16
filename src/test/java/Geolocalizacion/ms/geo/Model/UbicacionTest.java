package Geolocalizacion.ms.geo.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class UbicacionTest {

    @Test
    void debeCrearUbicacion() {
        Ubicacion ubicacion = new Ubicacion();

        assertNotNull(ubicacion);
    }

    @Test
    void debeAsignarDatosAUbicacion() {
        Ubicacion ubicacion = new Ubicacion();

        ubicacion.setId(1L);
        ubicacion.setLatitud(-33.4489);
        ubicacion.setLongitud(-70.6693);

        assertEquals(1L, ubicacion.getId());
        assertEquals(-33.4489, ubicacion.getLatitud());
        assertEquals(-70.6693, ubicacion.getLongitud());
    }
}