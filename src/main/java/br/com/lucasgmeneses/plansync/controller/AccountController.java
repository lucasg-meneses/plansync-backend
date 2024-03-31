package br.com.lucasgmeneses.plansync.controller;

import br.com.lucasgmeneses.plansync.domain.dto.user.UserResponseDto;
import br.com.lucasgmeneses.plansync.domain.model.UserModel;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {
    @GetMapping
    public ResponseEntity<UserResponseDto> getMyAccount(@AuthenticationPrincipal UserDetails userDetails){
        try {
            UserModel user = (UserModel) userDetails;
            return ResponseEntity.ok(new UserResponseDto(user.getUsername(), user.getEmail(), user.getDateUpdated()));
        }catch (Exception exception){
            return ResponseEntity.badRequest().build();
        }
    }
    @PutMapping
    public ResponseEntity<UserResponseDto> geUpdateAccount(@AuthenticationPrincipal UserDetails userDetails, ){
        try {
            UserModel user = (UserModel) userDetails;
            return ResponseEntity.ok(new UserResponseDto(user.getUsername(), user.getEmail(), user.getDateUpdated()));
        }catch (Exception exception){
            return ResponseEntity.badRequest().build();
        }
    }

}
