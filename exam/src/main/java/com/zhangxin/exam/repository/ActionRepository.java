//Action的数据库操作类
package com.zhangxin.exam.repository;

import com.zhangxin.exam.entity.Action;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionRepository extends JpaRepository<Action, Integer> {
}
