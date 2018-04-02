package br.com.game.of.thrones.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {

    private LocalDateTime dateTim;
    private String message;
    private String details;
}
