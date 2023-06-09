package com.br.uni.edu.jogoDaVelha.resource;

import com.br.uni.edu.jogoDaVelha.dtos.MatchDTO;
import com.br.uni.edu.jogoDaVelha.dtos.Response;
import com.br.uni.edu.jogoDaVelha.model.Match;
import com.br.uni.edu.jogoDaVelha.requests.CreateGameRequest;
import com.br.uni.edu.jogoDaVelha.requests.MoveRequest;
import com.br.uni.edu.jogoDaVelha.service.MatchService;
import com.br.uni.edu.jogoDaVelha.service.MoveService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/game")
public class GameResource {

    private final MoveService moveService;
    private final MatchService matchService;

    public GameResource(MoveService moveService, MatchService matchService) {
        this.moveService = moveService;
        this.matchService = matchService;
    }

    @PostMapping(value = "/create-game")
    public ResponseEntity<Response<MatchDTO>> createGame(@RequestBody CreateGameRequest createGameRequest){
        Response<MatchDTO> response = new Response<>();

        try{
            response.setData(matchService.createMatch(createGameRequest));
            response.setStatusCode(HttpStatus.CREATED.value());
        }catch (Exception e){
            response.setStatusCode(HttpStatus.BAD_REQUEST.value());
            response.setError(e.getMessage());
        }

        return ResponseEntity.ok().body(response);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<MatchDTO>> getGame(@PathVariable Long id){
        Response<MatchDTO> response = new Response<>();

        try{
            response.setData(matchService.findMatch(id));
            response.setStatusCode(HttpStatus.OK.value());
        }catch (Exception e){
            response.setStatusCode(HttpStatus.NOT_FOUND.value());
            response.setError(e.getMessage());
        }

        return ResponseEntity.ok().body(response);

    }

    @GetMapping("/player/{id}")
    public ResponseEntity<Response<List<MatchDTO>>> findMatchesByUser(@PathVariable Long id){
        Response<List<MatchDTO>> response = new Response<>();

        try{
            response.setData(matchService.findMatchesByUser(id));
            response.setStatusCode(HttpStatus.OK.value());
        }catch (Exception e){
            response.setStatusCode(HttpStatus.NOT_FOUND.value());
            response.setError(e.getMessage());
        }

        return ResponseEntity.ok().body(response);

    }

    @PostMapping(value = "/make-move")
    public ResponseEntity<Response<MatchDTO>> makeMove(@RequestBody MoveRequest moveRequest){
        Response<MatchDTO> response = new Response<>();

        try{
            response.setData(moveService.makeMove(moveRequest));
            response.setStatusCode(HttpStatus.OK.value());
        }catch (Exception e){
            response.setStatusCode(HttpStatus.BAD_REQUEST.value());
            response.setError(e.getMessage());
        }

        return ResponseEntity.ok().body(response);

    }
}
