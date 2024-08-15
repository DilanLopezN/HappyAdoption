package com.example.demo.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.AnimalEntity;
import com.example.demo.entities.AnimalEntity.Status;
import com.example.demo.services.AnimalService;
import io.swagger.v3.oas.annotations.Parameter;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@RestController
@RequestMapping("/api/animais")
@Tag(name = "Animal", description = "Endpoints para gerenciamento de animais")
public class AnimalController {
   @Autowired
    private AnimalService animalService;

    @PostMapping
        @Operation(
        summary = "Criar um novo animal",
        description = "Cria um novo animal na base de dados.",
        requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Animal a ser criado",
            content = @Content(
                schema = @Schema(implementation = AnimalEntity.class)
            )
        ),
        responses = {
            @ApiResponse(
                description = "Animal criado com sucesso",
                responseCode = "200",
                content = @Content(
                    schema = @Schema(implementation = AnimalEntity.class)
                )
            )
        }
    )
    public AnimalEntity criarAnimal(@RequestBody AnimalEntity animal) {
        return animalService.create(animal);
    }

    @GetMapping

    @Operation(
        summary = "Listar todos os animais",
        description = "Obtém a lista de todos os animais.",
        responses = {
            @ApiResponse(
                description = "Lista de animais",
                responseCode = "200",
                content = @Content(
                    schema = @Schema(implementation = AnimalEntity.class)
                )
            )
        }
    )
    public List<AnimalEntity> listarAnimais() {
        return animalService.findAll();
    }

    @PutMapping("/{id}/status")
    @Operation(
      summary = "Alterar o status de um animal",
      description = "Altera o status do animal especificado.",
      parameters = {
          @Parameter(name = "id", description = "ID do animal", required = true),
          @Parameter(name = "status", description = "Novo status do animal", required = true)
      },
      responses = {
          @ApiResponse(
              description = "Status do animal alterado com sucesso",
              responseCode = "200",
              content = @Content(
                  schema = @Schema(implementation = AnimalEntity.class)
              )
          )
      }
  )
    public AnimalEntity alterarStatus(@PathVariable Long id, @RequestParam Status status) {
        return animalService.changeStatus(id, status);
    }
}
