package com.datadesign.datadesign.SqlQueries;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "sql")
@Data
public class DepartmentQueries {
    public String departmentbyname;
    public String departmentbynameandaddress;
}
