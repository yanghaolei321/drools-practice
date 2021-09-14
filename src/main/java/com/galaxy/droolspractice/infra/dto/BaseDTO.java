package com.galaxy.droolspractice.infra.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * 基础 DTO
 * @author wangzukun
 * @date 2019/5/10 上午9:30
 */
@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseDTO implements Serializable {

}
