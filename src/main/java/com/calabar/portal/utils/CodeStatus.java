package com.calabar.portal.utils;

import lombok.Getter;
import lombok.Setter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 读取配置文件类
 */
@Component
public class CodeStatus {
    /**
     *系统超级管理员角色id
     */
    @Getter
    @Setter
    @Value("${administratorRoleId}")
    private  Long administratorRoleId;

    public Long getAdministratorRoleId() {
        return administratorRoleId;
    }

    public void setAdministratorRoleId(Long administratorRoleId) {
        this.administratorRoleId = administratorRoleId;
    }
}
