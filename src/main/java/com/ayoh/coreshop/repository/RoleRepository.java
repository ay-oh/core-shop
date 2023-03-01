package com.ayoh.coreshop.repository;

import com.ayoh.coreshop.entity.member.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Long> {

    List<Role> findRolesByEmail(String email);

}
