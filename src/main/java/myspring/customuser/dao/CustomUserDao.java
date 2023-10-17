package myspring.customuser.dao;

import java.util.List;

import myspring.customuser.vo.CustomUserVO;

public interface CustomUserDao {
	public List<CustomUserVO> readAll();

	public CustomUserVO read(int id);
}
