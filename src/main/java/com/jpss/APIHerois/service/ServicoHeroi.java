package com.jpss.APIHerois.service;

import com.jpss.APIHerois.document.Heroi;
import com.jpss.APIHerois.repository.RepositorioHeroi;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ServicoHeroi {
    private final RepositorioHeroi repositorioHeroi;

    public ServicoHeroi(RepositorioHeroi repositorioHeroi){
        this.repositorioHeroi = repositorioHeroi;
    }

    public Flux<Heroi> findAll(){
        return Flux.fromIterable(this.repositorioHeroi.findAll());
    }

    public Mono<Heroi> findById(String Id){
        return Mono.justOrEmpty(this.repositorioHeroi.findById(Id));
    }

    public Mono<Heroi> save(Heroi heroiTemp){
        return Mono.justOrEmpty(this.repositorioHeroi.save(heroiTemp));
    }

    public Mono<Boolean> deleteByIdHerioi(String Id){
        repositorioHeroi.deleteById(Id);
        return Mono.just(true);

    }
}
