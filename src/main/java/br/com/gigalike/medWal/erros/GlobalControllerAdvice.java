package br.com.gigalike.medWal.erros;
import br.com.gigalike.medWal.dto.DadosErrosValidacaoDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Classe GlobalControllerAdvice faz o tratamento de erros e excessões lançadas
 * @author Waldir Tiago
 * */

@RestControllerAdvice
public class GlobalControllerAdvice {
    @ExceptionHandler(BadRequest.class)
    public ResponseEntity<ResponseError> badRequest(BadRequest ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseError(HttpStatus.BAD_REQUEST,ex.getMessage(), LocalDateTime.now()));
    }

    @ExceptionHandler(NotFound.class)
    public ResponseEntity<ResponseError> notFound(NotFound ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseError(HttpStatus.NOT_FOUND,ex.getMessage(),LocalDateTime.now()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseError> globalError(Exception ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseError(
                HttpStatus.INTERNAL_SERVER_ERROR,
                ex.getMessage(),
                LocalDateTime.now()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<DadosErrosValidacaoDto>> validacaoDeCampos(MethodArgumentNotValidException ex){
        var erros = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(erros.stream().map(DadosErrosValidacaoDto::new).toList());
    }
}
