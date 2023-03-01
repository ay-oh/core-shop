package com.ayoh.coreshop.repository;

import com.ayoh.coreshop.entity.member.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Authority, Long> {

    List<Authority> findRolesByEmail(String email);

}
