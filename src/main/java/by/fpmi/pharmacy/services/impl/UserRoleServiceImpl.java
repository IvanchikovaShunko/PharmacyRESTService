package by.fpmi.pharmacy.services.impl;


import by.fpmi.pharmacy.dao.UserRoleDao;
import by.fpmi.pharmacy.model.UserRole;
import by.fpmi.pharmacy.services.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 */
@Transactional
@Service("roleService")
public class UserRoleServiceImpl implements UserRoleService {
    @Autowired
    private UserRoleDao roleDao;

    @Override
    public void saveRole(UserRole role) {
        roleDao.saveRole(role);
    }

    @Override
    public Set<UserRole> listRoles() {
        return roleDao.listRoles();
    }

    @Override
    public UserRole getRole(Long id) {
        return roleDao.getRole(id);
    }

    @Override
    public void deleteRole(Long id) {
        roleDao.deleteRole(id);
    }
}
