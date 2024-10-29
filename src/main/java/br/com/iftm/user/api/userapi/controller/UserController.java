package br.com.iftm.user.api.userapi.controller;

import br.com.iftm.user.api.userapi.model.dto.UserDTO;
import br.com.iftm.user.api.userapi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public List<UserDTO> getUsers() {
        return userService.getUsuarios();
    }

    @GetMapping("/{cpf}")
    public UserDTO buscaUsurioPorCpf(@PathVariable String cpf) {
        return userService.buscaUsuarioPorCpf(cpf);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO adicionaUsuario(@RequestBody @Valid UserDTO user) {
        user.setDataCadastro(LocalDateTime.now());
        userService.addUsuario(user);
        return user;
    }

    @DeleteMapping("/{cpf}")
    public ResponseEntity<String> deletaUsuario(@PathVariable String cpf) {
        userService.deletaUsuario(cpf);
        return new ResponseEntity<>("Usuário deletado com sucesso", HttpStatus.OK);
    }

}
