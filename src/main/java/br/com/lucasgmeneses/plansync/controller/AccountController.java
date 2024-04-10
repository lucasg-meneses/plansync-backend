package br.com.lucasgmeneses.plansync.controller;

import br.com.lucasgmeneses.plansync.domain.dto.user.AccountRequestDto;
import br.com.lucasgmeneses.plansync.domain.dto.user.UserResponseDto;
import br.com.lucasgmeneses.plansync.domain.model.UserModel;
import br.com.lucasgmeneses.plansync.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/account")
public class AccountController {
    @Autowired
    UserRepository userRepository;
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
    public ResponseEntity<UserResponseDto> updateAccount(@AuthenticationPrincipal UserDetails userDetails,
                                                         @RequestBody @Valid  AccountRequestDto accountRequestDto){
        try {
            UserModel user = (UserModel) userDetails;
            user.setEmail(accountRequestDto.email());
            user.setLogin(accountRequestDto.username());
            if(!accountRequestDto.email().isBlank())
                user.setPassword(new BCryptPasswordEncoder().encode(accountRequestDto.password()));

            user.setDateUpdated(new Date());

            userRepository.save(user);
            return ResponseEntity.ok(new UserResponseDto(user.getUsername(), user.getEmail(), user.getDateUpdated()));
        }catch (Exception exception){
            return ResponseEntity.badRequest().build();
        }
    }

}
