package br.com.luigiceschim.desafioitau.transacao;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record TransacaoRequest(BigDecimal valor, OffsetDateTime dataHora) {
}
