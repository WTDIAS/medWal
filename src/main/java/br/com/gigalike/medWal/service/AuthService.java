package br.com.gigalike.medWal.service;
import br.com.gigalike.medWal.dto.TokenResponseDto;
import br.com.gigalike.medWal.dto.UserDto;
import br.com.gigalike.medWal.erros.NotFound;
import br.com.gigalike.medWal.jwt.JwtUtil;
import br.com.gigalike.medWal.model.UserModel;
import br.com.gigalike.medWal.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Classe que contem as regras de negócio para AuthService
 * @author Waldir Tiago
 * */

@Service
public class AuthService {

    @Autowired
    private AuthRepository authRepository;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private BCryptPasswordEncoder bcrypt;

    @Transactional
    public ResponseEntity<TokenResponseDto> autenticar(UserDto userDto) {

        UserModel userModel = authRepository.findByLogin(userDto.login()).orElseThrow(()->new NotFound("Credenciais inválidas"));
        if (bcrypt.matches(userDto.senha(), userModel.getSenha())){
            String token = jwtUtil.gerarToken(userDto.login());
            return ResponseEntity.ok(new TokenResponseDto("Token gerado com sucesso",token));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new TokenResponseDto("Credenciais inválidas",""));
    }
}
