package co.edu.unab.misiontic2022.c3.fog.ecommerceservice.services;

import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.shared.RoleDto;

import java.util.List;

public interface IRoleService {

    public List<RoleDto> listAllRoles();
    public RoleDto getRoleById(Long id);
    public RoleDto createRole(RoleDto roleDto);
    public RoleDto updateRole(Long id, RoleDto roleDto);
    public void deleteRole(Long id);

}
