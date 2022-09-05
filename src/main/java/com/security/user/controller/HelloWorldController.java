package com.security.user.controller;


import com.security.user.model.AuthenticationRequest;
import com.security.user.model.AuthenticationResponse;
import com.security.user.service.MyUserDetailsService;
import com.security.user.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HelloWorldController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

            @Autowired
            private MyUserDetailsService userDetailsService;

            @RequestMapping({ "/hello" })
            public String firstPage() {
                return "Hello World";
            }

            @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
            public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

                try {
                    authenticationManager.authenticate(
                            new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword())
                    );
                }
                catch (BadCredentialsException e) {
                    throw new Exception("Incorrect username or password", e);
        }


                final UserDetails userDetails = userDetailsService
                        .loadUserByUsername(authenticationRequest.getEmail());

                final String jwt = jwtTokenUtil.generateToken(userDetails);

                return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

}