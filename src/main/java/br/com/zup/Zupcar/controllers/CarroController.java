package br.com.zup.Zupcar.controllers;

import br.com.zup.Zupcar.dtos.CarroDTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@RestController
@RequestMapping("/carros") // Mapea as requisições para o endpoint nele contido
public class CarroController {
    private List<CarroDTO> concessionaria = new ArrayList<>();

    @GetMapping // é o Request Mapping utilizando o Verbo GET do PROTOCOLO HTTP
    public List<CarroDTO> exibirTodosOsCarros(){
        return concessionaria;
    }

    @PostMapping // é o Request Mapping utilizando o Verbo POST do PROTOCOLO HTTP
    public void cadastrarCarro(@RequestBody CarroDTO carroDTO){
        // Todo Classe DTO são representações de Json seja de Entrada ou Saida.
        concessionaria.add(carroDTO);
    }

    @PutMapping ("/{nomeDoCarro")
    public CarroDTO atualizarCarro (@PathVariable String nomeDoCarro, @RequestBody CarroDTO carroAtualizado) {
        for (CarroDTO carro : concessionaria) {
            if (carro.getModelo().equalsIgnoreCase(nomeDoCarro)) {
                carro = carroAtualizado;
                concessionaria.add(carro);
                return carro;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @GetMapping ("/{nomeDoCarro}")
    @ResponseStatus(HttpStatus.CREATED)
    public CarroDTO exibirCarro (@PathVariable String nomeDoCarro){
        /* Tentativa Falha
        Predicate<CarroDTO> carroCerto = carroDTO -> carroDTO.getModelo().equalsIgnoreCase(nomeDoCarro);
        CarroDTO carroEncontrado =  (CarroDTO) concessionaria.stream().filter(carroCerto);
        return carroEncontrado;
        */
        for (CarroDTO carro : concessionaria){
            if (carro.getModelo().equalsIgnoreCase(nomeDoCarro)){
                return carro;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }



}
