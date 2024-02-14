package ru.mycloud.cloud.service.domain;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.mycloud.cloud.dto.request.role.RoleAddRequest;
import ru.mycloud.cloud.dto.response.role.RoleResponse;
import ru.mycloud.cloud.entity.role.Role;
import ru.mycloud.cloud.mapper.role.RoleMapper;
import ru.mycloud.cloud.mapper.role.RoleMerger;
import ru.mycloud.cloud.mapper.role.RoleResponseMapper;
import ru.mycloud.cloud.repository.RoleRepository;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RoleDomainServiceTest {
    @Mock
    private RoleRepository repository;
    @Mock
    private RoleResponseMapper roleResponseMapper;
    @Mock
    private RoleMapper roleMapper;
    @Mock
    private RoleMerger roleMerger;
    @InjectMocks
    private RoleDomainService roleDomainService;

    private final Long ID = 1L;

    @Test
    void getRoleTest() {
        when(repository.getReferenceById(anyLong())).thenReturn(getRole());
        when(roleResponseMapper.from(any(Role.class))).thenReturn(getRoleResponse());

        var result = roleDomainService.getRole(ID);

        assertThat(result).isNotNull();

        verify(repository).getReferenceById(anyLong());
        verify(roleResponseMapper).from(any(Role.class));
        verifyNoMoreInteractions(repository, roleResponseMapper);
        verifyNoInteractions(roleMapper, roleMerger);
    }

    @Test
    void getAllRoleTest() {
        when(repository.findAll()).thenReturn(Collections.singletonList(getRole()));
        when(roleResponseMapper.from((List<Role>)any())).thenReturn(Collections.singletonList(getRoleResponse()));

        var result = roleDomainService.getAllRole();

        assertThat(result).hasSize(1);
        assertThat(result.get(0)).isNotNull();

        verify(repository).findAll();
        verify(roleResponseMapper).from((List<Role>)any());
        verifyNoMoreInteractions(repository, roleResponseMapper);
        verifyNoInteractions(roleMapper, roleMerger);

    }

    @Test
    void deleteRoleTest() {
        roleDomainService.deleteRole(ID);

        verify(repository).deleteById(anyLong());
        verifyNoMoreInteractions(repository);
        verifyNoInteractions(roleMapper, roleMerger, roleResponseMapper);

    }

    @Test
    void getRolesByNameTest() {
        when(repository.getRoleByName(anyString())).thenReturn(Collections.singletonList(getRole()));
        when(roleResponseMapper.from((List<Role>)any())).thenReturn(Collections.singletonList(getRoleResponse()));

        var result = roleDomainService.getRolesByName(anyString());

        assertThat(result).hasSize(1);
        assertThat(result.get(0)).isNotNull();

        verify(repository).getRoleByName(anyString());
        verify(roleResponseMapper).from((List<Role>)any());
        verifyNoMoreInteractions(repository, roleResponseMapper);
        verifyNoInteractions(roleMapper, roleMerger);
    }

    @Test
    void addRoleTest() {
        when(repository.save(any())).thenReturn(getRole());
        when(roleMapper.from(any(RoleAddRequest.class))).thenReturn(getRole());

        var result = roleDomainService.addRole(getRequest());

        assertThat(result).isNotNull();

        verify(repository).save(any());
        verify(roleMapper).from(any(RoleAddRequest.class));
        verifyNoMoreInteractions(repository, roleMapper);
        verifyNoInteractions(roleMerger, roleResponseMapper);

    }

    @Test
    void editRoleTest() {
        when(repository.save(any())).thenReturn(getRole());
        when(repository.getReferenceById(anyLong())).thenReturn(getRole());
        when(roleMerger.merge(any(), any())).thenReturn(getRole());

        var result = roleDomainService.editRole(getRequest());

        assertThat(result).isNotNull();

        verify(repository).save(any());
        verify(repository).getReferenceById(anyLong());
        verify(roleMerger).merge(any(), any());
        verifyNoMoreInteractions(repository, roleMerger);
        verifyNoInteractions(roleResponseMapper, roleMapper);

    }

    private RoleResponse getRoleResponse() {
        return new RoleResponse();
    }

    private Role getRole() {
        return new Role().setId(ID);
    }

    private RoleAddRequest getRequest() {
        return new RoleAddRequest().setRoleId(ID);
    }

}
