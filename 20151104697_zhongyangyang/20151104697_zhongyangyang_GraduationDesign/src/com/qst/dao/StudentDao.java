package com.qst.dao;

import java.util.List;

import com.qst.bean.Student;

/*
 * @ Copyright (c) Create by JASON  Date:2018-02-09  All rights reserved.
 *
 * @ class description：对学生表的操作接口
 *
 */
public interface StudentDao {
	//获取所有学生信息
	public List<Student> getAllStudent();
	//获取指定学生信息
	public Student getStudentMoreInfo(Student stu);
	//添加学生
	public int addStudent(Student stu);
	//删除学生
	public int delStudent(Student stu);
	//修改学生信息
	public int modifyStudent(Student stu);
	//查找指定的学生存在不存在
	public boolean findStudent(Student stu);

}


