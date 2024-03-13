package com.marondal.spring.test.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marondal.spring.test.jpa.domain.Recruit;

public interface RecruitRepository extends JpaRepository<Recruit, Integer> {

	
	// companyId가 일치하는 행 조회
	// WHERE `companyId` = #{}
	public List<Recruit> findByCompanyId(int companyId);
	
	// position 값과 type 값이 일치하는 행 조회
	// WHERE `position` = #{} AND `type` = #{}
	public List<Recruit> findByPositionAndType(String position, String type);
	
	// type 값이 일치하거나 salary 값이 특정 값 이상인 조건에 맞는 행 조회
	// WHERE `type` = #{} OR `salary` >= #{}
	public List<Recruit> findByTypeOrSalaryGreaterThanEqual(String type, int salary);
	
}
