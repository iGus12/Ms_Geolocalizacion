package Geolocalizacion.ms.geo.service; 

import Geolocalizacion.ms.geo.model.ubicacion;
import Geolocalizacion.ms.geo.repository.UbicacionRepository;
import Geolocalizacion.ms.geo.service.UbicacionServiceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class UbicacionServiceImplTest {

    @Mock
    private UbicacionRepository ubicacionRepository;

    @InjectMocks
    private UbicacionServiceImpl ubicacionService;

    private ubicacion ubicacionRocco;

    @BeforeEach
    void setUp() {
        // Preparamos la ubicación de Rocco (ID mascota = 37L)
        ubicacionRocco = new ubicacion();
        ubicacionRocco.setId(1L);
        ubicacionRocco.setMascotaId(37L); 
        ubicacionRocco.setComuna("Santiago Centro");
    }

    @Test
    public void deberiaGuardarUbicacion() {
        when(ubicacionRepository.save(any(ubicacion.class))).thenReturn(ubicacionRocco);

        ubicacion resultado = ubicacionService.guardar(ubicacionRocco);

        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        verify(ubicacionRepository, times(1)).save(ubicacionRocco);
    }

    @Test
    public void deberiaRetornarTodasLasUbicaciones() {
        when(ubicacionRepository.findAll()).thenReturn(Arrays.asList(ubicacionRocco));

        List<ubicacion> resultado = ubicacionService.obtenerTodas();

        assertNotNull(resultado);
        assertEquals(1, resultado.size());
        verify(ubicacionRepository, times(1)).findAll();
    }

    @Test
    public void deberiaRetornarUbicacionesPorMascota() {
        Long mascotaId = 37L; // El ID de Rocco
        when(ubicacionRepository.findByMascotaId(mascotaId)).thenReturn(Arrays.asList(ubicacionRocco));

        List<ubicacion> resultado = ubicacionService.obtenerPorMascota(mascotaId);

        assertFalse(resultado.isEmpty());
        assertEquals(mascotaId, resultado.get(0).getMascotaId());
    }

    @Test
    public void deberiaContarUbicacionesPorComuna() {
        String comuna = "Santiago Centro";
        when(ubicacionRepository.countByComuna(comuna)).thenReturn(10L);

        long total = ubicacionService.contarPorComuna(comuna);

        assertEquals(10L, total);
        verify(ubicacionRepository, times(1)).countByComuna(comuna);
    }
}