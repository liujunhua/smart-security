package com.smart.resource.server.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author junhua.liu
 * @since 2020-09-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="CodeType对象", description="")
public class CodeType implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("CodeTypeId")
    private Integer CodeTypeId;

    @TableField("CodeTypeName")
    private String CodeTypeName;

    @TableField("CodeTypeFormat")
    private String CodeTypeFormat;

    @TableField("Memo")
    private String Memo;

    @TableField("Issequencesign")
    private String Issequencesign;

    @ApiModelProperty(value = "1  公用的，0 私用的")
    @TableField("PubPrivsign")
    private String PubPrivsign;

    @TableField("CodeLength")
    private Integer CodeLength;

    @TableField("CodeElement")
    private Integer CodeElement;


}
