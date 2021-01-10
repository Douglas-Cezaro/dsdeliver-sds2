package com.devsuperior.dsdeliver.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devsuperior.dsdeliver.dto.OrderDTO;
import com.devsuperior.dsdeliver.services.OrderService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping(value = "/orders")
@Tag(name = "Orders", description = "Responsável pela manipulação dos pedidos")
public class OrderController {

	@Autowired
	private OrderService service;

	@Operation(summary = "Listar todos os pedidos", description = "Método que lista todos os pedidos pelo mais antigo, e somente os não entregues")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Retorna os pedidos", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = OrderDTO.class))) }),
			@ApiResponse(responseCode = "404", description = "Nenhum pedido encontrado", content = @Content) })
	@GetMapping
	public ResponseEntity<List<OrderDTO>> findAll() {

		List<OrderDTO> list = service.findAll();

		return ResponseEntity.ok().body(list);
	}

	@Operation(summary = "Cadastra um novo pedidos", description = "Método que cadastra um novo pedido")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Retorna o pedido cadastrado", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = OrderDTO.class))) }),
			@ApiResponse(responseCode = "400", description = "Erro ao cadastrar pedido" , content = @Content) })
	@PostMapping
	public ResponseEntity<OrderDTO> insert(@RequestBody OrderDTO dto) {

		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);

	}
	@Operation(summary = "Atualizar status pedido", description = "Método que atualiza o status do pedido")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Retorna o pedido com status atualizado", content = {
			@Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = OrderDTO.class))) }),
			@ApiResponse(responseCode = "400", description = "Erro ao atualizar pedido" , content = @Content),
			@ApiResponse(responseCode = "500", description = "Pedido não encontrado" , content = @Content),
			})
	@PutMapping("/{id}/delivered")
	public ResponseEntity<OrderDTO> setDelivered(@PathVariable Long id) {

		OrderDTO dto = service.setDelivered(id);
		return ResponseEntity.ok().body(dto);

	}

}
