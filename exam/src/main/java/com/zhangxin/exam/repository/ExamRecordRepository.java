package com.zhangxin.exam.repository;

import com.zhangxin.exam.entity.ExamRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExamRecordRepository extends JpaRepository<ExamRecord, String> {
    /**
     * 获取指定用户参加过的所有考试
     *
     * @param userId 用户id
     * @return 用户参加过的所有考试
     */
    List<ExamRecord> findByExamJoinerId(String userId);
}
