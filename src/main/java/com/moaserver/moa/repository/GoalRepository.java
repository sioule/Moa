package com.moaserver.moa.repository;

import com.moaserver.moa.entity.goal.Goal;
import com.moaserver.moa.entity.mypage.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.YearMonth;
import java.util.Optional;

public interface GoalRepository extends JpaRepository<Goal, Long> {

    Optional<Goal> findByMemberAndDate(Member member, YearMonth date);
}

