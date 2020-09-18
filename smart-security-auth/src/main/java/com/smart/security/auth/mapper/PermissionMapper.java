package com.smart.security.auth.mapper;

import com.smart.security.auth.entity.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liujunhua
 * @since 2020-09-15
 */
public interface PermissionMapper extends BaseMapper<Permission> {
    @Select(" select " +
            " p.id, p.parent_id, p.name, p.ename, p.url, p.description, p.create_time, p.update_time " +
            " FROM " +
            " tb_permission AS p " +
            " LEFT JOIN tb_role_permission AS rp " +
            " ON p.id = rp.permission_id " +
            " LEFT JOIN tb_role AS r" +
            " ON rp.role_id = r.id " +
            " LEFT JOIN tb_user_role AS ur " +
            " ON r.id = ur.role_id " +
            " LEFT JOIN  tb_user AS u " +
            " ON u.id = ur.user_id " +
            " WHERE u.id = #{ userId }")
    List<Permission> queryByUserId(Long userId);
}
