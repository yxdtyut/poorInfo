package com.mizhi.yxd.result;

import lombok.Getter;

/**
 * @Author : yangxudong
 * @Description :   错误码
 * @Date : 下午3:04 2018/5/29
 */
@Getter
public class CodeMsg {
    /**通用模块.*/
    public static final CodeMsg SUCCESS = new CodeMsg(200, "成功");
    public static final CodeMsg SERVER_ERROR = new CodeMsg(500, "服务异常");

    /**用户模块.5001xx*/
    public static final CodeMsg USER_OR_PWD_NOT_RIGHT = new CodeMsg(500100, "用户或密码不正确");
    public static final CodeMsg USER_ALREADY_REGIST = new CodeMsg(500101, "用户已经被注册");
    public static final CodeMsg ACCOUNT_IS_NULL = new CodeMsg(500102, "登录名称为空");
    public static final CodeMsg PSW_IS_NULL = new CodeMsg(500103, "密码为空");
    public static final CodeMsg NAME_IS_NULL = new CodeMsg(500104, "用户名称为空");
    public static final CodeMsg PWD_NOT_RIGHT = new CodeMsg(500105, "原密码不正确");
    public static final CodeMsg TWO_PWD_NOT_RIGHT = new CodeMsg(500106, "两次密码输入不一致");
    public static final CodeMsg NOT_SYS_USER = new CodeMsg(500107, "非管理员无权限导入");
    public static final CodeMsg IMPROT_INSERT_ERROR = new CodeMsg(500108, "导入数据保存失败，请检查是否有重复数据");

    /**校验模块.6001xx*/
    public static final CodeMsg NAME_IDCARD_NULL = new CodeMsg(600101, "学期或者姓名或身份证为空");
    public static final CodeMsg SIX_FIFTEEN_NOT_RIGHT = new CodeMsg(600102, "是否6-15周岁字段只能写是或者否");
    public static final CodeMsg IDCARD_NOT_RIGHT = new CodeMsg(600103, "身份证格式有误");
    public static final CodeMsg DISABILITY_NOT_RIGHT = new CodeMsg(600104, "是否残疾生字段只能写是或者否");
    public static final CodeMsg ENJOY_NOT_RIGHT = new CodeMsg(600105, "本学期是否享受米脂资助只能写是或者否");
    public static final CodeMsg IMPORT_VALIDATE_ERROR = new CodeMsg(600106, "导入校验失败");
    public static final CodeMsg IDCARD_EXIST_ERROR = new CodeMsg(600107, "该身份证用户已存在!");
    public static final CodeMsg SUBSIDIZE_EXIST_ERROR = new CodeMsg(600108, "该生已经是被资助学生!");
    public static final CodeMsg DECIMAL_NOT_RIGHT_ERROR = new CodeMsg(600109, "请填写数字!");
    public static final CodeMsg THERE_IS_NO_COUNT_ERROR = new CodeMsg(600110, "没有符合条件的数据");
    public static final CodeMsg SCHOOLUNIFORMS_NOT_RIGHT = new CodeMsg(600111, "是否享受校服数据只能写是或者否");
    public static final CodeMsg HOMEWORK_NOT_RIGHT = new CodeMsg(600112, "是否享受作业本数据只能写是或者否");
    public static final CodeMsg STUDY_TOOL_NOT_RIGHT = new CodeMsg(600113, "是否享受学具数据只能写是或者否");
    public static final CodeMsg SEX_NOT_RIGHT = new CodeMsg(600114, "是否享受学具数据只能写是或者否");
    public static final CodeMsg DUILD_CARD_NOT_RIGHT = new CodeMsg(600115, "是否脱贫家庭数据只能写是或者否");
    public static final CodeMsg HEAD_OF_IDCARD_NOT_RIGHT = new CodeMsg(600116, "户主身份证格式有误");
    public static final CodeMsg SEMESTER_NOT_ONLY = new CodeMsg(600117, "学期字段不唯一");

    private Integer code;
    private String msg;

    private CodeMsg(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private CodeMsg() {
    }

    public CodeMsg setMsg(String msg) {
        this.msg = msg;
        return this;
    }


}
