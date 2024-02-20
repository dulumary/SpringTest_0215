package com.marondal.spring.test.db.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.marondal.spring.test.db.domain.Store;

@Mapper
public interface StoreRepository {
	
	// store 테이블의 모든 행 정보 조회 
	public List<Store> selectStoreList();

}
