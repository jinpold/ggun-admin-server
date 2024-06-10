package com.james.api.admin.service;
import com.james.api.common.component.security.JwtProvider;
import com.james.api.common.component.Messenger;
import com.james.api.admin.model.Admin;
import com.james.api.admin.model.AdminDto;
import com.james.api.admin.repository.AdminRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Log4j2
@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final AdminRepository adminRepository;
    private final JwtProvider jwtProvider;

    @Transactional
    @Override
    public Messenger save(AdminDto adminDto) {
        Admin ent = adminRepository.save(dtoToEntity(adminDto));
        System.out.println((ent instanceof Admin) ? "SUCCESS" : "FAILURE");
        return Messenger.builder()
                .message((ent instanceof Admin) ? "SUCCESS" : "FAILURE")
                .build();
    }
    @Override
    public List<AdminDto> findAll() {
        return adminRepository.findAll().stream().map(i->entityToDto(i)).toList();
    }
    @Override
    public Optional<AdminDto> findById(Long id) {
        return adminRepository.findById(id).stream().map(i -> entityToDto(i)).findAny();
    }

    @Transactional
    @Override
    public Messenger modify(AdminDto adminDto) {
        Admin admin = adminRepository.findById(adminDto.getId()).get();
        if (adminDto.getUsername() != null && !adminDto.getUsername().equals("")) {
            admin.setUsername(adminDto.getUsername());
        }
        admin.setUsername(adminDto.getUsername());
        admin.setPassword(adminDto.getPassword());
        admin.setEnpEmail(adminDto.getEnpEmail());
        admin.setEnpName(adminDto.getEnpName());
        admin.setEnpNum(adminDto.getEnpNum());
        admin.setPhone(adminDto.getPhone());
        admin.setDepartment(adminDto.getDepartment());
        admin.setPosition(admin.getPosition());
        admin.setJob(admin.getJob());
        adminRepository.save(admin);

        return adminRepository.findById(adminDto.getId()).get().equals(admin) ?
                Messenger.builder().message("SUCCESS").build() :
                Messenger.builder().message("FAILURE").build();
    }

    @Override
    public Messenger deleteById(Long id) {
        adminRepository.deleteById(id);
        return Messenger.builder().message
                (Stream.of(id)
                        .filter(i -> existsById(i))
                        .peek(i -> adminRepository.deleteById(i))
                        .map(i -> "SUCCESS")
                        .findAny()
                        .orElseGet(()->"FAILURE")).build();
    }
    @Override
    public boolean existsById(Long id) {
        return adminRepository.existsById(id);
    }

    @Override
    public Long count() {
        return adminRepository.count();
    }

    // SRP에 따라 아이디 존재여부를 프론트에서 먼저 판단하고, 넘어옴 (시큐리티)
    @Transactional
    @Override
    public Messenger login(AdminDto dto) {
        log.info("로그인 서비스로 들어온 파라미터 : " +dto);
        Admin admin = adminRepository.findUserByUsername((dto.getUsername())).get();
        String accessToken = jwtProvider.createToken(entityToDto(admin));

        boolean flag = admin.getPassword().equals(dto.getPassword());
        log.info("accessToken 확인용: "+accessToken);
        adminRepository.modifyTokenById(admin.getId(), accessToken);
        // 토큰을 각 섹션 (Header, payload, signature)으로 분할

        jwtProvider.printPayload(accessToken);
        return Messenger.builder()
                .message(flag ? "SUCCESS" : "FAILURE")
                .accessToken(flag ? accessToken : "NONE")
                .build();
    }

    @Override
    public Boolean existsByUsername(String username) {
        Integer count  = adminRepository.existsByUsername(username);
        return count ==1;
    }

    @Override
    public Optional<Admin> findUsersByRole(String role) {
        return adminRepository.findUsersByRole(role);
    }

    @Override
    public Optional<Admin> findUserByUsername(String username) {
        return adminRepository.findUserByUsername(username);
    }

    @Transactional
    @Override
    public Boolean logout(String token) {
        String accessToken = token != null && token.startsWith("Bearer ") ?
                token.substring(7) : "undefined";
        Long id = jwtProvider.getPayload(accessToken).get("userId", Long.class);
        String deleteToken = "";
        adminRepository.modifyTokenById(id,deleteToken);
        return adminRepository.findById(id).get().getToken().equals("");
    }

    @Override
    public Optional<AdminDto> findUserInfo(String accessToken) {
        String splitToken = accessToken.substring(7);
        Long id = jwtProvider.getPayload(splitToken).get("id", Long.class);

        return Optional.of(entityToDto(adminRepository.findById(id).orElseThrow()));
    }

}
