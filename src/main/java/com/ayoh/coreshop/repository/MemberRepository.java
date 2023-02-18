package com.ayoh.coreshop.repository;

import com.ayoh.coreshop.entity.member.Member;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {

    Optional<Member> findByEmail(String email);

}
