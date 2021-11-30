package com.jpss.APIHerois.controller;

import com.jpss.APIHerois.document.Heroi;
import com.jpss.APIHerois.repository.RepositorioHeroi;
import com.jpss.APIHerois.service.ServicoHeroi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import static com.jpss.APIHerois.constants.ConstantesHeroi.HEROES_ENDPOINT_LOCAL;

@RestController
//@Slf4j
public class ControladorHeroi {
    ServicoHeroi servicoHeroi;
    RepositorioHeroi repositorioHeroi;

    public static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(ControladorHeroi.class);

    public ControladorHeroi(ServicoHeroi servicoHeroi, RepositorioHeroi repositorioHeroi){
        this.repositorioHeroi = repositorioHeroi;
        this.servicoHeroi = servicoHeroi;
    }

    @GetMapping(HEROES_ENDPOINT_LOCAL)
    public Flux<Heroi> getAllItens(){
        log.info("Solicitando lista de Herois");
        return servicoHeroi.findAll();
    }

    @GetMapping(HEROES_ENDPOINT_LOCAL + "/id")
    public Mono<ResponseEntity<Heroi>> findByID(@PathVariable String id){
        log.info("Solicitando um heroi pelo id", id);
        return servicoHeroi.findById(id).map((item) -> new ResponseEntity<>(item, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping(HEROES_ENDPOINT_LOCAL)
    @ResponseStatus(code = HttpStatus.CREATED)
    public Mono<Heroi> ceateHero(@RequestBody Heroi heroiTemp){
        log.info("Um novo heroi foi criado.");
        return servicoHeroi.save(heroiTemp);
    }

    @DeleteMapping(HEROES_ENDPOINT_LOCAL + "/id")
    @ResponseStatus(code = HttpStatus.CONTINUE)
    public Mono<HttpStatus> deleteByIDHEroi(@PathVariable String id){
        servicoHeroi.deleteByIdHerioi(id);
        log.info("O heroi com id " +id+ " foi apagado.");
        return Mono.just(HttpStatus.CONTINUE);
    }
}
