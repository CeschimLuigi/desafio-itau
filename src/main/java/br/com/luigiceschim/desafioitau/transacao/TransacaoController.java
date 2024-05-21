package br.com.luigiceschim.desafioitau.transacao;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@RestController
@RequestMapping(value = "/transacao", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public record TransacaoController(TransacaoRepository transacaoRepository) {

    @PostMapping
    public ResponseEntity adicionar(@RequestBody TransacaoRequest transacaoRequest){
        System.out.println("Adicionando transacao...");


            

        try{
            validacaoTransacao(transacaoRequest);
            transacaoRepository.add(transacaoRequest);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (IllegalArgumentException illegalArgumentException){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }





 }

    @DeleteMapping
    public ResponseEntity limpar(){
        System.out.println("Limpando transacoes...");

        transacaoRepository.remove();

        return ResponseEntity.status(HttpStatus.OK).build();
    }




    private void validacaoTransacao(TransacaoRequest transacaoRequest) {
        if (transacaoRequest.valor().compareTo(BigDecimal.ZERO) < 0 ){
            throw new IllegalArgumentException("Valor de transação inválido!");
        }

        if (transacaoRequest.dataHora().isAfter(OffsetDateTime.now())){
            throw new IllegalArgumentException("Data da transação inválida");
        }

    }



}
