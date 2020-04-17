package id.giyomi.vms.backend.controller.rest;

import id.giyomi.vms.backend.component.authentication.JwtTokenUtil;
import id.giyomi.vms.backend.controller.rest.model.JwtRequest;
import id.giyomi.vms.backend.controller.rest.model.JwtResponse;
import id.giyomi.vms.backend.service.UserPrincipalDetailService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "/rest/auth")
public class RestAuthController {
    private AuthenticationManager authenticationManager;
    private JwtTokenUtil jwtTokenUtil;
    private UserPrincipalDetailService userPrincipalDetailService;

    public RestAuthController(AuthenticationManager authenticationManager, JwtTokenUtil jwtTokenUtil, UserPrincipalDetailService userPrincipalDetailService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userPrincipalDetailService = userPrincipalDetailService;
    }

    @GetMapping(value = "/loginAsCeo")
    public ResponseEntity<?> createAuthenticationTokenOfCeo() throws Exception {
        authenticate("ceo", "pass_ceo");
        final UserDetails userDetails = userPrincipalDetailService
                .loadUserByUsername("ceo");
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final UserDetails userDetails = userPrincipalDetailService
                .loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        }
        catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}