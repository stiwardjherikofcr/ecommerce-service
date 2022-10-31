package co.edu.unab.misiontic2022.c3.fog.ecommerceservice.controllers;

import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.models.response.RoleDataResponseModel;
import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.services.IRoleService;
import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.shared.RoleDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "api/v1/roles")
@Tag(name = "Roles", description = "Roles API")
public class RoleController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private IRoleService roleService;

    @GetMapping(value = "")
    public ResponseEntity<List<RoleDataResponseModel>> listRole() {
        List<RoleDto> roles = roleService.listAllRoles();
        if (roles.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<RoleDataResponseModel> rolesResponse = new ArrayList<>();
        roles.forEach(role -> {
            rolesResponse.add(modelMapper.map(role, RoleDataResponseModel.class));
        });
        return ResponseEntity.ok(rolesResponse);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<RoleDataResponseModel> getRole(@PathVariable("id") Long id) {
        RoleDto roleDto = roleService.getRoleById(id);
        RoleDataResponseModel roleDataResponseModel = modelMapper.map(roleDto, RoleDataResponseModel.class);
        return ResponseEntity.ok(roleDataResponseModel);
    }

    @PostMapping(value = "")
    public ResponseEntity<RoleDataResponseModel> createRole(@RequestBody RoleDataResponseModel roleDataResponseModel) {
        RoleDto roleDto = modelMapper.map(roleDataResponseModel, RoleDto.class);
        RoleDto roleDtoCreated = roleService.createRole(roleDto);
        RoleDataResponseModel roleDataResponseModelCreated = modelMapper.map(roleDtoCreated, RoleDataResponseModel.class);
        return ResponseEntity.ok(roleDataResponseModelCreated);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<RoleDataResponseModel> updateRole(@PathVariable("id") Long id, @RequestBody RoleDataResponseModel roleDataResponseModel) {
        RoleDto roleDto = modelMapper.map(roleDataResponseModel, RoleDto.class);
        RoleDto roleDtoUpdated = roleService.updateRole(id, roleDto);
        RoleDataResponseModel roleDataResponseModelUpdated = modelMapper.map(roleDtoUpdated, RoleDataResponseModel.class);
        return ResponseEntity.ok(roleDataResponseModelUpdated);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable("id") Long id) {
        roleService.deleteRole(id);
        return ResponseEntity.noContent().build();
    }

}
