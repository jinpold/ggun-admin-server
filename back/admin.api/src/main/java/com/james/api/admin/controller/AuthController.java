package com.james.api.admin.controller;
import com.james.api.common.component.Messenger;
import com.james.api.admin.model.AdminDto;
import com.james.api.admin.repository.AdminRepository;
import com.james.api.admin.service.AdminService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController("adminAuthController")
@RequiredArgsConstructor
@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        @ApiResponse(responseCode = "404", description = "Customer not found")})
@RequestMapping(path = "/api/auth")
@Slf4j
public class AuthController {
    private final AdminService service;
    private final AdminRepository adminRepository;

    // -----------------------------------Query ---------------------------------------

    @PostMapping(path = "/login")
    public ResponseEntity<Messenger> login(@RequestBody AdminDto dto) {
        log.info("입력받은 정보 : {}", dto);
        return ResponseEntity.ok(service.login(AdminDto.builder()
                .username(dto.getUsername())
                .password(dto.getPassword())
                .build()));
    }
    @GetMapping("/exists-username") //헤더 자리 params // 바디는  @RequestParam
    public ResponseEntity<Boolean> existsByUsername(@RequestParam("username") String username) {
        log.info("existsByUsername 파라미터 정보:"+username);
        log.info("existsByUsername 결과:" + username);
        return ResponseEntity.ok(service.existsByUsername(username));
    }
}