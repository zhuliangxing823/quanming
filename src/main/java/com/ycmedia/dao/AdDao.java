package com.ycmedia.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ycmedia.entity.Creative;
import com.ycmedia.entity.CreativeTpl;

@Repository
public interface AdDao {

	List<Creative> getAdList();

	List<CreativeTpl> getCreativeTpl();

	Creative findAdById(@Param("id")String id);

	void updateCreative(@Param("creative")Creative creative);

}
