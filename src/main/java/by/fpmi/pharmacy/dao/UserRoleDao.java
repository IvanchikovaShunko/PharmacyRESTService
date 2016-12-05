package by.fpmi.pharmacy.dao;



import by.fpmi.pharmacy.model.UserRole;

import java.util.Set;

public interface UserRoleDao {
    public void saveRole(UserRole role);

    public Set<UserRole> listRoles();
    public UserRole getRole(Long id);

    public void deleteRole(Long id);
}
