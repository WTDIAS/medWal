package br.com.gigalike.medWal.controller;
import br.com.gigalike.medWal.dto.TokenResponseDto;
import br.com.gigalike.medWal.dto.UserDto;
import br.com.gigalike.medWal.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Classe controller para autenticação, recebe um UserDto com login e senha e devolve um token
 * @author Waldir Tiago
 * */

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping
    public ResponseEntity<TokenResponseDto> login(@RequestBody @Valid UserDto userDto){
        return authService.autenticar(userDto);
    }
}
