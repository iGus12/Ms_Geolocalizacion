package Geolocalizacion.ms.geo.controller;

import Geolocalizacion.ms.geo.model.ubicacion;
import Geolocalizacion.ms.geo.service.IUbicacionService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class UbicacionControllerTest {

    private MockMvc mockMvc;
    private ObjectMapper objectMapper;

    @Mock
    private IUbicacionService ubicacionService;

    @InjectMocks
    private ubicacionController controller;

    private ubicacion ubicacionRocco;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
        objectMapper = new ObjectMapper();

        ubicacionRocco = new ubicacion();
        ubicacionRocco.setId(1L);
        ubicacionRocco.setMascotaId(37L); // Rocco
        ubicacionRocco.setComuna("Santiago Centro");
    }

    @Test
    public void deberiaListarTodasLasUbicaciones() throws Exception {
        when(ubicacionService.obtenerTodas()).thenReturn(Arrays.asList(ubicacionRocco));

        mockMvc.perform(get("/api/geo/listar")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].mascotaId").value(37))
                .andExpect(jsonPath("$[0].comuna").value("Santiago Centro"));
    }

    @Test
    public void deberiaRegistrarUbicacion() throws Exception {
        when(ubicacionService.guardar(any(ubicacion.class))).thenReturn(ubicacionRocco);

        mockMvc.perform(post("/api/geo/registrar")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(ubicacionRocco)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.comuna").value("Santiago Centro"));
    }

    @Test
    public void deberiaObtenerUbicacionPorMascota() throws Exception {
        when(ubicacionService.obtenerPorMascota(37L)).thenReturn(Arrays.asList(ubicacionRocco));

        mockMvc.perform(get("/api/geo/mascota/37")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].mascotaId").value(37));
    }

    @Test
    public void deberiaContarUbicacionesPorComuna() throws Exception {
        when(ubicacionService.contarPorComuna("Santiago Centro")).thenReturn(5L);

        mockMvc.perform(get("/api/geo/contar/Santiago Centro"))
                .andExpect(status().isOk())
                .andExpect(content().string("5"));
    }
}