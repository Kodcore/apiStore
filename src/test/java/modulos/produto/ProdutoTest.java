package modulos.produto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;


@DisplayName("Testes de API Rest do módulo de Produto")
public class ProdutoTest {
    @Test
    @DisplayName("Validar os limites proibidos do valor do Produto")
    public void testvalidarLimitesProibidosValorProduto(){
        //Configurando os dados da API Rest da lojinha
        baseURI ="http://165.227.93.41";
        //port = 8080;
        basePath = "/lojinha";

        //Obter o token do usuario admin
        /*
        dado que eu envio um contentTypeJson com esse body
        quando fizer um post para v2/lojinha
        entao extraia o que esta no corpo da resposta dentro de data dentro de token
         */
        String token = given()
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "  \"usuarioLogin\": \"admin\",\n" +
                        "  \"usuarioSenha\": \"admin\"\n" +
                        "}")
            .when()
                .post("/v2/login")
            .then()
                .extract()
                    .path("data.token");

        System.out.println(token);

        /*Tentar inserir um produto com valor 0.00 e validar que a mensagem de erro foi apresentada
        e o status code retornado foi 422   */
    }
}
