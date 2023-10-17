package myspring.customuser.dao.mapper;

import java.util.List;

import myspring.customuser.vo.CustomUserVO;

public interface CustomUserMapper {
	CustomUserVO selectCustomUserById(int id);
	List<CustomUserVO> selectCustomUserList();
}
