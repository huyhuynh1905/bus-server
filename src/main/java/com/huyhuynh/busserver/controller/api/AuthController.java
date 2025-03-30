package com.huyhuynh.busserver.controller.api;

import com.huyhuynh.busserver.model.ApiResponse;
import com.huyhuynh.busserver.model.LoginRequest;
import com.huyhuynh.busserver.model.AuthModel;
import com.huyhuynh.busserver.security.jwt.JwtUtil;
import com.huyhuynh.busserver.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constants.apiPrePath +"/authentication")
@CrossOrigin(origins = "*") // Cho phép tất cả domain
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<ApiResponse<AuthModel>> authenticate(@RequestBody LoginRequest request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
            AuthModel authModel = jwtUtil.generateToken(request.getUsername());

            ApiResponse<AuthModel> successResponse = ApiResponse.success(authModel);
            return ResponseEntity.ok(successResponse);

        } catch (BadCredentialsException ex) {
            ApiResponse<AuthModel> failedEx = ApiResponse.error(List.of("error","BadCredentialsException"));
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(failedEx);
        } catch (Exception ex) {
            ApiResponse<AuthModel> failedEx = ApiResponse.error(List.of("error", ex.getMessage()));
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(failedEx);
        }
    }
}
