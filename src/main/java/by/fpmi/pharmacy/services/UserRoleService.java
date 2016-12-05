package by.fpmi.pharmacy.services;



import by.fpmi.pharmacy.model.UserRole;

import java.util.Set;

public interface UserRoleService {
    void saveRole(UserRole role);

    Set<UserRole> listRoles();
    UserRole getRole(Long id);

    void deleteRole(Long id);
}
