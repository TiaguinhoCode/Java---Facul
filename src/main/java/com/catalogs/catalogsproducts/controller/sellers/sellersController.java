package com.catalogs.catalogsproducts.controller.sellers;

import java.util.List; // Import correto
import java.util.Map; // Import correto
import java.util.HashMap; // Para criar o Map de resposta

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.catalogs.catalogsproducts.models.sellers.sellers;
import com.catalogs.catalogsproducts.sellers.sellersRepository;
import com.catalogs.catalogsproducts.sellers.sellersResponseDTO;

@RestController
@RequestMapping("/v1/sellers")
public class sellersController { // Nome da classe corrigido

    @Autowired
    private sellersRepository repository; // Nome corrigido

    @GetMapping
    public Map<String, List<sellersResponseDTO>> getAll() {
        // Obter a lista de vendedores e mapear para o DTO
        List<sellersResponseDTO> sellersList = repository.findAll()
                .stream()
                .map(sellersResponseDTO::new)
                .toList();

        // Criar o mapa de resposta
        Map<String, List<sellersResponseDTO>> response = new HashMap<>();
        response.put("sellers", sellersList);

        // Retornar o mapa
        return response;
    }

    @PostMapping
    public ResponseEntity<sellersResponseDTO> save(@RequestBody sellers seller) {
        sellers savedSeller = repository.save(seller); 
        sellersResponseDTO responseDto = new sellersResponseDTO(savedSeller);

        return ResponseEntity.ok(responseDto); 
    }
}
