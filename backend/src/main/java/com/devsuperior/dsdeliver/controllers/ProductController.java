package com.devsuperior.dsdeliver.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsdeliver.dto.ProductDTO;
import com.devsuperior.dsdeliver.services.ProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/products")
@Tag(name = "Products", description = "Responsável pela manipulação dos produtos")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@Operation(summary = "Listar todos os produtos", description = "Método que lista todos os produtos em order alfabetica")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Retorna os produtos", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = ProductDTO.class))) }),
			@ApiResponse(responseCode = "404", description = "Nenhum produto encontrado", content = @Content) })
	@GetMapping
	public ResponseEntity<List<ProductDTO>> findAll(){
		
		List<ProductDTO> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
		
	}
	
}
