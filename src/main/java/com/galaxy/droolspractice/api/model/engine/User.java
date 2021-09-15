package com.galaxy.droolspractice.api.model.engine;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * Sample class as JavaBean.
 * 
 * @author michael
 */
@Data
@Accessors(chain = true)
public class User extends BaseFact {


	private long created;



}
