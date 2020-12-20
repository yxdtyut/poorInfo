package com.mizhi.yxd.service.impl;

import com.mizhi.yxd.entity.SubUser;
import com.mizhi.yxd.exception.GlobleException;
import com.mizhi.yxd.mapper.StudentMapper;
import com.mizhi.yxd.request.StudentRequest;
import com.mizhi.yxd.result.CodeMsg;
import com.mizhi.yxd.service.StudentService;
import com.mizhi.yxd.tools.SnowflakeIdWorker;
import com.mizhi.yxd.vo.UpdatePoorVo;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yangxudong
 * @description:
 * @date 2020/12/20 15:30
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<SubUser> findByCondition(StudentRequest studentRequest) {
        return studentMapper.findByCondition(studentRequest);
    }

    @Override
    public int findCountByCondition(StudentRequest studentRequest) {
        return studentMapper.findCountByCondition(studentRequest);
    }

    @Override
    public void insertPoorInfo(SubUser subUser) {
        subUser.setId(SnowflakeIdWorker.primaryKey());
        studentMapper.insertStudentInfo(subUser);
    }

    @Override
    public void checkIdcardExist(List<SubUser> subUsers) {
        List<SubUser> subUserList = studentMapper.quaryAll();
        if (CollectionUtils.isNotEmpty(subUserList)) {
            Map<String, SubUser> icCardMap = subUserList.stream().collect(Collectors.toMap(SubUser::getIdCard, x -> x));
            subUsers.stream().forEach(subUser -> {
                if (icCardMap.containsKey(subUser.getIdCard())) {
                    throw new GlobleException(CodeMsg.IDCARD_EXIST_ERROR.setMsg(subUser.getStudentName() + "--" + subUser.getIdCard() + "," + CodeMsg.IDCARD_EXIST_ERROR.getMsg()));
                }
            });
        }
    }

    @Override
    public int deleteStudentById(String id) {
        return studentMapper.deleteStudentById(id);
    }

    @Override
    public int deleteByPoorIds(List<String> data) {
        return studentMapper.deleteByPoorIds(data);
    }

    @Override
    public void updateByField(UpdatePoorVo updatePoorVo) {
        studentMapper.updateByField(updatePoorVo);
    }
}
