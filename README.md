# Error Handler

Lib criada para abstrair a logica de captura dos erros de validação de objetos e normalização do response de erros.

### Utilização

Adicione a depedencia no pom do projeto

``` xml
<dependency>
    <groupId>br.com.macorin.libs</groupId>
    <artifactId>error-handler</artifactId>
    <version>${error-handler.version}</version>
</dependency>
```

Utilizando spring é necessário adicionar a classe ao contexto da aplicação. Crie uma classe extendendo `ResponseExceptionHandler` e anotado com o `@ControllerAdvice`

``` java

import br.com.macorin.error_handler.ResponseExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseExceptionHandler {

}
```

Então, por exemplo, em objetos recebidos em requests podemos anotar propriedades com validações do pacote `javax.validation.constraints`

``` java
@NotNull(message = "O e-mail é requerido!")
@Email(message = "O e-mail é inválido!")
private String email;

@NotNull(message = "A senha é requirida")
@Size(min = 6, message = "O tamanho mínimo para a senha é de 6 caracteres.")
private String password;
```

Com isso, e a utilização do `@Valid` no `@RequestBody`, o handler transforma essas mensagens num response padronizado de erro.