package com.accounting_of_costumes.usercases.Tag.DTO;

import java.util.HashMap;
import java.util.Map;

public interface ITagPublicData {
    String name();
    Map<Long,String> items();
}
