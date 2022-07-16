package com.qf.data.base.utils;

import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * description:
 * author: Ken
 * 公众号：Java架构栈
 */
public class QfBeanUtils {

    /**
     * 单个对象的拷贝
     * @param <T>
     * @return
     */
    public static <T> T beanCopy(Object source, Class<T> cls){
        T to = null;
        try {
            to = cls.newInstance();
            BeanUtils.copyProperties(source, to);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return to;
    }

    /**
     * List<StudentVo> listCopy(List<Student>, StudentVo.class);
     *
     * 集合实体之间的转换
     * @param <T>
     * @return
     */
    public static <T> List<T> listCopy(List sourceList, Class<T> cls){
        List<T> collect = (List<T>) sourceList.stream().map(obj -> {
            T to = null;
            try {
                to = cls.newInstance();
                BeanUtils.copyProperties(obj, to);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return to;
        }).collect(Collectors.toList());
        return collect;
    }
}
