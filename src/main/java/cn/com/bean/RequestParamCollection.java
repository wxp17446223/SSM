package cn.com.bean;

import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Set;
@Data
public class RequestParamCollection {
    private List<String> list;
    private Set<String> set;
    private Map<String,String> map;

}
