package com.james.api.admin.service;
import com.james.api.common.component.Messenger;
import com.james.api.common.service.CommandService;
import com.james.api.common.service.QueryService;
import com.james.api.admin.model.Admin;
import com.james.api.admin.model.AdminDto;
import java.util.Optional;

public interface AdminService extends CommandService<AdminDto>, QueryService<AdminDto> {
    // command
    Messenger modify(AdminDto user);
    // query
    Messenger login(AdminDto param);
    Boolean existsByUsername(String username);
    Optional<Admin> findUsersByRole(String role);
    Optional<Admin> findUserByUsername(String username);
    Boolean logout(String accessToken);
    Optional<AdminDto> findUserInfo(String username);

    default Admin dtoToEntity(AdminDto dto){
        return Admin.builder()
                .id(dto.getId())
                .username(dto.getUsername())
                .password(dto.getPassword())
                .enpName(dto.getEnpName())
                .enpNum(dto.getEnpNum())
                .department(dto.getDepartment())
                .position(dto.getPosition())
                .job(dto.getJob())
                .enpEmail(dto.getEnpEmail())
                .phone(dto.getPhone())
                .role(dto.getRole())
                .token(dto.getToken())
                .build();
    }


    default AdminDto entityToDto(Admin ent) {
        return AdminDto.builder()
                .id(ent.getId())
                .username(ent.getUsername())
                .password(ent.getPassword())
                .enpName(ent.getEnpName())
                .enpNum(ent.getEnpNum())
                .department(ent.getDepartment())
                .position(ent.getPosition())
                .job(ent.getJob())
                .enpEmail(ent.getEnpEmail())
                .phone(ent.getPhone())
                .role(ent.getRole())
                .token(ent.getToken())
                .build();
    }



}


