package co.edu.unab.misiontic2022.c3.fog.ecommerceservice.services.impl;

import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.data.entities.RoleEntity;
import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.data.repository.IRoleRepository;
import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.services.IRoleService;
import co.edu.unab.misiontic2022.c3.fog.ecommerceservice.shared.RoleDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    IRoleRepository roleRepository;

    @Override
    public List<RoleDto> listAllRoles() {
        List<RoleEntity> rolesEntity = roleRepository.findAll();
        List<RoleDto> rolesDto = new ArrayList<>();
        for (RoleEntity roleEntity : rolesEntity) {
            rolesDto.add(modelMapper.map(roleEntity, RoleDto.class));
        }
        return rolesDto;
    }

    @Override
    public RoleDto getRoleById(Long id) {
        return roleRepository.findById(id).map(roleEntity -> modelMapper.map(roleEntity, RoleDto.class)).orElse(null);
    }

    @Override
    public RoleDto createRole(RoleDto roleDto) {
        RoleEntity roleEntity = modelMapper.map(roleDto, RoleEntity.class);
        roleEntity = roleRepository.save(roleEntity);
        return modelMapper.map(roleEntity, RoleDto.class);
    }

    @Override
    public RoleDto updateRole(Long id, RoleDto roleDto) {
        RoleEntity roleEntity = modelMapper.map(roleDto, RoleEntity.class);
        roleEntity = roleRepository.save(roleEntity);
        return modelMapper.map(roleEntity, RoleDto.class);
    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }

}
