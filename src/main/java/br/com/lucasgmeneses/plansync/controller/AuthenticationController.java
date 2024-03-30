package br.com.lucasgmeneses.plansync.controller;

import br.com.lucasgmeneses.plansync.config.security.TokenService;
import br.com.lucasgmeneses.plansync.domain.dto.user.AutenticationRequestDto;
import br.com.lucasgmeneses.plansync.domain.dto.user.LoginResponseDto;
import br.com.lucasgmeneses.plansync.domain.dto.user.UserRequestDto;
import br.com.lucasgmeneses.plansync.domain.model.UserModel;
import br.com.lucasgmeneses.plansync.domain.model.UserRole;
import br.com.lucasgmeneses.plansync.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AutenticationRequestDto userAuth){
    try {
        var usernamePassword = new UsernamePasswordAuthenticationToken(userAuth.login(), userAuth.password());
        var auth = authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((UserModel) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDto(token));
    } catch (Exception ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }


    }
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid UserRequestDto userRequestDto){
        if (userRepository.findByLogin(userRequestDto.login()) != null) return ResponseEntity.status(HttpStatus.FOUND).body("Username already registered");
        if (userRepository.findByEmail(userRequestDto.email()) != null) return ResponseEntity.status(HttpStatus.FOUND).body("Email already registered");
        UserModel newUser = new UserModel();
        newUser.setEmail(userRequestDto.email());
        newUser.setLogin(userRequestDto.login());

        String encryptedPassword = new BCryptPasswordEncoder().encode(userRequestDto.password());
        newUser.setPassword(encryptedPassword);

        newUser.setRole(UserRole.USER);
        newUser.setDateCreated(new Date());
        newUser.setDateUpdated(new Date());
        try {
            userRepository.save(newUser);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
        }


    }
}
