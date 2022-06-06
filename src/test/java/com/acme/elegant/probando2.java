package com.acme.elegant;

import com.acme.elegant.resource.PostResource;
import com.acme.elegant.service.PostService;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import javafx.geometry.Pos;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import static org.junit.Assert.*;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.Response;


public class probando2 {

    @Autowired
    TestRestTemplate testRestTemplate;

    ResponseEntity<PostResource> response;

    @Autowired
    private PostService postService;

    //mockMvc.perform(get("/people/" + id));

    @When("llama el endpoint posts indicando su id")
    public void llamaElEndpointPostsIndicandoSuId() {
        response = testRestTemplate.getForEntity("http://localhost:8080/api/posts/3", PostResource.class);
    }

    @Then("el codigo de respuesta es de {int}")
    public void elCodigoDeRespuestaEsDe(int arg0) {
        assertEquals(response.getStatusCodeValue(), arg0);
    }

    @And("muestra la descripcion correcta")
    public void muestraLaDescripcionCorrecta() {

        String descripcion = postService.getPostById(new Long(3)).getDescription();
        assertEquals(response.getBody().getDescription(), descripcion);
    }

}
