package br.com.zup.Zupcar.controllers;

import br.com.zup.Zupcar.dtos.CarroDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {
    private List<CarroDTO> concessionaria = new ArrayList<>();

}
