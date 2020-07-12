package cn.com.bean;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
    private Integer id;

    private String userName;

    private String password;

    private String createTime;

    private String updateTime;

    private Integer status;


}