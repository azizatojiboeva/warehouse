package uz.pdp.warehouse.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.warehouse.dto.auth.LoginDto;
import uz.pdp.warehouse.dto.auth.SessionDto;
import uz.pdp.warehouse.response.DataDto;
import uz.pdp.warehouse.response.ResponseEntity;
import uz.pdp.warehouse.service.auth.AuthUserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author Aziza Tojiboyeva
 */
@RestController
public class TokenController {

    private final AuthUserServiceImpl service;

    public TokenController(AuthUserServiceImpl service) {
        this.service = service;
    }

    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
    public ResponseEntity<DataDto<SessionDto>> getToken(@RequestBody LoginDto dto) {
        ResponseEntity<DataDto<SessionDto>> token = service.getToken(dto);
        return token;
    }

    @RequestMapping(value = "/refresh-token", method = RequestMethod.GET)
    public ResponseEntity<DataDto<SessionDto>> getToken(String refreshToken,HttpServletRequest request, HttpServletResponse response) {
        return service.refreshToken(refreshToken, request, response);
    }


}
