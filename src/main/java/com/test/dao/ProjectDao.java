package com.test.dao;

import java.util.List;

import com.test.entity.Project;

/**
 * 
 * @author L 
 * @time     2014年10月4日 下午6:14:22
 * 
 * @功能
 * 		1. 用户想要新增项目
 * 		2. 用户想要删除项目
 *      3. 用户想要获得项目列表
 *      4. 用户想要修改项目信息 
 *      5. 用户想要获得某个项目信息
 *
 */
public interface ProjectDao {
	
	public  List<Project> findAllProjects();

	public Project findById(Integer id);
	
	public  void saveOrUpdate(Project project);
	
	public  void delete(Project project);

}
