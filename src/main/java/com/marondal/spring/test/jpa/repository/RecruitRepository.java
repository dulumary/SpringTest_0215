package com.marondal.spring.test.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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
	
	// type값이 일치하는 행을 salary 내림차순 정렬해서 3개조회
	// WHERE `type` = #{} ORDER BY `salary` DESC LIMIT 3
	public List<Recruit> findTop3ByTypeOrderBySalaryDesc(String type);
	
	// region이 일치하고 salary 가 특정 값들 사이인 조건의 행 조회
	// WHERE `region` = #{} AND `salary` BETWEEN ${} AND #{}
	public List<Recruit> findByRegionAndSalaryBetween(String region, int start, int end);
	
	@Query(value="SELECT * FROM `recruit` "
			+ "WHERE `deadline` > :deadline "
			+ "AND `salary` >= :salary "
			+ "AND `type` = :type "
			+ "ORDER BY `salary` DESC", nativeQuery=true)
	public List<Recruit> findByNativeQuery(
			@Param("deadline")	String deadline
			, @Param("salary") int salary
			, @Param("type") String type);
	
}
